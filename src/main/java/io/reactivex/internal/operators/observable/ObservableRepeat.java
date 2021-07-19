/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.e0;
import e.a.g0;
import e.a.w0.e.e.a;
import e.a.z;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.operators.observable.ObservableRepeat$RepeatObserver;

public final class ObservableRepeat
extends a {
    public final long b;

    public ObservableRepeat(z z10, long l10) {
        super(z10);
        this.b = l10;
    }

    public void K5(g0 g02) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        g02.onSubscribe(sequentialDisposable);
        long l10 = this.b;
        long l11 = Long.MAX_VALUE;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (l12 != false) {
            l11 = --l10;
        }
        e0 e02 = this.a;
        ObservableRepeat$RepeatObserver observableRepeat$RepeatObserver = new ObservableRepeat$RepeatObserver(g02, l11, sequentialDisposable, e02);
        observableRepeat$RepeatObserver.subscribeNext();
    }
}

