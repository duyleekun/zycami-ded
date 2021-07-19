/*
 * Decompiled with CFR 0.151.
 */
package d.n.a;

import c.a.l.e;
import c.a.l.l;
import c.b.a.c;
import d.n.a.b$d;
import d.n.a.q0.x.p;
import e.a.z;

public final class r
implements e {
    private final c a;
    private final c b;

    public r(c c10, c c11) {
        this.a = c10;
        this.b = c11;
    }

    public static r a(c c10, c c11) {
        r r10 = new r(c10, c11);
        return r10;
    }

    public static z c(int n10, p p10) {
        return (z)l.b(b$d.u(n10, p10), "Cannot return null from a non-@Nullable @Provides method");
    }

    public z b() {
        int n10 = (Integer)this.a.get();
        p p10 = (p)this.b.get();
        return (z)l.b(b$d.u(n10, p10), "Cannot return null from a non-@Nullable @Provides method");
    }
}

