/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.j;
import e.a.v0.r;
import e.a.w0.e.b.a;
import i.g.d;
import io.reactivex.internal.operators.flowable.FlowableRetryPredicate$RetrySubscriber;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;

public final class FlowableRetryPredicate
extends a {
    public final r c;
    public final long d;

    public FlowableRetryPredicate(j j10, long l10, r r10) {
        super(j10);
        this.c = r10;
        this.d = l10;
    }

    public void m6(d d10) {
        SubscriptionArbiter subscriptionArbiter = new SubscriptionArbiter(false);
        d10.onSubscribe(subscriptionArbiter);
        long l10 = this.d;
        r r10 = this.c;
        j j10 = this.b;
        FlowableRetryPredicate$RetrySubscriber flowableRetryPredicate$RetrySubscriber = new FlowableRetryPredicate$RetrySubscriber(d10, l10, r10, subscriptionArbiter, j10);
        flowableRetryPredicate$RetrySubscriber.subscribeNext();
    }
}

