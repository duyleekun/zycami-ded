/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.l0;
import e.a.o0;
import e.a.s0.b;
import i.g.d;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscribers.SinglePostCompleteSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class FlowableConcatWithSingle$ConcatWithSubscriber
extends SinglePostCompleteSubscriber
implements l0 {
    private static final long serialVersionUID = -7346385463600070225L;
    public o0 other;
    public final AtomicReference otherDisposable;

    public FlowableConcatWithSingle$ConcatWithSubscriber(d atomicReference, o0 o02) {
        super((d)((Object)atomicReference));
        this.other = o02;
        this.otherDisposable = atomicReference = new AtomicReference();
    }

    public void cancel() {
        super.cancel();
        DisposableHelper.dispose(this.otherDisposable);
    }

    public void onComplete() {
        Object object = SubscriptionHelper.CANCELLED;
        this.upstream = object;
        object = this.other;
        this.other = null;
        object.f(this);
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

