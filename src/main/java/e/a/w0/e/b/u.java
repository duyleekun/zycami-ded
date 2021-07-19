/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.b;

import e.a.j;
import e.a.v0.o;
import e.a.w0.e.b.a;
import e.a.w0.e.b.u$a;
import e.a.w0.e.b.u$b;
import i.g.d;

public final class u
extends a {
    public final o c;
    public final e.a.v0.d d;

    public u(j j10, o o10, e.a.v0.d d10) {
        super(j10);
        this.c = o10;
        this.d = d10;
    }

    public void m6(d d10) {
        boolean bl2 = d10 instanceof e.a.w0.c.a;
        if (bl2) {
            d10 = (e.a.w0.c.a)d10;
            j j10 = this.b;
            o o10 = this.c;
            e.a.v0.d d11 = this.d;
            u$a u$a = new u$a((e.a.w0.c.a)d10, o10, d11);
            j10.l6(u$a);
        } else {
            j j11 = this.b;
            o o11 = this.c;
            e.a.v0.d d12 = this.d;
            u$b u$b = new u$b(d10, o11, d12);
            j11.l6(u$b);
        }
    }
}

