/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.collect.ImmutableCollection;
import com.google.common.util.concurrent.AggregateFuture;
import com.google.common.util.concurrent.AggregateFuture$ReleaseResourcesReason;
import com.google.common.util.concurrent.AsyncCallable;
import com.google.common.util.concurrent.CombinedFuture$CombinedFutureInterruptibleTask;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

public final class CombinedFuture
extends AggregateFuture {
    private CombinedFuture$CombinedFutureInterruptibleTask task;

    public CombinedFuture(ImmutableCollection serializable, boolean bl2, Executor executor, AsyncCallable asyncCallable) {
        super((ImmutableCollection)serializable, bl2, false);
        super(this, asyncCallable, executor);
        this.task = serializable;
        this.init();
    }

    public CombinedFuture(ImmutableCollection serializable, boolean bl2, Executor executor, Callable callable) {
        super((ImmutableCollection)serializable, bl2, false);
        super(this, callable, executor);
        this.task = serializable;
        this.init();
    }

    public static /* synthetic */ CombinedFuture$CombinedFutureInterruptibleTask access$002(CombinedFuture combinedFuture, CombinedFuture$CombinedFutureInterruptibleTask combinedFuture$CombinedFutureInterruptibleTask) {
        combinedFuture.task = combinedFuture$CombinedFutureInterruptibleTask;
        return combinedFuture$CombinedFutureInterruptibleTask;
    }

    public void collectOneValue(int n10, Object object) {
    }

    public void handleAllCompleted() {
        CombinedFuture$CombinedFutureInterruptibleTask combinedFuture$CombinedFutureInterruptibleTask = this.task;
        if (combinedFuture$CombinedFutureInterruptibleTask != null) {
            combinedFuture$CombinedFutureInterruptibleTask.execute();
        }
    }

    public void interruptTask() {
        CombinedFuture$CombinedFutureInterruptibleTask combinedFuture$CombinedFutureInterruptibleTask = this.task;
        if (combinedFuture$CombinedFutureInterruptibleTask != null) {
            combinedFuture$CombinedFutureInterruptibleTask.interruptTask();
        }
    }

    public void releaseResources(AggregateFuture$ReleaseResourcesReason aggregateFuture$ReleaseResourcesReason) {
        super.releaseResources(aggregateFuture$ReleaseResourcesReason);
        AggregateFuture$ReleaseResourcesReason aggregateFuture$ReleaseResourcesReason2 = AggregateFuture$ReleaseResourcesReason.OUTPUT_FUTURE_DONE;
        if (aggregateFuture$ReleaseResourcesReason == aggregateFuture$ReleaseResourcesReason2) {
            aggregateFuture$ReleaseResourcesReason = null;
            this.task = null;
        }
    }
}

