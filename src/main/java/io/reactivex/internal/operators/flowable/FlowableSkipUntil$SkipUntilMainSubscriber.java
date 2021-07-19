/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.w0.c.a;
import e.a.w0.i.g;
import i.g.d;
import i.g.e;
import io.reactivex.internal.operators.flowable.FlowableSkipUntil$SkipUntilMainSubscriber$OtherSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class FlowableSkipUntil$SkipUntilMainSubscriber
extends AtomicInteger
implements a,
e {
    private static final long serialVersionUID = -6270983465606289181L;
    public final d downstream;
    public final AtomicThrowable error;
    public volatile boolean gate;
    public final FlowableSkipUntil$SkipUntilMainSubscriber$OtherSubscriber other;
    public final AtomicLong requested;
    public final AtomicReference upstream;

    public FlowableSkipUntil$SkipUntilMainSubscriber(d atomicReference) {
        this.downstream = atomicReference;
        atomicReference = new AtomicReference();
        this.upstream = atomicReference;
        this.requested = atomicReference;
        this.other = atomicReference = new FlowableSkipUntil$SkipUntilMainSubscriber$OtherSubscriber(this);
        super();
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
        boolean bl2 = this.tryOnNext(object);
        if (!bl2) {
            object = (e)this.upstream.get();
            long l10 = 1L;
            object.request(l10);
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

    public boolean tryOnNext(Object object) {
        boolean bl2 = this.gate;
        if (bl2) {
            d d10 = this.downstream;
            AtomicThrowable atomicThrowable = this.error;
            g.f(d10, object, this, atomicThrowable);
            return true;
        }
        return false;
    }
}

