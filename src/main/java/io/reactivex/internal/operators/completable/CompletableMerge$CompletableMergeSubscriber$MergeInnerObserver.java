/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.completable;

import e.a.d;
import e.a.s0.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.completable.CompletableMerge$CompletableMergeSubscriber;
import java.util.concurrent.atomic.AtomicReference;

public final class CompletableMerge$CompletableMergeSubscriber$MergeInnerObserver
extends AtomicReference
implements d,
b {
    private static final long serialVersionUID = 251330541679988317L;
    public final /* synthetic */ CompletableMerge$CompletableMergeSubscriber this$0;

    public CompletableMerge$CompletableMergeSubscriber$MergeInnerObserver(CompletableMerge$CompletableMergeSubscriber completableMergeSubscriber) {
        this.this$0 = completableMergeSubscriber;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((b)this.get());
    }

    public void onComplete() {
        this.this$0.innerComplete(this);
    }

    public void onError(Throwable throwable) {
        this.this$0.innerError(this, throwable);
    }

    public void onSubscribe(b b10) {
        DisposableHelper.setOnce(this, b10);
    }
}

