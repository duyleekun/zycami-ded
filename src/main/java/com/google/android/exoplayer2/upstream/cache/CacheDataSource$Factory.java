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
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.PriorityTaskManager;

public final class CacheDataSource$Factory
implements DataSource$Factory {
    private Cache cache;
    private boolean cacheIsReadOnly;
    private CacheKeyFactory cacheKeyFactory;
    private DataSource$Factory cacheReadDataSourceFactory;
    private DataSink$Factory cacheWriteDataSinkFactory;
    private CacheDataSource$EventListener eventListener;
    private int flags;
    private DataSource$Factory upstreamDataSourceFactory;
    private int upstreamPriority;
    private PriorityTaskManager upstreamPriorityTaskManager;

    public CacheDataSource$Factory() {
        Object object = new FileDataSource$Factory();
        this.cacheReadDataSourceFactory = object;
        this.cacheKeyFactory = object = CacheKeyFactory.DEFAULT;
    }

    private CacheDataSource createDataSourceInternal(DataSource dataSource, int n10, int n11) {
        Object object;
        Object object2 = object = Assertions.checkNotNull(this.cache);
        object2 = (Cache)object;
        boolean bl2 = this.cacheIsReadOnly;
        if (!bl2 && dataSource != null) {
            object = this.cacheWriteDataSinkFactory;
            if (object != null) {
                object = object.createDataSink();
            } else {
                object = new CacheDataSink$Factory();
                object = ((CacheDataSink$Factory)object).setCache((Cache)object2).createDataSink();
            }
        } else {
            bl2 = false;
            object = null;
        }
        Object object3 = object;
        DataSource dataSource2 = this.cacheReadDataSourceFactory.createDataSource();
        CacheKeyFactory cacheKeyFactory = this.cacheKeyFactory;
        PriorityTaskManager priorityTaskManager = this.upstreamPriorityTaskManager;
        CacheDataSource$EventListener cacheDataSource$EventListener = this.eventListener;
        object = new CacheDataSource((Cache)object2, dataSource, dataSource2, (DataSink)object3, cacheKeyFactory, n10, priorityTaskManager, n11, cacheDataSource$EventListener, null);
        return object;
    }

    public CacheDataSource createDataSource() {
        Object object = this.upstreamDataSourceFactory;
        object = object != null ? object.createDataSource() : null;
        int n10 = this.flags;
        int n11 = this.upstreamPriority;
        return this.createDataSourceInternal((DataSource)object, n10, n11);
    }

    public CacheDataSource createDataSourceForDownloading() {
        Object object = this.upstreamDataSourceFactory;
        object = object != null ? object.createDataSource() : null;
        int n10 = this.flags | 1;
        return this.createDataSourceInternal((DataSource)object, n10, -1000);
    }

    public CacheDataSource createDataSourceForRemovingDownload() {
        int n10 = this.flags | 1;
        return this.createDataSourceInternal(null, n10, -1000);
    }

    public Cache getCache() {
        return this.cache;
    }

    public CacheKeyFactory getCacheKeyFactory() {
        return this.cacheKeyFactory;
    }

    public PriorityTaskManager getUpstreamPriorityTaskManager() {
        return this.upstreamPriorityTaskManager;
    }

    public CacheDataSource$Factory setCache(Cache cache) {
        this.cache = cache;
        return this;
    }

    public CacheDataSource$Factory setCacheKeyFactory(CacheKeyFactory cacheKeyFactory) {
        this.cacheKeyFactory = cacheKeyFactory;
        return this;
    }

    public CacheDataSource$Factory setCacheReadDataSourceFactory(DataSource$Factory dataSource$Factory) {
        this.cacheReadDataSourceFactory = dataSource$Factory;
        return this;
    }

    public CacheDataSource$Factory setCacheWriteDataSinkFactory(DataSink$Factory dataSink$Factory) {
        boolean bl2;
        this.cacheWriteDataSinkFactory = dataSink$Factory;
        if (dataSink$Factory == null) {
            bl2 = true;
        } else {
            bl2 = false;
            dataSink$Factory = null;
        }
        this.cacheIsReadOnly = bl2;
        return this;
    }

    public CacheDataSource$Factory setEventListener(CacheDataSource$EventListener cacheDataSource$EventListener) {
        this.eventListener = cacheDataSource$EventListener;
        return this;
    }

    public CacheDataSource$Factory setFlags(int n10) {
        this.flags = n10;
        return this;
    }

    public CacheDataSource$Factory setUpstreamDataSourceFactory(DataSource$Factory dataSource$Factory) {
        this.upstreamDataSourceFactory = dataSource$Factory;
        return this;
    }

    public CacheDataSource$Factory setUpstreamPriority(int n10) {
        this.upstreamPriority = n10;
        return this;
    }

    public CacheDataSource$Factory setUpstreamPriorityTaskManager(PriorityTaskManager priorityTaskManager) {
        this.upstreamPriorityTaskManager = priorityTaskManager;
        return this;
    }
}

