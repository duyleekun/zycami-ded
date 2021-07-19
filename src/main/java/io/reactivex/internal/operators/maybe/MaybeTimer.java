/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.maybe;

import e.a.h0;
import e.a.q;
import e.a.s0.b;
import e.a.t;
import io.reactivex.internal.operators.maybe.MaybeTimer$TimerDisposable;
import java.util.concurrent.TimeUnit;

public final class MaybeTimer
extends q {
    public final long a;
    public final TimeUnit b;
    public final h0 c;

    public MaybeTimer(long l10, TimeUnit timeUnit, h0 h02) {
        this.a = l10;
        this.b = timeUnit;
        this.c = h02;
    }

    public void t1(t object) {
        MaybeTimer$TimerDisposable maybeTimer$TimerDisposable = new MaybeTimer$TimerDisposable((t)object);
        object.onSubscribe(maybeTimer$TimerDisposable);
        object = this.c;
        long l10 = this.a;
        TimeUnit timeUnit = this.b;
        object = ((h0)object).f(maybeTimer$TimerDisposable, l10, timeUnit);
        maybeTimer$TimerDisposable.setFuture((b)object);
    }
}

