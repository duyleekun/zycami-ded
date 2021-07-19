/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.maybe;

import e.a.a1.a;
import e.a.s0.b;
import e.a.t;
import e.a.w;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.maybe.MaybeTimeoutMaybe$TimeoutFallbackMaybeObserver;
import io.reactivex.internal.operators.maybe.MaybeTimeoutMaybe$TimeoutOtherMaybeObserver;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeTimeoutMaybe$TimeoutMainMaybeObserver
extends AtomicReference
implements t,
b {
    private static final long serialVersionUID = -5955289211445418871L;
    public final t downstream;
    public final w fallback;
    public final MaybeTimeoutMaybe$TimeoutOtherMaybeObserver other;
    public final MaybeTimeoutMaybe$TimeoutFallbackMaybeObserver otherObserver;

    public MaybeTimeoutMaybe$TimeoutMainMaybeObserver(t t10, w object) {
        MaybeTimeoutMaybe$TimeoutOtherMaybeObserver maybeTimeoutMaybe$TimeoutOtherMaybeObserver;
        this.downstream = t10;
        this.other = maybeTimeoutMaybe$TimeoutOtherMaybeObserver = new MaybeTimeoutMaybe$TimeoutOtherMaybeObserver(this);
        this.fallback = object;
        object = object != null ? new MaybeTimeoutMaybe$TimeoutFallbackMaybeObserver(t10) : null;
        this.otherObserver = object;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
        DisposableHelper.dispose(this.other);
        MaybeTimeoutMaybe$TimeoutFallbackMaybeObserver maybeTimeoutMaybe$TimeoutFallbackMaybeObserver = this.otherObserver;
        if (maybeTimeoutMaybe$TimeoutFallbackMaybeObserver != null) {
            DisposableHelper.dispose(maybeTimeoutMaybe$TimeoutFallbackMaybeObserver);
        }
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((b)this.get());
    }

    public void onComplete() {
        DisposableHelper.dispose(this.other);
        Object object = DisposableHelper.DISPOSED;
        DisposableHelper disposableHelper = this.getAndSet(object);
        if (disposableHelper != object) {
            object = this.downstream;
            object.onComplete();
        }
    }

    public void onError(Throwable throwable) {
        DisposableHelper.dispose(this.other);
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
        DisposableHelper.dispose(this.other);
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
                MaybeTimeoutMaybe$TimeoutFallbackMaybeObserver maybeTimeoutMaybe$TimeoutFallbackMaybeObserver = this.otherObserver;
                object.g(maybeTimeoutMaybe$TimeoutFallbackMaybeObserver);
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

