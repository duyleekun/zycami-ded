/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.single;

import e.a.o0;
import e.a.q;
import e.a.t;
import e.a.v0.o;
import io.reactivex.internal.operators.single.SingleFlatMapMaybe$FlatMapSingleObserver;

public final class SingleFlatMapMaybe
extends q {
    public final o0 a;
    public final o b;

    public SingleFlatMapMaybe(o0 o02, o o10) {
        this.b = o10;
        this.a = o02;
    }

    public void t1(t t10) {
        o0 o02 = this.a;
        o o10 = this.b;
        SingleFlatMapMaybe$FlatMapSingleObserver singleFlatMapMaybe$FlatMapSingleObserver = new SingleFlatMapMaybe$FlatMapSingleObserver(t10, o10);
        o02.f(singleFlatMapMaybe$FlatMapSingleObserver);
    }
}

