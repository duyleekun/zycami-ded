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
import io.reactivex.internal.operators.flowable.FlowableIntervalRange$IntervalRangeSubscriber;
import java.util.concurrent.TimeUnit;

public final class FlowableIntervalRange
extends j {
    public final h0 b;
    public final long c;
    public final long d;
    public final long e;
    public final long f;
    public final TimeUnit g;

    public FlowableIntervalRange(long l10, long l11, long l12, long l13, TimeUnit timeUnit, h0 h02) {
        this.e = l12;
        this.f = l13;
        this.g = timeUnit;
        this.b = h02;
        this.c = l10;
        this.d = l11;
    }

    public void m6(d object) {
        FlowableIntervalRange$IntervalRangeSubscriber flowableIntervalRange$IntervalRangeSubscriber;
        long l10 = this.c;
        long l11 = this.d;
        Object object2 = flowableIntervalRange$IntervalRangeSubscriber;
        flowableIntervalRange$IntervalRangeSubscriber = new FlowableIntervalRange$IntervalRangeSubscriber((d)object, l10, l11);
        object.onSubscribe(flowableIntervalRange$IntervalRangeSubscriber);
        object2 = this.b;
        boolean bl2 = object2 instanceof l;
        if (bl2) {
            object2 = ((h0)object2).c();
            flowableIntervalRange$IntervalRangeSubscriber.setResource((b)object2);
            l10 = this.e;
            l11 = this.f;
            TimeUnit timeUnit = this.g;
            ((h0$c)object2).d(flowableIntervalRange$IntervalRangeSubscriber, l10, l11, timeUnit);
        } else {
            l10 = this.e;
            l11 = this.f;
            TimeUnit timeUnit = this.g;
            object = ((h0)object2).g(flowableIntervalRange$IntervalRangeSubscriber, l10, l11, timeUnit);
            flowableIntervalRange$IntervalRangeSubscriber.setResource((b)object);
        }
    }
}

