/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.mixed;

import e.a.e0;
import e.a.g;
import e.a.g0;
import e.a.z;
import io.reactivex.internal.operators.mixed.CompletableAndThenObservable$AndThenObservableObserver;

public final class CompletableAndThenObservable
extends z {
    public final g a;
    public final e0 b;

    public CompletableAndThenObservable(g g10, e0 e02) {
        this.a = g10;
        this.b = e02;
    }

    public void K5(g0 g02) {
        e0 e02 = this.b;
        CompletableAndThenObservable$AndThenObservableObserver completableAndThenObservable$AndThenObservableObserver = new CompletableAndThenObservable$AndThenObservableObserver(g02, e02);
        g02.onSubscribe(completableAndThenObservable$AndThenObservableObserver);
        this.a.f(completableAndThenObservable$AndThenObservableObserver);
    }
}

