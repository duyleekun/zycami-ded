/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.observers;

import e.a.a1.a;
import e.a.d;
import e.a.s0.b;
import e.a.y0.f;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class EmptyCompletableObserver
extends AtomicReference
implements d,
b,
f {
    private static final long serialVersionUID = -7545121636549663526L;

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean hasCustomOnError() {
        return false;
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
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        this.lazySet(disposableHelper);
    }

    public void onError(Throwable throwable) {
        Object object = DisposableHelper.DISPOSED;
        this.lazySet(object);
        object = new OnErrorNotImplementedException(throwable);
        a.Y((Throwable)object);
    }

    public void onSubscribe(b b10) {
        DisposableHelper.setOnce(this, b10);
    }
}

