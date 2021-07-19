/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.upstream.DefaultHttpDataSource;
import com.google.android.exoplayer2.upstream.HttpDataSource$Factory;
import com.google.android.exoplayer2.upstream.HttpDataSource$RequestProperties;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.common.base.Predicate;
import java.util.Map;

public final class DefaultHttpDataSource$Factory
implements HttpDataSource$Factory {
    private boolean allowCrossProtocolRedirects;
    private int connectTimeoutMs;
    private Predicate contentTypePredicate;
    private final HttpDataSource$RequestProperties defaultRequestProperties;
    private int readTimeoutMs;
    private TransferListener transferListener;
    private String userAgent;

    public DefaultHttpDataSource$Factory() {
        int n10;
        HttpDataSource$RequestProperties httpDataSource$RequestProperties;
        this.defaultRequestProperties = httpDataSource$RequestProperties = new HttpDataSource$RequestProperties();
        this.connectTimeoutMs = n10 = 8000;
        this.readTimeoutMs = n10;
    }

    public DefaultHttpDataSource createDataSource() {
        DefaultHttpDataSource defaultHttpDataSource;
        String string2 = this.userAgent;
        int n10 = this.connectTimeoutMs;
        int n11 = this.readTimeoutMs;
        boolean bl2 = this.allowCrossProtocolRedirects;
        HttpDataSource$RequestProperties httpDataSource$RequestProperties = this.defaultRequestProperties;
        Predicate predicate = this.contentTypePredicate;
        Object object = defaultHttpDataSource;
        defaultHttpDataSource = new DefaultHttpDataSource(string2, n10, n11, bl2, httpDataSource$RequestProperties, predicate, null);
        object = this.transferListener;
        if (object != null) {
            defaultHttpDataSource.addTransferListener((TransferListener)object);
        }
        return defaultHttpDataSource;
    }

    public final HttpDataSource$RequestProperties getDefaultRequestProperties() {
        return this.defaultRequestProperties;
    }

    public DefaultHttpDataSource$Factory setAllowCrossProtocolRedirects(boolean bl2) {
        this.allowCrossProtocolRedirects = bl2;
        return this;
    }

    public DefaultHttpDataSource$Factory setConnectTimeoutMs(int n10) {
        this.connectTimeoutMs = n10;
        return this;
    }

    public DefaultHttpDataSource$Factory setContentTypePredicate(Predicate predicate) {
        this.contentTypePredicate = predicate;
        return this;
    }

    public final DefaultHttpDataSource$Factory setDefaultRequestProperties(Map map) {
        this.defaultRequestProperties.clearAndSet(map);
        return this;
    }

    public DefaultHttpDataSource$Factory setReadTimeoutMs(int n10) {
        this.readTimeoutMs = n10;
        return this;
    }

    public DefaultHttpDataSource$Factory setTransferListener(TransferListener transferListener) {
        this.transferListener = transferListener;
        return this;
    }

    public DefaultHttpDataSource$Factory setUserAgent(String string2) {
        this.userAgent = string2;
        return this;
    }
}

