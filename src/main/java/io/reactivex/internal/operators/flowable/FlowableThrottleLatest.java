/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.h0;
import e.a.h0$c;
import e.a.j;
import e.a.w0.e.b.a;
import i.g.d;
import io.reactivex.internal.operators.flowable.FlowableThrottleLatest$ThrottleLatestSubscriber;
import java.util.concurrent.TimeUnit;

public final class FlowableThrottleLatest
extends a {
    public final long c;
    public final TimeUnit d;
    public final h0 e;
    public final boolean f;

    public FlowableThrottleLatest(j j10, long l10, TimeUnit timeUnit, h0 h02, boolean bl2) {
        super(j10);
        this.c = l10;
        this.d = timeUnit;
        this.e = h02;
        this.f = bl2;
    }

    public void m6(d d10) {
        j j10 = this.b;
        long l10 = this.c;
        TimeUnit timeUnit = this.d;
        h0$c h0$c = this.e.c();
        boolean bl2 = this.f;
        FlowableThrottleLatest$ThrottleLatestSubscriber flowableThrottleLatest$ThrottleLatestSubscriber = new FlowableThrottleLatest$ThrottleLatestSubscriber(d10, l10, timeUnit, h0$c, bl2);
        j10.l6(flowableThrottleLatest$ThrottleLatestSubscriber);
    }
}

