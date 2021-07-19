/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.ExecutionSequencer;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

public class ExecutionSequencer$3
implements Executor {
    public final /* synthetic */ ExecutionSequencer this$0;
    public final /* synthetic */ Executor val$executor;
    public final /* synthetic */ ListenableFuture val$oldFuture;

    public ExecutionSequencer$3(ExecutionSequencer executionSequencer, ListenableFuture listenableFuture, Executor executor) {
        this.this$0 = executionSequencer;
        this.val$oldFuture = listenableFuture;
        this.val$executor = executor;
    }

    public void execute(Runnable runnable) {
        ListenableFuture listenableFuture = this.val$oldFuture;
        Executor executor = this.val$executor;
        listenableFuture.addListener(runnable, executor);
    }
}

