/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.o;
import i.g.d;
import i.g.e;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;

public final class FlowableTimeoutTimed$a
implements o {
    public final d a;
    public final SubscriptionArbiter b;

    public FlowableTimeoutTimed$a(d d10, SubscriptionArbiter subscriptionArbiter) {
        this.a = d10;
        this.b = subscriptionArbiter;
    }

    public void onComplete() {
        this.a.onComplete();
    }

    public void onError(Throwable throwable) {
        this.a.onError(throwable);
    }

    public void onNext(Object object) {
        this.a.onNext(object);
    }

    public void onSubscribe(e e10) {
        this.b.setSubscription(e10);
    }
}

