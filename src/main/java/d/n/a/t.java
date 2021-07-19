/*
 * Decompiled with CFR 0.151.
 */
package d.n.a;

import c.a.l.e;
import c.a.l.l;
import c.b.a.c;
import d.n.a.b$d;

public final class t
implements e {
    private final c a;
    private final c b;

    public t(c c10, c c11) {
        this.a = c10;
        this.b = c11;
    }

    public static t a(c c10, c c11) {
        t t10 = new t(c10, c11);
        return t10;
    }

    public static String[] c(int n10, int n11) {
        return (String[])l.b(b$d.w(n10, n11), "Cannot return null from a non-@Nullable @Provides method");
    }

    public String[] b() {
        int n10 = (Integer)this.a.get();
        int n11 = (Integer)this.b.get();
        return (String[])l.b(b$d.w(n10, n11), "Cannot return null from a non-@Nullable @Provides method");
    }
}

