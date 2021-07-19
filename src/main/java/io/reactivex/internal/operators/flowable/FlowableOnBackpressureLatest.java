/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.j;
import e.a.w0.e.b.a;
import i.g.d;
import io.reactivex.internal.operators.flowable.FlowableOnBackpressureLatest$BackpressureLatestSubscriber;

public final class FlowableOnBackpressureLatest
extends a {
    public FlowableOnBackpressureLatest(j j10) {
        super(j10);
    }

    public void m6(d d10) {
        j j10 = this.b;
        FlowableOnBackpressureLatest$BackpressureLatestSubscriber flowableOnBackpressureLatest$BackpressureLatestSubscriber = new FlowableOnBackpressureLatest$BackpressureLatestSubscriber(d10);
        j10.l6(flowableOnBackpressureLatest$BackpressureLatestSubscriber);
    }
}

