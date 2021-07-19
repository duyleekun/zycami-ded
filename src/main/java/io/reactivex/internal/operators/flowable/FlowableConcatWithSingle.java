/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.j;
import e.a.o0;
import e.a.w0.e.b.a;
import i.g.d;
import io.reactivex.internal.operators.flowable.FlowableConcatWithSingle$ConcatWithSubscriber;

public final class FlowableConcatWithSingle
extends a {
    public final o0 c;

    public FlowableConcatWithSingle(j j10, o0 o02) {
        super(j10);
        this.c = o02;
    }

    public void m6(d d10) {
        j j10 = this.b;
        o0 o02 = this.c;
        FlowableConcatWithSingle$ConcatWithSubscriber flowableConcatWithSingle$ConcatWithSubscriber = new FlowableConcatWithSingle$ConcatWithSubscriber(d10, o02);
        j10.l6(flowableConcatWithSingle$ConcatWithSubscriber);
    }
}

