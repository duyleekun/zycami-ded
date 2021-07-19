/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.g0;
import e.a.h0;
import e.a.h0$c;
import e.a.s0.b;
import e.a.w0.g.l;
import e.a.z;
import io.reactivex.internal.operators.observable.ObservableIntervalRange$IntervalRangeObserver;
import java.util.concurrent.TimeUnit;

public final class ObservableIntervalRange
extends z {
    public final h0 a;
    public final long b;
    public final long c;
    public final long d;
    public final long e;
    public final TimeUnit f;

    public ObservableIntervalRange(long l10, long l11, long l12, long l13, TimeUnit timeUnit, h0 h02) {
        this.d = l12;
        this.e = l13;
        this.f = timeUnit;
        this.a = h02;
        this.b = l10;
        this.c = l11;
    }

    public void K5(g0 object) {
        ObservableIntervalRange$IntervalRangeObserver observableIntervalRange$IntervalRangeObserver;
        long l10 = this.b;
        long l11 = this.c;
        Object object2 = observableIntervalRange$IntervalRangeObserver;
        observableIntervalRange$IntervalRangeObserver = new ObservableIntervalRange$IntervalRangeObserver((g0)object, l10, l11);
        object.onSubscribe(observableIntervalRange$IntervalRangeObserver);
        object2 = this.a;
        boolean bl2 = object2 instanceof l;
        if (bl2) {
            object2 = ((h0)object2).c();
            observableIntervalRange$IntervalRangeObserver.setResource((b)object2);
            l10 = this.d;
            l11 = this.e;
            TimeUnit timeUnit = this.f;
            ((h0$c)object2).d(observableIntervalRange$IntervalRangeObserver, l10, l11, timeUnit);
        } else {
            l10 = this.d;
            l11 = this.e;
            TimeUnit timeUnit = this.f;
            object = ((h0)object2).g(observableIntervalRange$IntervalRangeObserver, l10, l11, timeUnit);
            observableIntervalRange$IntervalRangeObserver.setResource((b)object);
        }
    }
}

