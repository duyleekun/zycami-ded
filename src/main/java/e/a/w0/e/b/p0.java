/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.b;

import e.a.j;
import e.a.v0.o;
import e.a.w0.e.b.a;
import e.a.w0.e.b.p0$a;
import e.a.w0.e.b.p0$b;
import i.g.d;

public final class p0
extends a {
    public final o c;

    public p0(j j10, o o10) {
        super(j10);
        this.c = o10;
    }

    public void m6(d d10) {
        boolean bl2 = d10 instanceof e.a.w0.c.a;
        if (bl2) {
            j j10 = this.b;
            d10 = (e.a.w0.c.a)d10;
            o o10 = this.c;
            p0$a p0$a = new p0$a((e.a.w0.c.a)d10, o10);
            j10.l6(p0$a);
        } else {
            j j11 = this.b;
            o o11 = this.c;
            p0$b p0$b = new p0$b(d10, o11);
            j11.l6(p0$b);
        }
    }
}

