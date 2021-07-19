/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ForwardingListenableFuture;
import com.google.common.util.concurrent.ListenableFuture;

public abstract class ForwardingListenableFuture$SimpleForwardingListenableFuture
extends ForwardingListenableFuture {
    private final ListenableFuture delegate;

    public ForwardingListenableFuture$SimpleForwardingListenableFuture(ListenableFuture listenableFuture) {
        this.delegate = listenableFuture = (ListenableFuture)Preconditions.checkNotNull(listenableFuture);
    }

    public final ListenableFuture delegate() {
        return this.delegate;
    }
}

