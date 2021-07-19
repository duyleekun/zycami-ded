/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.single;

import e.a.h0;
import e.a.i0;
import e.a.l0;
import e.a.s0.b;
import io.reactivex.internal.operators.single.SingleTimer$TimerDisposable;
import java.util.concurrent.TimeUnit;

public final class SingleTimer
extends i0 {
    public final long a;
    public final TimeUnit b;
    public final h0 c;

    public SingleTimer(long l10, TimeUnit timeUnit, h0 h02) {
        this.a = l10;
        this.b = timeUnit;
        this.c = h02;
    }

    public void e1(l0 object) {
        SingleTimer$TimerDisposable singleTimer$TimerDisposable = new SingleTimer$TimerDisposable((l0)object);
        object.onSubscribe(singleTimer$TimerDisposable);
        object = this.c;
        long l10 = this.a;
        TimeUnit timeUnit = this.b;
        object = ((h0)object).f(singleTimer$TimerDisposable, l10, timeUnit);
        singleTimer$TimerDisposable.setFuture((b)object);
    }
}

