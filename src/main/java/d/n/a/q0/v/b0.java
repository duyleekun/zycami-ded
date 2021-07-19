/*
 * Decompiled with CFR 0.151.
 */
package d.n.a.q0.v;

import c.a.l.e;
import c.b.a.c;
import d.n.a.q0.v.a;
import d.n.a.q0.v.a0;
import d.n.a.q0.v.g;
import d.n.a.q0.v.u;
import d.n.a.q0.x.y;

public final class b0
implements e {
    private final c a;
    private final c b;
    private final c c;
    private final c d;

    public b0(c c10, c c11, c c12, c c13) {
        this.a = c10;
        this.b = c11;
        this.c = c12;
        this.d = c13;
    }

    public static b0 a(c c10, c c11, c c12, c c13) {
        b0 b02 = new b0(c10, c11, c12, c13);
        return b02;
    }

    public static a0 c(y y10, g g10, u u10, a a10) {
        a0 a02 = new a0(y10, g10, u10, a10);
        return a02;
    }

    public a0 b() {
        y y10 = (y)this.a.get();
        g g10 = (g)this.b.get();
        u u10 = (u)this.c.get();
        a a10 = (a)this.d.get();
        a0 a02 = new a0(y10, g10, u10, a10);
        return a02;
    }
}

