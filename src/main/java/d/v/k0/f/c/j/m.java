/*
 * Decompiled with CFR 0.151.
 */
package d.v.k0.f.c.j;

import d.v.k0.f.c.d;
import d.v.k0.f.c.e;
import d.v.k0.f.c.f;
import d.v.k0.f.c.h;
import d.v.k0.f.c.i;
import d.v.k0.f.c.j.k;
import d.v.k0.f.c.j.l;
import d.v.k0.f.c.j.m$a;
import d.v.k0.f.c.j.m$b;
import d.v.k0.f.c.j.m$c;
import d.v.k0.f.d.a;
import e.a.g0;
import e.a.z;
import java.util.Arrays;

public class m {
    private final l a;
    private final e.a.s0.a b;
    private h c;
    private a d;
    private a e;
    private f f;
    private final byte[] g;
    private final byte[] h;

    private m() {
        Object object = new l();
        this.a = object;
        this.b = object = new e.a.s0.a();
        int n10 = 2;
        byte[] byArray = new byte[n10];
        this.g = byArray;
        object = new byte[n10];
        this.h = (byte[])object;
    }

    public /* synthetic */ m(m$a a10) {
        this();
    }

    public static /* synthetic */ e.a.s0.a a(m m10) {
        return m10.b;
    }

    public static /* synthetic */ void b(m m10, int n10) {
        m10.u(n10);
    }

    public static /* synthetic */ f c(m m10) {
        return m10.f;
    }

    public static /* synthetic */ l d(m m10) {
        return m10.a;
    }

    public static /* synthetic */ void e(m m10, int n10) {
        m10.t(n10);
    }

    public static m k() {
        return m$c.a();
    }

    private void l(f f10) {
        if (f10 != null) {
            a a10;
            h h10 = new h();
            this.f = f10;
            this.e = a10 = new a();
            String string2 = this.d.d();
            a10 = a10.h(string2);
            int n10 = f10.c();
            a10.j(n10);
            int n11 = f10.b();
            boolean bl2 = true;
            this.m(h10, n11, bl2);
        }
    }

    private void m(h object, int n10, boolean bl2) {
        object = ((h)object).k(n10, 0, false);
        m$b m$b = new m$b(this, bl2);
        ((z)object).subscribe(m$b);
    }

    private void n(i object) {
        Object object2 = new a();
        this.d = object2;
        String string2 = ((i)object).c();
        object2 = ((a)object2).h(string2);
        int n10 = ((i)object).d();
        ((a)object2).j(n10);
        this.c = object2 = new h();
        object = ((i)object).c();
        ((h)object2).c((String)object);
        object = this.c;
        object2 = new d();
        ((h)object).p((e)object2);
        object = this.c.l();
        object2 = new m$a(this);
        ((z)object).subscribe((g0)object2);
    }

    private void t(int n10) {
        byte by2;
        byte[] byArray = this.h;
        byArray[n10] = by2 = 1;
        l l10 = null;
        n10 = byArray[0];
        int n11 = byArray[by2];
        if ((n10 += n11) == (n11 = 2)) {
            l10 = this.a;
            l10.k();
        }
    }

    private void u(int n10) {
        byte by2;
        byte[] byArray = this.g;
        byArray[n10] = by2 = 1;
        l l10 = null;
        n10 = byArray[0];
        int n11 = byArray[by2];
        if ((n10 += n11) == (n11 = 2)) {
            l10 = this.a;
            l10.q();
        }
    }

    public void f(k k10) {
        this.a.a(k10);
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

    public void j(i i10, f f10) {
        this.n(i10);
        h h10 = this.c;
        int n10 = i10.b();
        this.m(h10, n10, false);
        this.l(f10);
    }

    public void o() {
        this.v();
        this.i();
        this.h();
    }

    public void p(k k10) {
        this.a.r(k10);
    }

    public void q(k k10) {
        this.a.s(k10);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void r(byte[] object) {
        synchronized (this) {
            Object object2 = this.c;
            if (object2 != null && (object2 = this.d) != null) {
                ((a)object2).g((byte[])object);
                object = this.c;
                object2 = this.d;
                ((h)object).n((a)object2);
                return;
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void s(byte[] object) {
        synchronized (this) {
            Object object2 = this.c;
            if (object2 != null && (object2 = this.e) != null) {
                ((a)object2).g((byte[])object);
                object = this.c;
                object2 = this.e;
                ((h)object).n((a)object2);
                return;
            }
            return;
        }
    }

    public void v() {
        this.b.e();
        Object object = this.c;
        if (object != null) {
            this.c = null;
        }
        if ((object = this.d) != null) {
            ((a)object).a();
            this.d = null;
        }
        if ((object = this.e) != null) {
            ((a)object).a();
            this.e = null;
        }
        if ((object = this.f) != null) {
            this.f = null;
        }
        Arrays.fill(this.g, (byte)0);
        Arrays.fill(this.h, (byte)0);
    }
}

