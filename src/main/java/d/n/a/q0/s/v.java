/*
 * Decompiled with CFR 0.151.
 */
package d.n.a.q0.s;

import c.a.l.e;
import c.b.a.c;
import d.n.a.q0.s.u;
import d.n.a.q0.u.k;
import d.n.a.q0.w.a;

public final class v
implements e {
    private final c a;
    private final c b;

    public v(c c10, c c11) {
        this.a = c10;
        this.b = c11;
    }

    public static v a(c c10, c c11) {
        v v10 = new v(c10, c11);
        return v10;
    }

    public static u c(a a10, k k10) {
        u u10 = new u(a10, k10);
        return u10;
    }

    public u b() {
        a a10 = (a)this.a.get();
        k k10 = (k)this.b.get();
        u u10 = new u(a10, k10);
        return u10;
    }
}

