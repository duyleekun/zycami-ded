/*
 * Decompiled with CFR 0.151.
 */
package d.n.a.q0.s;

import c.a.l.e;
import c.a.l.l;
import c.b.a.c;
import d.n.a.q0.s.c0;
import d.n.a.q0.s.d;

public final class i
implements e {
    private final c a;
    private final c b;
    private final c c;

    public i(c c10, c c11, c c12) {
        this.a = c10;
        this.b = c11;
        this.c = c12;
    }

    public static i a(c c10, c c11, c c12) {
        i i10 = new i(c10, c11, c12);
        return i10;
    }

    public static c0 c(boolean bl2, c c10, c c11) {
        return (c0)l.b(d.o(bl2, c10, c11), "Cannot return null from a non-@Nullable @Provides method");
    }

    public c0 b() {
        boolean bl2 = (Boolean)this.a.get();
        c c10 = this.b;
        c c11 = this.c;
        return (c0)l.b(d.o(bl2, c10, c11), "Cannot return null from a non-@Nullable @Provides method");
    }
}

