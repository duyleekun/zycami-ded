/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.j;
import e.a.v0.r;
import e.a.w0.e.b.a;
import i.g.d;
import io.reactivex.internal.operators.flowable.FlowableAny$AnySubscriber;

public final class FlowableAny
extends a {
    public final r c;

    public FlowableAny(j j10, r r10) {
        super(j10);
        this.c = r10;
    }

    public void m6(d d10) {
        j j10 = this.b;
        r r10 = this.c;
        FlowableAny$AnySubscriber flowableAny$AnySubscriber = new FlowableAny$AnySubscriber(d10, r10);
        j10.l6(flowableAny$AnySubscriber);
    }
}

