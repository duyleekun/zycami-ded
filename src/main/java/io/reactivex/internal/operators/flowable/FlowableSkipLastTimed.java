/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.h0;
import e.a.j;
import e.a.w0.e.b.a;
import i.g.d;
import io.reactivex.internal.operators.flowable.FlowableSkipLastTimed$SkipLastTimedSubscriber;
import java.util.concurrent.TimeUnit;

public final class FlowableSkipLastTimed
extends a {
    public final long c;
    public final TimeUnit d;
    public final h0 e;
    public final int f;
    public final boolean g;

    public FlowableSkipLastTimed(j j10, long l10, TimeUnit timeUnit, h0 h02, int n10, boolean bl2) {
        super(j10);
        this.c = l10;
        this.d = timeUnit;
        this.e = h02;
        this.f = n10;
        this.g = bl2;
    }

    public void m6(d d10) {
        j j10 = this.b;
        long l10 = this.c;
        TimeUnit timeUnit = this.d;
        h0 h02 = this.e;
        int n10 = this.f;
        boolean bl2 = this.g;
        FlowableSkipLastTimed$SkipLastTimedSubscriber flowableSkipLastTimed$SkipLastTimedSubscriber = new FlowableSkipLastTimed$SkipLastTimedSubscriber(d10, l10, timeUnit, h02, n10, bl2);
        j10.l6(flowableSkipLastTimed$SkipLastTimedSubscriber);
    }
}

