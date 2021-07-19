/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSource$Factory;
import com.google.android.exoplayer2.upstream.ResolvingDataSource;
import com.google.android.exoplayer2.upstream.ResolvingDataSource$Resolver;

public final class ResolvingDataSource$Factory
implements DataSource$Factory {
    private final ResolvingDataSource$Resolver resolver;
    private final DataSource$Factory upstreamFactory;

    public ResolvingDataSource$Factory(DataSource$Factory dataSource$Factory, ResolvingDataSource$Resolver resolvingDataSource$Resolver) {
        this.upstreamFactory = dataSource$Factory;
        this.resolver = resolvingDataSource$Resolver;
    }

    public ResolvingDataSource createDataSource() {
        DataSource dataSource = this.upstreamFactory.createDataSource();
        ResolvingDataSource$Resolver resolvingDataSource$Resolver = this.resolver;
        ResolvingDataSource resolvingDataSource = new ResolvingDataSource(dataSource, resolvingDataSource$Resolver);
        return resolvingDataSource;
    }
}

