/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.o;
import e.a.t0.a;
import i.g.c;
import i.g.d;
import i.g.e;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import java.util.concurrent.atomic.AtomicInteger;

public final class FlowableRetryBiPredicate$RetryBiSubscriber
extends AtomicInteger
implements o {
    private static final long serialVersionUID = -7098360935104053232L;
    public final d downstream;
    public final e.a.v0.d predicate;
    public long produced;
    public int retries;
    public final SubscriptionArbiter sa;
    public final c source;

    public FlowableRetryBiPredicate$RetryBiSubscriber(d d10, e.a.v0.d d11, SubscriptionArbiter subscriptionArbiter, c c10) {
        this.downstream = d10;
        this.sa = subscriptionArbiter;
        this.source = c10;
        this.predicate = d11;
    }

    public void onComplete() {
        this.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        Object object;
        e.a.v0.d d10;
        int n10 = 1;
        try {
            d10 = this.predicate;
        }
        catch (Throwable throwable2) {
            a.b(throwable2);
            object = this.downstream;
            Throwable[] throwableArray = new Throwable[2];
            throwableArray[0] = throwable;
            throwableArray[n10] = throwable2;
            CompositeException compositeException = new CompositeException(throwableArray);
            object.onError(compositeException);
            return;
        }
        int n11 = this.retries + n10;
        this.retries = n11;
        object = n11;
        n10 = (int)(d10.a(object, throwable) ? 1 : 0);
        if (n10 == 0) {
            this.downstream.onError(throwable);
            return;
        }
        this.subscribeNext();
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

