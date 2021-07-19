/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.mixed;

import e.a.d;
import e.a.s0.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.mixed.FlowableConcatMapCompletable$ConcatMapCompletableObserver;
import java.util.concurrent.atomic.AtomicReference;

public final class FlowableConcatMapCompletable$ConcatMapCompletableObserver$ConcatMapInnerObserver
extends AtomicReference
implements d {
    private static final long serialVersionUID = 5638352172918776687L;
    public final FlowableConcatMapCompletable$ConcatMapCompletableObserver parent;

    public FlowableConcatMapCompletable$ConcatMapCompletableObserver$ConcatMapInnerObserver(FlowableConcatMapCompletable$ConcatMapCompletableObserver concatMapCompletableObserver) {
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

