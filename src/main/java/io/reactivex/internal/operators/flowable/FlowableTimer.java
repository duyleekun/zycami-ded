/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.h0;
import e.a.j;
import e.a.s0.b;
import i.g.d;
import io.reactivex.internal.operators.flowable.FlowableTimer$TimerSubscriber;
import java.util.concurrent.TimeUnit;

public final class FlowableTimer
extends j {
    public final h0 b;
    public final long c;
    public final TimeUnit d;

    public FlowableTimer(long l10, TimeUnit timeUnit, h0 h02) {
        this.c = l10;
        this.d = timeUnit;
        this.b = h02;
    }

    public void m6(d object) {
        FlowableTimer$TimerSubscriber flowableTimer$TimerSubscriber = new FlowableTimer$TimerSubscriber((d)object);
        object.onSubscribe(flowableTimer$TimerSubscriber);
        object = this.b;
        long l10 = this.c;
        TimeUnit timeUnit = this.d;
        object = ((h0)object).f(flowableTimer$TimerSubscriber, l10, timeUnit);
        flowableTimer$TimerSubscriber.setResource((b)object);
    }
}

