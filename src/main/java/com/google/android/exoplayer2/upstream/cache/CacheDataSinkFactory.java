/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.upstream.cache;

import com.google.android.exoplayer2.upstream.DataSink;
import com.google.android.exoplayer2.upstream.DataSink$Factory;
import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.upstream.cache.CacheDataSink;

public final class CacheDataSinkFactory
implements DataSink$Factory {
    private final int bufferSize;
    private final Cache cache;
    private final long fragmentSize;

    public CacheDataSinkFactory(Cache cache, long l10) {
        this(cache, l10, 20480);
    }

    public CacheDataSinkFactory(Cache cache, long l10, int n10) {
        this.cache = cache;
        this.fragmentSize = l10;
        this.bufferSize = n10;
    }

    public DataSink createDataSink() {
        Cache cache = this.cache;
        long l10 = this.fragmentSize;
        int n10 = this.bufferSize;
        CacheDataSink cacheDataSink = new CacheDataSink(cache, l10, n10);
        return cacheDataSink;
    }
}

