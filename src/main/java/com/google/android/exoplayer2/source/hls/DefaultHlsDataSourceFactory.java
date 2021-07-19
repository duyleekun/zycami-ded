/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source.hls;

import com.google.android.exoplayer2.source.hls.HlsDataSourceFactory;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSource$Factory;

public final class DefaultHlsDataSourceFactory
implements HlsDataSourceFactory {
    private final DataSource$Factory dataSourceFactory;

    public DefaultHlsDataSourceFactory(DataSource$Factory dataSource$Factory) {
        this.dataSourceFactory = dataSource$Factory;
    }

    public DataSource createDataSource(int n10) {
        return this.dataSourceFactory.createDataSource();
    }
}

