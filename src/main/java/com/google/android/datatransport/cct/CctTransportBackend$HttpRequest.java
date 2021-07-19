/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.cct;

import com.google.android.datatransport.cct.internal.BatchedLogRequest;
import java.net.URL;

public final class CctTransportBackend$HttpRequest {
    public final String apiKey;
    public final BatchedLogRequest requestBody;
    public final URL url;

    public CctTransportBackend$HttpRequest(URL uRL, BatchedLogRequest batchedLogRequest, String string2) {
        this.url = uRL;
        this.requestBody = batchedLogRequest;
        this.apiKey = string2;
    }

    public CctTransportBackend$HttpRequest withUrl(URL uRL) {
        BatchedLogRequest batchedLogRequest = this.requestBody;
        String string2 = this.apiKey;
        CctTransportBackend$HttpRequest cctTransportBackend$HttpRequest = new CctTransportBackend$HttpRequest(uRL, batchedLogRequest, string2);
        return cctTransportBackend$HttpRequest;
    }
}

