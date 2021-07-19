/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.g0;
import e.a.s0.b;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableSubscribeOn$SubscribeOnObserver
extends AtomicReference
implements g0,
b {
    private static final long serialVersionUID = 8094547886072529208L;
    public final g0 downstream;
    public final AtomicReference upstream;

    public ObservableSubscribeOn$SubscribeOnObserver(g0 atomicReference) {
        this.downstream = atomicReference;
        this.upstream = atomicReference = new AtomicReference();
    }

    public void dispose() {
        DisposableHelper.dispose(this.upstream);
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((b)this.get());
    }

    public void onComplete() {
        this.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        this.downstream.onError(throwable);
    }

    public void onNext(Object object) {
        this.downstream.onNext(object);
    }

    public void onSubscribe(b b10) {
        DisposableHelper.setOnce(this.upstream, b10);
    }

    public void setDisposable(b b10) {
        DisposableHelper.setOnce(this, b10);
    }
}

