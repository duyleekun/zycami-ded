/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.schedulers;

import e.a.d;
import e.a.h0$c;
import e.a.s0.b;
import io.reactivex.internal.schedulers.SchedulerWhen$ScheduledAction;
import io.reactivex.internal.schedulers.SchedulerWhen$b;
import java.util.concurrent.TimeUnit;

public class SchedulerWhen$DelayedAction
extends SchedulerWhen$ScheduledAction {
    private final Runnable action;
    private final long delayTime;
    private final TimeUnit unit;

    public SchedulerWhen$DelayedAction(Runnable runnable, long l10, TimeUnit timeUnit) {
        this.action = runnable;
        this.delayTime = l10;
        this.unit = timeUnit;
    }

    public b callActual(h0$c h0$c, d object) {
        Runnable runnable = this.action;
        SchedulerWhen$b schedulerWhen$b = new SchedulerWhen$b(runnable, (d)object);
        long l10 = this.delayTime;
        object = this.unit;
        return h0$c.c(schedulerWhen$b, l10, (TimeUnit)((Object)object));
    }
}

