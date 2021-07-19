/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.upstream.cache;

import com.google.android.exoplayer2.upstream.DataSink;
import com.google.android.exoplayer2.upstream.DataSink$Factory;
import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.upstream.cache.CacheDataSink;
import com.google.android.exoplayer2.util.Assertions;

public final class CacheDataSink$Factory
implements DataSink$Factory {
    private int bufferSize = 20480;
    private Cache cache;
    private long fragmentSize = 0x500000L;

    public DataSink createDataSink() {
        Cache cache = (Cache)Assertions.checkNotNull(this.cache);
        long l10 = this.fragmentSize;
        int n10 = this.bufferSize;
        CacheDataSink cacheDataSink = new CacheDataSink(cache, l10, n10);
        return cacheDataSink;
    }

    public CacheDataSink$Factory setBufferSize(int n10) {
        this.bufferSize = n10;
        return this;
    }

    public CacheDataSink$Factory setCache(Cache cache) {
        this.cache = cache;
        return this;
    }

    public CacheDataSink$Factory setFragmentSize(long l10) {
        this.fragmentSize = l10;
        return this;
    }
}

