/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.upstream.DataSource$Factory;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.upstream.HttpDataSource$RequestProperties;
import java.util.Map;

public interface HttpDataSource$Factory
extends DataSource$Factory {
    public HttpDataSource createDataSource();

    public HttpDataSource$RequestProperties getDefaultRequestProperties();

    public HttpDataSource$Factory setDefaultRequestProperties(Map var1);
}

