/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.h0;
import e.a.j;
import e.a.w0.e.b.a;
import i.g.d;
import io.reactivex.internal.operators.flowable.FlowableUnsubscribeOn$UnsubscribeSubscriber;

public final class FlowableUnsubscribeOn
extends a {
    public final h0 c;

    public FlowableUnsubscribeOn(j j10, h0 h02) {
        super(j10);
        this.c = h02;
    }

    public void m6(d d10) {
        j j10 = this.b;
        h0 h02 = this.c;
        FlowableUnsubscribeOn$UnsubscribeSubscriber flowableUnsubscribeOn$UnsubscribeSubscriber = new FlowableUnsubscribeOn$UnsubscribeSubscriber(d10, h02);
        j10.l6(flowableUnsubscribeOn$UnsubscribeSubscriber);
    }
}

