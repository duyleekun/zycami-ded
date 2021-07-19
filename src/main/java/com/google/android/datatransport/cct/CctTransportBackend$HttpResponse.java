/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.cct;

import java.net.URL;

public final class CctTransportBackend$HttpResponse {
    public final int code;
    public final long nextRequestMillis;
    public final URL redirectUrl;

    public CctTransportBackend$HttpResponse(int n10, URL uRL, long l10) {
        this.code = n10;
        this.redirectUrl = uRL;
        this.nextRequestMillis = l10;
    }
}

