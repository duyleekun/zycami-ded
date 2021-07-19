/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.e1.e;
import e.a.h0;
import e.a.h0$c;
import e.a.j;
import e.a.w0.e.b.a;
import i.g.d;
import io.reactivex.internal.operators.flowable.FlowableThrottleFirstTimed$DebounceTimedSubscriber;
import java.util.concurrent.TimeUnit;

public final class FlowableThrottleFirstTimed
extends a {
    public final long c;
    public final TimeUnit d;
    public final h0 e;

    public FlowableThrottleFirstTimed(j j10, long l10, TimeUnit timeUnit, h0 h02) {
        super(j10);
        this.c = l10;
        this.d = timeUnit;
        this.e = h02;
    }

    public void m6(d d10) {
        j j10 = this.b;
        e e10 = new e(d10);
        long l10 = this.c;
        TimeUnit timeUnit = this.d;
        h0$c h0$c = this.e.c();
        FlowableThrottleFirstTimed$DebounceTimedSubscriber flowableThrottleFirstTimed$DebounceTimedSubscriber = new FlowableThrottleFirstTimed$DebounceTimedSubscriber(e10, l10, timeUnit, h0$c);
        j10.l6(flowableThrottleFirstTimed$DebounceTimedSubscriber);
    }
}

