/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.mixed;

import e.a.g0;
import e.a.v0.o;
import e.a.w;
import e.a.z;
import io.reactivex.internal.operators.mixed.MaybeFlatMapObservable$FlatMapObserver;

public final class MaybeFlatMapObservable
extends z {
    public final w a;
    public final o b;

    public MaybeFlatMapObservable(w w10, o o10) {
        this.a = w10;
        this.b = o10;
    }

    public void K5(g0 g02) {
        o o10 = this.b;
        MaybeFlatMapObservable$FlatMapObserver maybeFlatMapObservable$FlatMapObserver = new MaybeFlatMapObservable$FlatMapObserver(g02, o10);
        g02.onSubscribe(maybeFlatMapObservable$FlatMapObserver);
        this.a.g(maybeFlatMapObservable$FlatMapObserver);
    }
}

