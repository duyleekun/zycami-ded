/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.g0;
import e.a.s0.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.observable.ObservableCombineLatest$LatestCoordinator;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableCombineLatest$CombinerObserver
extends AtomicReference
implements g0 {
    private static final long serialVersionUID = -4823716997131257941L;
    public final int index;
    public final ObservableCombineLatest$LatestCoordinator parent;

    public ObservableCombineLatest$CombinerObserver(ObservableCombineLatest$LatestCoordinator latestCoordinator, int n10) {
        this.parent = latestCoordinator;
        this.index = n10;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public void onComplete() {
        ObservableCombineLatest$LatestCoordinator observableCombineLatest$LatestCoordinator = this.parent;
        int n10 = this.index;
        observableCombineLatest$LatestCoordinator.innerComplete(n10);
    }

    public void onError(Throwable throwable) {
        ObservableCombineLatest$LatestCoordinator observableCombineLatest$LatestCoordinator = this.parent;
        int n10 = this.index;
        observableCombineLatest$LatestCoordinator.innerError(n10, throwable);
    }

    public void onNext(Object object) {
        ObservableCombineLatest$LatestCoordinator observableCombineLatest$LatestCoordinator = this.parent;
        int n10 = this.index;
        observableCombineLatest$LatestCoordinator.innerNext(n10, object);
    }

    public void onSubscribe(b b10) {
        DisposableHelper.setOnce(this, b10);
    }
}

