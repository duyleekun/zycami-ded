/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.schedulers;

import e.a.d;
import e.a.h0$c;
import e.a.s0.b;
import io.reactivex.internal.schedulers.SchedulerWhen$ScheduledAction;
import io.reactivex.internal.schedulers.SchedulerWhen$b;

public class SchedulerWhen$ImmediateAction
extends SchedulerWhen$ScheduledAction {
    private final Runnable action;

    public SchedulerWhen$ImmediateAction(Runnable runnable) {
        this.action = runnable;
    }

    public b callActual(h0$c h0$c, d d10) {
        Runnable runnable = this.action;
        SchedulerWhen$b schedulerWhen$b = new SchedulerWhen$b(runnable, d10);
        return h0$c.b(schedulerWhen$b);
    }
}

