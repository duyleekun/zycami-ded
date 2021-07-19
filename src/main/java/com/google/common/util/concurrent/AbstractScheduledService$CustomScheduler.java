/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractScheduledService$CustomScheduler$ReschedulableCallable;
import com.google.common.util.concurrent.AbstractScheduledService$CustomScheduler$Schedule;
import com.google.common.util.concurrent.AbstractScheduledService$Scheduler;
import com.google.common.util.concurrent.AbstractService;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;

public abstract class AbstractScheduledService$CustomScheduler
extends AbstractScheduledService$Scheduler {
    public AbstractScheduledService$CustomScheduler() {
        super(null);
    }

    public abstract AbstractScheduledService$CustomScheduler$Schedule getNextSchedule();

    public final Future schedule(AbstractService abstractService, ScheduledExecutorService scheduledExecutorService, Runnable runnable) {
        AbstractScheduledService$CustomScheduler$ReschedulableCallable abstractScheduledService$CustomScheduler$ReschedulableCallable = new AbstractScheduledService$CustomScheduler$ReschedulableCallable(this, abstractService, scheduledExecutorService, runnable);
        abstractScheduledService$CustomScheduler$ReschedulableCallable.reschedule();
        return abstractScheduledService$CustomScheduler$ReschedulableCallable;
    }
}

