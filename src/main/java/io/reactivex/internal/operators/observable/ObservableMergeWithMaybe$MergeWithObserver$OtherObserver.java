/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.s0.b;
import e.a.t;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.observable.ObservableMergeWithMaybe$MergeWithObserver;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableMergeWithMaybe$MergeWithObserver$OtherObserver
extends AtomicReference
implements t {
    private static final long serialVersionUID = -2935427570954647017L;
    public final ObservableMergeWithMaybe$MergeWithObserver parent;

    public ObservableMergeWithMaybe$MergeWithObserver$OtherObserver(ObservableMergeWithMaybe$MergeWithObserver mergeWithObserver) {
        this.parent = mergeWithObserver;
    }

    public void onComplete() {
        this.parent.otherComplete();
    }

    public void onError(Throwable throwable) {
        this.parent.otherError(throwable);
    }

    public void onSubscribe(b b10) {
        DisposableHelper.setOnce(this, b10);
    }

    public void onSuccess(Object object) {
        this.parent.otherSuccess(object);
    }
}

