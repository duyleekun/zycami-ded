/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.observers;

import e.a.a1.a;
import e.a.l0;
import e.a.s0.b;
import e.a.v0.g;
import e.a.y0.f;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.Functions;
import java.util.concurrent.atomic.AtomicReference;

public final class ConsumerSingleObserver
extends AtomicReference
implements l0,
b,
f {
    private static final long serialVersionUID = -7012088219455310787L;
    public final g onError;
    public final g onSuccess;

    public ConsumerSingleObserver(g g10, g g11) {
        this.onSuccess = g10;
        this.onError = g11;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean hasCustomOnError() {
        boolean bl2;
        g g10 = this.onError;
        g g11 = Functions.f;
        if (g10 != g11) {
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

    public void onError(Throwable throwable) {
        Object object = DisposableHelper.DISPOSED;
        this.lazySet(object);
        object = this.onError;
        try {
            object.accept(throwable);
        }
        catch (Throwable throwable2) {
            e.a.t0.a.b(throwable2);
            int n10 = 2;
            Throwable[] throwableArray = new Throwable[n10];
            throwableArray[0] = throwable;
            int n11 = 1;
            throwableArray[n11] = throwable2;
            CompositeException compositeException = new CompositeException(throwableArray);
            a.Y(compositeException);
        }
    }

    public void onSubscribe(b b10) {
        DisposableHelper.setOnce(this, b10);
    }

    public void onSuccess(Object object) {
        Object object2 = DisposableHelper.DISPOSED;
        this.lazySet(object2);
        object2 = this.onSuccess;
        try {
            object2.accept(object);
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            a.Y(throwable);
        }
    }
}

