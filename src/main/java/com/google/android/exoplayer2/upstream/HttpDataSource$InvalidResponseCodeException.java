/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.HttpDataSource$HttpDataSourceException;
import com.google.android.exoplayer2.util.Util;
import java.util.Map;

public final class HttpDataSource$InvalidResponseCodeException
extends HttpDataSource$HttpDataSourceException {
    public final Map headerFields;
    public final byte[] responseBody;
    public final int responseCode;
    public final String responseMessage;

    public HttpDataSource$InvalidResponseCodeException(int n10, String string2, Map map, DataSpec dataSpec) {
        byte[] byArray = Util.EMPTY_BYTE_ARRAY;
        this(n10, string2, map, dataSpec, byArray);
    }

    public HttpDataSource$InvalidResponseCodeException(int n10, String string2, Map map, DataSpec dataSpec, byte[] byArray) {
        CharSequence charSequence = new StringBuilder(26);
        charSequence.append("Response code: ");
        charSequence.append(n10);
        charSequence = charSequence.toString();
        super((String)charSequence, dataSpec, 1);
        this.responseCode = n10;
        this.responseMessage = string2;
        this.headerFields = map;
        this.responseBody = byArray;
    }

    public HttpDataSource$InvalidResponseCodeException(int n10, Map map, DataSpec dataSpec) {
        byte[] byArray = Util.EMPTY_BYTE_ARRAY;
        this(n10, null, map, dataSpec, byArray);
    }
}

