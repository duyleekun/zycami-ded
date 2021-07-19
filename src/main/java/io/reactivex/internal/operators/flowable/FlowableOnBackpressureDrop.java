/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.j;
import e.a.v0.g;
import e.a.w0.e.b.a;
import i.g.d;
import io.reactivex.internal.operators.flowable.FlowableOnBackpressureDrop$BackpressureDropSubscriber;

public final class FlowableOnBackpressureDrop
extends a
implements g {
    public final g c;

    public FlowableOnBackpressureDrop(j j10) {
        super(j10);
        this.c = this;
    }

    public FlowableOnBackpressureDrop(j j10, g g10) {
        super(j10);
        this.c = g10;
    }

    public void accept(Object object) {
    }

    public void m6(d d10) {
        j j10 = this.b;
        g g10 = this.c;
        FlowableOnBackpressureDrop$BackpressureDropSubscriber flowableOnBackpressureDrop$BackpressureDropSubscriber = new FlowableOnBackpressureDrop$BackpressureDropSubscriber(d10, g10);
        j10.l6(flowableOnBackpressureDrop$BackpressureDropSubscriber);
    }
}

