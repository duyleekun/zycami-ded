/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.b;

import e.a.j;
import e.a.v0.r;
import e.a.w0.e.b.a;
import e.a.w0.e.b.c0$a;
import e.a.w0.e.b.c0$b;
import i.g.d;

public final class c0
extends a {
    public final r c;

    public c0(j j10, r r10) {
        super(j10);
        this.c = r10;
    }

    public void m6(d d10) {
        boolean bl2 = d10 instanceof e.a.w0.c.a;
        if (bl2) {
            j j10 = this.b;
            d10 = (e.a.w0.c.a)d10;
            r r10 = this.c;
            c0$a c0$a = new c0$a((e.a.w0.c.a)d10, r10);
            j10.l6(c0$a);
        } else {
            j j11 = this.b;
            r r11 = this.c;
            c0$b c0$b = new c0$b(d10, r11);
            j11.l6(c0$b);
        }
    }
}

