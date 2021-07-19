/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.j;
import e.a.v0.o;
import e.a.w0.e.b.a;
import i.g.d;
import io.reactivex.internal.operators.flowable.FlowableOnErrorReturn$OnErrorReturnSubscriber;

public final class FlowableOnErrorReturn
extends a {
    public final o c;

    public FlowableOnErrorReturn(j j10, o o10) {
        super(j10);
        this.c = o10;
    }

    public void m6(d d10) {
        j j10 = this.b;
        o o10 = this.c;
        FlowableOnErrorReturn$OnErrorReturnSubscriber flowableOnErrorReturn$OnErrorReturnSubscriber = new FlowableOnErrorReturn$OnErrorReturnSubscriber(d10, o10);
        j10.l6(flowableOnErrorReturn$OnErrorReturnSubscriber);
    }
}

