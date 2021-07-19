/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.mixed;

import e.a.l0;
import e.a.s0.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.mixed.FlowableConcatMapSingle$ConcatMapSingleSubscriber;
import java.util.concurrent.atomic.AtomicReference;

public final class FlowableConcatMapSingle$ConcatMapSingleSubscriber$ConcatMapSingleObserver
extends AtomicReference
implements l0 {
    private static final long serialVersionUID = -3051469169682093892L;
    public final FlowableConcatMapSingle$ConcatMapSingleSubscriber parent;

    public FlowableConcatMapSingle$ConcatMapSingleSubscriber$ConcatMapSingleObserver(FlowableConcatMapSingle$ConcatMapSingleSubscriber concatMapSingleSubscriber) {
        this.parent = concatMapSingleSubscriber;
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

