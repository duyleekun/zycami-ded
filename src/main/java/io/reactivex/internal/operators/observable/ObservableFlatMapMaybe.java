/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.e0;
import e.a.g0;
import e.a.v0.o;
import e.a.w0.e.e.a;
import io.reactivex.internal.operators.observable.ObservableFlatMapMaybe$FlatMapMaybeObserver;

public final class ObservableFlatMapMaybe
extends a {
    public final o b;
    public final boolean c;

    public ObservableFlatMapMaybe(e0 e02, o o10, boolean bl2) {
        super(e02);
        this.b = o10;
        this.c = bl2;
    }

    public void K5(g0 g02) {
        e0 e02 = this.a;
        o o10 = this.b;
        boolean bl2 = this.c;
        ObservableFlatMapMaybe$FlatMapMaybeObserver observableFlatMapMaybe$FlatMapMaybeObserver = new ObservableFlatMapMaybe$FlatMapMaybeObserver(g02, o10, bl2);
        e02.subscribe(observableFlatMapMaybe$FlatMapMaybeObserver);
    }
}

