/*
 * Decompiled with CFR 0.151.
 */
package d.v.k0.f.c.j;

import d.v.k0.f.c.d;
import d.v.k0.f.c.e;
import d.v.k0.f.c.h;
import d.v.k0.f.c.j.k;
import d.v.k0.f.c.j.l;
import d.v.k0.f.c.j.n$a;
import d.v.k0.f.c.j.n$b;
import d.v.k0.f.c.j.n$c;
import d.v.k0.f.c.j.n$d;
import d.v.k0.f.c.j.o;
import d.v.k0.f.d.a;
import e.a.g0;
import e.a.z;
import java.util.Arrays;

public class n {
    private final l a;
    private final e.a.s0.a b;
    private h c;
    private o d;
    private final byte[] e;
    private final byte[] f;

    private n() {
        Object object = new l();
        this.a = object;
        this.b = object = new e.a.s0.a();
        int n10 = 2;
        byte[] byArray = new byte[n10];
        this.e = byArray;
        object = new byte[n10];
        this.f = (byte[])object;
    }

    public /* synthetic */ n(n$a a10) {
        this();
    }

    public static /* synthetic */ l a(n n10) {
        return n10.a;
    }

    public static /* synthetic */ e.a.s0.a b(n n10) {
        return n10.b;
    }

    public static /* synthetic */ void c(n n10, int n11) {
        n10.v(n11);
    }

    public static /* synthetic */ void d(n n10, int n11) {
        n10.u(n11);
    }

    public static n l() {
        return n$d.a();
    }

    private void m(int n10) {
        Object object = this.c;
        if (object == null) {
            return;
        }
        z z10 = ((h)object).k(n10, 0, true);
        object = new n$c(this);
        z10.subscribe((g0)object);
    }

    private void n() {
        Object object = new h();
        this.c = object;
        Object object2 = new d();
        ((h)object).p((e)object2);
        object = this.c.l();
        object2 = new n$b(this);
        ((z)object).subscribe((g0)object2);
    }

    private void u(int n10) {
        byte by2;
        byte[] byArray = this.f;
        byArray[n10] = by2 = 1;
        l l10 = null;
        n10 = byArray[0];
        int n11 = byArray[by2];
        if ((n10 += n11) == (n11 = 2)) {
            l10 = this.a;
            l10.k();
        }
    }

    private void v(int n10) {
        byte by2;
        byte[] byArray = this.e;
        byArray[n10] = by2 = 1;
        l l10 = null;
        n10 = byArray[0];
        int n11 = byArray[by2];
        if ((n10 += n11) == (n11 = 2)) {
            l10 = this.a;
            l10.q();
        }
    }

    public void e(k k10) {
        this.a.a(k10);
    }

    public void f(String string2) {
        Object object = this.c;
        if (object != null) {
            ((h)object).c(string2);
        }
        if ((object = this.d) != null) {
            ((o)object).d(string2);
        }
    }

    public void g(k k10) {
        this.a.b(k10);
    }

    public void h() {
        this.a.d();
    }

    public void i() {
        this.a.c();
    }

    public void j(int n10) {
        this.n();
        this.m(n10);
    }

    public void k(int n10) {
        Object object = new o();
        this.d = object;
        ((o)object).f();
        this.d.e(n10);
        o o10 = this.d;
        object = new n$a(this);
        o10.i((k)object);
    }

    public void o() {
        this.w();
        this.i();
        this.h();
    }

    public void p(k k10) {
        this.a.r(k10);
    }

    public void q(String string2) {
        Object object = this.c;
        if (object != null) {
            ((h)object).m(string2);
        }
        if ((object = this.d) != null) {
            ((o)object).g(string2);
        }
    }

    public void r(k k10) {
        this.a.s(k10);
    }

    public void s(a a10) {
        synchronized (this) {
            h h10;
            block4: {
                h10 = this.c;
                if (h10 != null) break block4;
                return;
            }
            h10.n(a10);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void t(a a10) {
        synchronized (this) {
            o o10 = this.d;
            if (o10 != null) {
                o10.h(a10);
            }
            return;
        }
    }

    public void w() {
        this.b.e();
        Object object = this.d;
        if (object != null) {
            ((o)object).j();
        }
        if ((object = this.c) != null) {
            object = null;
            this.c = null;
        }
        Arrays.fill(this.e, (byte)0);
        Arrays.fill(this.f, (byte)0);
    }
}

