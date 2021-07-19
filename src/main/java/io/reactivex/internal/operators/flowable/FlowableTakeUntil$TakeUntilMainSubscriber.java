/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.o;
import e.a.w0.i.g;
import i.g.d;
import i.g.e;
import io.reactivex.internal.operators.flowable.FlowableTakeUntil$TakeUntilMainSubscriber$OtherSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class FlowableTakeUntil$TakeUntilMainSubscriber
extends AtomicInteger
implements o,
e {
    private static final long serialVersionUID = -4945480365982832967L;
    public final d downstream;
    public final AtomicThrowable error;
    public final FlowableTakeUntil$TakeUntilMainSubscriber$OtherSubscriber other;
    public final AtomicLong requested;
    public final AtomicReference upstream;

    public FlowableTakeUntil$TakeUntilMainSubscriber(d atomicReference) {
        this.downstream = atomicReference;
        atomicReference = new AtomicLong();
        this.requested = atomicReference;
        this.upstream = atomicReference = new AtomicReference();
        this.other = atomicReference = new FlowableTakeUntil$TakeUntilMainSubscriber$OtherSubscriber(this);
        this.error = atomicReference;
    }

    public void cancel() {
        SubscriptionHelper.cancel(this.upstream);
        SubscriptionHelper.cancel(this.other);
    }

    public void onComplete() {
        SubscriptionHelper.cancel(this.other);
        d d10 = this.downstream;
        AtomicThrowable atomicThrowable = this.error;
        g.b(d10, this, atomicThrowable);
    }

    public void onError(Throwable throwable) {
        SubscriptionHelper.cancel(this.other);
        d d10 = this.downstream;
        AtomicThrowable atomicThrowable = this.error;
        g.d(d10, throwable, this, atomicThrowable);
    }

    public void onNext(Object object) {
        d d10 = this.downstream;
        AtomicThrowable atomicThrowable = this.error;
        g.f(d10, object, this, atomicThrowable);
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

