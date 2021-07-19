/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.mixed;

import e.a.d;
import e.a.e0;
import e.a.g0;
import e.a.s0.b;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class CompletableAndThenObservable$AndThenObservableObserver
extends AtomicReference
implements g0,
d,
b {
    private static final long serialVersionUID = -8948264376121066672L;
    public final g0 downstream;
    public e0 other;

    public CompletableAndThenObservable$AndThenObservableObserver(g0 g02, e0 e02) {
        this.other = e02;
        this.downstream = g02;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((b)this.get());
    }

    public void onComplete() {
        Object object = this.other;
        if (object == null) {
            object = this.downstream;
            object.onComplete();
        } else {
            this.other = null;
            object.subscribe(this);
        }
    }

    public void onError(Throwable throwable) {
        this.downstream.onError(throwable);
    }

    public void onNext(Object object) {
        this.downstream.onNext(object);
    }

    public void onSubscribe(b b10) {
        DisposableHelper.replace(this, b10);
    }
}

