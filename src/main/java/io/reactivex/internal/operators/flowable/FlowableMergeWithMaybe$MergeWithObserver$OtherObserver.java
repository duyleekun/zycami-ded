/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.s0.b;
import e.a.t;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.flowable.FlowableMergeWithMaybe$MergeWithObserver;
import java.util.concurrent.atomic.AtomicReference;

public final class FlowableMergeWithMaybe$MergeWithObserver$OtherObserver
extends AtomicReference
implements t {
    private static final long serialVersionUID = -2935427570954647017L;
    public final FlowableMergeWithMaybe$MergeWithObserver parent;

    public FlowableMergeWithMaybe$MergeWithObserver$OtherObserver(FlowableMergeWithMaybe$MergeWithObserver mergeWithObserver) {
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

