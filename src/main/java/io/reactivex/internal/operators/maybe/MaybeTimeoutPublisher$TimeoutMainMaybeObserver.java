/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.maybe;

import e.a.a1.a;
import e.a.s0.b;
import e.a.t;
import e.a.w;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.maybe.MaybeTimeoutPublisher$TimeoutFallbackMaybeObserver;
import io.reactivex.internal.operators.maybe.MaybeTimeoutPublisher$TimeoutOtherMaybeObserver;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeTimeoutPublisher$TimeoutMainMaybeObserver
extends AtomicReference
implements t,
b {
    private static final long serialVersionUID = -5955289211445418871L;
    public final t downstream;
    public final w fallback;
    public final MaybeTimeoutPublisher$TimeoutOtherMaybeObserver other;
    public final MaybeTimeoutPublisher$TimeoutFallbackMaybeObserver otherObserver;

    public MaybeTimeoutPublisher$TimeoutMainMaybeObserver(t t10, w object) {
        MaybeTimeoutPublisher$TimeoutOtherMaybeObserver maybeTimeoutPublisher$TimeoutOtherMaybeObserver;
        this.downstream = t10;
        this.other = maybeTimeoutPublisher$TimeoutOtherMaybeObserver = new MaybeTimeoutPublisher$TimeoutOtherMaybeObserver(this);
        this.fallback = object;
        object = object != null ? new MaybeTimeoutPublisher$TimeoutFallbackMaybeObserver(t10) : null;
        this.otherObserver = object;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
        SubscriptionHelper.cancel(this.other);
        MaybeTimeoutPublisher$TimeoutFallbackMaybeObserver maybeTimeoutPublisher$TimeoutFallbackMaybeObserver = this.otherObserver;
        if (maybeTimeoutPublisher$TimeoutFallbackMaybeObserver != null) {
            DisposableHelper.dispose(maybeTimeoutPublisher$TimeoutFallbackMaybeObserver);
        }
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
            Object object = this.fallback;
            if (object == null) {
                object = this.downstream;
                TimeoutException timeoutException = new TimeoutException();
                object.onError(timeoutException);
            } else {
                MaybeTimeoutPublisher$TimeoutFallbackMaybeObserver maybeTimeoutPublisher$TimeoutFallbackMaybeObserver = this.otherObserver;
                object.g(maybeTimeoutPublisher$TimeoutFallbackMaybeObserver);
            }
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

