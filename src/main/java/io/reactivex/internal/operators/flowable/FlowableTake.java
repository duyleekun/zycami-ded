/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.j;
import e.a.w0.e.b.a;
import i.g.d;
import io.reactivex.internal.operators.flowable.FlowableTake$TakeSubscriber;

public final class FlowableTake
extends a {
    public final long c;

    public FlowableTake(j j10, long l10) {
        super(j10);
        this.c = l10;
    }

    public void m6(d d10) {
        j j10 = this.b;
        long l10 = this.c;
        FlowableTake$TakeSubscriber flowableTake$TakeSubscriber = new FlowableTake$TakeSubscriber(d10, l10);
        j10.l6(flowableTake$TakeSubscriber);
    }
}

