/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.schedulers;

import e.a.d;
import e.a.h0$c;
import e.a.s0.b;
import io.reactivex.internal.schedulers.SchedulerWhen;
import java.util.concurrent.atomic.AtomicReference;

public abstract class SchedulerWhen$ScheduledAction
extends AtomicReference
implements b {
    public SchedulerWhen$ScheduledAction() {
        b b10 = SchedulerWhen.e;
        super(b10);
    }

    public void call(h0$c b10, d d10) {
        b b11;
        b b12 = (b)this.get();
        if (b12 == (b11 = SchedulerWhen.f)) {
            return;
        }
        b11 = SchedulerWhen.e;
        if (b12 != b11) {
            return;
        }
        boolean bl2 = this.compareAndSet(b11, b10 = this.callActual((h0$c)b10, d10));
        if (!bl2) {
            b10.dispose();
        }
    }

    public abstract b callActual(h0$c var1, d var2);

    public void dispose() {
        b b10;
        boolean bl2;
        b b11 = SchedulerWhen.f;
        do {
            b b12;
            if ((b10 = (b)this.get()) != (b12 = SchedulerWhen.f)) continue;
            return;
        } while (!(bl2 = this.compareAndSet(b10, b11)));
        b11 = SchedulerWhen.e;
        if (b10 != b11) {
            b10.dispose();
        }
    }

    public boolean isDisposed() {
        return ((b)this.get()).isDisposed();
    }
}

