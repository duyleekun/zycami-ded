/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.AbstractListeningExecutorService;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class MoreExecutors$ListeningDecorator
extends AbstractListeningExecutorService {
    private final ExecutorService delegate;

    public MoreExecutors$ListeningDecorator(ExecutorService executorService) {
        this.delegate = executorService = (ExecutorService)Preconditions.checkNotNull(executorService);
    }

    public final boolean awaitTermination(long l10, TimeUnit timeUnit) {
        return this.delegate.awaitTermination(l10, timeUnit);
    }

    public final void execute(Runnable runnable) {
        this.delegate.execute(runnable);
    }

    public final boolean isShutdown() {
        return this.delegate.isShutdown();
    }

    public final boolean isTerminated() {
        return this.delegate.isTerminated();
    }

    public final void shutdown() {
        this.delegate.shutdown();
    }

    public final List shutdownNow() {
        return this.delegate.shutdownNow();
    }
}

