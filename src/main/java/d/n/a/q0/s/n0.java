/*
 * Decompiled with CFR 0.151.
 */
package d.n.a.q0.s;

import d.n.a.q0.s.m0;
import d.n.a.q0.s.n;
import d.n.a.q0.s.n0$a;
import d.n.a.q0.s.x0;
import e.a.s0.b;
import e.a.s0.d;
import e.a.v0.g;
import e.a.v0.r;
import e.a.z;
import io.reactivex.internal.functions.Functions;

public class n0
implements n,
m0,
g {
    private Integer a;
    private final z b;
    private final d c;

    public n0(x0 object, int n10) {
        Object object2 = new d();
        this.c = object2;
        object = ((x0)object).i();
        object2 = new n0$a(this);
        this.b = object = ((z)object).X4((r)object2);
        this.a = object = Integer.valueOf(n10);
    }

    public int a() {
        return this.a;
    }

    public void b() {
        this.c.dispose();
    }

    public void c() {
        d d10 = this.c;
        Object object = this.b;
        g g10 = Functions.h();
        object = ((z)object).c(this, g10);
        d10.c((b)object);
    }

    public void d(Integer n10) {
        this.a = n10;
    }
}

