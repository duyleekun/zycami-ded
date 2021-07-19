/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import com.google.common.util.concurrent.AbstractFuture$TrustedFuture;

public final class MoreExecutors$ScheduledListeningDecorator$NeverSuccessfulListenableFutureTask
extends AbstractFuture$TrustedFuture
implements Runnable {
    private final Runnable delegate;

    public MoreExecutors$ScheduledListeningDecorator$NeverSuccessfulListenableFutureTask(Runnable runnable) {
        this.delegate = runnable = (Runnable)Preconditions.checkNotNull(runnable);
    }

    public void run() {
        Runnable runnable;
        try {
            runnable = this.delegate;
        }
        catch (Throwable throwable) {
            this.setException(throwable);
            throw Throwables.propagate(throwable);
        }
        runnable.run();
    }
}

