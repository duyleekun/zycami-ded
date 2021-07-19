/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.observers;

import e.a.a1.a;
import e.a.g0;
import e.a.s0.b;
import e.a.v0.g;
import e.a.y0.f;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.Functions;
import java.util.concurrent.atomic.AtomicReference;

public final class LambdaObserver
extends AtomicReference
implements g0,
b,
f {
    private static final long serialVersionUID = -7251123623727029452L;
    public final e.a.v0.a onComplete;
    public final g onError;
    public final g onNext;
    public final g onSubscribe;

    public LambdaObserver(g g10, g g11, e.a.v0.a a10, g g12) {
        this.onNext = g10;
        this.onError = g11;
        this.onComplete = a10;
        this.onSubscribe = g12;
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

    public void onComplete() {
        boolean bl2 = this.isDisposed();
        if (!bl2) {
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
    }

    public void onError(Throwable throwable) {
        boolean bl2 = this.isDisposed();
        if (!bl2) {
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
        } else {
            a.Y(throwable);
        }
    }

    public void onNext(Object object) {
        boolean bl2 = this.isDisposed();
        if (!bl2) {
            Object object2 = this.onNext;
            try {
                object2.accept(object);
            }
            catch (Throwable throwable) {
                e.a.t0.a.b(throwable);
                object2 = (b)this.get();
                object2.dispose();
                this.onError(throwable);
            }
        }
    }

    public void onSubscribe(b b10) {
        boolean bl2 = DisposableHelper.setOnce(this, b10);
        if (bl2) {
            g g10 = this.onSubscribe;
            try {
                g10.accept(this);
            }
            catch (Throwable throwable) {
                e.a.t0.a.b(throwable);
                b10.dispose();
                this.onError(throwable);
            }
        }
    }
}

