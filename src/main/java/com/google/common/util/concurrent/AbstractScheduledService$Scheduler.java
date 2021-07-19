/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.AbstractScheduledService$1;
import com.google.common.util.concurrent.AbstractScheduledService$Scheduler$1;
import com.google.common.util.concurrent.AbstractScheduledService$Scheduler$2;
import com.google.common.util.concurrent.AbstractService;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public abstract class AbstractScheduledService$Scheduler {
    private AbstractScheduledService$Scheduler() {
    }

    public /* synthetic */ AbstractScheduledService$Scheduler(AbstractScheduledService.1 var1_1) {
        this();
    }

    public static AbstractScheduledService$Scheduler newFixedDelaySchedule(long l10, long l11, TimeUnit timeUnit) {
        AbstractScheduledService$Scheduler$1 abstractScheduledService$Scheduler$1;
        Preconditions.checkNotNull((Object)timeUnit);
        long l12 = 0L;
        long l13 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
        if (l13 > 0) {
            l13 = 1;
        } else {
            l13 = 0;
            abstractScheduledService$Scheduler$1 = null;
        }
        Preconditions.checkArgument((boolean)l13, "delay must be > 0, found %s", l11);
        abstractScheduledService$Scheduler$1 = new AbstractScheduledService$Scheduler$1(l10, l11, timeUnit);
        return abstractScheduledService$Scheduler$1;
    }

    public static AbstractScheduledService$Scheduler newFixedRateSchedule(long l10, long l11, TimeUnit timeUnit) {
        AbstractScheduledService$Scheduler$2 abstractScheduledService$Scheduler$2;
        Preconditions.checkNotNull((Object)timeUnit);
        long l12 = 0L;
        long l13 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
        if (l13 > 0) {
            l13 = 1;
        } else {
            l13 = 0;
            abstractScheduledService$Scheduler$2 = null;
        }
        Preconditions.checkArgument((boolean)l13, "period must be > 0, found %s", l11);
        abstractScheduledService$Scheduler$2 = new AbstractScheduledService$Scheduler$2(l10, l11, timeUnit);
        return abstractScheduledService$Scheduler$2;
    }

    public abstract Future schedule(AbstractService var1, ScheduledExecutorService var2, Runnable var3);
}

