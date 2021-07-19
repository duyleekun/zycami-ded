/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.l0;
import e.a.s0.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.observable.ObservableMergeWithSingle$MergeWithObserver;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableMergeWithSingle$MergeWithObserver$OtherObserver
extends AtomicReference
implements l0 {
    private static final long serialVersionUID = -2935427570954647017L;
    public final ObservableMergeWithSingle$MergeWithObserver parent;

    public ObservableMergeWithSingle$MergeWithObserver$OtherObserver(ObservableMergeWithSingle$MergeWithObserver mergeWithObserver) {
        this.parent = mergeWithObserver;
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

