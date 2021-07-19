/*
 * Decompiled with CFR 0.151.
 */
package d.n.a.q0.v;

import d.n.a.q0.v.e;
import d.n.a.q0.v.g;
import d.n.a.q0.v.m;
import d.n.a.q0.v.u;
import d.n.a.q0.v.w;
import d.n.a.q0.v.x;
import d.n.a.q0.v.y$a;
import d.n.a.r0.b;
import e.a.f0;

public class y
implements x {
    private final d.n.a.q0.x.y a;
    private final g b;
    private final u c;

    public y(d.n.a.q0.x.y y10, g g10, u u10) {
        this.a = y10;
        this.b = g10;
        this.c = u10;
    }

    public w a(d.n.a.r0.e object, b ... object2) {
        Object object3 = this.c;
        int n10 = ((d.n.a.r0.e)object).h();
        object3 = ((u)object3).b(n10);
        Object object4 = this.c;
        int n11 = ((d.n.a.r0.e)object).d();
        object = ((u)object4).a(n11);
        d.n.a.q0.x.y y10 = this.a;
        g g10 = this.b;
        e e10 = new e((m)object2);
        d.n.a.q0.u.w w10 = new d.n.a.q0.u.w(y10, g10, e10);
        object2 = new y$a(this, (f0)object3, (f0)object);
        object4 = new w(w10, (f0)object2);
        return object4;
    }
}

