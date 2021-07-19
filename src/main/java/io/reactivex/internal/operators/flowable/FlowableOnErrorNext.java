/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.j;
import e.a.v0.o;
import e.a.w0.e.b.a;
import i.g.d;
import io.reactivex.internal.operators.flowable.FlowableOnErrorNext$OnErrorNextSubscriber;

public final class FlowableOnErrorNext
extends a {
    public final o c;
    public final boolean d;

    public FlowableOnErrorNext(j j10, o o10, boolean bl2) {
        super(j10);
        this.c = o10;
        this.d = bl2;
    }

    public void m6(d d10) {
        o o10 = this.c;
        boolean bl2 = this.d;
        FlowableOnErrorNext$OnErrorNextSubscriber flowableOnErrorNext$OnErrorNextSubscriber = new FlowableOnErrorNext$OnErrorNextSubscriber(d10, o10, bl2);
        d10.onSubscribe(flowableOnErrorNext$OnErrorNextSubscriber);
        this.b.l6(flowableOnErrorNext$OnErrorNextSubscriber);
    }
}

