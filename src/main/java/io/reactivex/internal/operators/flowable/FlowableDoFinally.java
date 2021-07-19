/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.j;
import e.a.w0.e.b.a;
import i.g.d;
import io.reactivex.internal.operators.flowable.FlowableDoFinally$DoFinallyConditionalSubscriber;
import io.reactivex.internal.operators.flowable.FlowableDoFinally$DoFinallySubscriber;

public final class FlowableDoFinally
extends a {
    public final e.a.v0.a c;

    public FlowableDoFinally(j j10, e.a.v0.a a10) {
        super(j10);
        this.c = a10;
    }

    public void m6(d d10) {
        boolean bl2 = d10 instanceof e.a.w0.c.a;
        if (bl2) {
            j j10 = this.b;
            d10 = (e.a.w0.c.a)d10;
            e.a.v0.a a10 = this.c;
            FlowableDoFinally$DoFinallyConditionalSubscriber flowableDoFinally$DoFinallyConditionalSubscriber = new FlowableDoFinally$DoFinallyConditionalSubscriber((e.a.w0.c.a)d10, a10);
            j10.l6(flowableDoFinally$DoFinallyConditionalSubscriber);
        } else {
            j j11 = this.b;
            e.a.v0.a a11 = this.c;
            FlowableDoFinally$DoFinallySubscriber flowableDoFinally$DoFinallySubscriber = new FlowableDoFinally$DoFinallySubscriber(d10, a11);
            j11.l6(flowableDoFinally$DoFinallySubscriber);
        }
    }
}

