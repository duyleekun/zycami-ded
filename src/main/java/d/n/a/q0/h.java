/*
 * Decompiled with CFR 0.151.
 */
package d.n.a.q0;

import c.a.l.e;
import c.a.l.l;
import d.n.a.q0.c;
import d.n.a.q0.u.z;
import e.a.h0;

public final class h
implements e {
    private final c.b.a.c a;

    public h(c.b.a.c c10) {
        this.a = c10;
    }

    public static h a(c.b.a.c c10) {
        h h10 = new h(c10);
        return h10;
    }

    public static z c(h0 h02) {
        return (z)l.b(c.g(h02), "Cannot return null from a non-@Nullable @Provides method");
    }

    public z b() {
        return (z)l.b(c.g((h0)this.a.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}

