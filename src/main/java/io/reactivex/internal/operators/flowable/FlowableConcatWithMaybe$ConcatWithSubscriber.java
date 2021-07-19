/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.s0.b;
import e.a.t;
import e.a.w;
import i.g.d;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscribers.SinglePostCompleteSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class FlowableConcatWithMaybe$ConcatWithSubscriber
extends SinglePostCompleteSubscriber
implements t {
    private static final long serialVersionUID = -7346385463600070225L;
    public boolean inMaybe;
    public w other;
    public final AtomicReference otherDisposable;

    public FlowableConcatWithMaybe$ConcatWithSubscriber(d atomicReference, w w10) {
        super((d)((Object)atomicReference));
        this.other = w10;
        this.otherDisposable = atomicReference = new AtomicReference();
    }

    public void cancel() {
        super.cancel();
        DisposableHelper.dispose(this.otherDisposable);
    }

    public void onComplete() {
        boolean bl2 = this.inMaybe;
        if (bl2) {
            d d10 = this.downstream;
            d10.onComplete();
        } else {
            this.inMaybe = bl2 = true;
            Object object = SubscriptionHelper.CANCELLED;
            this.upstream = object;
            object = this.other;
            this.other = null;
            object.g(this);
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

    public void onSubscribe(b b10) {
        DisposableHelper.setOnce(this.otherDisposable, b10);
    }

    public void onSuccess(Object object) {
        this.complete(object);
    }
}

