/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import java.util.concurrent.Executor;

public final class ExecutionList$RunnableExecutorPair {
    public final Executor executor;
    public ExecutionList$RunnableExecutorPair next;
    public final Runnable runnable;

    public ExecutionList$RunnableExecutorPair(Runnable runnable, Executor executor, ExecutionList$RunnableExecutorPair executionList$RunnableExecutorPair) {
        this.runnable = runnable;
        this.executor = executor;
        this.next = executionList$RunnableExecutorPair;
    }
}

