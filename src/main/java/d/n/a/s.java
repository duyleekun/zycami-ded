/*
 * Decompiled with CFR 0.151.
 */
package d.n.a;

import c.a.l.e;
import c.a.l.l;
import c.b.a.c;
import d.n.a.b$d;
import d.n.a.q0.x.r;

public final class s
implements e {
    private final c a;
    private final c b;
    private final c c;

    public s(c c10, c c11, c c12) {
        this.a = c10;
        this.b = c11;
        this.c = c12;
    }

    public static s a(c c10, c c11, c c12) {
        s s10 = new s(c10, c11, c12);
        return s10;
    }

    public static r c(int n10, c c10, c c11) {
        return (r)l.b(b$d.v(n10, c10, c11), "Cannot return null from a non-@Nullable @Provides method");
    }

    public r b() {
        int n10 = (Integer)this.a.get();
        c c10 = this.b;
        c c11 = this.c;
        return (r)l.b(b$d.v(n10, c10, c11), "Cannot return null from a non-@Nullable @Provides method");
    }
}

