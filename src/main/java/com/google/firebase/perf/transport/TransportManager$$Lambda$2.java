/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf.transport;

import com.google.firebase.perf.transport.PendingPerfEvent;
import com.google.firebase.perf.transport.TransportManager;

public final class TransportManager$$Lambda$2
implements Runnable {
    private final TransportManager arg$1;
    private final PendingPerfEvent arg$2;

    private TransportManager$$Lambda$2(TransportManager transportManager, PendingPerfEvent pendingPerfEvent) {
        this.arg$1 = transportManager;
        this.arg$2 = pendingPerfEvent;
    }

    public static Runnable lambdaFactory$(TransportManager transportManager, PendingPerfEvent pendingPerfEvent) {
        TransportManager$$Lambda$2 transportManager$$Lambda$2 = new TransportManager$$Lambda$2(transportManager, pendingPerfEvent);
        return transportManager$$Lambda$2;
    }

    public void run() {
        TransportManager transportManager = this.arg$1;
        PendingPerfEvent pendingPerfEvent = this.arg$2;
        TransportManager.lambda$finishInitialization$0(transportManager, pendingPerfEvent);
    }
}

