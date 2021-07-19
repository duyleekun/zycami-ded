/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.single;

import e.a.i0;
import e.a.l0;
import e.a.o0;
import e.a.v0.a;
import io.reactivex.internal.operators.single.SingleDoOnDispose$DoOnDisposeObserver;

public final class SingleDoOnDispose
extends i0 {
    public final o0 a;
    public final a b;

    public SingleDoOnDispose(o0 o02, a a10) {
        this.a = o02;
        this.b = a10;
    }

    public void e1(l0 l02) {
        o0 o02 = this.a;
        a a10 = this.b;
        SingleDoOnDispose$DoOnDisposeObserver singleDoOnDispose$DoOnDisposeObserver = new SingleDoOnDispose$DoOnDisposeObserver(l02, a10);
        o02.f(singleDoOnDispose$DoOnDisposeObserver);
    }
}

