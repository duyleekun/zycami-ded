/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.maybe;

import e.a.t;
import e.a.v0.o;
import e.a.w;
import e.a.w0.e.c.a;
import io.reactivex.internal.operators.maybe.MaybeOnErrorNext$OnErrorNextMaybeObserver;

public final class MaybeOnErrorNext
extends a {
    public final o b;
    public final boolean c;

    public MaybeOnErrorNext(w w10, o o10, boolean bl2) {
        super(w10);
        this.b = o10;
        this.c = bl2;
    }

    public void t1(t t10) {
        w w10 = this.a;
        o o10 = this.b;
        boolean bl2 = this.c;
        MaybeOnErrorNext$OnErrorNextMaybeObserver maybeOnErrorNext$OnErrorNextMaybeObserver = new MaybeOnErrorNext$OnErrorNextMaybeObserver(t10, o10, bl2);
        w10.g(maybeOnErrorNext$OnErrorNextMaybeObserver);
    }
}

