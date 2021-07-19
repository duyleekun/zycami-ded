/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.j;
import e.a.w0.e.b.a;
import i.g.d;
import io.reactivex.internal.operators.flowable.FlowableTakeLastOne$TakeLastOneSubscriber;

public final class FlowableTakeLastOne
extends a {
    public FlowableTakeLastOne(j j10) {
        super(j10);
    }

    public void m6(d d10) {
        j j10 = this.b;
        FlowableTakeLastOne$TakeLastOneSubscriber flowableTakeLastOne$TakeLastOneSubscriber = new FlowableTakeLastOne$TakeLastOneSubscriber(d10);
        j10.l6(flowableTakeLastOne$TakeLastOneSubscriber);
    }
}

