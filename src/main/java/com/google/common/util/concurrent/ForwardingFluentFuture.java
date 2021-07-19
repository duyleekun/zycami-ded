/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.FluentFuture;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public final class ForwardingFluentFuture
extends FluentFuture {
    private final ListenableFuture delegate;

    public ForwardingFluentFuture(ListenableFuture listenableFuture) {
        this.delegate = listenableFuture = (ListenableFuture)Preconditions.checkNotNull(listenableFuture);
    }

    public void addListener(Runnable runnable, Executor executor) {
        this.delegate.addListener(runnable, executor);
    }

    public boolean cancel(boolean bl2) {
        return this.delegate.cancel(bl2);
    }

    public Object get() {
        return this.delegate.get();
    }

    public Object get(long l10, TimeUnit timeUnit) {
        return this.delegate.get(l10, timeUnit);
    }

    public boolean isCancelled() {
        return this.delegate.isCancelled();
    }

    public boolean isDone() {
        return this.delegate.isDone();
    }

    public String toString() {
        return this.delegate.toString();
    }
}

