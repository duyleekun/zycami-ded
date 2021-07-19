/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.b;

import e.a.j;
import e.a.v0.g;
import e.a.w0.e.b.a;
import e.a.w0.e.b.v$a;
import e.a.w0.e.b.v$b;
import i.g.d;

public final class v
extends a {
    public final g c;

    public v(j j10, g g10) {
        super(j10);
        this.c = g10;
    }

    public void m6(d d10) {
        boolean bl2 = d10 instanceof e.a.w0.c.a;
        if (bl2) {
            j j10 = this.b;
            d10 = (e.a.w0.c.a)d10;
            g g10 = this.c;
            v$a v$a = new v$a((e.a.w0.c.a)d10, g10);
            j10.l6(v$a);
        } else {
            j j11 = this.b;
            g g11 = this.c;
            v$b v$b = new v$b(d10, g11);
            j11.l6(v$b);
        }
    }
}

