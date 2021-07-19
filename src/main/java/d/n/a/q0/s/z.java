/*
 * Decompiled with CFR 0.151.
 */
package d.n.a.q0.s;

import c.a.l.e;
import c.b.a.c;
import d.n.a.q0.s.w;
import d.n.a.q0.x.y;

public final class z
implements e {
    private final c a;
    private final c b;
    private final c c;

    public z(c c10, c c11, c c12) {
        this.a = c10;
        this.b = c11;
        this.c = c12;
    }

    public static z a(c c10, c c11, c c12) {
        z z10 = new z(c10, c11, c12);
        return z10;
    }

    public static w c(String string2, y y10, e.a.z z10) {
        w w10 = new w(string2, y10, z10);
        return w10;
    }

    public w b() {
        String string2 = (String)this.a.get();
        y y10 = (y)this.b.get();
        e.a.z z10 = (e.a.z)this.c.get();
        w w10 = new w(string2, y10, z10);
        return w10;
    }
}

