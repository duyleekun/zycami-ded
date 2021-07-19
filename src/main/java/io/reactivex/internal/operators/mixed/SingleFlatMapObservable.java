/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.mixed;

import e.a.g0;
import e.a.o0;
import e.a.v0.o;
import e.a.z;
import io.reactivex.internal.operators.mixed.SingleFlatMapObservable$FlatMapObserver;

public final class SingleFlatMapObservable
extends z {
    public final o0 a;
    public final o b;

    public SingleFlatMapObservable(o0 o02, o o10) {
        this.a = o02;
        this.b = o10;
    }

    public void K5(g0 g02) {
        o o10 = this.b;
        SingleFlatMapObservable$FlatMapObserver singleFlatMapObservable$FlatMapObserver = new SingleFlatMapObservable$FlatMapObserver(g02, o10);
        g02.onSubscribe(singleFlatMapObservable$FlatMapObserver);
        this.a.f(singleFlatMapObservable$FlatMapObserver);
    }
}

