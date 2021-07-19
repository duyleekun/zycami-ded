/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.ConditionVariable
 */
package com.google.android.exoplayer2.upstream.cache;

import android.os.ConditionVariable;
import com.google.android.exoplayer2.database.DatabaseIOException;
import com.google.android.exoplayer2.database.DatabaseProvider;
import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.upstream.cache.Cache$CacheException;
import com.google.android.exoplayer2.upstream.cache.Cache$Listener;
import com.google.android.exoplayer2.upstream.cache.CacheEvictor;
import com.google.android.exoplayer2.upstream.cache.CacheFileMetadata;
import com.google.android.exoplayer2.upstream.cache.CacheFileMetadataIndex;
import com.google.android.exoplayer2.upstream.cache.CacheSpan;
import com.google.android.exoplayer2.upstream.cache.CachedContent;
import com.google.android.exoplayer2.upstream.cache.CachedContentIndex;
import com.google.android.exoplayer2.upstream.cache.ContentMetadata;
import com.google.android.exoplayer2.upstream.cache.ContentMetadataMutations;
import com.google.android.exoplayer2.upstream.cache.SimpleCache$1;
import com.google.android.exoplayer2.upstream.cache.SimpleCacheSpan;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public final class SimpleCache
implements Cache {
    private static final int SUBDIRECTORY_COUNT = 10;
    private static final String TAG = "SimpleCache";
    private static final String UID_FILE_SUFFIX = ".uid";
    private static final HashSet lockedCacheDirs;
    private final File cacheDir;
    private final CachedContentIndex contentIndex;
    private final CacheEvictor evictor;
    private final CacheFileMetadataIndex fileIndex;
    private Cache$CacheException initializationException;
    private final HashMap listeners;
    private final Random random;
    private boolean released;
    private long totalSpace;
    private final boolean touchCacheSpans;
    private long uid;

    static {
        HashSet hashSet;
        lockedCacheDirs = hashSet = new HashSet();
    }

    public SimpleCache(File file, CacheEvictor cacheEvictor) {
        this(file, cacheEvictor, null, false);
    }

    public SimpleCache(File file, CacheEvictor cacheEvictor, DatabaseProvider databaseProvider) {
        this(file, cacheEvictor, databaseProvider, null, false, false);
    }

    public SimpleCache(File file, CacheEvictor cacheEvictor, DatabaseProvider databaseProvider, byte[] object, boolean bl2, boolean bl3) {
        CachedContentIndex cachedContentIndex = new CachedContentIndex(databaseProvider, file, (byte[])object, bl2, bl3);
        if (databaseProvider != null && !bl3) {
            object = new CacheFileMetadataIndex;
            super(databaseProvider);
        } else {
            object = null;
        }
        this(file, cacheEvictor, cachedContentIndex, (CacheFileMetadataIndex)object);
    }

    public SimpleCache(File object, CacheEvictor object2, CachedContentIndex cachedContentIndex, CacheFileMetadataIndex object3) {
        boolean bl2 = SimpleCache.lockFolder((File)object);
        if (bl2) {
            boolean bl3;
            this.cacheDir = object;
            this.evictor = object2;
            this.contentIndex = cachedContentIndex;
            this.fileIndex = object3;
            object = new HashMap();
            this.listeners = object;
            this.random = object;
            this.touchCacheSpans = bl3 = object2.requiresCacheSpanTouches();
            this.uid = -1;
            object = new ConditionVariable();
            object2 = new SimpleCache$1(this, "ExoPlayer:SimpleCacheInit", (ConditionVariable)object);
            ((Thread)object2).start();
            object.block();
            return;
        }
        object = String.valueOf(object);
        int n10 = String.valueOf(object).length() + 46;
        object3 = new StringBuilder(n10);
        ((StringBuilder)object3).append("Another SimpleCache instance uses the folder: ");
        ((StringBuilder)object3).append((String)object);
        object = ((StringBuilder)object3).toString();
        object2 = new IllegalStateException((String)object);
        throw object2;
    }

    public SimpleCache(File file, CacheEvictor cacheEvictor, byte[] byArray) {
        boolean bl2 = byArray != null;
        this(file, cacheEvictor, byArray, bl2);
    }

    public SimpleCache(File file, CacheEvictor cacheEvictor, byte[] byArray, boolean bl2) {
        this(file, cacheEvictor, null, byArray, bl2, true);
    }

    public static /* synthetic */ void access$000(SimpleCache simpleCache) {
        simpleCache.initialize();
    }

    public static /* synthetic */ CacheEvictor access$100(SimpleCache simpleCache) {
        return simpleCache.evictor;
    }

    private void addSpan(SimpleCacheSpan simpleCacheSpan) {
        CachedContentIndex cachedContentIndex = this.contentIndex;
        String string2 = simpleCacheSpan.key;
        cachedContentIndex.getOrAdd(string2).addSpan(simpleCacheSpan);
        long l10 = this.totalSpace;
        long l11 = simpleCacheSpan.length;
        this.totalSpace = l10 += l11;
        this.notifySpanAdded(simpleCacheSpan);
    }

    private static void createCacheDirectories(File object) {
        boolean bl2;
        boolean n10 = ((File)object).mkdirs();
        if (!n10 && !(bl2 = ((File)object).isDirectory())) {
            object = String.valueOf(object);
            int n11 = String.valueOf(object).length() + 34;
            StringBuilder stringBuilder = new StringBuilder(n11);
            stringBuilder.append("Failed to create cache directory: ");
            stringBuilder.append((String)object);
            object = stringBuilder.toString();
            Log.e(TAG, (String)object);
            Cache$CacheException cache$CacheException = new Cache$CacheException((String)object);
            throw cache$CacheException;
        }
    }

    private static long createUid(File serializable) {
        long l10;
        Object object = new SecureRandom();
        long l11 = ((Random)object).nextLong();
        long l12 = l11 - (l10 = Long.MIN_VALUE);
        Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        l11 = object2 == false ? 0L : Math.abs(l11);
        object2 = 16;
        CharSequence charSequence = Long.toString(l11, (int)object2);
        charSequence = String.valueOf(charSequence);
        String string2 = UID_FILE_SUFFIX;
        int n10 = string2.length();
        if (n10 != 0) {
            charSequence = ((String)charSequence).concat(string2);
        } else {
            string2 = new String((String)charSequence);
            charSequence = string2;
        }
        File file = new File((File)serializable, (String)charSequence);
        boolean bl2 = file.createNewFile();
        if (bl2) {
            return l11;
        }
        object = String.valueOf(file);
        int n11 = String.valueOf(object).length() + 27;
        charSequence = new StringBuilder(n11);
        ((StringBuilder)charSequence).append("Failed to create UID file: ");
        ((StringBuilder)charSequence).append((String)object);
        object = ((StringBuilder)charSequence).toString();
        serializable = new IOException((String)object);
        throw serializable;
    }

    public static void delete(File file, DatabaseProvider object) {
        long l10;
        long l11;
        long l12;
        long l13;
        String string2 = "Failed to delete file metadata: ";
        String string3 = TAG;
        boolean bl2 = file.exists();
        if (!bl2) {
            return;
        }
        File[] fileArray = file.listFiles();
        if (fileArray == null) {
            file.delete();
            return;
        }
        if (object != null && (l13 = (l12 = (l11 = SimpleCache.loadUid(fileArray)) - (l10 = (long)-1)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) != false) {
            l13 = 52;
            try {
                CacheFileMetadataIndex.delete((DatabaseProvider)object, l11);
            }
            catch (DatabaseIOException databaseIOException) {
                CharSequence charSequence = new StringBuilder((int)l13);
                charSequence.append(string2);
                charSequence.append(l11);
                charSequence = charSequence.toString();
                Log.w(string3, (String)charSequence);
            }
            try {
                CachedContentIndex.delete((DatabaseProvider)object, l11);
            }
            catch (DatabaseIOException databaseIOException) {
                object = new StringBuilder((int)l13);
                ((StringBuilder)object).append(string2);
                ((StringBuilder)object).append(l11);
                object = ((StringBuilder)object).toString();
                Log.w(string3, (String)object);
            }
        }
        Util.recursiveDelete(file);
    }

    private SimpleCacheSpan getSpan(String object, long l10, long l11) {
        CachedContent cachedContent = this.contentIndex.get((String)object);
        if (cachedContent == null) {
            return SimpleCacheSpan.createHole((String)object, l10, l11);
        }
        while (true) {
            long l12;
            File file;
            long l13;
            long l14;
            object = cachedContent.getSpan(l10, l11);
            boolean bl2 = ((CacheSpan)object).isCached;
            if (!bl2 || !(bl2 = (l14 = (l13 = (file = ((CacheSpan)object).file).length()) - (l12 = ((CacheSpan)object).length)) == 0L ? 0 : (l14 < 0L ? -1 : 1))) break;
            this.removeStaleSpans();
        }
        return object;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void initialize() {
        Set set;
        long l10;
        Object object = this.cacheDir;
        boolean bl2 = ((File)object).exists();
        if (!bl2) {
            try {
                object = this.cacheDir;
                SimpleCache.createCacheDirectories((File)object);
            }
            catch (Cache$CacheException cache$CacheException) {
                this.initializationException = cache$CacheException;
                return;
            }
        }
        object = this.cacheDir.listFiles();
        Object object2 = TAG;
        if (object == null) {
            object = String.valueOf(this.cacheDir);
            int n10 = String.valueOf(object).length() + 38;
            StringBuilder stringBuilder = new StringBuilder(n10);
            stringBuilder.append("Failed to list cache directory files: ");
            stringBuilder.append((String)object);
            object = stringBuilder.toString();
            Log.e((String)object2, (String)object);
            this.initializationException = object2 = new Cache$CacheException((String)object);
            return;
        }
        this.uid = l10 = SimpleCache.loadUid((File[])object);
        long l11 = -1;
        long l12 = l10 - l11;
        Object object3 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object3 == false) {
            try {
                set = this.cacheDir;
                this.uid = l10 = SimpleCache.createUid((File)((Object)set));
            }
            catch (IOException iOException) {
                String string2 = String.valueOf(this.cacheDir);
                int n11 = String.valueOf(string2).length() + 28;
                StringBuilder stringBuilder = new StringBuilder(n11);
                stringBuilder.append("Failed to create cache UID: ");
                stringBuilder.append(string2);
                string2 = stringBuilder.toString();
                Log.e((String)object2, string2, iOException);
                this.initializationException = object2 = new Cache$CacheException(string2, iOException);
                return;
            }
        }
        try {
            set = this.contentIndex;
            long l13 = this.uid;
            ((CachedContentIndex)((Object)set)).initialize(l13);
            set = this.fileIndex;
            boolean bl3 = true;
            if (set != null) {
                l11 = this.uid;
                ((CacheFileMetadataIndex)((Object)set)).initialize(l11);
                set = this.fileIndex;
                set = ((CacheFileMetadataIndex)((Object)set)).getAll();
                File file = this.cacheDir;
                this.loadDirectory(file, bl3, (File[])object, (Map)((Object)set));
                object = this.fileIndex;
                set = set.keySet();
                ((CacheFileMetadataIndex)object).removeAll(set);
            } else {
                set = this.cacheDir;
                Object var12_20 = null;
                this.loadDirectory((File)((Object)set), bl3, (File[])object, null);
            }
            object = this.contentIndex;
            ((CachedContentIndex)object).removeEmpty();
        }
        catch (IOException iOException) {
            set = String.valueOf(this.cacheDir);
            int n12 = String.valueOf(set).length() + 36;
            StringBuilder stringBuilder = new StringBuilder(n12);
            stringBuilder.append("Failed to initialize cache indices: ");
            stringBuilder.append((String)((Object)set));
            set = stringBuilder.toString();
            Log.e((String)object2, (String)((Object)set), iOException);
            this.initializationException = object2 = new Cache$CacheException((String)((Object)set), iOException);
            return;
        }
        try {
            object = this.contentIndex;
            ((CachedContentIndex)object).store();
            return;
        }
        catch (IOException iOException) {
            set = "Storing index file failed";
            Log.e((String)object2, (String)((Object)set), iOException);
        }
    }

    public static boolean isCacheFolderLocked(File file) {
        Class<SimpleCache> clazz = SimpleCache.class;
        synchronized (clazz) {
            HashSet hashSet = lockedCacheDirs;
            file = file.getAbsoluteFile();
            boolean bl2 = hashSet.contains(file);
            return bl2;
        }
    }

    private void loadDirectory(File file, boolean bl2, File[] fileArray, Map map) {
        int n10;
        if (fileArray != null && (n10 = fileArray.length) != 0) {
            int n11 = fileArray.length;
            n10 = 0;
            for (int i10 = 0; i10 < n11; ++i10) {
                String string2;
                int n12;
                int n13;
                File file2 = fileArray[i10];
                Object object = file2.getName();
                if (bl2 && (n13 = object.indexOf(46)) == (n12 = -1)) {
                    object = file2.listFiles();
                    this.loadDirectory(file2, false, (File[])object, map);
                    continue;
                }
                if (bl2 && ((n13 = (int)(CachedContentIndex.isIndexFile((String)object) ? 1 : 0)) != 0 || (n13 = (int)(object.endsWith(string2 = UID_FILE_SUFFIX) ? 1 : 0)) != 0)) continue;
                long l10 = -1;
                long l11 = -9223372036854775807L;
                object = map != null ? (CacheFileMetadata)map.remove(object) : null;
                if (object != null) {
                    l10 = object.length;
                    l11 = object.lastTouchTimestamp;
                }
                CachedContentIndex cachedContentIndex = this.contentIndex;
                object = file2;
                object = SimpleCacheSpan.createCacheEntry(file2, l10, l11, cachedContentIndex);
                if (object != null) {
                    this.addSpan((SimpleCacheSpan)object);
                    continue;
                }
                file2.delete();
            }
            return;
        }
        if (!bl2) {
            file.delete();
        }
    }

    private static long loadUid(File[] fileArray) {
        for (File file : fileArray) {
            String string2;
            String string3 = file.getName();
            int n10 = string3.endsWith(string2 = UID_FILE_SUFFIX);
            if (n10 == 0) continue;
            try {
                return SimpleCache.parseUid(string3);
            }
            catch (NumberFormatException numberFormatException) {
                string3 = String.valueOf(file);
                n10 = String.valueOf(string3).length() + 20;
                StringBuilder stringBuilder = new StringBuilder(n10);
                stringBuilder.append("Malformed UID file: ");
                stringBuilder.append(string3);
                string3 = stringBuilder.toString();
                string2 = TAG;
                Log.e(string2, string3);
                file.delete();
            }
        }
        return -1;
    }

    private static boolean lockFolder(File file) {
        Class<SimpleCache> clazz = SimpleCache.class;
        synchronized (clazz) {
            HashSet hashSet = lockedCacheDirs;
            file = file.getAbsoluteFile();
            boolean bl2 = hashSet.add(file);
            return bl2;
        }
    }

    private void notifySpanAdded(SimpleCacheSpan simpleCacheSpan) {
        Cloneable cloneable = this.listeners;
        String string2 = simpleCacheSpan.key;
        if ((cloneable = (ArrayList)((HashMap)cloneable).get(string2)) != null) {
            for (int i10 = ((ArrayList)cloneable).size() + -1; i10 >= 0; i10 += -1) {
                Cache$Listener cache$Listener = (Cache$Listener)((ArrayList)cloneable).get(i10);
                cache$Listener.onSpanAdded(this, simpleCacheSpan);
            }
        }
        this.evictor.onSpanAdded(this, simpleCacheSpan);
    }

    private void notifySpanRemoved(CacheSpan cacheSpan) {
        Cloneable cloneable = this.listeners;
        String string2 = cacheSpan.key;
        if ((cloneable = (ArrayList)((HashMap)cloneable).get(string2)) != null) {
            for (int i10 = ((ArrayList)cloneable).size() + -1; i10 >= 0; i10 += -1) {
                Cache$Listener cache$Listener = (Cache$Listener)((ArrayList)cloneable).get(i10);
                cache$Listener.onSpanRemoved(this, cacheSpan);
            }
        }
        this.evictor.onSpanRemoved(this, cacheSpan);
    }

    private void notifySpanTouched(SimpleCacheSpan simpleCacheSpan, CacheSpan cacheSpan) {
        Cloneable cloneable = this.listeners;
        String string2 = simpleCacheSpan.key;
        if ((cloneable = (ArrayList)((HashMap)cloneable).get(string2)) != null) {
            for (int i10 = ((ArrayList)cloneable).size() + -1; i10 >= 0; i10 += -1) {
                Cache$Listener cache$Listener = (Cache$Listener)((ArrayList)cloneable).get(i10);
                cache$Listener.onSpanTouched(this, simpleCacheSpan, cacheSpan);
            }
        }
        this.evictor.onSpanTouched(this, simpleCacheSpan, cacheSpan);
    }

    private static long parseUid(String string2) {
        int n10 = string2.indexOf(46);
        return Long.parseLong(string2.substring(0, n10), 16);
    }

    private void removeSpanInternal(CacheSpan cacheSpan) {
        boolean bl2;
        Object object = this.contentIndex;
        Object object2 = cacheSpan.key;
        if ((object = ((CachedContentIndex)object).get((String)object2)) != null && (bl2 = ((CachedContent)object).removeSpan(cacheSpan))) {
            long l10 = this.totalSpace;
            long l11 = cacheSpan.length;
            this.totalSpace = l10 -= l11;
            object2 = this.fileIndex;
            if (object2 != null) {
                object2 = cacheSpan.file.getName();
                Object object3 = this.fileIndex;
                try {
                    ((CacheFileMetadataIndex)object3).remove((String)object2);
                }
                catch (IOException iOException) {
                    object3 = "Failed to remove file index entry for: ";
                    object2 = String.valueOf(object2);
                    int n10 = ((String)object2).length();
                    object2 = n10 != 0 ? ((String)object3).concat((String)object2) : new String((String)object3);
                    object3 = TAG;
                    Log.w((String)object3, (String)object2);
                }
            }
            object2 = this.contentIndex;
            object = ((CachedContent)object).key;
            ((CachedContentIndex)object2).maybeRemove((String)object);
            this.notifySpanRemoved(cacheSpan);
        }
    }

    private void removeStaleSpans() {
        Object object;
        int n10;
        ArrayList<CacheSpan> arrayList = new ArrayList<CacheSpan>();
        Iterator iterator2 = this.contentIndex.getAll().iterator();
        while ((n10 = iterator2.hasNext()) != 0) {
            boolean bl2;
            object = ((CachedContent)iterator2.next()).getSpans().iterator();
            while (bl2 = object.hasNext()) {
                long l10;
                CacheSpan cacheSpan = (CacheSpan)object.next();
                File file = cacheSpan.file;
                long l11 = file.length();
                long l12 = l11 - (l10 = cacheSpan.length);
                Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
                if (object2 == false) continue;
                arrayList.add(cacheSpan);
            }
        }
        iterator2 = null;
        for (int i10 = 0; i10 < (n10 = arrayList.size()); ++i10) {
            object = (CacheSpan)arrayList.get(i10);
            this.removeSpanInternal((CacheSpan)object);
        }
    }

    private SimpleCacheSpan touchSpan(String object, SimpleCacheSpan simpleCacheSpan) {
        boolean bl2 = this.touchCacheSpans;
        if (!bl2) {
            return simpleCacheSpan;
        }
        String string2 = ((File)Assertions.checkNotNull(simpleCacheSpan.file)).getName();
        long l10 = simpleCacheSpan.length;
        long l11 = System.currentTimeMillis();
        bl2 = false;
        Object object2 = this.fileIndex;
        if (object2 != null) {
            try {
                ((CacheFileMetadataIndex)object2).set(string2, l10, l11);
            }
            catch (IOException iOException) {
                object2 = TAG;
                string2 = "Failed to update index with new touch timestamp.";
                Log.w((String)object2, string2);
            }
        } else {
            bl2 = true;
        }
        object = this.contentIndex.get((String)object).setLastTouchTimestamp(simpleCacheSpan, l11, bl2);
        this.notifySpanTouched(simpleCacheSpan, (CacheSpan)object);
        return object;
    }

    private static void unlockFolder(File file) {
        Class<SimpleCache> clazz = SimpleCache.class;
        synchronized (clazz) {
            HashSet hashSet = lockedCacheDirs;
            file = file.getAbsoluteFile();
            hashSet.remove(file);
            return;
        }
    }

    public NavigableSet addListener(String object, Cache$Listener cache$Listener) {
        synchronized (this) {
            Cloneable cloneable;
            boolean bl2;
            block14: {
                bl2 = this.released;
                if (!bl2) {
                    bl2 = true;
                    break block14;
                }
                bl2 = false;
                cloneable = null;
            }
            Assertions.checkState(bl2);
            Assertions.checkNotNull(object);
            Assertions.checkNotNull(cache$Listener);
            cloneable = this.listeners;
            cloneable = cloneable.get(object);
            cloneable = (ArrayList)cloneable;
            if (cloneable == null) {
                cloneable = new ArrayList();
                HashMap hashMap = this.listeners;
                hashMap.put(object, cloneable);
            }
            ((ArrayList)cloneable).add(cache$Listener);
            object = this.getCachedSpans((String)object);
            return object;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void applyContentMetadataMutations(String object, ContentMetadataMutations object2) {
        synchronized (this) {
            Cache$CacheException cache$CacheException;
            CachedContentIndex cachedContentIndex;
            boolean bl2 = this.released;
            if (!bl2) {
                bl2 = true;
            } else {
                bl2 = false;
                cachedContentIndex = null;
            }
            Assertions.checkState(bl2);
            this.checkInitialization();
            cachedContentIndex = this.contentIndex;
            cachedContentIndex.applyContentMetadataMutations((String)object, (ContentMetadataMutations)((Object)cache$CacheException));
            try {
                object = this.contentIndex;
                ((CachedContentIndex)object).store();
                return;
            }
            catch (IOException iOException) {
                cache$CacheException = new Cache$CacheException(iOException);
                throw cache$CacheException;
            }
        }
    }

    public void checkInitialization() {
        synchronized (this) {
            Cache$CacheException cache$CacheException;
            block4: {
                cache$CacheException = this.initializationException;
                if (cache$CacheException != null) break block4;
                return;
            }
            throw cache$CacheException;
        }
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void commitFile(File object, long l10) {
        synchronized (this) {
            String string2;
            void var2_4;
            Object object2;
            Object object3 = this.released;
            boolean bl2 = true;
            if (!object3) {
                object3 = bl2;
            } else {
                object3 = false;
                object2 = null;
            }
            Assertions.checkState(object3);
            object3 = ((File)object).exists();
            if (!object3) {
                return;
            }
            long l11 = 0L;
            void cfr_temp_0 = var2_4 - l11;
            object3 = cfr_temp_0 == 0 ? 0 : (cfr_temp_0 < 0 ? -1 : 1);
            if (!object3) {
                ((File)object).delete();
                return;
            }
            object2 = this.contentIndex;
            Object object4 = SimpleCacheSpan.createCacheEntry((File)object, (long)var2_4, (CachedContentIndex)object2);
            object4 = Assertions.checkNotNull(object4);
            object4 = (SimpleCacheSpan)object4;
            Object object5 = this.contentIndex;
            object2 = ((CacheSpan)object4).key;
            object5 = ((CachedContentIndex)object5).get((String)object2);
            object5 = Assertions.checkNotNull(object5);
            object5 = (CachedContent)object5;
            l11 = ((CacheSpan)object4).position;
            long l12 = ((CacheSpan)object4).length;
            object3 = ((CachedContent)object5).isFullyLocked(l11, l12);
            Assertions.checkState(object3);
            object5 = ((CachedContent)object5).getMetadata();
            l11 = ContentMetadata.getContentLength((ContentMetadata)object5);
            l12 = -1;
            Object object6 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
            if (object6 != false) {
                l12 = ((CacheSpan)object4).position;
                long l13 = ((CacheSpan)object4).length;
                long l14 = (l12 += l13) - l11;
                object6 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
                if (object6 > 0) {
                    bl2 = false;
                    string2 = null;
                }
                Assertions.checkState(bl2);
            }
            if ((object5 = this.fileIndex) != null) {
                string2 = ((File)object).getName();
                try {
                    object2 = this.fileIndex;
                    long l15 = ((CacheSpan)object4).length;
                    long l16 = ((CacheSpan)object4).lastTouchTimestamp;
                    ((CacheFileMetadataIndex)object2).set(string2, l15, l16);
                }
                catch (IOException iOException) {
                    object4 = new Cache$CacheException(iOException);
                    throw object4;
                }
            }
            this.addSpan((SimpleCacheSpan)object4);
            try {
                object = this.contentIndex;
                ((CachedContentIndex)object).store();
                this.notifyAll();
            }
            catch (IOException iOException) {
                object4 = new Cache$CacheException(iOException);
                throw object4;
            }
            return;
        }
    }

    public long getCacheSpace() {
        synchronized (this) {
            boolean bl2;
            block6: {
                bl2 = this.released;
                if (!bl2) {
                    bl2 = true;
                    break block6;
                }
                bl2 = false;
                Object var2_2 = null;
            }
            Assertions.checkState(bl2);
            long l10 = this.totalSpace;
            return l10;
        }
    }

    public long getCachedBytes(String string2, long l10, long l11) {
        synchronized (this) {
            long l12 = -1;
            long l13 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
            long l14 = Long.MAX_VALUE;
            long l15 = l13 == false ? l14 : l10 + l11;
            long l16 = 0L;
            l13 = l15 == l16 ? 0 : (l15 < l16 ? -1 : 1);
            long l17 = l13 < 0 ? l14 : l15;
            long l18 = l10;
            long l19 = l16;
            while ((l13 = l18 == l17 ? 0 : (l18 < l17 ? -1 : 1)) < 0) {
                block4: {
                    long l20 = l17 - l18;
                    l15 = l18;
                    l12 = this.getCachedLength(string2, l18, l20);
                    long l21 = l12 == l16 ? 0 : (l12 < l16 ? -1 : 1);
                    if (l21 <= 0) break block4;
                    l19 += l12;
                }
                l12 = -l12;
                l18 += l12;
            }
            return l19;
        }
    }

    public long getCachedLength(String object, long l10, long l11) {
        synchronized (this) {
            long l12;
            block11: {
                block10: {
                    CachedContentIndex cachedContentIndex;
                    boolean bl2;
                    block9: {
                        bl2 = this.released;
                        if (!bl2) {
                            bl2 = true;
                            break block9;
                        }
                        bl2 = false;
                        cachedContentIndex = null;
                    }
                    Assertions.checkState(bl2);
                    long l13 = -1;
                    bl2 = l11 == l13 ? 0 : (l11 < l13 ? -1 : 1);
                    if (!bl2) {
                        l11 = Long.MAX_VALUE;
                    }
                    cachedContentIndex = this.contentIndex;
                    object = cachedContentIndex.get((String)object);
                    if (object == null) break block10;
                    l12 = ((CachedContent)object).getCachedBytesLength(l10, l11);
                    break block11;
                }
                l12 = -l11;
            }
            return l12;
        }
    }

    public NavigableSet getCachedSpans(String object) {
        synchronized (this) {
            TreeSet treeSet;
            block13: {
                boolean bl2;
                block12: {
                    bl2 = this.released;
                    if (!bl2) {
                        bl2 = true;
                        break block12;
                    }
                    bl2 = false;
                    treeSet = null;
                }
                Assertions.checkState(bl2);
                treeSet = this.contentIndex;
                object = ((CachedContentIndex)((Object)treeSet)).get((String)object);
                if (object == null) break block13;
                bl2 = ((CachedContent)object).isEmpty();
                if (bl2) break block13;
                object = ((CachedContent)object).getSpans();
                treeSet = new TreeSet(object);
            }
            treeSet = new TreeSet();
            return treeSet;
        }
    }

    public ContentMetadata getContentMetadata(String object) {
        synchronized (this) {
            CachedContentIndex cachedContentIndex;
            boolean bl2;
            block7: {
                bl2 = this.released;
                if (!bl2) {
                    bl2 = true;
                    break block7;
                }
                bl2 = false;
                cachedContentIndex = null;
            }
            Assertions.checkState(bl2);
            cachedContentIndex = this.contentIndex;
            object = cachedContentIndex.getContentMetadata((String)object);
            return object;
        }
    }

    public Set getKeys() {
        synchronized (this) {
            HashSet hashSet;
            boolean bl2;
            block8: {
                bl2 = this.released;
                if (!bl2) {
                    bl2 = true;
                    break block8;
                }
                bl2 = false;
                hashSet = null;
            }
            Assertions.checkState(bl2);
            Object object = this.contentIndex;
            object = ((CachedContentIndex)object).getKeys();
            hashSet = new HashSet(object);
            return hashSet;
        }
    }

    public long getUid() {
        synchronized (this) {
            long l10 = this.uid;
            return l10;
        }
    }

    public boolean isCached(String object, long l10, long l11) {
        synchronized (this) {
            boolean bl2;
            block9: {
                block8: {
                    CachedContentIndex cachedContentIndex;
                    boolean bl3;
                    block7: {
                        bl3 = this.released;
                        bl2 = true;
                        if (!bl3) {
                            bl3 = bl2;
                            break block7;
                        }
                        bl3 = false;
                        cachedContentIndex = null;
                    }
                    Assertions.checkState(bl3);
                    cachedContentIndex = this.contentIndex;
                    object = cachedContentIndex.get((String)object);
                    if (object == null) break block8;
                    long l12 = ((CachedContent)object).getCachedBytesLength(l10, l11);
                    long l13 = l12 == l11 ? 0 : (l12 < l11 ? -1 : 1);
                    if (l13 >= 0) break block9;
                }
                bl2 = false;
            }
            return bl2;
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void release() {
        synchronized (this) {
            Object object;
            Throwable throwable2;
            boolean bl2;
            block10: {
                block11: {
                    bl2 = this.released;
                    if (bl2) {
                        return;
                    }
                    HashMap hashMap = this.listeners;
                    hashMap.clear();
                    this.removeStaleSpans();
                    bl2 = true;
                    Object object2 = this.contentIndex;
                    ((CachedContentIndex)object2).store();
                    object2 = this.cacheDir;
                    {
                        File file;
                        catch (Throwable throwable2) {
                            break block10;
                        }
                        catch (IOException iOException) {}
                        object = TAG;
                        String string2 = "Storing index file failed";
                        {
                            Log.e((String)object, string2, iOException);
                            file = this.cacheDir;
                        }
                        SimpleCache.unlockFolder(file);
                        break block11;
                    }
                    SimpleCache.unlockFolder((File)object2);
                }
                this.released = bl2;
                return;
            }
            object = this.cacheDir;
            SimpleCache.unlockFolder((File)object);
            this.released = bl2;
            throw throwable2;
        }
    }

    public void releaseHoleSpan(CacheSpan object) {
        synchronized (this) {
            Object object2;
            boolean bl2;
            block13: {
                bl2 = this.released;
                if (!bl2) {
                    bl2 = true;
                    break block13;
                }
                bl2 = false;
                object2 = null;
            }
            Assertions.checkState(bl2);
            object2 = this.contentIndex;
            String string2 = ((CacheSpan)object).key;
            object2 = ((CachedContentIndex)object2).get(string2);
            object2 = Assertions.checkNotNull(object2);
            object2 = (CachedContent)object2;
            long l10 = ((CacheSpan)object).position;
            ((CachedContent)object2).unlockRange(l10);
            object = this.contentIndex;
            object2 = ((CachedContent)object2).key;
            ((CachedContentIndex)object).maybeRemove((String)object2);
            this.notifyAll();
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void removeListener(String string2, Cache$Listener object) {
        synchronized (this) {
            boolean bl2 = this.released;
            if (bl2) {
                return;
            }
            Cloneable cloneable = this.listeners;
            cloneable = ((HashMap)cloneable).get(string2);
            if ((cloneable = (ArrayList)cloneable) != null) {
                HashMap hashMap;
                ((ArrayList)cloneable).remove(hashMap);
                boolean bl3 = ((ArrayList)cloneable).isEmpty();
                if (bl3) {
                    hashMap = this.listeners;
                    hashMap.remove(string2);
                }
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void removeResource(String iterator2) {
        synchronized (this) {
            CacheSpan cacheSpan;
            boolean bl2 = this.released;
            if (!bl2) {
                bl2 = true;
            } else {
                bl2 = false;
                cacheSpan = null;
            }
            Assertions.checkState(bl2);
            iterator2 = this.getCachedSpans((String)((Object)iterator2));
            iterator2 = iterator2.iterator();
            while (bl2 = iterator2.hasNext()) {
                cacheSpan = (CacheSpan)iterator2.next();
                cacheSpan = cacheSpan;
                this.removeSpanInternal(cacheSpan);
            }
            return;
        }
    }

    public void removeSpan(CacheSpan cacheSpan) {
        synchronized (this) {
            boolean bl2 = this.released;
            bl2 = !bl2;
            Assertions.checkState(bl2);
            this.removeSpanInternal(cacheSpan);
            return;
        }
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public File startFile(String object, long l10, long l11) {
        synchronized (this) {
            void var4_3;
            void var2_2;
            Object object2;
            boolean bl2 = this.released;
            if (!bl2) {
                bl2 = true;
            } else {
                bl2 = false;
                object2 = null;
            }
            Assertions.checkState(bl2);
            this.checkInitialization();
            object2 = this.contentIndex;
            object2 = ((CachedContentIndex)object2).get((String)object);
            Assertions.checkNotNull(object2);
            boolean bl3 = ((CachedContent)object2).isFullyLocked((long)var2_2, (long)var4_3);
            Assertions.checkState(bl3);
            Object object3 = this.cacheDir;
            bl3 = ((File)object3).exists();
            if (!bl3) {
                object3 = this.cacheDir;
                SimpleCache.createCacheDirectories((File)object3);
                this.removeStaleSpans();
            }
            object3 = this.evictor;
            Object object4 = this;
            long l12 = var4_3;
            object3.onStartFile(this, (String)object, (long)var2_2, (long)var4_3);
            object = this.cacheDir;
            Object object5 = this.random;
            int n10 = 10;
            int n11 = ((Random)object5).nextInt(n10);
            object5 = Integer.toString(n11);
            object4 = new File((File)object, (String)object5);
            boolean bl4 = ((File)object4).exists();
            if (!bl4) {
                SimpleCache.createCacheDirectories((File)object4);
            }
            l12 = System.currentTimeMillis();
            int n12 = ((CachedContent)object2).id;
            return SimpleCacheSpan.getCacheFile((File)object4, n12, (long)var2_2, l12);
        }
    }

    public CacheSpan startReadWrite(String string2, long l10, long l11) {
        synchronized (this) {
            CacheSpan cacheSpan;
            boolean bl2;
            block8: {
                bl2 = this.released;
                if (!bl2) {
                    bl2 = true;
                    break block8;
                }
                bl2 = false;
                cacheSpan = null;
            }
            Assertions.checkState(bl2);
            this.checkInitialization();
            while (true) {
                cacheSpan = this.startReadWriteNonBlocking(string2, l10, l11);
                if (cacheSpan == null) break block9;
                break;
            }
            {
                block9: {
                    return cacheSpan;
                }
                this.wait();
                continue;
            }
        }
    }

    public CacheSpan startReadWriteNonBlocking(String object, long l10, long l11) {
        synchronized (this) {
            block13: {
                SimpleCacheSpan simpleCacheSpan;
                block12: {
                    boolean bl2 = this.released;
                    bl2 = !bl2;
                    Assertions.checkState(bl2);
                    this.checkInitialization();
                    simpleCacheSpan = this.getSpan((String)object, l10, l11);
                    boolean bl3 = simpleCacheSpan.isCached;
                    if (!bl3) break block12;
                    object = this.touchSpan((String)object, simpleCacheSpan);
                    return object;
                }
                CachedContentIndex cachedContentIndex = this.contentIndex;
                object = cachedContentIndex.getOrAdd((String)object);
                long l12 = simpleCacheSpan.length;
                boolean bl4 = ((CachedContent)object).lockRange(l10, l12);
                if (!bl4) break block13;
                return simpleCacheSpan;
            }
            return null;
            finally {
            }
        }
    }
}

