/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.g0;
import e.a.s0.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.observable.ObservableConcatMap$SourceObserver;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableConcatMap$SourceObserver$InnerObserver
extends AtomicReference
implements g0 {
    private static final long serialVersionUID = -7449079488798789337L;
    public final g0 downstream;
    public final ObservableConcatMap$SourceObserver parent;

    public ObservableConcatMap$SourceObserver$InnerObserver(g0 g02, ObservableConcatMap$SourceObserver sourceObserver) {
        this.downstream = g02;
        this.parent = sourceObserver;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public void onComplete() {
        this.parent.innerComplete();
    }

    public void onError(Throwable throwable) {
        this.parent.dispose();
        this.downstream.onError(throwable);
    }

    public void onNext(Object object) {
        this.downstream.onNext(object);
    }

    public void onSubscribe(b b10) {
        DisposableHelper.replace(this, b10);
    }
}

