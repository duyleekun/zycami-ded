/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractFuture$TrustedFuture;
import com.google.common.util.concurrent.ListenableFuture;

public final class Futures$NonCancellationPropagatingFuture
extends AbstractFuture$TrustedFuture
implements Runnable {
    private ListenableFuture delegate;

    public Futures$NonCancellationPropagatingFuture(ListenableFuture listenableFuture) {
        this.delegate = listenableFuture;
    }

    public void afterDone() {
        this.delegate = null;
    }

    public String pendingToString() {
        ListenableFuture listenableFuture = this.delegate;
        if (listenableFuture != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("delegate=[");
            stringBuilder.append(listenableFuture);
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
        return null;
    }

    public void run() {
        ListenableFuture listenableFuture = this.delegate;
        if (listenableFuture != null) {
            this.setFuture(listenableFuture);
        }
    }
}

