/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractFuture$TrustedFuture;
import com.google.common.util.concurrent.ListenableFuture;

public final class SettableFuture
extends AbstractFuture$TrustedFuture {
    private SettableFuture() {
    }

    public static SettableFuture create() {
        SettableFuture settableFuture = new SettableFuture();
        return settableFuture;
    }

    public boolean set(Object object) {
        return super.set(object);
    }

    public boolean setException(Throwable throwable) {
        return super.setException(throwable);
    }

    public boolean setFuture(ListenableFuture listenableFuture) {
        return super.setFuture(listenableFuture);
    }
}

