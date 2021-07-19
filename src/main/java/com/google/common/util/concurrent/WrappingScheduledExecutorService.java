/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.WrappingExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public abstract class WrappingScheduledExecutorService
extends WrappingExecutorService
implements ScheduledExecutorService {
    public final ScheduledExecutorService delegate;

    public WrappingScheduledExecutorService(ScheduledExecutorService scheduledExecutorService) {
        super(scheduledExecutorService);
        this.delegate = scheduledExecutorService;
    }

    public final ScheduledFuture schedule(Runnable runnable, long l10, TimeUnit timeUnit) {
        ScheduledExecutorService scheduledExecutorService = this.delegate;
        runnable = this.wrapTask(runnable);
        return scheduledExecutorService.schedule(runnable, l10, timeUnit);
    }

    public final ScheduledFuture schedule(Callable callable, long l10, TimeUnit timeUnit) {
        ScheduledExecutorService scheduledExecutorService = this.delegate;
        callable = this.wrapTask(callable);
        return scheduledExecutorService.schedule(callable, l10, timeUnit);
    }

    public final ScheduledFuture scheduleAtFixedRate(Runnable runnable, long l10, long l11, TimeUnit timeUnit) {
        ScheduledExecutorService scheduledExecutorService = this.delegate;
        Runnable runnable2 = this.wrapTask(runnable);
        return scheduledExecutorService.scheduleAtFixedRate(runnable2, l10, l11, timeUnit);
    }

    public final ScheduledFuture scheduleWithFixedDelay(Runnable runnable, long l10, long l11, TimeUnit timeUnit) {
        ScheduledExecutorService scheduledExecutorService = this.delegate;
        Runnable runnable2 = this.wrapTask(runnable);
        return scheduledExecutorService.scheduleWithFixedDelay(runnable2, l10, l11, timeUnit);
    }
}

