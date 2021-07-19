/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.observers;

import e.a.a1.a;
import e.a.l0;
import e.a.v0.b;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class BiConsumerSingleObserver
extends AtomicReference
implements l0,
e.a.s0.b {
    private static final long serialVersionUID = 4943102778943297569L;
    public final b onCallback;

    public BiConsumerSingleObserver(b b10) {
        this.onCallback = b10;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
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
        object = this.onCallback;
        CompositeException compositeException = null;
        try {
            object.accept(null, throwable);
        }
        catch (Throwable throwable2) {
            e.a.t0.a.b(throwable2);
            int n10 = 2;
            Throwable[] throwableArray = new Throwable[n10];
            throwableArray[0] = throwable;
            int n11 = 1;
            throwableArray[n11] = throwable2;
            compositeException = new CompositeException(throwableArray);
            a.Y(compositeException);
        }
    }

    public void onSubscribe(e.a.s0.b b10) {
        DisposableHelper.setOnce(this, b10);
    }

    public void onSuccess(Object object) {
        Object object2 = DisposableHelper.DISPOSED;
        this.lazySet(object2);
        object2 = this.onCallback;
        try {
            object2.accept(object, null);
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            a.Y(throwable);
        }
    }
}

