/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.observers;

import e.a.a1.a;
import e.a.d;
import e.a.s0.b;
import e.a.v0.g;
import e.a.y0.f;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class CallbackCompletableObserver
extends AtomicReference
implements d,
b,
g,
f {
    private static final long serialVersionUID = -4361286194466301354L;
    public final e.a.v0.a onComplete;
    public final g onError;

    public CallbackCompletableObserver(e.a.v0.a a10) {
        this.onError = this;
        this.onComplete = a10;
    }

    public CallbackCompletableObserver(g g10, e.a.v0.a a10) {
        this.onError = g10;
        this.onComplete = a10;
    }

    public void accept(Throwable throwable) {
        OnErrorNotImplementedException onErrorNotImplementedException = new OnErrorNotImplementedException(throwable);
        a.Y(onErrorNotImplementedException);
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean hasCustomOnError() {
        boolean bl2;
        g g10 = this.onError;
        if (g10 != this) {
            bl2 = true;
        } else {
            bl2 = false;
            g10 = null;
        }
        return bl2;
    }

    public boolean isDisposed() {
        boolean bl2;
        DisposableHelper disposableHelper;
        Object v10 = this.get();
        if (v10 == (disposableHelper = DisposableHelper.DISPOSED)) {
            bl2 = true;
        } else {
            bl2 = false;
            v10 = null;
        }
        return bl2;
    }

    public void onComplete() {
        Object object = this.onComplete;
        try {
            object.run();
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            a.Y(throwable);
        }
        object = DisposableHelper.DISPOSED;
        this.lazySet(object);
    }

    public void onError(Throwable object) {
        g g10 = this.onError;
        try {
            g10.accept(object);
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            a.Y(throwable);
        }
        object = DisposableHelper.DISPOSED;
        this.lazySet(object);
    }

    public void onSubscribe(b b10) {
        DisposableHelper.setOnce(this, b10);
    }
}

