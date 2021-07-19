/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf.transport;

import com.google.firebase.perf.transport.TransportManager;

public final class TransportManager$$Lambda$1
implements Runnable {
    private final TransportManager arg$1;

    private TransportManager$$Lambda$1(TransportManager transportManager) {
        this.arg$1 = transportManager;
    }

    public static Runnable lambdaFactory$(TransportManager transportManager) {
        TransportManager$$Lambda$1 transportManager$$Lambda$1 = new TransportManager$$Lambda$1(transportManager);
        return transportManager$$Lambda$1;
    }

    public void run() {
        TransportManager.access$lambda$0(this.arg$1);
    }
}

