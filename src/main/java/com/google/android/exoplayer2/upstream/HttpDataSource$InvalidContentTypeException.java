/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.HttpDataSource$HttpDataSourceException;

public final class HttpDataSource$InvalidContentTypeException
extends HttpDataSource$HttpDataSourceException {
    public final String contentType;

    public HttpDataSource$InvalidContentTypeException(String string2, DataSpec dataSpec) {
        String string3 = String.valueOf(string2);
        int n10 = string3.length();
        String string4 = "Invalid content type: ";
        string3 = n10 != 0 ? string4.concat(string3) : new String(string4);
        super(string3, dataSpec, 1);
        this.contentType = string2;
    }
}

