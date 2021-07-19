/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.maybe;

import e.a.a1.a;
import e.a.s0.b;
import e.a.t;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.maybe.MaybeTakeUntilPublisher$TakeUntilMainMaybeObserver$TakeUntilOtherMaybeObserver;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeTakeUntilPublisher$TakeUntilMainMaybeObserver
extends AtomicReference
implements t,
b {
    private static final long serialVersionUID = -2187421758664251153L;
    public final t downstream;
    public final MaybeTakeUntilPublisher$TakeUntilMainMaybeObserver$TakeUntilOtherMaybeObserver other;

    public MaybeTakeUntilPublisher$TakeUntilMainMaybeObserver(t object) {
        this.downstream = object;
        this.other = object = new MaybeTakeUntilPublisher$TakeUntilMainMaybeObserver$TakeUntilOtherMaybeObserver(this);
    }

    public void dispose() {
        DisposableHelper.dispose(this);
        SubscriptionHelper.cancel(this.other);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((b)this.get());
    }

    public void onComplete() {
        SubscriptionHelper.cancel(this.other);
        Object object = DisposableHelper.DISPOSED;
        DisposableHelper disposableHelper = this.getAndSet(object);
        if (disposableHelper != object) {
            object = this.downstream;
            object.onComplete();
        }
    }

    public void onError(Throwable throwable) {
        SubscriptionHelper.cancel(this.other);
        Object object = DisposableHelper.DISPOSED;
        DisposableHelper disposableHelper = this.getAndSet(object);
        if (disposableHelper != object) {
            object = this.downstream;
            object.onError(throwable);
        } else {
            a.Y(throwable);
        }
    }

    public void onSubscribe(b b10) {
        DisposableHelper.setOnce(this, b10);
    }

    public void onSuccess(Object object) {
        SubscriptionHelper.cancel(this.other);
        Object object2 = DisposableHelper.DISPOSED;
        DisposableHelper disposableHelper = this.getAndSet(object2);
        if (disposableHelper != object2) {
            object2 = this.downstream;
            object2.onSuccess(object);
        }
    }

    public void otherComplete() {
        boolean bl2 = DisposableHelper.dispose(this);
        if (bl2) {
            t t10 = this.downstream;
            t10.onComplete();
        }
    }

    public void otherError(Throwable throwable) {
        boolean bl2 = DisposableHelper.dispose(this);
        if (bl2) {
            t t10 = this.downstream;
            t10.onError(throwable);
        } else {
            a.Y(throwable);
        }
    }
}

