/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.AbstractFuture;
import com.google.common.util.concurrent.AsyncCallable;
import com.google.common.util.concurrent.InterruptibleTask;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.TrustedListenableFutureTask;

public final class TrustedListenableFutureTask$TrustedFutureInterruptibleAsyncTask
extends InterruptibleTask {
    private final AsyncCallable callable;
    public final /* synthetic */ TrustedListenableFutureTask this$0;

    public TrustedListenableFutureTask$TrustedFutureInterruptibleAsyncTask(TrustedListenableFutureTask object, AsyncCallable asyncCallable) {
        this.this$0 = object;
        this.callable = object = (AsyncCallable)Preconditions.checkNotNull(asyncCallable);
    }

    public void afterRanInterruptibly(ListenableFuture listenableFuture, Throwable object) {
        if (object == null) {
            object = this.this$0;
            ((AbstractFuture)object).setFuture(listenableFuture);
        } else {
            listenableFuture = this.this$0;
            ((AbstractFuture)listenableFuture).setException((Throwable)object);
        }
    }

    public final boolean isDone() {
        return this.this$0.isDone();
    }

    public ListenableFuture runInterruptibly() {
        ListenableFuture listenableFuture = this.callable.call();
        AsyncCallable asyncCallable = this.callable;
        return (ListenableFuture)Preconditions.checkNotNull((Object)listenableFuture, "AsyncCallable.call returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", (Object)asyncCallable);
    }

    public String toPendingString() {
        return this.callable.toString();
    }
}

