/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import java.util.concurrent.TimeUnit;

public final class AbstractScheduledService$CustomScheduler$Schedule {
    private final long delay;
    private final TimeUnit unit;

    public AbstractScheduledService$CustomScheduler$Schedule(long l10, TimeUnit timeUnit) {
        TimeUnit timeUnit2;
        this.delay = l10;
        this.unit = timeUnit2 = (TimeUnit)((Object)Preconditions.checkNotNull((Object)timeUnit));
    }

    public static /* synthetic */ long access$800(AbstractScheduledService$CustomScheduler$Schedule abstractScheduledService$CustomScheduler$Schedule) {
        return abstractScheduledService$CustomScheduler$Schedule.delay;
    }

    public static /* synthetic */ TimeUnit access$900(AbstractScheduledService$CustomScheduler$Schedule abstractScheduledService$CustomScheduler$Schedule) {
        return abstractScheduledService$CustomScheduler$Schedule.unit;
    }
}

