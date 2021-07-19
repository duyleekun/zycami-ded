/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.o;
import i.g.c;
import i.g.d;
import i.g.e;
import io.reactivex.internal.operators.flowable.FlowableRepeatWhen$WhenSourceSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class FlowableRepeatWhen$WhenReceiver
extends AtomicInteger
implements o,
e {
    private static final long serialVersionUID = 2827772011130406689L;
    public final AtomicLong requested;
    public final c source;
    public FlowableRepeatWhen$WhenSourceSubscriber subscriber;
    public final AtomicReference upstream;

    public FlowableRepeatWhen$WhenReceiver(c serializable) {
        this.source = serializable;
        this.upstream = serializable = new Serializable();
        this.requested = serializable;
    }

    public void cancel() {
        SubscriptionHelper.cancel(this.upstream);
    }

    public void onComplete() {
        this.subscriber.cancel();
        this.subscriber.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        this.subscriber.cancel();
        this.subscriber.downstream.onError(throwable);
    }

    public void onNext(Object object) {
        int n10 = this.getAndIncrement();
        if (n10 == 0) {
            do {
                e e10;
                if ((object = this.upstream.get()) == (e10 = SubscriptionHelper.CANCELLED)) {
                    return;
                }
                object = this.source;
                e10 = this.subscriber;
                object.subscribe((d)((Object)e10));
            } while ((n10 = this.decrementAndGet()) != 0);
        }
    }

    public void onSubscribe(e e10) {
        AtomicReference atomicReference = this.upstream;
        AtomicLong atomicLong = this.requested;
        SubscriptionHelper.deferredSetOnce(atomicReference, atomicLong, e10);
    }

    public void request(long l10) {
        AtomicReference atomicReference = this.upstream;
        AtomicLong atomicLong = this.requested;
        SubscriptionHelper.deferredRequest(atomicReference, atomicLong, l10);
    }
}

