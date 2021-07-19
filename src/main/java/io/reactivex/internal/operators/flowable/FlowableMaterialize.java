/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.j;
import e.a.w0.e.b.a;
import i.g.d;
import io.reactivex.internal.operators.flowable.FlowableMaterialize$MaterializeSubscriber;

public final class FlowableMaterialize
extends a {
    public FlowableMaterialize(j j10) {
        super(j10);
    }

    public void m6(d d10) {
        j j10 = this.b;
        FlowableMaterialize$MaterializeSubscriber flowableMaterialize$MaterializeSubscriber = new FlowableMaterialize$MaterializeSubscriber(d10);
        j10.l6(flowableMaterialize$MaterializeSubscriber);
    }
}

