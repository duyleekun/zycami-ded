/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.g0;
import e.a.h0;
import e.a.s0.b;
import e.a.z;
import io.reactivex.internal.operators.observable.ObservableTimer$TimerObserver;
import java.util.concurrent.TimeUnit;

public final class ObservableTimer
extends z {
    public final h0 a;
    public final long b;
    public final TimeUnit c;

    public ObservableTimer(long l10, TimeUnit timeUnit, h0 h02) {
        this.b = l10;
        this.c = timeUnit;
        this.a = h02;
    }

    public void K5(g0 object) {
        ObservableTimer$TimerObserver observableTimer$TimerObserver = new ObservableTimer$TimerObserver((g0)object);
        object.onSubscribe(observableTimer$TimerObserver);
        object = this.a;
        long l10 = this.b;
        TimeUnit timeUnit = this.c;
        object = ((h0)object).f(observableTimer$TimerObserver, l10, timeUnit);
        observableTimer$TimerObserver.setResource((b)object);
    }
}

