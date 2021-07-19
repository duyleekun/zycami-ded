/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.j;
import e.a.v0.e;
import e.a.w0.e.b.a;
import i.g.d;
import io.reactivex.internal.operators.flowable.FlowableRepeatUntil$RepeatSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;

public final class FlowableRepeatUntil
extends a {
    public final e c;

    public FlowableRepeatUntil(j j10, e e10) {
        super(j10);
        this.c = e10;
    }

    public void m6(d d10) {
        SubscriptionArbiter subscriptionArbiter = new SubscriptionArbiter(false);
        d10.onSubscribe(subscriptionArbiter);
        e e10 = this.c;
        j j10 = this.b;
        FlowableRepeatUntil$RepeatSubscriber flowableRepeatUntil$RepeatSubscriber = new FlowableRepeatUntil$RepeatSubscriber(d10, e10, subscriptionArbiter, j10);
        flowableRepeatUntil$RepeatSubscriber.subscribeNext();
    }
}

