/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf.transport;

import com.google.android.datatransport.Transformer;
import com.google.firebase.perf.v1.PerfMetric;

public final class FlgTransport$$Lambda$1
implements Transformer {
    private static final FlgTransport$$Lambda$1 instance;

    static {
        FlgTransport$$Lambda$1 flgTransport$$Lambda$1;
        instance = flgTransport$$Lambda$1 = new FlgTransport$$Lambda$1();
    }

    private FlgTransport$$Lambda$1() {
    }

    public static Transformer lambdaFactory$() {
        return instance;
    }

    public Object apply(Object object) {
        return ((PerfMetric)object).toByteArray();
    }
}

