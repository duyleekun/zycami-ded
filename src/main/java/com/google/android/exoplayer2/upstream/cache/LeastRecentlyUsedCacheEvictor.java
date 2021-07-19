/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.upstream.cache;

import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.upstream.cache.CacheEvictor;
import com.google.android.exoplayer2.upstream.cache.CacheSpan;
import d.h.a.a.q0.e.b;
import java.util.TreeSet;

public final class LeastRecentlyUsedCacheEvictor
implements CacheEvictor {
    private long currentSize;
    private final TreeSet leastRecentlyUsed;
    private final long maxBytes;

    public LeastRecentlyUsedCacheEvictor(long l10) {
        TreeSet treeSet;
        this.maxBytes = l10;
        b b10 = b.a;
        this.leastRecentlyUsed = treeSet = new TreeSet(b10);
    }

    public static /* synthetic */ int a(CacheSpan cacheSpan, CacheSpan cacheSpan2) {
        return LeastRecentlyUsedCacheEvictor.compare(cacheSpan, cacheSpan2);
    }

    private static int compare(CacheSpan cacheSpan, CacheSpan cacheSpan2) {
        long l10 = cacheSpan.lastTouchTimestamp;
        long l11 = cacheSpan2.lastTouchTimestamp;
        long l12 = l10 - l11;
        long l13 = 0L;
        long l14 = l12 - l13;
        Object object = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
        if (object == false) {
            return cacheSpan.compareTo(cacheSpan2);
        }
        Object object2 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        object2 = object2 < 0 ? (Object)-1 : (Object)1;
        return (int)object2;
    }

    private void evictCache(Cache cache, long l10) {
        Object object;
        long l11;
        long l12;
        long l13;
        long l14;
        while ((l14 = (l13 = (l12 = this.currentSize + l10) - (l11 = this.maxBytes)) == 0L ? 0 : (l13 < 0L ? -1 : 1)) > 0 && (l14 = (long)((TreeSet)(object = this.leastRecentlyUsed)).isEmpty()) == false) {
            object = (CacheSpan)this.leastRecentlyUsed.first();
            cache.removeSpan((CacheSpan)object);
        }
    }

    public void onCacheInitialized() {
    }

    public void onSpanAdded(Cache cache, CacheSpan cacheSpan) {
        this.leastRecentlyUsed.add(cacheSpan);
        long l10 = this.currentSize;
        long l11 = cacheSpan.length;
        this.currentSize = l10 += l11;
        this.evictCache(cache, 0L);
    }

    public void onSpanRemoved(Cache cache, CacheSpan cacheSpan) {
        this.leastRecentlyUsed.remove(cacheSpan);
        long l10 = this.currentSize;
        long l11 = cacheSpan.length;
        this.currentSize = l10 -= l11;
    }

    public void onSpanTouched(Cache cache, CacheSpan cacheSpan, CacheSpan cacheSpan2) {
        this.onSpanRemoved(cache, cacheSpan);
        this.onSpanAdded(cache, cacheSpan2);
    }

    public void onStartFile(Cache cache, String string2, long l10, long l11) {
        long l12 = -1;
        long l13 = l11 - l12;
        Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object != false) {
            this.evictCache(cache, l11);
        }
    }

    public boolean requiresCacheSpanTouches() {
        return true;
    }
}

