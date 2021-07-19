/*
 * Decompiled with CFR 0.151.
 */
package d.n.a.q0.s;

import c.a.l.e;
import c.b.a.c;
import d.n.a.q0.s.s;
import d.n.a.q0.u.q;
import d.n.a.q0.w.d;

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

    public static s c(d d10, q q10) {
        s s10 = new s(d10, q10);
        return s10;
    }

    public s b() {
        d d10 = (d)this.a.get();
        q q10 = (q)this.b.get();
        s s10 = new s(d10, q10);
        return s10;
    }
}

