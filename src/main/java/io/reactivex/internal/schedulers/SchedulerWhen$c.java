/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.schedulers;

import e.a.b1.a;
import e.a.h0$c;
import e.a.s0.b;
import io.reactivex.internal.schedulers.SchedulerWhen$DelayedAction;
import io.reactivex.internal.schedulers.SchedulerWhen$ImmediateAction;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public final class SchedulerWhen$c
extends h0$c {
    private final AtomicBoolean a;
    private final a b;
    private final h0$c c;

    public SchedulerWhen$c(a object, h0$c h0$c) {
        this.b = object;
        this.c = h0$c;
        this.a = object = new AtomicBoolean();
    }

    public b b(Runnable runnable) {
        SchedulerWhen$ImmediateAction schedulerWhen$ImmediateAction = new SchedulerWhen$ImmediateAction(runnable);
        this.b.onNext(schedulerWhen$ImmediateAction);
        return schedulerWhen$ImmediateAction;
    }

    public b c(Runnable runnable, long l10, TimeUnit timeUnit) {
        SchedulerWhen$DelayedAction schedulerWhen$DelayedAction = new SchedulerWhen$DelayedAction(runnable, l10, timeUnit);
        this.b.onNext(schedulerWhen$DelayedAction);
        return schedulerWhen$DelayedAction;
    }

    public void dispose() {
        Object object = this.a;
        boolean bl2 = true;
        boolean bl3 = ((AtomicBoolean)object).compareAndSet(false, bl2);
        if (bl3) {
            this.b.onComplete();
            object = this.c;
            object.dispose();
        }
    }

    public boolean isDisposed() {
        return this.a.get();
    }
}

