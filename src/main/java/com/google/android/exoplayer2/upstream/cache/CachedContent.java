/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.upstream.cache;

import com.google.android.exoplayer2.upstream.cache.CacheSpan;
import com.google.android.exoplayer2.upstream.cache.CachedContent$Range;
import com.google.android.exoplayer2.upstream.cache.ContentMetadataMutations;
import com.google.android.exoplayer2.upstream.cache.DefaultContentMetadata;
import com.google.android.exoplayer2.upstream.cache.SimpleCacheSpan;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import java.io.File;
import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.TreeSet;

public final class CachedContent {
    private static final String TAG = "CachedContent";
    private final TreeSet cachedSpans;
    public final int id;
    public final String key;
    private final ArrayList lockedRanges;
    private DefaultContentMetadata metadata;

    public CachedContent(int n10, String string2) {
        DefaultContentMetadata defaultContentMetadata = DefaultContentMetadata.EMPTY;
        this(n10, string2, defaultContentMetadata);
    }

    public CachedContent(int n10, String string2, DefaultContentMetadata defaultContentMetadata) {
        AbstractCollection abstractCollection;
        this.id = n10;
        this.key = string2;
        this.metadata = defaultContentMetadata;
        this.cachedSpans = abstractCollection = new AbstractCollection();
        this.lockedRanges = abstractCollection;
    }

    public void addSpan(SimpleCacheSpan simpleCacheSpan) {
        this.cachedSpans.add(simpleCacheSpan);
    }

    public boolean applyMetadataMutations(ContentMetadataMutations object) {
        DefaultContentMetadata defaultContentMetadata = this.metadata;
        this.metadata = object = defaultContentMetadata.copyWithMutationsApplied((ContentMetadataMutations)object);
        return ((DefaultContentMetadata)object).equals(defaultContentMetadata) ^ true;
    }

    public boolean equals(Object object) {
        Object object2;
        Object object3;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (object3 = CachedContent.class) == (object2 = object.getClass())) {
            boolean bl3;
            object = (CachedContent)object;
            int n10 = this.id;
            int n11 = ((CachedContent)object).id;
            if (n10 != n11 || (n10 = (int)(((String)(object3 = this.key)).equals(object2 = ((CachedContent)object).key) ? 1 : 0)) == 0 || (n10 = (int)(((AbstractSet)(object3 = this.cachedSpans)).equals(object2 = ((CachedContent)object).cachedSpans) ? 1 : 0)) == 0 || !(bl3 = ((DefaultContentMetadata)(object3 = this.metadata)).equals(object = ((CachedContent)object).metadata))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public long getCachedBytesLength(long l10, long l11) {
        Object object;
        boolean bl2;
        Object object2;
        long l12 = 0L;
        long l13 = l10 == l12 ? 0 : (l10 < l12 ? -1 : 1);
        int n10 = 1;
        Object object3 = 0;
        if (l13 >= 0) {
            l13 = n10;
        } else {
            l13 = 0;
            object2 = null;
        }
        Assertions.checkArgument((boolean)l13);
        l13 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
        if (l13 < 0) {
            bl2 = false;
            object = null;
        }
        Assertions.checkArgument(bl2);
        object2 = this.getSpan(l10, l11);
        boolean bl3 = ((CacheSpan)object2).isHoleSpan();
        long l14 = Long.MAX_VALUE;
        if (bl3) {
            boolean bl4 = ((CacheSpan)object2).isOpenEnded();
            if (!bl4) {
                l14 = ((CacheSpan)object2).length;
            }
            return -Math.min(l14, l11);
        }
        long l15 = l10 + l11;
        long l16 = l15 - l12;
        Object object4 = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
        if (object4 >= 0) {
            l14 = l15;
        }
        l12 = ((CacheSpan)object2).position;
        l15 = ((CacheSpan)object2).length;
        long l17 = (l12 += l15) - l14;
        long l18 = l17 == 0L ? 0 : (l17 < 0L ? -1 : 1);
        if (l18 < 0) {
            int n11;
            object = this.cachedSpans;
            object2 = ((TreeSet)object).tailSet(object2, false).iterator();
            while ((n11 = object2.hasNext()) != 0) {
                long l19;
                long l20;
                object = (SimpleCacheSpan)object2.next();
                l15 = ((CacheSpan)object).position;
                long l21 = l15 - l12;
                object3 = l21 == 0L ? 0 : (l21 < 0L ? -1 : 1);
                if (object3 <= 0 && (n11 = (l20 = (l12 = Math.max(l12, l15 += (l19 = ((CacheSpan)object).length))) - l14) == 0L ? 0 : (l20 < 0L ? -1 : 1)) < 0) continue;
            }
        }
        return Math.min(l12 - l10, l11);
    }

    public DefaultContentMetadata getMetadata() {
        return this.metadata;
    }

    public SimpleCacheSpan getSpan(long l10, long l11) {
        Object object;
        long l12;
        SimpleCacheSpan simpleCacheSpan = SimpleCacheSpan.createLookup(this.key, l10);
        Object object2 = this.cachedSpans.floor(simpleCacheSpan);
        if (object2 != null) {
            l12 = ((CacheSpan)object2).position;
            long l13 = ((CacheSpan)object2).length;
            long l14 = (l12 += l13) - l10;
            object = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
            if (object > 0) {
                return object2;
            }
        }
        if ((simpleCacheSpan = ((TreeSet)(object2 = this.cachedSpans)).ceiling(simpleCacheSpan)) != null) {
            long l15 = simpleCacheSpan.position - l10;
            l12 = -1;
            long l16 = l11 - l12;
            object = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
            l11 = object == false ? l15 : Math.min(l15, l11);
        }
        return SimpleCacheSpan.createHole(this.key, l10, l11);
    }

    public TreeSet getSpans() {
        return this.cachedSpans;
    }

    public int hashCode() {
        int n10 = this.id * 31;
        int n11 = this.key.hashCode();
        n10 = (n10 + n11) * 31;
        n11 = this.metadata.hashCode();
        return n10 + n11;
    }

    public boolean isEmpty() {
        return this.cachedSpans.isEmpty();
    }

    public boolean isFullyLocked(long l10, long l11) {
        Object object;
        int n10;
        for (int i10 = 0; i10 < (n10 = ((ArrayList)(object = this.lockedRanges)).size()); ++i10) {
            object = (CachedContent$Range)this.lockedRanges.get(i10);
            n10 = (int)(((CachedContent$Range)object).contains(l10, l11) ? 1 : 0);
            if (n10 == 0) continue;
            return true;
        }
        return false;
    }

    public boolean isFullyUnlocked() {
        return this.lockedRanges.isEmpty();
    }

    public boolean lockRange(long l10, long l11) {
        Object object;
        int n10;
        ArrayList arrayList = null;
        CachedContent$Range cachedContent$Range = null;
        for (int i10 = 0; i10 < (n10 = ((ArrayList)(object = this.lockedRanges)).size()); ++i10) {
            object = (CachedContent$Range)this.lockedRanges.get(i10);
            n10 = (int)(((CachedContent$Range)object).intersects(l10, l11) ? 1 : 0);
            if (n10 == 0) continue;
            return false;
        }
        arrayList = this.lockedRanges;
        cachedContent$Range = new CachedContent$Range(l10, l11);
        arrayList.add(cachedContent$Range);
        return true;
    }

    public boolean removeSpan(CacheSpan comparable) {
        TreeSet treeSet = this.cachedSpans;
        boolean bl2 = treeSet.remove(comparable);
        if (bl2) {
            comparable = ((CacheSpan)comparable).file;
            if (comparable != null) {
                ((File)comparable).delete();
            }
            return true;
        }
        return false;
    }

    public SimpleCacheSpan setLastTouchTimestamp(SimpleCacheSpan simpleCacheSpan, long l10, boolean bl2) {
        boolean bl3 = this.cachedSpans.remove(simpleCacheSpan);
        Assertions.checkState(bl3);
        Object object = (File)Assertions.checkNotNull(simpleCacheSpan.file);
        if (bl2) {
            Object object2;
            Object object3 = object2 = Assertions.checkNotNull(((File)object).getParentFile());
            object3 = (File)object2;
            int n10 = this.id;
            long l11 = simpleCacheSpan.position;
            boolean bl4 = ((File)object).renameTo((File)(object2 = SimpleCacheSpan.getCacheFile((File)object3, n10, l11, l10)));
            if (bl4) {
                object = object2;
            } else {
                object3 = String.valueOf(object);
                object2 = String.valueOf(object2);
                n10 = String.valueOf(object3).length() + 21;
                int n11 = String.valueOf(object2).length();
                StringBuilder stringBuilder = new StringBuilder(n10 += n11);
                String string2 = "Failed to rename ";
                stringBuilder.append(string2);
                stringBuilder.append((String)object3);
                stringBuilder.append(" to ");
                stringBuilder.append((String)object2);
                object2 = stringBuilder.toString();
                object3 = TAG;
                Log.w((String)object3, (String)object2);
            }
        }
        simpleCacheSpan = simpleCacheSpan.copyWithFileAndLastTouchTimestamp((File)object, l10);
        this.cachedSpans.add(simpleCacheSpan);
        return simpleCacheSpan;
    }

    public void unlockRange(long l10) {
        Object object;
        int n10;
        for (int i10 = 0; i10 < (n10 = ((ArrayList)(object = this.lockedRanges)).size()); ++i10) {
            object = (CachedContent$Range)this.lockedRanges.get(i10);
            long l11 = ((CachedContent$Range)object).position;
            long l12 = l11 - l10;
            n10 = (int)(l12 == 0L ? 0 : (l12 < 0L ? -1 : 1));
            if (n10 != 0) continue;
            this.lockedRanges.remove(i10);
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException();
        throw illegalStateException;
    }
}

