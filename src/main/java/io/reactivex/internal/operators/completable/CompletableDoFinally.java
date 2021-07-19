/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.completable;

import e.a.d;
import e.a.g;
import e.a.v0.a;
import io.reactivex.internal.operators.completable.CompletableDoFinally$DoFinallyObserver;

public final class CompletableDoFinally
extends e.a.a {
    public final g a;
    public final a b;

    public CompletableDoFinally(g g10, a a10) {
        this.a = g10;
        this.b = a10;
    }

    public void L0(d d10) {
        g g10 = this.a;
        a a10 = this.b;
        CompletableDoFinally$DoFinallyObserver completableDoFinally$DoFinallyObserver = new CompletableDoFinally$DoFinallyObserver(d10, a10);
        g10.f(completableDoFinally$DoFinallyObserver);
    }
}

