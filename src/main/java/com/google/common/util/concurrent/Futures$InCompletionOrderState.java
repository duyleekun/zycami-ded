/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.AbstractFuture;
import com.google.common.util.concurrent.Futures$1;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public final class Futures$InCompletionOrderState {
    private volatile int delegateIndex = 0;
    private final AtomicInteger incompleteOutputCount;
    private final ListenableFuture[] inputFutures;
    private boolean shouldInterrupt = true;
    private boolean wasCancelled = false;

    private Futures$InCompletionOrderState(ListenableFuture[] listenableFutureArray) {
        AtomicInteger atomicInteger;
        this.inputFutures = listenableFutureArray;
        int n10 = listenableFutureArray.length;
        this.incompleteOutputCount = atomicInteger = new AtomicInteger(n10);
    }

    public /* synthetic */ Futures$InCompletionOrderState(ListenableFuture[] listenableFutureArray, Futures$1 futures$1) {
        this(listenableFutureArray);
    }

    public static /* synthetic */ void access$300(Futures$InCompletionOrderState futures$InCompletionOrderState, ImmutableList immutableList, int n10) {
        futures$InCompletionOrderState.recordInputCompletion(immutableList, n10);
    }

    public static /* synthetic */ void access$400(Futures$InCompletionOrderState futures$InCompletionOrderState, boolean bl2) {
        futures$InCompletionOrderState.recordOutputCancellation(bl2);
    }

    public static /* synthetic */ ListenableFuture[] access$500(Futures$InCompletionOrderState futures$InCompletionOrderState) {
        return futures$InCompletionOrderState.inputFutures;
    }

    public static /* synthetic */ AtomicInteger access$600(Futures$InCompletionOrderState futures$InCompletionOrderState) {
        return futures$InCompletionOrderState.incompleteOutputCount;
    }

    private void recordCompletion() {
        ListenableFuture[] listenableFutureArray = this.incompleteOutputCount;
        int n10 = listenableFutureArray.decrementAndGet();
        if (n10 == 0 && (n10 = (int)(this.wasCancelled ? 1 : 0)) != 0) {
            for (ListenableFuture listenableFuture : this.inputFutures) {
                if (listenableFuture == null) continue;
                boolean bl2 = this.shouldInterrupt;
                listenableFuture.cancel(bl2);
            }
        }
    }

    private void recordInputCompletion(ImmutableList immutableList, int n10) {
        int n11;
        int n12;
        Object object = this.inputFutures;
        ListenableFuture listenableFuture = object[n10];
        object[n10] = null;
        for (n10 = this.delegateIndex; n10 < (n12 = immutableList.size()); ++n10) {
            object = (AbstractFuture)immutableList.get(n10);
            n12 = (int)(((AbstractFuture)object).setFuture(listenableFuture) ? 1 : 0);
            if (n12 == 0) continue;
            this.recordCompletion();
            this.delegateIndex = ++n10;
            return;
        }
        this.delegateIndex = n11 = immutableList.size();
    }

    private void recordOutputCancellation(boolean bl2) {
        boolean bl3;
        this.wasCancelled = bl3 = true;
        if (!bl2) {
            bl2 = false;
            this.shouldInterrupt = false;
        }
        this.recordCompletion();
    }
}

