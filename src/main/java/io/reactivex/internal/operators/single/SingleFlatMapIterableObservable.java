/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.single;

import e.a.g0;
import e.a.o0;
import e.a.v0.o;
import e.a.z;
import io.reactivex.internal.operators.single.SingleFlatMapIterableObservable$FlatMapIterableObserver;

public final class SingleFlatMapIterableObservable
extends z {
    public final o0 a;
    public final o b;

    public SingleFlatMapIterableObservable(o0 o02, o o10) {
        this.a = o02;
        this.b = o10;
    }

    public void K5(g0 g02) {
        o0 o02 = this.a;
        o o10 = this.b;
        SingleFlatMapIterableObservable$FlatMapIterableObserver singleFlatMapIterableObservable$FlatMapIterableObserver = new SingleFlatMapIterableObservable$FlatMapIterableObserver(g02, o10);
        o02.f(singleFlatMapIterableObservable$FlatMapIterableObserver);
    }
}

