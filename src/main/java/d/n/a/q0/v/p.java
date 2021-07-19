/*
 * Decompiled with CFR 0.151.
 */
package d.n.a.q0.v;

import c.a.l.e;
import c.b.a.c;
import d.n.a.q0.v.o;
import d.n.a.q0.x.r;
import d.n.a.q0.x.y;

public final class p
implements e {
    private final c a;
    private final c b;

    public p(c c10, c c11) {
        this.a = c10;
        this.b = c11;
    }

    public static p a(c c10, c c11) {
        p p10 = new p(c10, c11);
        return p10;
    }

    public o b() {
        y y10 = (y)this.a.get();
        r r10 = (r)this.b.get();
        o o10 = new o(y10, r10);
        return o10;
    }
}

