/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.ExecutionSequencer;
import com.google.common.util.concurrent.ExecutionSequencer$RunningState;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.concurrent.atomic.AtomicReference;

public class ExecutionSequencer$4
implements Runnable {
    public final /* synthetic */ ExecutionSequencer this$0;
    public final /* synthetic */ SettableFuture val$newFuture;
    public final /* synthetic */ ListenableFuture val$oldFuture;
    public final /* synthetic */ ListenableFuture val$outputFuture;
    public final /* synthetic */ AtomicReference val$runningState;
    public final /* synthetic */ ListenableFuture val$taskFuture;

    public ExecutionSequencer$4(ExecutionSequencer executionSequencer, ListenableFuture listenableFuture, ListenableFuture listenableFuture2, AtomicReference atomicReference, SettableFuture settableFuture, ListenableFuture listenableFuture3) {
        this.this$0 = executionSequencer;
        this.val$taskFuture = listenableFuture;
        this.val$outputFuture = listenableFuture2;
        this.val$runningState = atomicReference;
        this.val$newFuture = settableFuture;
        this.val$oldFuture = listenableFuture3;
    }

    public void run() {
        ExecutionSequencer$RunningState executionSequencer$RunningState;
        Object object;
        Object object2 = this.val$taskFuture;
        boolean bl2 = object2.isDone();
        if (bl2 || (bl2 = (object2 = this.val$outputFuture).isCancelled()) && (bl2 = ((AtomicReference)(object2 = this.val$runningState)).compareAndSet(object = ExecutionSequencer$RunningState.NOT_RUN, executionSequencer$RunningState = ExecutionSequencer$RunningState.CANCELLED))) {
            object2 = this.val$newFuture;
            object = this.val$oldFuture;
            ((SettableFuture)object2).setFuture((ListenableFuture)object);
        }
    }
}

