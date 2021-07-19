/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.single;

import e.a.i0;
import e.a.l0;
import e.a.o0;
import e.a.v0.o;
import io.reactivex.internal.operators.single.SingleFlatMap$SingleFlatMapCallback;

public final class SingleFlatMap
extends i0 {
    public final o0 a;
    public final o b;

    public SingleFlatMap(o0 o02, o o10) {
        this.b = o10;
        this.a = o02;
    }

    public void e1(l0 l02) {
        o0 o02 = this.a;
        o o10 = this.b;
        SingleFlatMap$SingleFlatMapCallback singleFlatMap$SingleFlatMapCallback = new SingleFlatMap$SingleFlatMapCallback(l02, o10);
        o02.f(singleFlatMap$SingleFlatMapCallback);
    }
}

