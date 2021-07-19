/*
 * Decompiled with CFR 0.151.
 */
package d.n.a.q0;

import c.a.l.e;
import c.a.l.l;
import d.n.a.q0.c;
import d.n.a.q0.u.z;
import e.a.h0;

public final class g
implements e {
    private final c.b.a.c a;

    public g(c.b.a.c c10) {
        this.a = c10;
    }

    public static g a(c.b.a.c c10) {
        g g10 = new g(c10);
        return g10;
    }

    public static z c(h0 h02) {
        return (z)l.b(c.f(h02), "Cannot return null from a non-@Nullable @Provides method");
    }

    public z b() {
        return (z)l.b(c.f((h0)this.a.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}

