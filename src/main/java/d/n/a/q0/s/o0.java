/*
 * Decompiled with CFR 0.151.
 */
package d.n.a.q0.s;

import c.a.l.e;
import c.b.a.c;
import d.n.a.q0.s.n0;
import d.n.a.q0.s.x0;

public final class o0
implements e {
    private final c a;
    private final c b;

    public o0(c c10, c c11) {
        this.a = c10;
        this.b = c11;
    }

    public static o0 a(c c10, c c11) {
        o0 o02 = new o0(c10, c11);
        return o02;
    }

    public static n0 c(x0 x02, int n10) {
        n0 n02 = new n0(x02, n10);
        return n02;
    }

    public n0 b() {
        x0 x02 = (x0)this.a.get();
        int n10 = (Integer)this.b.get();
        n0 n02 = new n0(x02, n10);
        return n02;
    }
}

