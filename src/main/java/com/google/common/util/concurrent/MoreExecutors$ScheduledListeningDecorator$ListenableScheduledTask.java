/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.ForwardingListenableFuture$SimpleForwardingListenableFuture;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableScheduledFuture;
import java.util.concurrent.Delayed;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public final class MoreExecutors$ScheduledListeningDecorator$ListenableScheduledTask
extends ForwardingListenableFuture$SimpleForwardingListenableFuture
implements ListenableScheduledFuture {
    private final ScheduledFuture scheduledDelegate;

    public MoreExecutors$ScheduledListeningDecorator$ListenableScheduledTask(ListenableFuture listenableFuture, ScheduledFuture scheduledFuture) {
        super(listenableFuture);
        this.scheduledDelegate = scheduledFuture;
    }

    public boolean cancel(boolean bl2) {
        boolean bl3 = super.cancel(bl2);
        if (bl3) {
            ScheduledFuture scheduledFuture = this.scheduledDelegate;
            scheduledFuture.cancel(bl2);
        }
        return bl3;
    }

    public int compareTo(Delayed delayed) {
        return this.scheduledDelegate.compareTo(delayed);
    }

    public long getDelay(TimeUnit timeUnit) {
        return this.scheduledDelegate.getDelay(timeUnit);
    }
}

