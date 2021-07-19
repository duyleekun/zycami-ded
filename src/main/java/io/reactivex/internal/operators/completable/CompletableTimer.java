/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.completable;

import e.a.a;
import e.a.d;
import e.a.h0;
import e.a.s0.b;
import io.reactivex.internal.operators.completable.CompletableTimer$TimerDisposable;
import java.util.concurrent.TimeUnit;

public final class CompletableTimer
extends a {
    public final long a;
    public final TimeUnit b;
    public final h0 c;

    public CompletableTimer(long l10, TimeUnit timeUnit, h0 h02) {
        this.a = l10;
        this.b = timeUnit;
        this.c = h02;
    }

    public void L0(d object) {
        CompletableTimer$TimerDisposable completableTimer$TimerDisposable = new CompletableTimer$TimerDisposable((d)object);
        object.onSubscribe(completableTimer$TimerDisposable);
        object = this.c;
        long l10 = this.a;
        TimeUnit timeUnit = this.b;
        object = ((h0)object).f(completableTimer$TimerDisposable, l10, timeUnit);
        completableTimer$TimerDisposable.setFuture((b)object);
    }
}

