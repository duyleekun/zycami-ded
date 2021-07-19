/*
 * Decompiled with CFR 0.151.
 */
package d.n.a.q0.w;

import d.n.a.q0.u.p;
import d.n.a.q0.w.a;
import d.n.a.q0.w.b$a;
import d.n.a.q0.w.b$b;
import d.n.a.q0.w.h;
import e.a.h0;
import e.a.z;

public class b
implements a {
    public final h a;

    public b(h0 h02) {
        Object object = new h();
        this.a = object;
        b$a b$a = new b$a(this, h02);
        object = new Thread(b$a);
        ((Thread)object).start();
    }

    public z d(p p10) {
        b$b b$b = new b$b(this, p10);
        return z.y1(b$b);
    }
}

