/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.j;
import e.a.u0.a;
import e.a.v0.g;
import i.g.d;

public final class FlowableReplay$a
extends a {
    private final a b;
    private final j c;

    public FlowableReplay$a(a a10, j j10) {
        this.b = a10;
        this.c = j10;
    }

    public void O8(g g10) {
        this.b.O8(g10);
    }

    public void m6(d d10) {
        this.c.subscribe(d10);
    }
}

