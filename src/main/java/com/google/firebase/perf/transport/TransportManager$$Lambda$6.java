/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf.transport;

import com.google.firebase.perf.transport.TransportManager;
import com.google.firebase.perf.v1.ApplicationProcessState;
import com.google.firebase.perf.v1.GaugeMetric;

public final class TransportManager$$Lambda$6
implements Runnable {
    private final TransportManager arg$1;
    private final GaugeMetric arg$2;
    private final ApplicationProcessState arg$3;

    private TransportManager$$Lambda$6(TransportManager transportManager, GaugeMetric gaugeMetric, ApplicationProcessState applicationProcessState) {
        this.arg$1 = transportManager;
        this.arg$2 = gaugeMetric;
        this.arg$3 = applicationProcessState;
    }

    public static Runnable lambdaFactory$(TransportManager transportManager, GaugeMetric gaugeMetric, ApplicationProcessState applicationProcessState) {
        TransportManager$$Lambda$6 transportManager$$Lambda$6 = new TransportManager$$Lambda$6(transportManager, gaugeMetric, applicationProcessState);
        return transportManager$$Lambda$6;
    }

    public void run() {
        TransportManager transportManager = this.arg$1;
        GaugeMetric gaugeMetric = this.arg$2;
        ApplicationProcessState applicationProcessState = this.arg$3;
        TransportManager.lambda$log$4(transportManager, gaugeMetric, applicationProcessState);
    }
}

