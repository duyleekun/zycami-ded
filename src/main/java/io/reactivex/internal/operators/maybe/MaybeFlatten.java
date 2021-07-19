/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.maybe;

import e.a.t;
import e.a.v0.o;
import e.a.w;
import e.a.w0.e.c.a;
import io.reactivex.internal.operators.maybe.MaybeFlatten$FlatMapMaybeObserver;

public final class MaybeFlatten
extends a {
    public final o b;

    public MaybeFlatten(w w10, o o10) {
        super(w10);
        this.b = o10;
    }

    public void t1(t t10) {
        w w10 = this.a;
        o o10 = this.b;
        MaybeFlatten$FlatMapMaybeObserver maybeFlatten$FlatMapMaybeObserver = new MaybeFlatten$FlatMapMaybeObserver(t10, o10);
        w10.g(maybeFlatten$FlatMapMaybeObserver);
    }
}

