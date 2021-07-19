/*
 * Decompiled with CFR 0.151.
 */
package d.n.a;

import c.a.l.e;
import c.a.l.l;
import c.b.a.c;
import d.n.a.b$d;
import d.n.a.q0.v.n;

public final class u
implements e {
    private final c a;
    private final c b;
    private final c c;

    public u(c c10, c c11, c c12) {
        this.a = c10;
        this.b = c11;
        this.c = c12;
    }

    public static u a(c c10, c c11, c c12) {
        u u10 = new u(c10, c11, c12);
        return u10;
    }

    public static n c(int n10, c c10, c c11) {
        return (n)l.b(b$d.x(n10, c10, c11), "Cannot return null from a non-@Nullable @Provides method");
    }

    public n b() {
        int n10 = (Integer)this.a.get();
        c c10 = this.b;
        c c11 = this.c;
        return (n)l.b(b$d.x(n10, c10, c11), "Cannot return null from a non-@Nullable @Provides method");
    }
}

