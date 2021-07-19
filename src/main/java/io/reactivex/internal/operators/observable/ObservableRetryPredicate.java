/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.e0;
import e.a.g0;
import e.a.v0.r;
import e.a.w0.e.e.a;
import e.a.z;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.operators.observable.ObservableRetryPredicate$RepeatObserver;

public final class ObservableRetryPredicate
extends a {
    public final r b;
    public final long c;

    public ObservableRetryPredicate(z z10, long l10, r r10) {
        super(z10);
        this.b = r10;
        this.c = l10;
    }

    public void K5(g0 g02) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        g02.onSubscribe(sequentialDisposable);
        long l10 = this.c;
        r r10 = this.b;
        e0 e02 = this.a;
        ObservableRetryPredicate$RepeatObserver observableRetryPredicate$RepeatObserver = new ObservableRetryPredicate$RepeatObserver(g02, l10, r10, sequentialDisposable, e02);
        observableRetryPredicate$RepeatObserver.subscribeNext();
    }
}

