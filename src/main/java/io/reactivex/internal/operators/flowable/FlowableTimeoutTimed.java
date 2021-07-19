/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.h0;
import e.a.h0$c;
import e.a.j;
import e.a.o;
import e.a.w0.e.b.a;
import i.g.c;
import i.g.d;
import i.g.e;
import io.reactivex.internal.operators.flowable.FlowableTimeoutTimed$TimeoutFallbackSubscriber;
import io.reactivex.internal.operators.flowable.FlowableTimeoutTimed$TimeoutSubscriber;
import java.util.concurrent.TimeUnit;

public final class FlowableTimeoutTimed
extends a {
    public final long c;
    public final TimeUnit d;
    public final h0 e;
    public final c f;

    public FlowableTimeoutTimed(j j10, long l10, TimeUnit timeUnit, h0 h02, c c10) {
        super(j10);
        this.c = l10;
        this.d = timeUnit;
        this.e = h02;
        this.f = c10;
    }

    public void m6(d object) {
        Object object2 = this.f;
        long l10 = 0L;
        if (object2 == null) {
            long l11 = this.c;
            TimeUnit timeUnit = this.d;
            h0$c h0$c = this.e.c();
            object2 = new FlowableTimeoutTimed$TimeoutSubscriber((d)object, l11, timeUnit, h0$c);
            object.onSubscribe((e)object2);
            ((FlowableTimeoutTimed$TimeoutSubscriber)object2).startTimeout(l10);
            object = this.b;
            ((j)object).l6((o)object2);
        } else {
            long l12 = this.c;
            TimeUnit timeUnit = this.d;
            h0$c h0$c = this.e.c();
            c c10 = this.f;
            object2 = new FlowableTimeoutTimed$TimeoutFallbackSubscriber((d)object, l12, timeUnit, h0$c, c10);
            object.onSubscribe((e)object2);
            ((FlowableTimeoutTimed$TimeoutFallbackSubscriber)object2).startTimeout(l10);
            object = this.b;
            ((j)object).l6((o)object2);
        }
    }
}

