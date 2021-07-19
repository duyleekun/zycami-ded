/*
 * Decompiled with CFR 0.151.
 */
package d.v.k0.f.c.j;

import d.v.k0.f.c.d;
import d.v.k0.f.c.e;
import d.v.k0.f.c.h;
import d.v.k0.f.c.j.k;
import d.v.k0.f.c.j.o$a;
import d.v.k0.f.c.j.o$b;
import d.v.k0.f.d.a;
import e.a.c1.b;
import e.a.g0;
import e.a.h0;
import e.a.z;

public class o {
    private k a;
    private final e.a.s0.a b;
    private h c;

    public o() {
        e.a.s0.a a10;
        this.b = a10 = new e.a.s0.a();
    }

    public static /* synthetic */ e.a.s0.a a(o o10) {
        return o10.b;
    }

    public static /* synthetic */ k b(o o10) {
        return o10.a;
    }

    public static /* synthetic */ h c(o o10) {
        return o10.c;
    }

    public void d(String string2) {
        h h10 = this.c;
        if (h10 != null) {
            h10.c(string2);
        }
    }

    public void e(int n10) {
        Object object = this.c;
        if (object == null) {
            return;
        }
        z z10 = ((h)object).k(n10, 0, true);
        object = e.a.c1.b.d();
        z10 = z10.i4((h0)object);
        object = new o$b(this);
        z10.subscribe((g0)object);
    }

    public void f() {
        Object object = new h();
        this.c = object;
        Object object2 = new d();
        ((h)object).p((e)object2);
        object = this.c.l();
        object2 = new o$a(this);
        ((z)object).subscribe((g0)object2);
    }

    public void g(String string2) {
        h h10 = this.c;
        if (h10 != null) {
            h10.m(string2);
        }
    }

    public void h(a a10) {
        h h10 = this.c;
        if (h10 != null) {
            h10.n(a10);
        }
    }

    public void i(k k10) {
        this.a = k10;
    }

    public void j() {
        this.b.e();
        this.i(null);
        h h10 = this.c;
        if (h10 != null) {
            this.c = null;
        }
    }
}

