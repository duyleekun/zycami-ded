/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.cct;

import com.google.android.datatransport.cct.CctTransportBackend;
import com.google.android.datatransport.cct.CctTransportBackend$HttpRequest;
import com.google.android.datatransport.runtime.retries.Function;

public final class CctTransportBackend$$Lambda$1
implements Function {
    private final CctTransportBackend arg$1;

    private CctTransportBackend$$Lambda$1(CctTransportBackend cctTransportBackend) {
        this.arg$1 = cctTransportBackend;
    }

    public static Function lambdaFactory$(CctTransportBackend cctTransportBackend) {
        CctTransportBackend$$Lambda$1 cctTransportBackend$$Lambda$1 = new CctTransportBackend$$Lambda$1(cctTransportBackend);
        return cctTransportBackend$$Lambda$1;
    }

    public Object apply(Object object) {
        CctTransportBackend cctTransportBackend = this.arg$1;
        object = (CctTransportBackend$HttpRequest)object;
        return CctTransportBackend.access$lambda$0(cctTransportBackend, (CctTransportBackend$HttpRequest)object);
    }
}

