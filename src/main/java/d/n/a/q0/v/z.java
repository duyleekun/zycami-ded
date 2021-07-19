/*
 * Decompiled with CFR 0.151.
 */
package d.n.a.q0.v;

import c.a.l.e;
import c.b.a.c;
import d.n.a.q0.v.g;
import d.n.a.q0.v.u;
import d.n.a.q0.v.y;

public final class z
implements e {
    private final c a;
    private final c b;
    private final c c;

    public z(c c10, c c11, c c12) {
        this.a = c10;
        this.b = c11;
        this.c = c12;
    }

    public static z a(c c10, c c11, c c12) {
        z z10 = new z(c10, c11, c12);
        return z10;
    }

    public static y c(d.n.a.q0.x.y y10, g g10, u u10) {
        y y11 = new y(y10, g10, u10);
        return y11;
    }

    public y b() {
        d.n.a.q0.x.y y10 = (d.n.a.q0.x.y)this.a.get();
        g g10 = (g)this.b.get();
        u u10 = (u)this.c.get();
        y y11 = new y(y10, g10, u10);
        return y11;
    }
}

