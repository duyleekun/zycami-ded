/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.e0;
import e.a.g0;
import e.a.v0.e;
import e.a.w0.e.e.a;
import e.a.z;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.operators.observable.ObservableRepeatUntil$RepeatUntilObserver;

public final class ObservableRepeatUntil
extends a {
    public final e b;

    public ObservableRepeatUntil(z z10, e e10) {
        super(z10);
        this.b = e10;
    }

    public void K5(g0 g02) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        g02.onSubscribe(sequentialDisposable);
        e e10 = this.b;
        e0 e02 = this.a;
        ObservableRepeatUntil$RepeatUntilObserver observableRepeatUntil$RepeatUntilObserver = new ObservableRepeatUntil$RepeatUntilObserver(g02, e10, sequentialDisposable, e02);
        observableRepeatUntil$RepeatUntilObserver.subscribeNext();
    }
}

