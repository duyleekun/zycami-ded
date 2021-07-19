/*
 * Decompiled with CFR 0.151.
 */
package d.n.a;

import c.a.l.e;
import c.a.l.l;
import c.b.a.c;
import d.n.a.b$d;
import d.n.a.q0.v.x;

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

    public static x c(int n10, c c10, c c11, c c12) {
        return (x)l.b(b$d.z(n10, c10, c11, c12), "Cannot return null from a non-@Nullable @Provides method");
    }

    public x b() {
        int n10 = (Integer)this.a.get();
        c c10 = this.b;
        c c11 = this.c;
        c c12 = this.d;
        return (x)l.b(b$d.z(n10, c10, c11, c12), "Cannot return null from a non-@Nullable @Provides method");
    }
}

