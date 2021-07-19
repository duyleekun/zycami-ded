/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.upstream.cache;

import com.google.android.exoplayer2.extractor.ChunkIndex;
import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.upstream.cache.Cache$Listener;
import com.google.android.exoplayer2.upstream.cache.CacheSpan;
import com.google.android.exoplayer2.upstream.cache.CachedRegionTracker$Region;
import com.google.android.exoplayer2.util.Log;
import java.util.Arrays;
import java.util.TreeSet;

public final class CachedRegionTracker
implements Cache$Listener {
    public static final int CACHED_TO_END = 254;
    public static final int NOT_CACHED = 255;
    private static final String TAG = "CachedRegionTracker";
    private final Cache cache;
    private final String cacheKey;
    private final ChunkIndex chunkIndex;
    private final CachedRegionTracker$Region lookupRegion;
    private final TreeSet regions;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public CachedRegionTracker(Cache iterator2, String object, ChunkIndex object2) {
        this.cache = iterator2;
        this.cacheKey = object;
        this.chunkIndex = object2;
        object2 = new TreeSet();
        this.regions = object2;
        long l10 = 0L;
        this.lookupRegion = object2 = new CachedRegionTracker$Region(l10, l10);
        synchronized (this) {
            iterator2 = iterator2.addListener((String)object, this);
            iterator2 = iterator2.descendingIterator();
            boolean bl2;
            while (bl2 = iterator2.hasNext()) {
                object = iterator2.next();
                object = (CacheSpan)object;
                this.mergeSpan((CacheSpan)object);
            }
            return;
        }
    }

    private void mergeSpan(CacheSpan object) {
        long l10 = ((CacheSpan)object).position;
        Object object2 = ((CacheSpan)object).length + l10;
        CachedRegionTracker$Region cachedRegionTracker$Region = new CachedRegionTracker$Region(l10, (long)object2);
        object = this.regions.floor(cachedRegionTracker$Region);
        Object object3 = this.regions.ceiling(cachedRegionTracker$Region);
        int n10 = this.regionsConnect((CachedRegionTracker$Region)object, cachedRegionTracker$Region);
        boolean bl2 = this.regionsConnect(cachedRegionTracker$Region, (CachedRegionTracker$Region)object3);
        if (bl2) {
            if (n10 != 0) {
                int n11;
                long l11;
                ((CachedRegionTracker$Region)object).endOffset = l11 = ((CachedRegionTracker$Region)object3).endOffset;
                ((CachedRegionTracker$Region)object).endOffsetIndex = n11 = ((CachedRegionTracker$Region)object3).endOffsetIndex;
            } else {
                int n12;
                long l12;
                cachedRegionTracker$Region.endOffset = l12 = ((CachedRegionTracker$Region)object3).endOffset;
                cachedRegionTracker$Region.endOffsetIndex = n12 = ((CachedRegionTracker$Region)object3).endOffsetIndex;
                object = this.regions;
                ((TreeSet)object).add(cachedRegionTracker$Region);
            }
            object = this.regions;
            ((TreeSet)object).remove(object3);
        } else if (n10 != 0) {
            long l13;
            ((CachedRegionTracker$Region)object).endOffset = l13 = cachedRegionTracker$Region.endOffset;
            int n13 = ((CachedRegionTracker$Region)object).endOffsetIndex;
            while (true) {
                long l14;
                Object object4;
                long l15;
                object3 = this.chunkIndex;
                n10 = ((ChunkIndex)object3).length + -1;
                if (n13 >= n10 || (l15 = (object4 = (object2 = (Object)(object3 = (Object)((ChunkIndex)object3).offsets)[n10 = n13 + 1]) - (l14 = ((CachedRegionTracker$Region)object).endOffset)) == 0L ? 0 : (object4 < 0L ? -1 : 1)) > 0) break;
                n13 = n10;
            }
            ((CachedRegionTracker$Region)object).endOffsetIndex = n13;
        } else {
            object = this.chunkIndex.offsets;
            l10 = cachedRegionTracker$Region.endOffset;
            int n14 = Arrays.binarySearch((long[])object, l10);
            if (n14 < 0) {
                n14 = -n14 + -2;
            }
            cachedRegionTracker$Region.endOffsetIndex = n14;
            object = this.regions;
            ((TreeSet)object).add(cachedRegionTracker$Region);
        }
    }

    private boolean regionsConnect(CachedRegionTracker$Region cachedRegionTracker$Region, CachedRegionTracker$Region cachedRegionTracker$Region2) {
        long l10;
        long l11;
        long l12;
        boolean bl2;
        if (cachedRegionTracker$Region != null && cachedRegionTracker$Region2 != null && !(bl2 = (l12 = (l11 = cachedRegionTracker$Region.endOffset) - (l10 = cachedRegionTracker$Region2.startOffset)) == 0L ? 0 : (l12 < 0L ? -1 : 1))) {
            bl2 = true;
        } else {
            bl2 = false;
            cachedRegionTracker$Region = null;
        }
        return bl2;
    }

    public int getRegionEndTimeMs(long object) {
        synchronized (this) {
            int n10;
            block27: {
                Object object4 = this.lookupRegion;
                ((CachedRegionTracker$Region)object4).startOffset = (long)object;
                TreeSet treeSet = this.regions;
                object4 = treeSet.floor(object4);
                n10 = -1;
                if (object4 == null) break block27;
                long l12 = ((CachedRegionTracker$Region)object4).endOffset;
                Object l11 = object == l12 ? 0 : (object < l12 ? -1 : 1);
                if (l11 <= 0) {
                    long l10;
                    reference var11_9;
                    Object object2;
                    Object object3;
                    block28: {
                        l11 = ((CachedRegionTracker$Region)object4).endOffsetIndex;
                        if (l11 == n10) break block27;
                        object3 = this.chunkIndex;
                        object2 = ((ChunkIndex)object3).length + -1;
                        if (l11 != object2) break block28;
                        object4 = ((ChunkIndex)object3).offsets;
                        var11_9 = object4[l11];
                        object4 = ((ChunkIndex)object3).sizes;
                        l10 = (long)object4[l11];
                        long l13 = l12 - (var11_9 += l10);
                        object2 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
                        if (object2 == 0) {
                            return -2;
                        }
                    }
                    object4 = ((ChunkIndex)object3).durationsUs;
                    var11_9 = object4[l11];
                    object4 = ((ChunkIndex)object3).offsets;
                    Object object5 = object4[l11];
                    var11_9 *= (l12 -= object5);
                    object4 = ((ChunkIndex)object3).sizes;
                    object2 = object4[l11];
                    l10 = object2;
                    object3 = ((ChunkIndex)object3).timesUs;
                    object = object3[l11] + (var11_9 /= l10);
                    l10 = 1000L;
                    l11 = object / l10;
                    return (int)l11;
                }
            }
            return n10;
            finally {
            }
        }
    }

    public void onSpanAdded(Cache cache, CacheSpan cacheSpan) {
        synchronized (this) {
            this.mergeSpan(cacheSpan);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onSpanRemoved(Cache object, CacheSpan object2) {
        synchronized (this) {
            long l10;
            long l11;
            Object object3;
            long l12 = ((CacheSpan)object3).position;
            long l13 = ((CacheSpan)object3).length + l12;
            object = new CachedRegionTracker$Region(l12, l13);
            object3 = this.regions;
            object3 = ((TreeSet)object3).floor(object);
            object3 = (CachedRegionTracker$Region)object3;
            if (object3 == null) {
                object = TAG;
                object3 = "Removed a span we were not aware of";
                Log.e((String)object, (String)object3);
                return;
            }
            Object object4 = this.regions;
            ((TreeSet)object4).remove(object3);
            l12 = ((CachedRegionTracker$Region)object3).startOffset;
            l13 = ((CachedRegionTracker$Region)object).startOffset;
            long l14 = l12 == l13 ? 0 : (l12 < l13 ? -1 : 1);
            if (l14 < 0) {
                CachedRegionTracker$Region cachedRegionTracker$Region = new CachedRegionTracker$Region(l12, l13);
                object4 = this.chunkIndex;
                object4 = ((ChunkIndex)object4).offsets;
                long l15 = cachedRegionTracker$Region.endOffset;
                int n10 = Arrays.binarySearch((long[])object4, l15);
                if (n10 < 0) {
                    n10 = -n10 + -2;
                }
                cachedRegionTracker$Region.endOffsetIndex = n10;
                object4 = this.regions;
                ((TreeSet)object4).add(cachedRegionTracker$Region);
            }
            if ((l11 = (l10 = (l12 = ((CachedRegionTracker$Region)object3).endOffset) - (l13 = ((CachedRegionTracker$Region)object).endOffset)) == 0L ? 0 : (l10 < 0L ? -1 : 1)) > 0) {
                int n11;
                long l16 = 1L;
                object = new CachedRegionTracker$Region(l13 += l16, l12);
                ((CachedRegionTracker$Region)object).endOffsetIndex = n11 = ((CachedRegionTracker$Region)object3).endOffsetIndex;
                object3 = this.regions;
                ((TreeSet)object3).add(object);
            }
            return;
        }
    }

    public void onSpanTouched(Cache cache, CacheSpan cacheSpan, CacheSpan cacheSpan2) {
    }

    public void release() {
        Cache cache = this.cache;
        String string2 = this.cacheKey;
        cache.removeListener(string2, this);
    }
}

