/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.d;
import e.a.s0.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.flowable.FlowableMergeWithCompletable$MergeWithSubscriber;
import java.util.concurrent.atomic.AtomicReference;

public final class FlowableMergeWithCompletable$MergeWithSubscriber$OtherObserver
extends AtomicReference
implements d {
    private static final long serialVersionUID = -2935427570954647017L;
    public final FlowableMergeWithCompletable$MergeWithSubscriber parent;

    public FlowableMergeWithCompletable$MergeWithSubscriber$OtherObserver(FlowableMergeWithCompletable$MergeWithSubscriber mergeWithSubscriber) {
        this.parent = mergeWithSubscriber;
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
}

