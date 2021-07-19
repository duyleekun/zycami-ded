/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.completable;

import e.a.d;
import e.a.s0.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.completable.CompletableTakeUntilCompletable$TakeUntilMainObserver;
import java.util.concurrent.atomic.AtomicReference;

public final class CompletableTakeUntilCompletable$TakeUntilMainObserver$OtherObserver
extends AtomicReference
implements d {
    private static final long serialVersionUID = 5176264485428790318L;
    public final CompletableTakeUntilCompletable$TakeUntilMainObserver parent;

    public CompletableTakeUntilCompletable$TakeUntilMainObserver$OtherObserver(CompletableTakeUntilCompletable$TakeUntilMainObserver takeUntilMainObserver) {
        this.parent = takeUntilMainObserver;
    }

    public void onComplete() {
        this.parent.innerComplete();
    }

    public void onError(Throwable throwable) {
        this.parent.innerError(throwable);
    }

    public void onSubscribe(b b10) {
        DisposableHelper.setOnce(this, b10);
    }
}

