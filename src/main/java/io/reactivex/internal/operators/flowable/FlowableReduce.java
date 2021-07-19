/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.j;
import e.a.v0.c;
import e.a.w0.e.b.a;
import i.g.d;
import io.reactivex.internal.operators.flowable.FlowableReduce$ReduceSubscriber;

public final class FlowableReduce
extends a {
    public final c c;

    public FlowableReduce(j j10, c c10) {
        super(j10);
        this.c = c10;
    }

    public void m6(d d10) {
        j j10 = this.b;
        c c10 = this.c;
        FlowableReduce$ReduceSubscriber flowableReduce$ReduceSubscriber = new FlowableReduce$ReduceSubscriber(d10, c10);
        j10.l6(flowableReduce$ReduceSubscriber);
    }
}

