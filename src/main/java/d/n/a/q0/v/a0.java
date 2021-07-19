/*
 * Decompiled with CFR 0.151.
 */
package d.n.a.q0.v;

import d.n.a.q0.v.a;
import d.n.a.q0.v.e;
import d.n.a.q0.v.g;
import d.n.a.q0.v.u;
import d.n.a.q0.v.w;
import d.n.a.q0.v.x;
import d.n.a.q0.x.y;
import d.n.a.r0.b;
import e.a.f0;

public class a0
implements x {
    private final y a;
    private final g b;
    private final u c;
    private final a d;

    public a0(y y10, g g10, u u10, a a10) {
        this.a = y10;
        this.b = g10;
        this.c = u10;
        this.d = a10;
    }

    public w a(d.n.a.r0.e e10, b ... bArray) {
        Object object = this.c;
        int n10 = e10.d();
        object = ((u)object).a(n10);
        y y10 = this.a;
        g g10 = this.b;
        a a10 = this.d;
        e e11 = new e(bArray);
        d.n.a.q0.u.x x10 = new d.n.a.q0.u.x(y10, g10, a10, e10, e11, null);
        w w10 = new w(x10, (f0)object);
        return w10;
    }
}

