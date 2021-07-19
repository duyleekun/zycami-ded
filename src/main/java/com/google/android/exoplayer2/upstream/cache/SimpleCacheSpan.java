/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.upstream.cache;

import com.google.android.exoplayer2.upstream.cache.CacheSpan;
import com.google.android.exoplayer2.upstream.cache.CachedContentIndex;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class SimpleCacheSpan
extends CacheSpan {
    private static final Pattern CACHE_FILE_PATTERN_V1;
    private static final Pattern CACHE_FILE_PATTERN_V2;
    private static final Pattern CACHE_FILE_PATTERN_V3;
    public static final String COMMON_SUFFIX = ".exo";
    private static final String SUFFIX = ".v3.exo";

    static {
        int n10 = 32;
        CACHE_FILE_PATTERN_V1 = Pattern.compile("^(.+)\\.(\\d+)\\.(\\d+)\\.v1\\.exo$", n10);
        CACHE_FILE_PATTERN_V2 = Pattern.compile("^(.+)\\.(\\d+)\\.(\\d+)\\.v2\\.exo$", n10);
        CACHE_FILE_PATTERN_V3 = Pattern.compile("^(\\d+)\\.(\\d+)\\.(\\d+)\\.v3\\.exo$", n10);
    }

    private SimpleCacheSpan(String string2, long l10, long l11, long l12, File file) {
        super(string2, l10, l11, l12, file);
    }

    public static SimpleCacheSpan createCacheEntry(File file, long l10, long l11, CachedContentIndex cachedContentIndex) {
        long l12;
        Object object;
        Object object2;
        Object object3 = cachedContentIndex;
        Object object4 = file.getName();
        boolean n10 = ((String)object4).endsWith((String)(object2 = SUFFIX));
        if (!n10) {
            object2 = file;
            object4 = SimpleCacheSpan.upgradeFile(file, cachedContentIndex);
            if (object4 == null) {
                return null;
            }
            object2 = ((File)object4).getName();
            object = object4;
            object4 = object2;
        } else {
            object2 = file;
            object = file;
        }
        object2 = CACHE_FILE_PATTERN_V3;
        object4 = ((Pattern)object2).matcher((CharSequence)object4);
        boolean bl2 = ((Matcher)object4).matches();
        if (!bl2) {
            return null;
        }
        object2 = (String)Assertions.checkNotNull(((Matcher)object4).group(1));
        int n11 = Integer.parseInt((String)object2);
        String string2 = ((CachedContentIndex)object3).getKeyForId(n11);
        if (string2 == null) {
            return null;
        }
        long l13 = -1;
        long l14 = l10 - l13;
        Object object5 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
        long l15 = object5 == false ? (l13 = ((File)object).length()) : l10;
        long l16 = l15 - (l13 = 0L);
        object5 = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
        if (object5 == false) {
            return null;
        }
        object3 = (String)Assertions.checkNotNull(((Matcher)object4).group(2));
        l13 = Long.parseLong((String)object3);
        long l17 = -9223372036854775807L;
        long l18 = l11 - l17;
        object5 = l18 == 0L ? 0 : (l18 < 0L ? -1 : 1);
        if (object5 == false) {
            long l19;
            object5 = 3;
            object3 = (String)Assertions.checkNotNull(((Matcher)object4).group((int)object5));
            l12 = l19 = Long.parseLong((String)object3);
        } else {
            l12 = l11;
        }
        object3 = new SimpleCacheSpan(string2, l13, l15, l12, (File)object);
        return object3;
    }

    public static SimpleCacheSpan createCacheEntry(File file, long l10, CachedContentIndex cachedContentIndex) {
        return SimpleCacheSpan.createCacheEntry(file, l10, -9223372036854775807L, cachedContentIndex);
    }

    public static SimpleCacheSpan createHole(String string2, long l10, long l11) {
        SimpleCacheSpan simpleCacheSpan = new SimpleCacheSpan(string2, l10, l11, -9223372036854775807L, null);
        return simpleCacheSpan;
    }

    public static SimpleCacheSpan createLookup(String string2, long l10) {
        SimpleCacheSpan simpleCacheSpan = new SimpleCacheSpan(string2, l10, -1, -9223372036854775807L, null);
        return simpleCacheSpan;
    }

    public static File getCacheFile(File file, int n10, long l10, long l11) {
        StringBuilder stringBuilder = new StringBuilder(60);
        stringBuilder.append(n10);
        String string2 = ".";
        stringBuilder.append(string2);
        stringBuilder.append(l10);
        stringBuilder.append(string2);
        stringBuilder.append(l11);
        stringBuilder.append(SUFFIX);
        string2 = stringBuilder.toString();
        File file2 = new File(file, string2);
        return file2;
    }

    private static File upgradeFile(File file, CachedContentIndex object) {
        int n10;
        long l10;
        long l11;
        Object object2;
        String string2 = file.getName();
        Matcher matcher = CACHE_FILE_PATTERN_V2.matcher(string2);
        boolean bl2 = matcher.matches();
        int n11 = 1;
        if (bl2) {
            string2 = Util.unescapeFileName((String)Assertions.checkNotNull(matcher.group(n11)));
        } else {
            matcher = CACHE_FILE_PATTERN_V1.matcher(string2);
            boolean bl3 = matcher.matches();
            if (bl3) {
                string2 = (String)Assertions.checkNotNull(matcher.group(n11));
            } else {
                bl3 = false;
                string2 = null;
            }
        }
        if (string2 == null) {
            return null;
        }
        Object object3 = object2 = Assertions.checkStateNotNull(file.getParentFile());
        object3 = (File)object2;
        int n12 = ((CachedContentIndex)object).assignIdForKey(string2);
        boolean bl4 = file.renameTo((File)(object = SimpleCacheSpan.getCacheFile((File)object3, n12, l11 = Long.parseLong((String)Assertions.checkNotNull(matcher.group(2))), l10 = Long.parseLong((String)Assertions.checkNotNull(matcher.group(n10 = 3))))));
        if (!bl4) {
            return null;
        }
        return object;
    }

    public SimpleCacheSpan copyWithFileAndLastTouchTimestamp(File file, long l10) {
        Assertions.checkState(this.isCached);
        String string2 = this.key;
        long l11 = this.position;
        long l12 = this.length;
        SimpleCacheSpan simpleCacheSpan = new SimpleCacheSpan(string2, l11, l12, l10, file);
        return simpleCacheSpan;
    }
}

