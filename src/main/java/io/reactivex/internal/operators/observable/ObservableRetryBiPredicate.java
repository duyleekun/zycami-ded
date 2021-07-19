/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.e0;
import e.a.g0;
import e.a.v0.d;
import e.a.w0.e.e.a;
import e.a.z;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.operators.observable.ObservableRetryBiPredicate$RetryBiObserver;

public final class ObservableRetryBiPredicate
extends a {
    public final d b;

    public ObservableRetryBiPredicate(z z10, d d10) {
        super(z10);
        this.b = d10;
    }

    public void K5(g0 g02) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        g02.onSubscribe(sequentialDisposable);
        d d10 = this.b;
        e0 e02 = this.a;
        ObservableRetryBiPredicate$RetryBiObserver observableRetryBiPredicate$RetryBiObserver = new ObservableRetryBiPredicate$RetryBiObserver(g02, d10, sequentialDisposable, e02);
        observableRetryBiPredicate$RetryBiObserver.subscribeNext();
    }
}

