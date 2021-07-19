/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.completable;

import e.a.d;
import e.a.s0.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.completable.CompletableConcat$CompletableConcatSubscriber;
import java.util.concurrent.atomic.AtomicReference;

public final class CompletableConcat$CompletableConcatSubscriber$ConcatInnerObserver
extends AtomicReference
implements d {
    private static final long serialVersionUID = -5454794857847146511L;
    public final CompletableConcat$CompletableConcatSubscriber parent;

    public CompletableConcat$CompletableConcatSubscriber$ConcatInnerObserver(CompletableConcat$CompletableConcatSubscriber completableConcatSubscriber) {
        this.parent = completableConcatSubscriber;
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

