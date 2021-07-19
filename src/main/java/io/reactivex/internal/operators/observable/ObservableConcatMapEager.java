/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.e0;
import e.a.g0;
import e.a.v0.o;
import e.a.w0.e.e.a;
import io.reactivex.internal.operators.observable.ObservableConcatMapEager$ConcatMapEagerMainObserver;
import io.reactivex.internal.util.ErrorMode;

public final class ObservableConcatMapEager
extends a {
    public final o b;
    public final ErrorMode c;
    public final int d;
    public final int e;

    public ObservableConcatMapEager(e0 e02, o o10, ErrorMode errorMode, int n10, int n11) {
        super(e02);
        this.b = o10;
        this.c = errorMode;
        this.d = n10;
        this.e = n11;
    }

    public void K5(g0 g02) {
        e0 e02 = this.a;
        o o10 = this.b;
        int n10 = this.d;
        int n11 = this.e;
        ErrorMode errorMode = this.c;
        ObservableConcatMapEager$ConcatMapEagerMainObserver observableConcatMapEager$ConcatMapEagerMainObserver = new ObservableConcatMapEager$ConcatMapEagerMainObserver(g02, o10, n10, n11, errorMode);
        e02.subscribe(observableConcatMapEager$ConcatMapEagerMainObserver);
    }
}

