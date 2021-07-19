/*
 * Decompiled with CFR 0.151.
 */
package d.n.a.q0.v;

import c.a.l.e;
import c.b.a.c;
import d.n.a.q0.v.a;
import d.n.a.q0.v.c0;
import d.n.a.q0.v.g;
import d.n.a.q0.v.u;
import d.n.a.q0.x.y;

public final class d0
implements e {
    private final c a;
    private final c b;
    private final c c;
    private final c d;

    public d0(c c10, c c11, c c12, c c13) {
        this.a = c10;
        this.b = c11;
        this.c = c12;
        this.d = c13;
    }

    public static d0 a(c c10, c c11, c c12, c c13) {
        d0 d02 = new d0(c10, c11, c12, c13);
        return d02;
    }

    public static c0 c(y y10, g g10, u u10, a a10) {
        c0 c02 = new c0(y10, g10, u10, a10);
        return c02;
    }

    public c0 b() {
        y y10 = (y)this.a.get();
        g g10 = (g)this.b.get();
        u u10 = (u)this.c.get();
        a a10 = (a)this.d.get();
        c0 c02 = new c0(y10, g10, u10, a10);
        return c02;
    }
}

