/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.maybe;

import e.a.j;
import e.a.v0.o;
import e.a.w;
import i.g.d;
import io.reactivex.internal.operators.maybe.MaybeFlatMapIterableFlowable$FlatMapIterableObserver;

public final class MaybeFlatMapIterableFlowable
extends j {
    public final w b;
    public final o c;

    public MaybeFlatMapIterableFlowable(w w10, o o10) {
        this.b = w10;
        this.c = o10;
    }

    public void m6(d d10) {
        w w10 = this.b;
        o o10 = this.c;
        MaybeFlatMapIterableFlowable$FlatMapIterableObserver maybeFlatMapIterableFlowable$FlatMapIterableObserver = new MaybeFlatMapIterableFlowable$FlatMapIterableObserver(d10, o10);
        w10.g(maybeFlatMapIterableFlowable$FlatMapIterableObserver);
    }
}

