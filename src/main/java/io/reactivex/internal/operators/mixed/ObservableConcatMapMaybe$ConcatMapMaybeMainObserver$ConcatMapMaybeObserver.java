/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.mixed;

import e.a.s0.b;
import e.a.t;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.mixed.ObservableConcatMapMaybe$ConcatMapMaybeMainObserver;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableConcatMapMaybe$ConcatMapMaybeMainObserver$ConcatMapMaybeObserver
extends AtomicReference
implements t {
    private static final long serialVersionUID = -3051469169682093892L;
    public final ObservableConcatMapMaybe$ConcatMapMaybeMainObserver parent;

    public ObservableConcatMapMaybe$ConcatMapMaybeMainObserver$ConcatMapMaybeObserver(ObservableConcatMapMaybe$ConcatMapMaybeMainObserver concatMapMaybeMainObserver) {
        this.parent = concatMapMaybeMainObserver;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public void onComplete() {
        this.parent.innerComplete();
    }

    public void onError(Throwable throwable) {
        this.parent.innerError(throwable);
    }

    public void onSubscribe(b b10) {
        DisposableHelper.replace(this, b10);
    }

    public void onSuccess(Object object) {
        this.parent.innerSuccess(object);
    }
}

