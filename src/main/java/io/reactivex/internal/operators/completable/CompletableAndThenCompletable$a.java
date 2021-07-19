/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.completable;

import e.a.d;
import e.a.s0.b;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class CompletableAndThenCompletable$a
implements d {
    public final AtomicReference a;
    public final d b;

    public CompletableAndThenCompletable$a(AtomicReference atomicReference, d d10) {
        this.a = atomicReference;
        this.b = d10;
    }

    public void onComplete() {
        this.b.onComplete();
    }

    public void onError(Throwable throwable) {
        this.b.onError(throwable);
    }

    public void onSubscribe(b b10) {
        DisposableHelper.replace(this.a, b10);
    }
}

