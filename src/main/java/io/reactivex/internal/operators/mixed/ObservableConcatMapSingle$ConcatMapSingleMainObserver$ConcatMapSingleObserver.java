/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.mixed;

import e.a.l0;
import e.a.s0.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.mixed.ObservableConcatMapSingle$ConcatMapSingleMainObserver;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableConcatMapSingle$ConcatMapSingleMainObserver$ConcatMapSingleObserver
extends AtomicReference
implements l0 {
    private static final long serialVersionUID = -3051469169682093892L;
    public final ObservableConcatMapSingle$ConcatMapSingleMainObserver parent;

    public ObservableConcatMapSingle$ConcatMapSingleMainObserver$ConcatMapSingleObserver(ObservableConcatMapSingle$ConcatMapSingleMainObserver concatMapSingleMainObserver) {
        this.parent = concatMapSingleMainObserver;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
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

