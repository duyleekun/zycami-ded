/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.maybe;

import e.a.a1.a;
import e.a.s0.b;
import e.a.t;
import e.a.v0.g;
import e.a.y0.f;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.Functions;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeCallbackObserver
extends AtomicReference
implements t,
b,
f {
    private static final long serialVersionUID = -6076952298809384986L;
    public final e.a.v0.a onComplete;
    public final g onError;
    public final g onSuccess;

    public MaybeCallbackObserver(g g10, g g11, e.a.v0.a a10) {
        this.onSuccess = g10;
        this.onError = g11;
        this.onComplete = a10;
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
        return DisposableHelper.isDisposed((b)this.get());
    }

    public void onComplete() {
        Object object = DisposableHelper.DISPOSED;
        this.lazySet(object);
        object = this.onComplete;
        try {
            object.run();
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            a.Y(throwable);
        }
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

