/*
 * Decompiled with CFR 0.151.
 */
package d.n.a.q0.x;

import c.a.l.e;
import c.b.a.c;
import d.n.a.q0.x.i;
import d.n.a.q0.x.k;
import d.n.a.q0.x.u;

public final class v
implements e {
    private final c a;
    private final c b;
    private final c c;
    private final c d;

    public v(c c10, c c11, c c12, c c13) {
        this.a = c10;
        this.b = c11;
        this.c = c12;
        this.d = c13;
    }

    public static v a(c c10, c c11, c c12, c c13) {
        v v10 = new v(c10, c11, c12, c13);
        return v10;
    }

    public static u c(k k10, i i10, int n10, boolean bl2) {
        u u10 = new u(k10, i10, n10, bl2);
        return u10;
    }

    public u b() {
        k k10 = (k)this.a.get();
        i i10 = (i)this.b.get();
        int n10 = (Integer)this.c.get();
        boolean bl2 = (Boolean)this.d.get();
        u u10 = new u(k10, i10, n10, bl2);
        return u10;
    }
}

