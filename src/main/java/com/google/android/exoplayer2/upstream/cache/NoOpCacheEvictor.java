/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.upstream.cache;

import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.upstream.cache.CacheEvictor;
import com.google.android.exoplayer2.upstream.cache.CacheSpan;

public final class NoOpCacheEvictor
implements CacheEvictor {
    public void onCacheInitialized() {
    }

    public void onSpanAdded(Cache cache, CacheSpan cacheSpan) {
    }

    public void onSpanRemoved(Cache cache, CacheSpan cacheSpan) {
    }

    public void onSpanTouched(Cache cache, CacheSpan cacheSpan, CacheSpan cacheSpan2) {
    }

    public void onStartFile(Cache cache, String string2, long l10, long l11) {
    }

    public boolean requiresCacheSpanTouches() {
        return false;
    }
}

