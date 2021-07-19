/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.j;
import e.a.v0.r;
import e.a.w0.e.b.a;
import i.g.d;
import io.reactivex.internal.operators.flowable.FlowableAll$AllSubscriber;

public final class FlowableAll
extends a {
    public final r c;

    public FlowableAll(j j10, r r10) {
        super(j10);
        this.c = r10;
    }

    public void m6(d d10) {
        j j10 = this.b;
        r r10 = this.c;
        FlowableAll$AllSubscriber flowableAll$AllSubscriber = new FlowableAll$AllSubscriber(d10, r10);
        j10.l6(flowableAll$AllSubscriber);
    }
}

