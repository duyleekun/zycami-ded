/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.single;

import e.a.a;
import e.a.d;
import e.a.o0;
import e.a.v0.o;
import io.reactivex.internal.operators.single.SingleFlatMapCompletable$FlatMapCompletableObserver;

public final class SingleFlatMapCompletable
extends a {
    public final o0 a;
    public final o b;

    public SingleFlatMapCompletable(o0 o02, o o10) {
        this.a = o02;
        this.b = o10;
    }

    public void L0(d d10) {
        o o10 = this.b;
        SingleFlatMapCompletable$FlatMapCompletableObserver singleFlatMapCompletable$FlatMapCompletableObserver = new SingleFlatMapCompletable$FlatMapCompletableObserver(d10, o10);
        d10.onSubscribe(singleFlatMapCompletable$FlatMapCompletableObserver);
        this.a.f(singleFlatMapCompletable$FlatMapCompletableObserver);
    }
}

