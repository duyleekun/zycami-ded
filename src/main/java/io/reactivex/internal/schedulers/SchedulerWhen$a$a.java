/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.schedulers;

import e.a.a;
import e.a.d;
import e.a.h0$c;
import io.reactivex.internal.schedulers.SchedulerWhen$ScheduledAction;
import io.reactivex.internal.schedulers.SchedulerWhen$a;

public final class SchedulerWhen$a$a
extends a {
    public final SchedulerWhen$ScheduledAction a;
    public final /* synthetic */ SchedulerWhen$a b;

    public SchedulerWhen$a$a(SchedulerWhen$a schedulerWhen$a, SchedulerWhen$ScheduledAction schedulerWhen$ScheduledAction) {
        this.b = schedulerWhen$a;
        this.a = schedulerWhen$ScheduledAction;
    }

    public void L0(d d10) {
        SchedulerWhen$ScheduledAction schedulerWhen$ScheduledAction = this.a;
        d10.onSubscribe(schedulerWhen$ScheduledAction);
        schedulerWhen$ScheduledAction = this.a;
        h0$c h0$c = this.b.a;
        schedulerWhen$ScheduledAction.call(h0$c, d10);
    }
}

