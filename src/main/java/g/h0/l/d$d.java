/*
 * Decompiled with CFR 0.151.
 */
package g.h0.l;

import f.h2.t.f0;
import g.h0.l.d;
import g.h0.l.d$d$a;
import g.h0.l.d$d$b;
import g.h0.l.g;
import g.h0.l.k;

public abstract class d$d {
    public static final d$d a;
    public static final d$d$b b;

    static {
        Object object = new d$d$b(null);
        b = object;
        a = object = new d$d$a();
    }

    public void e(d d10, k k10) {
        f0.p(d10, "connection");
        f0.p(k10, "settings");
    }

    public abstract void f(g var1);
}

