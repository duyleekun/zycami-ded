/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.upstream.cache;

import com.google.android.exoplayer2.upstream.DataSink;
import com.google.android.exoplayer2.upstream.DataSink$Factory;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSource$Factory;
import com.google.android.exoplayer2.upstream.FileDataSource$Factory;
import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.upstream.cache.CacheDataSink$Factory;
import com.google.android.exoplayer2.upstream.cache.CacheDataSource;
import com.google.android.exoplayer2.upstream.cache.CacheDataSource$EventListener;
import com.google.android.exoplayer2.upstream.cache.CacheKeyFactory;

public final class CacheDataSourceFactory
implements DataSource$Factory {
    private final Cache cache;
    private final CacheKeyFactory cacheKeyFactory;
    private final DataSource$Factory cacheReadDataSourceFactory;
    private final DataSink$Factory cacheWriteDataSinkFactory;
    private final CacheDataSource$EventListener eventListener;
    private final int flags;
    private final DataSource$Factory upstreamFactory;

    public CacheDataSourceFactory(Cache cache, DataSource$Factory dataSource$Factory) {
        this(cache, dataSource$Factory, 0);
    }

    public CacheDataSourceFactory(Cache cache, DataSource$Factory dataSource$Factory, int n10) {
        FileDataSource$Factory fileDataSource$Factory = new FileDataSource$Factory();
        Object object = new CacheDataSink$Factory();
        CacheDataSink$Factory cacheDataSink$Factory = ((CacheDataSink$Factory)object).setCache(cache);
        object = this;
        this(cache, dataSource$Factory, fileDataSource$Factory, cacheDataSink$Factory, n10, null);
    }

    public CacheDataSourceFactory(Cache cache, DataSource$Factory dataSource$Factory, DataSource$Factory dataSource$Factory2, DataSink$Factory dataSink$Factory, int n10, CacheDataSource$EventListener cacheDataSource$EventListener) {
        this(cache, dataSource$Factory, dataSource$Factory2, dataSink$Factory, n10, cacheDataSource$EventListener, null);
    }

    public CacheDataSourceFactory(Cache cache, DataSource$Factory dataSource$Factory, DataSource$Factory dataSource$Factory2, DataSink$Factory dataSink$Factory, int n10, CacheDataSource$EventListener cacheDataSource$EventListener, CacheKeyFactory cacheKeyFactory) {
        this.cache = cache;
        this.upstreamFactory = dataSource$Factory;
        this.cacheReadDataSourceFactory = dataSource$Factory2;
        this.cacheWriteDataSinkFactory = dataSink$Factory;
        this.flags = n10;
        this.eventListener = cacheDataSource$EventListener;
        this.cacheKeyFactory = cacheKeyFactory;
    }

    public CacheDataSource createDataSource() {
        CacheDataSource cacheDataSource;
        Cache cache = this.cache;
        DataSource dataSource = this.upstreamFactory.createDataSource();
        DataSource dataSource2 = this.cacheReadDataSourceFactory.createDataSource();
        Object object = this.cacheWriteDataSinkFactory;
        object = object == null ? null : object.createDataSink();
        Object object2 = object;
        int n10 = this.flags;
        CacheDataSource$EventListener cacheDataSource$EventListener = this.eventListener;
        CacheKeyFactory cacheKeyFactory = this.cacheKeyFactory;
        object = cacheDataSource;
        cacheDataSource = new CacheDataSource(cache, dataSource, dataSource2, (DataSink)object2, n10, cacheDataSource$EventListener, cacheKeyFactory);
        return cacheDataSource;
    }
}

