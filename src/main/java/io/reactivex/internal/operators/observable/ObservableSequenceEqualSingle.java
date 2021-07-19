/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.a1.a;
import e.a.e0;
import e.a.i0;
import e.a.l0;
import e.a.w0.c.d;
import e.a.z;
import io.reactivex.internal.operators.observable.ObservableSequenceEqual;
import io.reactivex.internal.operators.observable.ObservableSequenceEqualSingle$EqualCoordinator;

public final class ObservableSequenceEqualSingle
extends i0
implements d {
    public final e0 a;
    public final e0 b;
    public final e.a.v0.d c;
    public final int d;

    public ObservableSequenceEqualSingle(e0 e02, e0 e03, e.a.v0.d d10, int n10) {
        this.a = e02;
        this.b = e03;
        this.c = d10;
        this.d = n10;
    }

    public void e1(l0 l02) {
        int n10 = this.d;
        e0 e02 = this.a;
        e0 e03 = this.b;
        e.a.v0.d d10 = this.c;
        ObservableSequenceEqualSingle$EqualCoordinator observableSequenceEqualSingle$EqualCoordinator = new ObservableSequenceEqualSingle$EqualCoordinator(l02, n10, e02, e03, d10);
        l02.onSubscribe(observableSequenceEqualSingle$EqualCoordinator);
        observableSequenceEqualSingle$EqualCoordinator.subscribe();
    }

    public z i() {
        e0 e02 = this.a;
        e0 e03 = this.b;
        e.a.v0.d d10 = this.c;
        int n10 = this.d;
        ObservableSequenceEqual observableSequenceEqual = new ObservableSequenceEqual(e02, e03, d10, n10);
        return e.a.a1.a.R(observableSequenceEqual);
    }
}

