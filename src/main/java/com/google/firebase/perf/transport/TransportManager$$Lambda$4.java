/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf.transport;

import com.google.firebase.perf.transport.TransportManager;
import com.google.firebase.perf.v1.ApplicationProcessState;
import com.google.firebase.perf.v1.TraceMetric;

public final class TransportManager$$Lambda$4
implements Runnable {
    private final TransportManager arg$1;
    private final TraceMetric arg$2;
    private final ApplicationProcessState arg$3;

    private TransportManager$$Lambda$4(TransportManager transportManager, TraceMetric traceMetric, ApplicationProcessState applicationProcessState) {
        this.arg$1 = transportManager;
        this.arg$2 = traceMetric;
        this.arg$3 = applicationProcessState;
    }

    public static Runnable lambdaFactory$(TransportManager transportManager, TraceMetric traceMetric, ApplicationProcessState applicationProcessState) {
        TransportManager$$Lambda$4 transportManager$$Lambda$4 = new TransportManager$$Lambda$4(transportManager, traceMetric, applicationProcessState);
        return transportManager$$Lambda$4;
    }

    public void run() {
        TransportManager transportManager = this.arg$1;
        TraceMetric traceMetric = this.arg$2;
        ApplicationProcessState applicationProcessState = this.arg$3;
        TransportManager.lambda$log$2(transportManager, traceMetric, applicationProcessState);
    }
}

