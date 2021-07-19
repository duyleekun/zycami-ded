/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.ForwardingFuture;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

public abstract class ForwardingListenableFuture
extends ForwardingFuture
implements ListenableFuture {
    public void addListener(Runnable runnable, Executor executor) {
        this.delegate().addListener(runnable, executor);
    }

    public abstract ListenableFuture delegate();
}

