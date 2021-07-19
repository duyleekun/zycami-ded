/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.v0.w.c;

import d.v.c.v0.w.c.a$a;
import d.v.e.l.w1;
import k.d;

public class a {
    private static volatile a a;

    private a() {
    }

    public static a a() {
        a a10 = a;
        if (a10 == null) {
            a = a10 = new a();
        }
        return a;
    }

    public void b(int n10) {
        d d10 = d.v.c.v0.l.a.a.a(n10);
        a$a a$a = new a$a(this);
        d10.h(a$a);
    }

    public d c() {
        d.v.c.v0.l.a a10 = d.v.c.v0.l.a.a;
        String string2 = w1.a();
        return a10.e(string2);
    }
}

