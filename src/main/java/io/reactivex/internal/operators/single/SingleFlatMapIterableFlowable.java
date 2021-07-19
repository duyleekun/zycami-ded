/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.single;

import e.a.j;
import e.a.o0;
import e.a.v0.o;
import i.g.d;
import io.reactivex.internal.operators.single.SingleFlatMapIterableFlowable$FlatMapIterableObserver;

public final class SingleFlatMapIterableFlowable
extends j {
    public final o0 b;
    public final o c;

    public SingleFlatMapIterableFlowable(o0 o02, o o10) {
        this.b = o02;
        this.c = o10;
    }

    public void m6(d d10) {
        o0 o02 = this.b;
        o o10 = this.c;
        SingleFlatMapIterableFlowable$FlatMapIterableObserver singleFlatMapIterableFlowable$FlatMapIterableObserver = new SingleFlatMapIterableFlowable$FlatMapIterableObserver(d10, o10);
        o02.f(singleFlatMapIterableFlowable$FlatMapIterableObserver);
    }
}

