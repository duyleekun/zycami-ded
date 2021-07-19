/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.g;
import e.a.j;
import e.a.w0.e.b.a;
import i.g.d;
import io.reactivex.internal.operators.flowable.FlowableConcatWithCompletable$ConcatWithSubscriber;

public final class FlowableConcatWithCompletable
extends a {
    public final g c;

    public FlowableConcatWithCompletable(j j10, g g10) {
        super(j10);
        this.c = g10;
    }

    public void m6(d d10) {
        j j10 = this.b;
        g g10 = this.c;
        FlowableConcatWithCompletable$ConcatWithSubscriber flowableConcatWithCompletable$ConcatWithSubscriber = new FlowableConcatWithCompletable$ConcatWithSubscriber(d10, g10);
        j10.l6(flowableConcatWithCompletable$ConcatWithSubscriber);
    }
}

