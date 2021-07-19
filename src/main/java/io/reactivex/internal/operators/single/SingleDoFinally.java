/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.single;

import e.a.i0;
import e.a.l0;
import e.a.o0;
import e.a.v0.a;
import io.reactivex.internal.operators.single.SingleDoFinally$DoFinallyObserver;

public final class SingleDoFinally
extends i0 {
    public final o0 a;
    public final a b;

    public SingleDoFinally(o0 o02, a a10) {
        this.a = o02;
        this.b = a10;
    }

    public void e1(l0 l02) {
        o0 o02 = this.a;
        a a10 = this.b;
        SingleDoFinally$DoFinallyObserver singleDoFinally$DoFinallyObserver = new SingleDoFinally$DoFinallyObserver(l02, a10);
        o02.f(singleDoFinally$DoFinallyObserver);
    }
}

