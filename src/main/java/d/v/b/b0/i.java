/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseArray
 */
package d.v.b.b0;

import android.util.SparseArray;
import com.zhiyun.renderengine.business.display.DisplayRender;
import d.v.b.b0.e;
import d.v.b.b0.j;
import d.v.b.b0.k.a;
import d.v.b.b0.k.b;
import d.v.b.b0.k.c;
import d.v.b.b0.k.d;
import d.v.b.b0.k.f;
import d.v.b.b0.k.g;
import d.v.b.b0.k.h;
import d.v.b.c0.e$a;
import d.v.b0.c.e.c$a;

public class i
implements j {
    private final SparseArray a;
    private final DisplayRender b;

    public i(DisplayRender displayRender) {
        SparseArray sparseArray;
        this.a = sparseArray = new SparseArray();
        d.v.d.h.f.a("init beauty");
        this.b = displayRender;
        this.g();
    }

    private void b(int n10, d.v.b.c0.b b10) {
        this.a.append(n10, (Object)b10);
    }

    private void c() {
        b b10 = new b();
        this.b(5, b10);
        d.v.b.b0.g g10 = new d.v.b.b0.g(this);
        b10.h(g10);
    }

    private void d() {
        a a10 = new a();
        this.b(2, a10);
        d.v.b.b0.h h10 = new d.v.b.b0.h(this);
        a10.h(h10);
    }

    private void e() {
        c c10 = new c();
        this.b(1, c10);
        d.v.b.b0.b b10 = new d.v.b.b0.b(this, c10);
        c10.h(b10);
    }

    private void f() {
        d d10 = new d();
        this.b(6, d10);
        e e10 = new e(this);
        d10.h(e10);
    }

    private void g() {
        this.c();
        this.d();
        this.i();
        this.h();
        this.f();
        this.k();
        this.j();
        this.e();
    }

    private void h() {
        f f10 = new f();
        this.b(7, f10);
        d.v.b.b0.f f11 = new d.v.b.b0.f(this);
        f10.h(f11);
    }

    private void i() {
        g g10 = new g();
        this.b(3, g10);
        d.v.b.b0.d d10 = new d.v.b.b0.d(this);
        g10.h(d10);
    }

    private void j() {
        Object object;
        Object object2 = this.b;
        if (object2 == null) {
            object = null;
            object2 = new h(false);
        } else {
            boolean bl2 = ((DisplayRender)object2).Q();
            object2 = object = new h(bl2);
        }
        this.b(9, (d.v.b.c0.b)object2);
        object = new d.v.b.b0.c(this);
        ((d.v.b.c0.b)object2).h((e$a)object);
    }

    private void k() {
        d.v.b.b0.k.i i10 = new d.v.b.b0.k.i();
        this.b(4, i10);
        d.v.b.b0.a a10 = new d.v.b.b0.a(this);
        i10.h(a10);
    }

    private /* synthetic */ void l(Float f10, int n10) {
        Object object = new StringBuilder();
        String string2 = "eye=";
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append(f10);
        d.v.d.h.f.a(((StringBuilder)object).toString());
        object = this.b;
        if (object == null) {
            return;
        }
        float f11 = f10.floatValue();
        ((DisplayRender)object).m0(f11);
    }

    private /* synthetic */ void n(Float f10, int n10) {
        Object object = new StringBuilder();
        String string2 = "face=";
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append(f10);
        d.v.d.h.f.a(((StringBuilder)object).toString());
        object = this.b;
        if (object == null) {
            return;
        }
        float f11 = f10.floatValue();
        ((DisplayRender)object).n0(f11);
    }

    private /* synthetic */ void p(c object, Integer object2, int n10) {
        Object object3 = new StringBuilder();
        String string2 = "filter integer=";
        ((StringBuilder)object3).append(string2);
        ((StringBuilder)object3).append(object2);
        object3 = ((StringBuilder)object3).toString();
        d.v.d.h.f.a((String)object3);
        object = ((d.v.b.c0.b)object).f();
        boolean bl2 = ((Integer)object2).equals(object);
        if (bl2) {
            object = this.b;
            boolean bl3 = false;
            object2 = null;
            ((DisplayRender)object).a0(false);
        } else {
            object = this.b;
            n10 = 1;
            ((DisplayRender)object).a0(n10 != 0);
            object = this.b;
            object3 = d.v.b0.c.e.c.a();
            int n11 = (Integer)object2;
            object2 = (c$a)object3.get(n11);
            ((DisplayRender)object).r0((c$a)object2);
        }
    }

    private /* synthetic */ void r(Float f10, int n10) {
        Object object = new StringBuilder();
        String string2 = "light=";
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append(f10);
        d.v.d.h.f.a(((StringBuilder)object).toString());
        object = this.b;
        if (object == null) {
            return;
        }
        float f11 = f10.floatValue();
        ((DisplayRender)object).l0(f11);
    }

    private /* synthetic */ void t(Float f10, int n10) {
        Object object = new StringBuilder();
        String string2 = "rosy=";
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append(f10);
        d.v.d.h.f.a(((StringBuilder)object).toString());
        object = this.b;
        if (object == null) {
            return;
        }
        float f11 = f10.floatValue();
        ((DisplayRender)object).w0(f11);
    }

    private /* synthetic */ void v(Float f10, int n10) {
        Object object = new StringBuilder();
        String string2 = "skin=";
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append(f10);
        d.v.d.h.f.a(((StringBuilder)object).toString());
        object = this.b;
        if (object == null) {
            return;
        }
        float f11 = f10.floatValue();
        ((DisplayRender)object).s0(f11);
    }

    private /* synthetic */ void x(Boolean bl2, int n10) {
        Object object = new StringBuilder();
        String string2 = "switch beauty aBoolean=";
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append(bl2);
        d.v.d.h.f.a(((StringBuilder)object).toString());
        object = this.b;
        if (object == null) {
            return;
        }
        boolean bl3 = bl2;
        ((DisplayRender)object).Z(bl3);
    }

    private /* synthetic */ void z(Float f10, int n10) {
        Object object = new StringBuilder();
        String string2 = "white=";
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append(f10);
        d.v.d.h.f.a(((StringBuilder)object).toString());
        object = this.b;
        if (object == null) {
            return;
        }
        float f11 = f10.floatValue();
        ((DisplayRender)object).z0(f11);
    }

    public /* synthetic */ void A(Float f10, int n10) {
        this.z(f10, n10);
    }

    public d.v.b.c0.e a(int n10) {
        return (d.v.b.c0.e)this.a.get(n10);
    }

    public /* synthetic */ void m(Float f10, int n10) {
        this.l(f10, n10);
    }

    public /* synthetic */ void o(Float f10, int n10) {
        this.n(f10, n10);
    }

    public /* synthetic */ void q(c c10, Integer n10, int n11) {
        this.p(c10, n10, n11);
    }

    public void release() {
        Object object;
        int n10;
        for (int i10 = 0; i10 < (n10 = (object = this.a).size()); ++i10) {
            object = (d.v.b.c0.e)this.a.valueAt(i10);
            object.b();
        }
    }

    public /* synthetic */ void s(Float f10, int n10) {
        this.r(f10, n10);
    }

    public /* synthetic */ void u(Float f10, int n10) {
        this.t(f10, n10);
    }

    public /* synthetic */ void w(Float f10, int n10) {
        this.v(f10, n10);
    }

    public /* synthetic */ void y(Boolean bl2, int n10) {
        this.x(bl2, n10);
    }
}

