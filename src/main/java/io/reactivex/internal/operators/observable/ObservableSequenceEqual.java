/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.e0;
import e.a.g0;
import e.a.v0.d;
import e.a.z;
import io.reactivex.internal.operators.observable.ObservableSequenceEqual$EqualCoordinator;

public final class ObservableSequenceEqual
extends z {
    public final e0 a;
    public final e0 b;
    public final d c;
    public final int d;

    public ObservableSequenceEqual(e0 e02, e0 e03, d d10, int n10) {
        this.a = e02;
        this.b = e03;
        this.c = d10;
        this.d = n10;
    }

    public void K5(g0 g02) {
        int n10 = this.d;
        e0 e02 = this.a;
        e0 e03 = this.b;
        d d10 = this.c;
        ObservableSequenceEqual$EqualCoordinator observableSequenceEqual$EqualCoordinator = new ObservableSequenceEqual$EqualCoordinator(g02, n10, e02, e03, d10);
        g02.onSubscribe(observableSequenceEqual$EqualCoordinator);
        observableSequenceEqual$EqualCoordinator.subscribe();
    }
}

