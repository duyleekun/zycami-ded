/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.schedulers;

import e.a.a;
import e.a.h0$c;
import e.a.v0.o;
import io.reactivex.internal.schedulers.SchedulerWhen$ScheduledAction;
import io.reactivex.internal.schedulers.SchedulerWhen$a$a;

public final class SchedulerWhen$a
implements o {
    public final h0$c a;

    public SchedulerWhen$a(h0$c h0$c) {
        this.a = h0$c;
    }

    public a a(SchedulerWhen$ScheduledAction schedulerWhen$ScheduledAction) {
        SchedulerWhen$a$a schedulerWhen$a$a = new SchedulerWhen$a$a(this, schedulerWhen$ScheduledAction);
        return schedulerWhen$a$a;
    }
}

