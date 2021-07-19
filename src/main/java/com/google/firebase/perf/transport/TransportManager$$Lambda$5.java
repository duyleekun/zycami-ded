/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf.transport;

import com.google.firebase.perf.transport.TransportManager;
import com.google.firebase.perf.v1.ApplicationProcessState;
import com.google.firebase.perf.v1.NetworkRequestMetric;

public final class TransportManager$$Lambda$5
implements Runnable {
    private final TransportManager arg$1;
    private final NetworkRequestMetric arg$2;
    private final ApplicationProcessState arg$3;

    private TransportManager$$Lambda$5(TransportManager transportManager, NetworkRequestMetric networkRequestMetric, ApplicationProcessState applicationProcessState) {
        this.arg$1 = transportManager;
        this.arg$2 = networkRequestMetric;
        this.arg$3 = applicationProcessState;
    }

    public static Runnable lambdaFactory$(TransportManager transportManager, NetworkRequestMetric networkRequestMetric, ApplicationProcessState applicationProcessState) {
        TransportManager$$Lambda$5 transportManager$$Lambda$5 = new TransportManager$$Lambda$5(transportManager, networkRequestMetric, applicationProcessState);
        return transportManager$$Lambda$5;
    }

    public void run() {
        TransportManager transportManager = this.arg$1;
        NetworkRequestMetric networkRequestMetric = this.arg$2;
        ApplicationProcessState applicationProcessState = this.arg$3;
        TransportManager.lambda$log$3(transportManager, networkRequestMetric, applicationProcessState);
    }
}

