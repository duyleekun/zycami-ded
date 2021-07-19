/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.h0;
import e.a.h0$c;
import e.a.j;
import e.a.s0.b;
import e.a.w0.g.l;
import i.g.d;
import io.reactivex.internal.operators.flowable.FlowableInterval$IntervalSubscriber;
import java.util.concurrent.TimeUnit;

public final class FlowableInterval
extends j {
    public final h0 b;
    public final long c;
    public final long d;
    public final TimeUnit e;

    public FlowableInterval(long l10, long l11, TimeUnit timeUnit, h0 h02) {
        this.c = l10;
        this.d = l11;
        this.e = timeUnit;
        this.b = h02;
    }

    public void m6(d object) {
        FlowableInterval$IntervalSubscriber flowableInterval$IntervalSubscriber = new FlowableInterval$IntervalSubscriber((d)object);
        object.onSubscribe(flowableInterval$IntervalSubscriber);
        Object object2 = this.b;
        boolean bl2 = object2 instanceof l;
        if (bl2) {
            object2 = ((h0)object2).c();
            flowableInterval$IntervalSubscriber.setResource((b)object2);
            long l10 = this.c;
            long l11 = this.d;
            TimeUnit timeUnit = this.e;
            ((h0$c)object2).d(flowableInterval$IntervalSubscriber, l10, l11, timeUnit);
        } else {
            long l12 = this.c;
            long l13 = this.d;
            TimeUnit timeUnit = this.e;
            object = ((h0)object2).g(flowableInterval$IntervalSubscriber, l12, l13, timeUnit);
            flowableInterval$IntervalSubscriber.setResource((b)object);
        }
    }
}

