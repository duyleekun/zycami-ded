/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.upstream.DefaultHttpDataSource;
import com.google.android.exoplayer2.upstream.HttpDataSource$BaseFactory;
import com.google.android.exoplayer2.upstream.HttpDataSource$RequestProperties;
import com.google.android.exoplayer2.upstream.TransferListener;

public final class DefaultHttpDataSourceFactory
extends HttpDataSource$BaseFactory {
    private final boolean allowCrossProtocolRedirects;
    private final int connectTimeoutMillis;
    private final TransferListener listener;
    private final int readTimeoutMillis;
    private final String userAgent;

    public DefaultHttpDataSourceFactory() {
        this(null);
    }

    public DefaultHttpDataSourceFactory(String string2) {
        this(string2, null);
    }

    public DefaultHttpDataSourceFactory(String string2, int n10, int n11, boolean bl2) {
        this(string2, null, n10, n11, bl2);
    }

    public DefaultHttpDataSourceFactory(String string2, TransferListener transferListener) {
        this(string2, transferListener, 8000, 8000, false);
    }

    public DefaultHttpDataSourceFactory(String string2, TransferListener transferListener, int n10, int n11, boolean bl2) {
        this.userAgent = string2;
        this.listener = transferListener;
        this.connectTimeoutMillis = n10;
        this.readTimeoutMillis = n11;
        this.allowCrossProtocolRedirects = bl2;
    }

    public DefaultHttpDataSource createDataSourceInternal(HttpDataSource$RequestProperties object) {
        String string2 = this.userAgent;
        int n10 = this.connectTimeoutMillis;
        int n11 = this.readTimeoutMillis;
        boolean bl2 = this.allowCrossProtocolRedirects;
        DefaultHttpDataSource defaultHttpDataSource = new DefaultHttpDataSource(string2, n10, n11, bl2, (HttpDataSource$RequestProperties)object);
        object = this.listener;
        if (object != null) {
            defaultHttpDataSource.addTransferListener((TransferListener)object);
        }
        return defaultHttpDataSource;
    }
}

