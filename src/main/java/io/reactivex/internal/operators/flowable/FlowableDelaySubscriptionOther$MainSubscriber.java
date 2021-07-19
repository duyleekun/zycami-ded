/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.o;
import i.g.c;
import i.g.d;
import i.g.e;
import io.reactivex.internal.operators.flowable.FlowableDelaySubscriptionOther$MainSubscriber$OtherSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class FlowableDelaySubscriptionOther$MainSubscriber
extends AtomicLong
implements o,
e {
    private static final long serialVersionUID = 2259811067697317255L;
    public final d downstream;
    public final c main;
    public final FlowableDelaySubscriptionOther$MainSubscriber$OtherSubscriber other;
    public final AtomicReference upstream;

    public FlowableDelaySubscriptionOther$MainSubscriber(d atomicReference, c c10) {
        this.downstream = atomicReference;
        this.main = c10;
        super(this);
        this.other = atomicReference;
        this.upstream = atomicReference = new AtomicReference();
    }

    public void cancel() {
        SubscriptionHelper.cancel(this.other);
        SubscriptionHelper.cancel(this.upstream);
    }

    public void next() {
        this.main.subscribe(this);
    }

    public void onComplete() {
        this.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        this.downstream.onError(throwable);
    }

    public void onNext(Object object) {
        this.downstream.onNext(object);
    }

    public void onSubscribe(e e10) {
        SubscriptionHelper.deferredSetOnce(this.upstream, this, e10);
    }

    public void request(long l10) {
        boolean bl2 = SubscriptionHelper.validate(l10);
        if (bl2) {
            AtomicReference atomicReference = this.upstream;
            SubscriptionHelper.deferredRequest(atomicReference, this, l10);
        }
    }
}

