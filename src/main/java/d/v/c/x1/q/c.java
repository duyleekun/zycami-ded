/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.x1.q;

import d.v.c.m0$a;
import d.v.c.x1.q.a;

public abstract class c {
    public static final int a = m0$a.b;

    public static c a(String string2, long l10) {
        int n10 = a;
        return c.b(string2, l10, n10);
    }

    public static c b(String string2, long l10, int n10) {
        a a10 = new a(string2, l10, n10);
        return a10;
    }

    public abstract int c();

    public abstract long d();

    public abstract String e();
}

