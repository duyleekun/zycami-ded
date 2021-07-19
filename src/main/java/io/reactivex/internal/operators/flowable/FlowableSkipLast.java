/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.j;
import e.a.w0.e.b.a;
import i.g.d;
import io.reactivex.internal.operators.flowable.FlowableSkipLast$SkipLastSubscriber;

public final class FlowableSkipLast
extends a {
    public final int c;

    public FlowableSkipLast(j j10, int n10) {
        super(j10);
        this.c = n10;
    }

    public void m6(d d10) {
        j j10 = this.b;
        int n10 = this.c;
        FlowableSkipLast$SkipLastSubscriber flowableSkipLast$SkipLastSubscriber = new FlowableSkipLast$SkipLastSubscriber(d10, n10);
        j10.l6(flowableSkipLast$SkipLastSubscriber);
    }
}

