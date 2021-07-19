/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.AsyncCallable;
import com.google.common.util.concurrent.CombinedFuture;
import com.google.common.util.concurrent.CombinedFuture$CombinedFutureInterruptibleTask;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

public final class CombinedFuture$AsyncCallableInterruptibleTask
extends CombinedFuture$CombinedFutureInterruptibleTask {
    private final AsyncCallable callable;
    public final /* synthetic */ CombinedFuture this$0;

    public CombinedFuture$AsyncCallableInterruptibleTask(CombinedFuture object, AsyncCallable asyncCallable, Executor executor) {
        this.this$0 = object;
        super((CombinedFuture)object, executor);
        this.callable = object = (AsyncCallable)Preconditions.checkNotNull(asyncCallable);
    }

    public ListenableFuture runInterruptibly() {
        this.thrownByExecute = false;
        ListenableFuture listenableFuture = this.callable.call();
        AsyncCallable asyncCallable = this.callable;
        return (ListenableFuture)Preconditions.checkNotNull((Object)listenableFuture, "AsyncCallable.call returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", (Object)asyncCallable);
    }

    public void setValue(ListenableFuture listenableFuture) {
        this.this$0.setFuture(listenableFuture);
    }

    public String toPendingString() {
        return this.callable.toString();
    }
}

