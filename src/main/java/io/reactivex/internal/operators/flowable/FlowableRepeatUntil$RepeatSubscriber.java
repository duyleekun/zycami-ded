/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.o;
import e.a.t0.a;
import i.g.c;
import i.g.d;
import i.g.e;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import java.util.concurrent.atomic.AtomicInteger;

public final class FlowableRepeatUntil$RepeatSubscriber
extends AtomicInteger
implements o {
    private static final long serialVersionUID = -7098360935104053232L;
    public final d downstream;
    public long produced;
    public final SubscriptionArbiter sa;
    public final c source;
    public final e.a.v0.e stop;

    public FlowableRepeatUntil$RepeatSubscriber(d d10, e.a.v0.e e10, SubscriptionArbiter subscriptionArbiter, c c10) {
        this.downstream = d10;
        this.sa = subscriptionArbiter;
        this.source = c10;
        this.stop = e10;
    }

    public void onComplete() {
        Object object;
        try {
            object = this.stop;
        }
        catch (Throwable throwable) {
            a.b(throwable);
            this.downstream.onError(throwable);
            return;
        }
        boolean bl2 = object.getAsBoolean();
        if (bl2) {
            object = this.downstream;
            object.onComplete();
        } else {
            this.subscribeNext();
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

