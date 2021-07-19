/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.cct;

import com.google.android.datatransport.cct.CctTransportBackend;
import com.google.android.datatransport.cct.CctTransportBackend$HttpRequest;
import com.google.android.datatransport.cct.CctTransportBackend$HttpResponse;
import com.google.android.datatransport.runtime.retries.RetryStrategy;

public final class CctTransportBackend$$Lambda$4
implements RetryStrategy {
    private static final CctTransportBackend$$Lambda$4 instance;

    static {
        CctTransportBackend$$Lambda$4 cctTransportBackend$$Lambda$4;
        instance = cctTransportBackend$$Lambda$4 = new CctTransportBackend$$Lambda$4();
    }

    private CctTransportBackend$$Lambda$4() {
    }

    public static RetryStrategy lambdaFactory$() {
        return instance;
    }

    public Object shouldRetry(Object object, Object object2) {
        object = (CctTransportBackend$HttpRequest)object;
        object2 = (CctTransportBackend$HttpResponse)object2;
        return CctTransportBackend.lambda$send$0((CctTransportBackend$HttpRequest)object, (CctTransportBackend$HttpResponse)object2);
    }
}

