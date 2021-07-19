/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.j;
import e.a.w;
import e.a.w0.e.b.a;
import i.g.d;
import io.reactivex.internal.operators.flowable.FlowableConcatWithMaybe$ConcatWithSubscriber;

public final class FlowableConcatWithMaybe
extends a {
    public final w c;

    public FlowableConcatWithMaybe(j j10, w w10) {
        super(j10);
        this.c = w10;
    }

    public void m6(d d10) {
        j j10 = this.b;
        w w10 = this.c;
        FlowableConcatWithMaybe$ConcatWithSubscriber flowableConcatWithMaybe$ConcatWithSubscriber = new FlowableConcatWithMaybe$ConcatWithSubscriber(d10, w10);
        j10.l6(flowableConcatWithMaybe$ConcatWithSubscriber);
    }
}

