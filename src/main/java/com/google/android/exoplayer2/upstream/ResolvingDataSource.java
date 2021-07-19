/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.ResolvingDataSource$Resolver;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import java.util.Map;

public final class ResolvingDataSource
implements DataSource {
    private final ResolvingDataSource$Resolver resolver;
    private final DataSource upstreamDataSource;
    private boolean upstreamOpened;

    public ResolvingDataSource(DataSource dataSource, ResolvingDataSource$Resolver resolvingDataSource$Resolver) {
        this.upstreamDataSource = dataSource;
        this.resolver = resolvingDataSource$Resolver;
    }

    public void addTransferListener(TransferListener transferListener) {
        Assertions.checkNotNull(transferListener);
        this.upstreamDataSource.addTransferListener(transferListener);
    }

    public void close() {
        boolean bl2 = this.upstreamOpened;
        if (bl2) {
            bl2 = false;
            this.upstreamOpened = false;
            DataSource dataSource = this.upstreamDataSource;
            dataSource.close();
        }
    }

    public Map getResponseHeaders() {
        return this.upstreamDataSource.getResponseHeaders();
    }

    public Uri getUri() {
        Uri uri = this.upstreamDataSource.getUri();
        if (uri == null) {
            uri = null;
        } else {
            ResolvingDataSource$Resolver resolvingDataSource$Resolver = this.resolver;
            uri = resolvingDataSource$Resolver.resolveReportedUri(uri);
        }
        return uri;
    }

    public long open(DataSpec dataSpec) {
        dataSpec = this.resolver.resolveDataSpec(dataSpec);
        this.upstreamOpened = true;
        return this.upstreamDataSource.open(dataSpec);
    }

    public int read(byte[] byArray, int n10, int n11) {
        return this.upstreamDataSource.read(byArray, n10, n11);
    }
}

