/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.o;
import i.g.c;
import i.g.d;
import i.g.e;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import java.util.concurrent.atomic.AtomicInteger;

public final class FlowableRepeat$RepeatSubscriber
extends AtomicInteger
implements o {
    private static final long serialVersionUID = -7098360935104053232L;
    public final d downstream;
    public long produced;
    public long remaining;
    public final SubscriptionArbiter sa;
    public final c source;

    public FlowableRepeat$RepeatSubscriber(d d10, long l10, SubscriptionArbiter subscriptionArbiter, c c10) {
        this.downstream = d10;
        this.sa = subscriptionArbiter;
        this.source = c10;
        this.remaining = l10;
    }

    public void onComplete() {
        long l10;
        long l11;
        long l12 = this.remaining;
        long l13 = Long.MAX_VALUE;
        long l14 = l12 - l13;
        Object object = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
        if (object != false) {
            this.remaining = l13 = l12 - 1L;
        }
        if ((l11 = (l10 = l12 - (l13 = 0L)) == 0L ? 0 : (l10 < 0L ? -1 : 1)) != false) {
            this.subscribeNext();
        } else {
            d d10 = this.downstream;
            d10.onComplete();
        }
    }

    public void onError(Throwable throwable) {
        this.downstream.onError(throwable);
    }

    public void onNext(Object object) {
        long l10;
        this.produced = l10 = this.produced + 1L;
        this.downstream.onNext(object);
    }

    public void onSubscribe(e e10) {
        this.sa.setSubscription(e10);
    }

    public void subscribeNext() {
        int n10 = this.getAndIncrement();
        if (n10 == 0) {
            n10 = 1;
            do {
                Object object;
                boolean bl2;
                if (bl2 = ((SubscriptionArbiter)(object = this.sa)).isCancelled()) {
                    return;
                }
                long l10 = this.produced;
                long l11 = 0L;
                long l12 = l10 - l11;
                Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
                if (object2 != false) {
                    this.produced = l11;
                    SubscriptionArbiter subscriptionArbiter = this.sa;
                    subscriptionArbiter.produced(l10);
                }
                object = this.source;
                object.subscribe(this);
                n10 = -n10;
            } while ((n10 = this.addAndGet(n10)) != 0);
        }
    }
}

