/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.j;
import e.a.w0.e.b.a;
import i.g.d;
import io.reactivex.internal.operators.flowable.FlowableRetryBiPredicate$RetryBiSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;

public final class FlowableRetryBiPredicate
extends a {
    public final e.a.v0.d c;

    public FlowableRetryBiPredicate(j j10, e.a.v0.d d10) {
        super(j10);
        this.c = d10;
    }

    public void m6(d d10) {
        SubscriptionArbiter subscriptionArbiter = new SubscriptionArbiter(false);
        d10.onSubscribe(subscriptionArbiter);
        e.a.v0.d d11 = this.c;
        j j10 = this.b;
        FlowableRetryBiPredicate$RetryBiSubscriber flowableRetryBiPredicate$RetryBiSubscriber = new FlowableRetryBiPredicate$RetryBiSubscriber(d10, d11, subscriptionArbiter, j10);
        flowableRetryBiPredicate$RetryBiSubscriber.subscribeNext();
    }
}

