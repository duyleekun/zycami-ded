/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.maybe;

import e.a.q;
import e.a.t;
import e.a.v0.o;
import e.a.w;
import io.reactivex.internal.operators.maybe.MaybeFlatMapSingleElement$FlatMapMaybeObserver;

public final class MaybeFlatMapSingleElement
extends q {
    public final w a;
    public final o b;

    public MaybeFlatMapSingleElement(w w10, o o10) {
        this.a = w10;
        this.b = o10;
    }

    public void t1(t t10) {
        w w10 = this.a;
        o o10 = this.b;
        MaybeFlatMapSingleElement$FlatMapMaybeObserver maybeFlatMapSingleElement$FlatMapMaybeObserver = new MaybeFlatMapSingleElement$FlatMapMaybeObserver(t10, o10);
        w10.g(maybeFlatMapSingleElement$FlatMapMaybeObserver);
    }
}

