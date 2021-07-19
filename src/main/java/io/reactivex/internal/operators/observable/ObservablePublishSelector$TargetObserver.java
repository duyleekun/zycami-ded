/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.g0;
import e.a.s0.b;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservablePublishSelector$TargetObserver
extends AtomicReference
implements g0,
b {
    private static final long serialVersionUID = 854110278590336484L;
    public final g0 downstream;
    public b upstream;

    public ObservablePublishSelector$TargetObserver(g0 g02) {
        this.downstream = g02;
    }

    public void dispose() {
        this.upstream.dispose();
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return this.upstream.isDisposed();
    }

    public void onComplete() {
        DisposableHelper.dispose(this);
        this.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        DisposableHelper.dispose(this);
        this.downstream.onError(throwable);
    }

    public void onNext(Object object) {
        this.downstream.onNext(object);
    }

    public void onSubscribe(b object) {
        b b10 = this.upstream;
        boolean bl2 = DisposableHelper.validate(b10, (b)object);
        if (bl2) {
            this.upstream = object;
            object = this.downstream;
            object.onSubscribe(this);
        }
    }
}

