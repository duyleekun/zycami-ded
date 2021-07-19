/*
 * Decompiled with CFR 0.151.
 */
package d.n.a.q0;

import c.a.l.l;
import d.k.b.b;
import d.n.a.q0.c;
import d.n.a.q0.s.m;

public final class e
implements c.a.l.e {
    private final c.b.a.c a;

    public e(c.b.a.c c10) {
        this.a = c10;
    }

    public static e a(c.b.a.c c10) {
        e e10 = new e(c10);
        return e10;
    }

    public static m c(b b10) {
        return (m)l.b(c.d(b10), "Cannot return null from a non-@Nullable @Provides method");
    }

    public m b() {
        return (m)l.b(c.d((b)this.a.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}

