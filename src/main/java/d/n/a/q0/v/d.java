/*
 * Decompiled with CFR 0.151.
 */
package d.n.a.q0.v;

import c.a.l.e;
import d.n.a.q0.v.a;
import d.n.a.q0.v.c;
import d.n.a.q0.v.g;
import d.n.a.q0.v.i;
import d.n.a.q0.x.y;

public final class d
implements e {
    private final c.b.a.c a;
    private final c.b.a.c b;
    private final c.b.a.c c;
    private final c.b.a.c d;

    public d(c.b.a.c c10, c.b.a.c c11, c.b.a.c c12, c.b.a.c c13) {
        this.a = c10;
        this.b = c11;
        this.c = c12;
        this.d = c13;
    }

    public static d a(c.b.a.c c10, c.b.a.c c11, c.b.a.c c12, c.b.a.c c13) {
        d d10 = new d(c10, c11, c12, c13);
        return d10;
    }

    public static c c(y y10, a a10, g g10, i i10) {
        c c10 = new c(y10, a10, g10, i10);
        return c10;
    }

    public c b() {
        y y10 = (y)this.a.get();
        a a10 = (a)this.b.get();
        g g10 = (g)this.c.get();
        i i10 = (i)this.d.get();
        c c10 = new c(y10, a10, g10, i10);
        return c10;
    }
}

