/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.maybe;

import e.a.i0;
import e.a.l0;
import e.a.v0.o;
import e.a.w;
import io.reactivex.internal.operators.maybe.MaybeFlatMapSingle$FlatMapMaybeObserver;

public final class MaybeFlatMapSingle
extends i0 {
    public final w a;
    public final o b;

    public MaybeFlatMapSingle(w w10, o o10) {
        this.a = w10;
        this.b = o10;
    }

    public void e1(l0 l02) {
        w w10 = this.a;
        o o10 = this.b;
        MaybeFlatMapSingle$FlatMapMaybeObserver maybeFlatMapSingle$FlatMapMaybeObserver = new MaybeFlatMapSingle$FlatMapMaybeObserver(l02, o10);
        w10.g(maybeFlatMapSingle$FlatMapMaybeObserver);
    }
}

