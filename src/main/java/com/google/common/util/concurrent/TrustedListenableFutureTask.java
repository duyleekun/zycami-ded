/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AsyncCallable;
import com.google.common.util.concurrent.FluentFuture$TrustedFuture;
import com.google.common.util.concurrent.InterruptibleTask;
import com.google.common.util.concurrent.TrustedListenableFutureTask$TrustedFutureInterruptibleAsyncTask;
import com.google.common.util.concurrent.TrustedListenableFutureTask$TrustedFutureInterruptibleTask;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.RunnableFuture;

public class TrustedListenableFutureTask
extends FluentFuture$TrustedFuture
implements RunnableFuture {
    private volatile InterruptibleTask task;

    public TrustedListenableFutureTask(AsyncCallable asyncCallable) {
        TrustedListenableFutureTask$TrustedFutureInterruptibleAsyncTask trustedListenableFutureTask$TrustedFutureInterruptibleAsyncTask = new TrustedListenableFutureTask$TrustedFutureInterruptibleAsyncTask(this, asyncCallable);
        this.task = trustedListenableFutureTask$TrustedFutureInterruptibleAsyncTask;
    }

    public TrustedListenableFutureTask(Callable callable) {
        TrustedListenableFutureTask$TrustedFutureInterruptibleTask trustedListenableFutureTask$TrustedFutureInterruptibleTask = new TrustedListenableFutureTask$TrustedFutureInterruptibleTask(this, callable);
        this.task = trustedListenableFutureTask$TrustedFutureInterruptibleTask;
    }

    public static TrustedListenableFutureTask create(AsyncCallable asyncCallable) {
        TrustedListenableFutureTask trustedListenableFutureTask = new TrustedListenableFutureTask(asyncCallable);
        return trustedListenableFutureTask;
    }

    public static TrustedListenableFutureTask create(Runnable object, Object object2) {
        object = Executors.callable((Runnable)object, object2);
        TrustedListenableFutureTask trustedListenableFutureTask = new TrustedListenableFutureTask((Callable)object);
        return trustedListenableFutureTask;
    }

    public static TrustedListenableFutureTask create(Callable callable) {
        TrustedListenableFutureTask trustedListenableFutureTask = new TrustedListenableFutureTask(callable);
        return trustedListenableFutureTask;
    }

    public void afterDone() {
        InterruptibleTask interruptibleTask;
        super.afterDone();
        boolean bl2 = this.wasInterrupted();
        if (bl2 && (interruptibleTask = this.task) != null) {
            interruptibleTask.interruptTask();
        }
        this.task = null;
    }

    public String pendingToString() {
        InterruptibleTask interruptibleTask = this.task;
        if (interruptibleTask != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("task=[");
            stringBuilder.append(interruptibleTask);
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
        return super.pendingToString();
    }

    public void run() {
        InterruptibleTask interruptibleTask = this.task;
        if (interruptibleTask != null) {
            interruptibleTask.run();
        }
        this.task = null;
    }
}

