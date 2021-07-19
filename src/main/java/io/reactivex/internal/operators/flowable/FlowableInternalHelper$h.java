/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.h0;
import e.a.j;
import e.a.v0.o;
import e.a.w0.b.a;
import i.g.c;

public final class FlowableInternalHelper$h
implements o {
    private final o a;
    private final h0 b;

    public FlowableInternalHelper$h(o o10, h0 h02) {
        this.a = o10;
        this.b = h02;
    }

    public c a(j j10) {
        j10 = j.f3((c)e.a.w0.b.a.g(this.a.apply(j10), "The selector returned a null Publisher"));
        h0 h02 = this.b;
        return j10.s4(h02);
    }
}

