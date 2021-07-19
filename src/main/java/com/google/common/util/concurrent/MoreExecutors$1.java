/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.BlockingQueue;

public final class MoreExecutors$1
implements Runnable {
    public final /* synthetic */ ListenableFuture val$future;
    public final /* synthetic */ BlockingQueue val$queue;

    public MoreExecutors$1(BlockingQueue blockingQueue, ListenableFuture listenableFuture) {
        this.val$queue = blockingQueue;
        this.val$future = listenableFuture;
    }

    public void run() {
        BlockingQueue blockingQueue = this.val$queue;
        ListenableFuture listenableFuture = this.val$future;
        blockingQueue.add(listenableFuture);
    }
}

