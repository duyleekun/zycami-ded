/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.mixed;

import e.a.d;
import e.a.s0.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.mixed.ObservableConcatMapCompletable$ConcatMapCompletableObserver;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableConcatMapCompletable$ConcatMapCompletableObserver$ConcatMapInnerObserver
extends AtomicReference
implements d {
    private static final long serialVersionUID = 5638352172918776687L;
    public final ObservableConcatMapCompletable$ConcatMapCompletableObserver parent;

    public ObservableConcatMapCompletable$ConcatMapCompletableObserver$ConcatMapInnerObserver(ObservableConcatMapCompletable$ConcatMapCompletableObserver concatMapCompletableObserver) {
        this.parent = concatMapCompletableObserver;
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
}

