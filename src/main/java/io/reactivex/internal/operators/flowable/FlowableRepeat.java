/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.j;
import e.a.w0.e.b.a;
import i.g.d;
import io.reactivex.internal.operators.flowable.FlowableRepeat$RepeatSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;

public final class FlowableRepeat
extends a {
    public final long c;

    public FlowableRepeat(j j10, long l10) {
        super(j10);
        this.c = l10;
    }

    public void m6(d d10) {
        SubscriptionArbiter subscriptionArbiter = new SubscriptionArbiter(false);
        d10.onSubscribe(subscriptionArbiter);
        long l10 = this.c;
        long l11 = Long.MAX_VALUE;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (l12 != false) {
            l11 = --l10;
        }
        j j10 = this.b;
        FlowableRepeat$RepeatSubscriber flowableRepeat$RepeatSubscriber = new FlowableRepeat$RepeatSubscriber(d10, l11, subscriptionArbiter, j10);
        flowableRepeat$RepeatSubscriber.subscribeNext();
    }
}

