/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.b;

import e.a.j;
import e.a.v0.g;
import e.a.w0.e.b.a;
import e.a.w0.e.b.w$a;
import e.a.w0.e.b.w$b;
import i.g.d;

public final class w
extends a {
    public final g c;
    public final g d;
    public final e.a.v0.a e;
    public final e.a.v0.a f;

    public w(j j10, g g10, g g11, e.a.v0.a a10, e.a.v0.a a11) {
        super(j10);
        this.c = g10;
        this.d = g11;
        this.e = a10;
        this.f = a11;
    }

    public void m6(d d10) {
        boolean bl2 = d10 instanceof e.a.w0.c.a;
        if (bl2) {
            j j10 = this.b;
            d d11 = d10;
            d11 = (e.a.w0.c.a)d10;
            g g10 = this.c;
            g g11 = this.d;
            e.a.v0.a a10 = this.e;
            e.a.v0.a a11 = this.f;
            w$a w$a = new w$a((e.a.w0.c.a)d11, g10, g11, a10, a11);
            j10.l6(w$a);
        } else {
            j j11 = this.b;
            g g12 = this.c;
            g g13 = this.d;
            e.a.v0.a a12 = this.e;
            e.a.v0.a a13 = this.f;
            d d12 = d10;
            w$b w$b = new w$b(d10, g12, g13, a12, a13);
            j11.l6(w$b);
        }
    }
}

