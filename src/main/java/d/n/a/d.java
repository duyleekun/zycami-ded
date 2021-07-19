/*
 * Decompiled with CFR 0.151.
 */
package d.n.a;

import c.a.l.e;
import c.a.l.l;
import d.n.a.b$d;
import e.a.h0;

public final class d
implements e {
    private static final d a;

    static {
        d d10;
        a = d10 = new d();
    }

    public static d a() {
        return a;
    }

    public static h0 c() {
        return (h0)l.b(b$d.g(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public h0 b() {
        return (h0)l.b(b$d.g(), "Cannot return null from a non-@Nullable @Provides method");
    }
}

