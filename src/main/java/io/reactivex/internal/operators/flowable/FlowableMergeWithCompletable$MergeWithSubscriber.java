/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.o;
import e.a.w0.i.g;
import i.g.d;
import i.g.e;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.flowable.FlowableMergeWithCompletable$MergeWithSubscriber$OtherObserver;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class FlowableMergeWithCompletable$MergeWithSubscriber
extends AtomicInteger
implements o,
e {
    private static final long serialVersionUID = -4592979584110982903L;
    public final d downstream;
    public final AtomicThrowable error;
    public volatile boolean mainDone;
    public final AtomicReference mainSubscription;
    public volatile boolean otherDone;
    public final FlowableMergeWithCompletable$MergeWithSubscriber$OtherObserver otherObserver;
    public final AtomicLong requested;

    public FlowableMergeWithCompletable$MergeWithSubscriber(d serializable) {
        this.downstream = serializable;
        this.mainSubscription = serializable = new AtomicReference();
        this.otherObserver = serializable = new FlowableMergeWithCompletable$MergeWithSubscriber$OtherObserver(this);
        this.error = serializable;
        super();
        this.requested = serializable;
    }

    public void cancel() {
        SubscriptionHelper.cancel(this.mainSubscription);
        DisposableHelper.dispose(this.otherObserver);
    }

    public void onComplete() {
        this.mainDone = true;
        boolean bl2 = this.otherDone;
        if (bl2) {
            d d10 = this.downstream;
            AtomicThrowable atomicThrowable = this.error;
            g.b(d10, this, atomicThrowable);
        }
    }

    public void onError(Throwable throwable) {
        DisposableHelper.dispose(this.otherObserver);
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
        AtomicReference atomicReference = this.mainSubscription;
        AtomicLong atomicLong = this.requested;
        SubscriptionHelper.deferredSetOnce(atomicReference, atomicLong, e10);
    }

    public void otherComplete() {
        this.otherDone = true;
        boolean bl2 = this.mainDone;
        if (bl2) {
            d d10 = this.downstream;
            AtomicThrowable atomicThrowable = this.error;
            g.b(d10, this, atomicThrowable);
        }
    }

    public void otherError(Throwable throwable) {
        SubscriptionHelper.cancel(this.mainSubscription);
        d d10 = this.downstream;
        AtomicThrowable atomicThrowable = this.error;
        g.d(d10, throwable, this, atomicThrowable);
    }

    public void request(long l10) {
        AtomicReference atomicReference = this.mainSubscription;
        AtomicLong atomicLong = this.requested;
        SubscriptionHelper.deferredRequest(atomicReference, atomicLong, l10);
    }
}

