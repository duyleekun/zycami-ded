/*
 * Decompiled with CFR 0.151.
 */
package d.n.a.q0.x;

import c.a.l.e;
import c.b.a.c;
import d.n.a.q0.x.m;
import d.n.a.q0.x.r;
import d.n.a.q0.x.y;
import e.a.h0;
import e.a.z;

public final class n
implements e {
    private final c a;
    private final c b;
    private final c c;
    private final c d;
    private final c e;

    public n(c c10, c c11, c c12, c c13, c c14) {
        this.a = c10;
        this.b = c11;
        this.c = c12;
        this.d = c13;
        this.e = c14;
    }

    public static n a(c c10, c c11, c c12, c c13, c c14) {
        n n10 = new n(c10, c11, c12, c13, c14);
        return n10;
    }

    public static m c(y y10, z z10, z z11, r r10, h0 h02) {
        m m10 = new m(y10, z10, z11, r10, h02);
        return m10;
    }

    public m b() {
        m m10;
        Object object;
        Object object2 = object = this.a.get();
        object2 = (y)object;
        Object object3 = object = this.b.get();
        object3 = (z)object;
        Object object4 = object = this.c.get();
        object4 = (z)object;
        Object object5 = object = this.d.get();
        object5 = (r)object;
        Object object6 = object = this.e.get();
        object6 = (h0)object;
        object = m10;
        m10 = new m((y)object2, (z)object3, (z)object4, (r)object5, (h0)object6);
        return m10;
    }
}

