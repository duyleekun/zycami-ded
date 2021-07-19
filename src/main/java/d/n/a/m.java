/*
 * Decompiled with CFR 0.151.
 */
package d.n.a;

import c.a.l.e;
import c.a.l.l;
import d.n.a.b$d;

public final class m
implements e {
    private static final m a;

    static {
        m m10;
        a = m10 = new m();
    }

    public static m a() {
        return a;
    }

    public static byte[] c() {
        return (byte[])l.b(b$d.p(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public byte[] b() {
        return (byte[])l.b(b$d.p(), "Cannot return null from a non-@Nullable @Provides method");
    }
}

