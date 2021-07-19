/*
 * Decompiled with CFR 0.151.
 */
package d.n.a.q0.s;

import c.a.l.e;
import c.b.a.c;
import d.n.a.q0.s.a;
import d.n.a.q0.s.p0;
import d.n.a.q0.s.w;
import d.n.a.q0.s.x0;
import e.a.h0;

public final class y0
implements e {
    private final c a;
    private final c b;
    private final c c;
    private final c d;

    public y0(c c10, c c11, c c12, c c13) {
        this.a = c10;
        this.b = c11;
        this.c = c12;
        this.d = c13;
    }

    public static y0 a(c c10, c c11, c c12, c c13) {
        y0 y02 = new y0(c10, c11, c12, c13);
        return y02;
    }

    public static x0 c(h0 h02, a a10, Object object, Object object2) {
        object = (w)object;
        object2 = (p0)object2;
        x0 x02 = new x0(h02, a10, (w)object, (p0)object2);
        return x02;
    }

    public x0 b() {
        h0 h02 = (h0)this.a.get();
        a a10 = (a)this.b.get();
        w w10 = (w)this.c.get();
        p0 p02 = (p0)this.d.get();
        x0 x02 = new x0(h02, a10, w10, p02);
        return x02;
    }
}

