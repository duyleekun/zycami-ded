/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.v0.c;
import e.a.w0.b.a;
import i.g.d;
import i.g.e;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class FlowableWithLatestFrom$WithLatestFromSubscriber
extends AtomicReference
implements e.a.w0.c.a,
e {
    private static final long serialVersionUID = -312246233408980075L;
    public final c combiner;
    public final d downstream;
    public final AtomicReference other;
    public final AtomicLong requested;
    public final AtomicReference upstream;

    public FlowableWithLatestFrom$WithLatestFromSubscriber(d d10, c c10) {
        AtomicReference atomicReference = new AtomicReference();
        this.upstream = atomicReference;
        this.requested = atomicReference;
        this.other = atomicReference = new AtomicReference();
        this.downstream = d10;
        this.combiner = c10;
    }

    public void cancel() {
        SubscriptionHelper.cancel(this.upstream);
        SubscriptionHelper.cancel(this.other);
    }

    public void onComplete() {
        SubscriptionHelper.cancel(this.other);
        this.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        SubscriptionHelper.cancel(this.other);
        this.downstream.onError(throwable);
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

    public void otherError(Throwable throwable) {
        SubscriptionHelper.cancel(this.upstream);
        this.downstream.onError(throwable);
    }

    public void request(long l10) {
        AtomicReference atomicReference = this.upstream;
        AtomicLong atomicLong = this.requested;
        SubscriptionHelper.deferredRequest(atomicReference, atomicLong, l10);
    }

    public boolean setOther(e e10) {
        return SubscriptionHelper.setOnce(this.other, e10);
    }

    public boolean tryOnNext(Object object) {
        Object object2 = this.get();
        if (object2 != null) {
            c c10 = this.combiner;
            object = c10.apply(object, object2);
            object2 = "The combiner returned a null value";
            try {
                object = a.g(object, object2);
                this.downstream.onNext(object);
                return true;
            }
            catch (Throwable throwable) {
                e.a.t0.a.b(throwable);
                this.cancel();
                object2 = this.downstream;
                object2.onError(throwable);
            }
        }
        return false;
    }
}

