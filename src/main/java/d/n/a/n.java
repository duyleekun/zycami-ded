/*
 * Decompiled with CFR 0.151.
 */
package d.n.a;

import c.a.l.e;
import c.a.l.l;
import d.n.a.b$d;

public final class n
implements e {
    private static final n a;

    static {
        n n10;
        a = n10 = new n();
    }

    public static n a() {
        return a;
    }

    public static byte[] c() {
        return (byte[])l.b(b$d.q(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public byte[] b() {
        return (byte[])l.b(b$d.q(), "Cannot return null from a non-@Nullable @Provides method");
    }
}

