/*
 * Decompiled with CFR 0.151.
 */
package d.n.a.q0.s;

import c.a.l.e;
import c.a.l.l;
import c.b.a.c;
import d.n.a.n0;
import d.n.a.q0.s.d;
import d.n.a.q0.u.z;
import e.a.h0;

public final class j
implements e {
    private final c a;
    private final c b;

    public j(c c10, c c11) {
        this.a = c10;
        this.b = c11;
    }

    public static j a(c c10, c c11) {
        j j10 = new j(c10, c11);
        return j10;
    }

    public static z c(h0 h02, n0 n02) {
        return (z)l.b(d.p(h02, n02), "Cannot return null from a non-@Nullable @Provides method");
    }

    public z b() {
        h0 h02 = (h0)this.a.get();
        n0 n02 = (n0)this.b.get();
        return (z)l.b(d.p(h02, n02), "Cannot return null from a non-@Nullable @Provides method");
    }
}

