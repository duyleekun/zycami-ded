/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.e0;
import e.a.g0;
import e.a.w0.e.e.a;
import io.reactivex.internal.operators.observable.ObservableDoFinally$DoFinallyObserver;

public final class ObservableDoFinally
extends a {
    public final e.a.v0.a b;

    public ObservableDoFinally(e0 e02, e.a.v0.a a10) {
        super(e02);
        this.b = a10;
    }

    public void K5(g0 g02) {
        e0 e02 = this.a;
        e.a.v0.a a10 = this.b;
        ObservableDoFinally$DoFinallyObserver observableDoFinally$DoFinallyObserver = new ObservableDoFinally$DoFinallyObserver(g02, a10);
        e02.subscribe(observableDoFinally$DoFinallyObserver);
    }
}

