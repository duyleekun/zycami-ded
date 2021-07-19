/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AsyncCallable;
import com.google.common.util.concurrent.ExecutionSequencer;
import com.google.common.util.concurrent.ExecutionSequencer$RunningState;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.atomic.AtomicReference;

public class ExecutionSequencer$2
implements AsyncCallable {
    public final /* synthetic */ ExecutionSequencer this$0;
    public final /* synthetic */ AsyncCallable val$callable;
    public final /* synthetic */ AtomicReference val$runningState;

    public ExecutionSequencer$2(ExecutionSequencer executionSequencer, AtomicReference atomicReference, AsyncCallable asyncCallable) {
        this.this$0 = executionSequencer;
        this.val$runningState = atomicReference;
        this.val$callable = asyncCallable;
    }

    public ListenableFuture call() {
        AtomicReference atomicReference = this.val$runningState;
        ExecutionSequencer$RunningState executionSequencer$RunningState = ExecutionSequencer$RunningState.NOT_RUN;
        ExecutionSequencer$RunningState executionSequencer$RunningState2 = ExecutionSequencer$RunningState.STARTED;
        boolean bl2 = atomicReference.compareAndSet(executionSequencer$RunningState, executionSequencer$RunningState2);
        if (!bl2) {
            return Futures.immediateCancelledFuture();
        }
        return this.val$callable.call();
    }

    public String toString() {
        return this.val$callable.toString();
    }
}

