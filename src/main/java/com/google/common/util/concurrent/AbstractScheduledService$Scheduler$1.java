/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractScheduledService$Scheduler;
import com.google.common.util.concurrent.AbstractService;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public final class AbstractScheduledService$Scheduler$1
extends AbstractScheduledService$Scheduler {
    public final /* synthetic */ long val$delay;
    public final /* synthetic */ long val$initialDelay;
    public final /* synthetic */ TimeUnit val$unit;

    public AbstractScheduledService$Scheduler$1(long l10, long l11, TimeUnit timeUnit) {
        this.val$initialDelay = l10;
        this.val$delay = l11;
        this.val$unit = timeUnit;
        super(null);
    }

    public Future schedule(AbstractService abstractService, ScheduledExecutorService scheduledExecutorService, Runnable runnable) {
        long l10 = this.val$initialDelay;
        long l11 = this.val$delay;
        TimeUnit timeUnit = this.val$unit;
        return scheduledExecutorService.scheduleWithFixedDelay(runnable, l10, l11, timeUnit);
    }
}

