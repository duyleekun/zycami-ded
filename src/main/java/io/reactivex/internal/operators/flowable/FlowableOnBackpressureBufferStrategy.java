/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.j;
import e.a.w0.e.b.a;
import i.g.d;
import io.reactivex.BackpressureOverflowStrategy;
import io.reactivex.internal.operators.flowable.FlowableOnBackpressureBufferStrategy$OnBackpressureBufferStrategySubscriber;

public final class FlowableOnBackpressureBufferStrategy
extends a {
    public final long c;
    public final e.a.v0.a d;
    public final BackpressureOverflowStrategy e;

    public FlowableOnBackpressureBufferStrategy(j j10, long l10, e.a.v0.a a10, BackpressureOverflowStrategy backpressureOverflowStrategy) {
        super(j10);
        this.c = l10;
        this.d = a10;
        this.e = backpressureOverflowStrategy;
    }

    public void m6(d d10) {
        j j10 = this.b;
        e.a.v0.a a10 = this.d;
        BackpressureOverflowStrategy backpressureOverflowStrategy = this.e;
        long l10 = this.c;
        FlowableOnBackpressureBufferStrategy$OnBackpressureBufferStrategySubscriber flowableOnBackpressureBufferStrategy$OnBackpressureBufferStrategySubscriber = new FlowableOnBackpressureBufferStrategy$OnBackpressureBufferStrategySubscriber(d10, a10, backpressureOverflowStrategy, l10);
        j10.l6(flowableOnBackpressureBufferStrategy$OnBackpressureBufferStrategySubscriber);
    }
}

