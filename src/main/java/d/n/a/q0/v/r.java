/*
 * Decompiled with CFR 0.151.
 */
package d.n.a.q0.v;

import c.a.l.e;
import c.b.a.c;
import d.n.a.q0.v.o;
import d.n.a.q0.v.q;
import e.a.h0;

public final class r
implements e {
    private final c a;
    private final c b;

    public r(c c10, c c11) {
        this.a = c10;
        this.b = c11;
    }

    public static r a(c c10, c c11) {
        r r10 = new r(c10, c11);
        return r10;
    }

    public q b() {
        o o10 = (o)this.a.get();
        h0 h02 = (h0)this.b.get();
        q q10 = new q(o10, h02);
        return q10;
    }
}

