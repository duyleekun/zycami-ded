/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.e0;
import e.a.g0;
import e.a.h0;
import e.a.h0$c;
import e.a.s0.b;
import e.a.w0.e.e.a;
import e.a.z;
import io.reactivex.internal.operators.observable.ObservableTimeoutTimed$TimeoutFallbackObserver;
import io.reactivex.internal.operators.observable.ObservableTimeoutTimed$TimeoutObserver;
import java.util.concurrent.TimeUnit;

public final class ObservableTimeoutTimed
extends a {
    public final long b;
    public final TimeUnit c;
    public final h0 d;
    public final e0 e;

    public ObservableTimeoutTimed(z z10, long l10, TimeUnit timeUnit, h0 h02, e0 e02) {
        super(z10);
        this.b = l10;
        this.c = timeUnit;
        this.d = h02;
        this.e = e02;
    }

    public void K5(g0 object) {
        Object object2 = this.e;
        long l10 = 0L;
        if (object2 == null) {
            long l11 = this.b;
            TimeUnit timeUnit = this.c;
            h0$c h0$c = this.d.c();
            object2 = new ObservableTimeoutTimed$TimeoutObserver((g0)object, l11, timeUnit, h0$c);
            object.onSubscribe((b)object2);
            ((ObservableTimeoutTimed$TimeoutObserver)object2).startTimeout(l10);
            object = this.a;
            object.subscribe((g0)object2);
        } else {
            long l12 = this.b;
            TimeUnit timeUnit = this.c;
            h0$c h0$c = this.d.c();
            e0 e02 = this.e;
            object2 = new ObservableTimeoutTimed$TimeoutFallbackObserver((g0)object, l12, timeUnit, h0$c, e02);
            object.onSubscribe((b)object2);
            ((ObservableTimeoutTimed$TimeoutFallbackObserver)object2).startTimeout(l10);
            object = this.a;
            object.subscribe((g0)object2);
        }
    }
}

