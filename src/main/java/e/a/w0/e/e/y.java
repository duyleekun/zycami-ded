/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.e0;
import e.a.g0;
import e.a.v0.d;
import e.a.v0.o;
import e.a.w0.e.e.a;
import e.a.w0.e.e.y$a;

public final class y
extends a {
    public final o b;
    public final d c;

    public y(e0 e02, o o10, d d10) {
        super(e02);
        this.b = o10;
        this.c = d10;
    }

    public void K5(g0 g02) {
        e0 e02 = this.a;
        o o10 = this.b;
        d d10 = this.c;
        y$a y$a = new y$a(g02, o10, d10);
        e02.subscribe(y$a);
    }
}

