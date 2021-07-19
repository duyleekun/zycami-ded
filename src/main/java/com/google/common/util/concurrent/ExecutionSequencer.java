/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.AsyncCallable;
import com.google.common.util.concurrent.ExecutionSequencer$1;
import com.google.common.util.concurrent.ExecutionSequencer$2;
import com.google.common.util.concurrent.ExecutionSequencer$3;
import com.google.common.util.concurrent.ExecutionSequencer$4;
import com.google.common.util.concurrent.ExecutionSequencer$RunningState;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.SettableFuture;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

public final class ExecutionSequencer {
    private final AtomicReference ref;

    private ExecutionSequencer() {
        AtomicReference<ListenableFuture> atomicReference;
        ListenableFuture listenableFuture = Futures.immediateFuture(null);
        this.ref = atomicReference = new AtomicReference<ListenableFuture>(listenableFuture);
    }

    public static ExecutionSequencer create() {
        ExecutionSequencer executionSequencer = new ExecutionSequencer();
        return executionSequencer;
    }

    public ListenableFuture submit(Callable callable, Executor executor) {
        Preconditions.checkNotNull(callable);
        ExecutionSequencer$1 executionSequencer$1 = new ExecutionSequencer$1(this, callable);
        return this.submitAsync(executionSequencer$1, executor);
    }

    public ListenableFuture submitAsync(AsyncCallable object, Executor object2) {
        ExecutionSequencer$4 executionSequencer$4;
        Preconditions.checkNotNull(object);
        Object object3 = ExecutionSequencer$RunningState.NOT_RUN;
        AtomicReference<ExecutionSequencer$RunningState> atomicReference = new AtomicReference<ExecutionSequencer$RunningState>((ExecutionSequencer$RunningState)((Object)object3));
        object3 = new ExecutionSequencer$2(this, atomicReference, (AsyncCallable)object);
        SettableFuture settableFuture = SettableFuture.create();
        Object object4 = object = this.ref.getAndSet(settableFuture);
        object4 = (ListenableFuture)object;
        object = new ExecutionSequencer$3(this, (ListenableFuture)object4, (Executor)object2);
        object = Futures.submitAsync((AsyncCallable)object3, (Executor)object);
        object2 = Futures.nonCancellationPropagating((ListenableFuture)object);
        object3 = executionSequencer$4;
        executionSequencer$4 = new ExecutionSequencer$4(this, (ListenableFuture)object, (ListenableFuture)object2, atomicReference, settableFuture, (ListenableFuture)object4);
        object3 = MoreExecutors.directExecutor();
        object2.addListener(executionSequencer$4, (Executor)object3);
        object3 = MoreExecutors.directExecutor();
        object.addListener(executionSequencer$4, (Executor)object3);
        return object2;
    }
}

