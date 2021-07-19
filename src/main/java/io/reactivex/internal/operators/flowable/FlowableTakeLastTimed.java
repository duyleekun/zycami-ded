/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.h0;
import e.a.j;
import e.a.w0.e.b.a;
import i.g.d;
import io.reactivex.internal.operators.flowable.FlowableTakeLastTimed$TakeLastTimedSubscriber;
import java.util.concurrent.TimeUnit;

public final class FlowableTakeLastTimed
extends a {
    public final long c;
    public final long d;
    public final TimeUnit e;
    public final h0 f;
    public final int g;
    public final boolean h;

    public FlowableTakeLastTimed(j j10, long l10, long l11, TimeUnit timeUnit, h0 h02, int n10, boolean bl2) {
        super(j10);
        this.c = l10;
        this.d = l11;
        this.e = timeUnit;
        this.f = h02;
        this.g = n10;
        this.h = bl2;
    }

    public void m6(d d10) {
        j j10 = this.b;
        long l10 = this.c;
        long l11 = this.d;
        TimeUnit timeUnit = this.e;
        h0 h02 = this.f;
        int n10 = this.g;
        boolean bl2 = this.h;
        FlowableTakeLastTimed$TakeLastTimedSubscriber flowableTakeLastTimed$TakeLastTimedSubscriber = new FlowableTakeLastTimed$TakeLastTimedSubscriber(d10, l10, l11, timeUnit, h02, n10, bl2);
        j10.l6(flowableTakeLastTimed$TakeLastTimedSubscriber);
    }
}

