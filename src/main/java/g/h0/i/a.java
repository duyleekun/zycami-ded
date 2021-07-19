/*
 * Decompiled with CFR 0.151.
 */
package g.h0.i;

import f.h2.t.f0;
import g.a0;
import g.c0;
import g.h0.i.c;
import g.h0.j.g;
import g.u;
import g.u$a;

public final class a
implements u {
    public static final a b;

    static {
        a a10;
        b = a10 = new a();
    }

    private a() {
    }

    public c0 intercept(u$a object) {
        f0.p(object, "chain");
        object = (g)object;
        c c10 = ((g)object).k().s((g)object);
        g g10 = g.j((g)object, 0, c10, null, 0, 0, 0, 61, null);
        object = ((g)object).o();
        return g10.c((a0)object);
    }
}

