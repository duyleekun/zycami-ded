/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf.transport;

import com.google.firebase.perf.transport.TransportManager;

public final class TransportManager$$Lambda$3
implements Runnable {
    private final TransportManager arg$1;

    private TransportManager$$Lambda$3(TransportManager transportManager) {
        this.arg$1 = transportManager;
    }

    public static Runnable lambdaFactory$(TransportManager transportManager) {
        TransportManager$$Lambda$3 transportManager$$Lambda$3 = new TransportManager$$Lambda$3(transportManager);
        return transportManager$$Lambda$3;
    }

    public void run() {
        TransportManager.lambda$onUpdateAppState$1(this.arg$1);
    }
}

