/*
 * Decompiled with CFR 0.151.
 */
package d.n.a.q0.s;

import c.a.l.e;
import c.b.a.c;
import d.n.a.q0.s.c$a;
import d.n.a.q0.s.p;
import d.n.a.q0.w.a;
import e.a.h0;

public final class q
implements e {
    private final c a;
    private final c b;
    private final c c;

    public q(c c10, c c11, c c12) {
        this.a = c10;
        this.b = c11;
        this.c = c12;
    }

    public static q a(c c10, c c11, c c12) {
        q q10 = new q(c10, c11, c12);
        return q10;
    }

    public p b() {
        a a10 = (a)this.a.get();
        c$a c$a = (c$a)this.b.get();
        h0 h02 = (h0)this.c.get();
        p p10 = new p(a10, c$a, h02);
        return p10;
    }
}

