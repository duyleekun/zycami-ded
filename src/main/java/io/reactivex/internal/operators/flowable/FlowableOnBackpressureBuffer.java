/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.j;
import e.a.w0.e.b.a;
import i.g.d;
import io.reactivex.internal.operators.flowable.FlowableOnBackpressureBuffer$BackpressureBufferSubscriber;

public final class FlowableOnBackpressureBuffer
extends a {
    public final int c;
    public final boolean d;
    public final boolean e;
    public final e.a.v0.a f;

    public FlowableOnBackpressureBuffer(j j10, int n10, boolean bl2, boolean bl3, e.a.v0.a a10) {
        super(j10);
        this.c = n10;
        this.d = bl2;
        this.e = bl3;
        this.f = a10;
    }

    public void m6(d d10) {
        j j10 = this.b;
        int n10 = this.c;
        boolean bl2 = this.d;
        boolean bl3 = this.e;
        e.a.v0.a a10 = this.f;
        FlowableOnBackpressureBuffer$BackpressureBufferSubscriber flowableOnBackpressureBuffer$BackpressureBufferSubscriber = new FlowableOnBackpressureBuffer$BackpressureBufferSubscriber(d10, n10, bl2, bl3, a10);
        j10.l6(flowableOnBackpressureBuffer$BackpressureBufferSubscriber);
    }
}

