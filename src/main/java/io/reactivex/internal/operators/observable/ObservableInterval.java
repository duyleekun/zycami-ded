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
import io.reactivex.internal.operators.observable.ObservableInterval$IntervalObserver;
import java.util.concurrent.TimeUnit;

public final class ObservableInterval
extends z {
    public final h0 a;
    public final long b;
    public final long c;
    public final TimeUnit d;

    public ObservableInterval(long l10, long l11, TimeUnit timeUnit, h0 h02) {
        this.b = l10;
        this.c = l11;
        this.d = timeUnit;
        this.a = h02;
    }

    public void K5(g0 object) {
        ObservableInterval$IntervalObserver observableInterval$IntervalObserver = new ObservableInterval$IntervalObserver((g0)object);
        object.onSubscribe(observableInterval$IntervalObserver);
        Object object2 = this.a;
        boolean bl2 = object2 instanceof l;
        if (bl2) {
            object2 = ((h0)object2).c();
            observableInterval$IntervalObserver.setResource((b)object2);
            long l10 = this.b;
            long l11 = this.c;
            TimeUnit timeUnit = this.d;
            ((h0$c)object2).d(observableInterval$IntervalObserver, l10, l11, timeUnit);
        } else {
            long l12 = this.b;
            long l13 = this.c;
            TimeUnit timeUnit = this.d;
            object = ((h0)object2).g(observableInterval$IntervalObserver, l12, l13, timeUnit);
            observableInterval$IntervalObserver.setResource((b)object);
        }
    }
}

