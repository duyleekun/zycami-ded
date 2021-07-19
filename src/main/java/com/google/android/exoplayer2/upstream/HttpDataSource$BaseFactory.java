/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.upstream.HttpDataSource$Factory;
import com.google.android.exoplayer2.upstream.HttpDataSource$RequestProperties;
import java.util.Map;

public abstract class HttpDataSource$BaseFactory
implements HttpDataSource$Factory {
    private final HttpDataSource$RequestProperties defaultRequestProperties;

    public HttpDataSource$BaseFactory() {
        HttpDataSource$RequestProperties httpDataSource$RequestProperties;
        this.defaultRequestProperties = httpDataSource$RequestProperties = new HttpDataSource$RequestProperties();
    }

    public final HttpDataSource createDataSource() {
        HttpDataSource$RequestProperties httpDataSource$RequestProperties = this.defaultRequestProperties;
        return this.createDataSourceInternal(httpDataSource$RequestProperties);
    }

    public abstract HttpDataSource createDataSourceInternal(HttpDataSource$RequestProperties var1);

    public final HttpDataSource$RequestProperties getDefaultRequestProperties() {
        return this.defaultRequestProperties;
    }

    public final HttpDataSource$Factory setDefaultRequestProperties(Map map) {
        this.defaultRequestProperties.clearAndSet(map);
        return this;
    }
}

