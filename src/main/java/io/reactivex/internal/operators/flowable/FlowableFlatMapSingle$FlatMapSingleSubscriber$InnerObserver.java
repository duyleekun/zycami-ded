/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.l0;
import e.a.s0.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.flowable.FlowableFlatMapSingle$FlatMapSingleSubscriber;
import java.util.concurrent.atomic.AtomicReference;

public final class FlowableFlatMapSingle$FlatMapSingleSubscriber$InnerObserver
extends AtomicReference
implements l0,
b {
    private static final long serialVersionUID = -502562646270949838L;
    public final /* synthetic */ FlowableFlatMapSingle$FlatMapSingleSubscriber this$0;

    public FlowableFlatMapSingle$FlatMapSingleSubscriber$InnerObserver(FlowableFlatMapSingle$FlatMapSingleSubscriber flatMapSingleSubscriber) {
        this.this$0 = flatMapSingleSubscriber;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((b)this.get());
    }

    public void onError(Throwable throwable) {
        this.this$0.innerError(this, throwable);
    }

    public void onSubscribe(b b10) {
        DisposableHelper.setOnce(this, b10);
    }

    public void onSuccess(Object object) {
        this.this$0.innerSuccess(this, object);
    }
}

