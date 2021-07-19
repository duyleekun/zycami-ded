/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.maybe;

import e.a.t;
import e.a.w;
import e.a.w0.e.c.a;
import io.reactivex.internal.operators.maybe.MaybeDoFinally$DoFinallyObserver;

public final class MaybeDoFinally
extends a {
    public final e.a.v0.a b;

    public MaybeDoFinally(w w10, e.a.v0.a a10) {
        super(w10);
        this.b = a10;
    }

    public void t1(t t10) {
        w w10 = this.a;
        e.a.v0.a a10 = this.b;
        MaybeDoFinally$DoFinallyObserver maybeDoFinally$DoFinallyObserver = new MaybeDoFinally$DoFinallyObserver(t10, a10);
        w10.g(maybeDoFinally$DoFinallyObserver);
    }
}

