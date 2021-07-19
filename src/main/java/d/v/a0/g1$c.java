/*
 * Decompiled with CFR 0.151.
 */
package d.v.a0;

import d.v.a0.g;
import d.v.a0.g1;
import d.v.a0.h;
import d.v.a0.h1;
import d.v.a0.i;
import d.v.a0.j;
import d.v.a0.k;
import d.v.a0.l;
import d.v.a0.l1;
import d.v.a0.m;
import d.v.a0.n;
import d.v.a0.n1.f;
import d.v.k0.f.e.s;
import d.v.k0.g.d;
import d.v.z.l.e;
import d.v.z.n.c;
import java.util.Map;
import java.util.Optional;
import m.a.a;

public class g1$c
implements s {
    public final /* synthetic */ f a;
    public final /* synthetic */ g1 b;

    public g1$c(g1 g12, f f10) {
        this.b = g12;
        this.a = f10;
    }

    public static /* synthetic */ void B(f f10) {
        f10.onStart();
    }

    public static /* synthetic */ void r(f f10, e e10) {
        f10.m(e10);
    }

    public static /* synthetic */ void s(f f10, e e10, e e11) {
        f10.h(e10, e11);
    }

    public static /* synthetic */ void t(f f10, e e10) {
        f10.o(e10);
    }

    public static /* synthetic */ void u(f f10) {
        f10.a();
    }

    public static /* synthetic */ void v(f f10, String string2, Throwable throwable, int n10) {
        f10.b(string2, throwable, n10);
    }

    public static /* synthetic */ boolean w(d.v.k0.f.d.a object, e object2) {
        object2 = ((e)object2).n();
        object = ((d.v.k0.f.d.a)object).d();
        return ((String)object2).equals(object);
    }

    private /* synthetic */ void x(f object, e object2) {
        if (object != null) {
            n n10 = new n((f)object, (e)object2);
            d.j(n10, object);
        }
        object = g1.F(this.b);
        object2 = ((e)object2).k();
        object.remove(object2);
    }

    private /* synthetic */ void z(f f10, h1 object) {
        object = (e)((c)((h1)object).b()).getData();
        Object object2 = ((e)object).k();
        Object object3 = (e)g1.F(this.b).get(object2);
        if (object3 == null) {
            object3 = g1.F(this.b);
            object3.put(object2, object);
            if (f10 != null) {
                object2 = new i(f10, (e)object);
                d.j((Runnable)object2, f10);
            }
            return;
        }
        boolean bl2 = ((e)object).equals(object3);
        if (!bl2) {
            Map map = g1.F(this.b);
            map.put(object2, object);
            if (f10 != null) {
                object2 = new l(f10, (e)object3, (e)object);
                d.j((Runnable)object2, f10);
            }
        }
    }

    public /* synthetic */ void A(f f10, h1 h12) {
        this.z(f10, h12);
    }

    public void a() {
        f f10 = this.a;
        if (f10 != null) {
            f10.getClass();
            g g10 = new g(f10);
            f10 = this.a;
            d.j(g10, f10);
        }
    }

    public void b(String string2, Throwable throwable, int n10) {
        f f10 = this.a;
        if (f10 != null) {
            h h10 = new h(f10, string2, throwable, n10);
            d.j(h10, f10);
        }
    }

    public void c() {
        g1.F(this.b).clear();
    }

    public void f(d.v.k0.f.d.a a10) {
        Object object = a10.d();
        Object object2 = new Object[]{object};
        m.a.a.b("scanInfo.getHost():%s", (Object[])object2);
        object2 = g1.D(this.b);
        object = this.a;
        k k10 = new k(this, (f)object);
        ((l1)object2).b(a10, k10);
    }

    public void g(d.v.k0.f.d.a object) {
        Object object2 = g1.F(this.b).values().stream();
        Object object3 = new m((d.v.k0.f.d.a)object);
        object = object2.filter(object3).findFirst();
        object2 = this.a;
        object3 = new d.v.a0.f(this, (f)object2);
        ((Optional)object).ifPresent(object3);
    }

    public void onStart() {
        g1.F(this.b).clear();
        f f10 = this.a;
        if (f10 != null) {
            f10.getClass();
            j j10 = new j(f10);
            f10 = this.a;
            d.j(j10, f10);
        }
    }

    public /* synthetic */ void y(f f10, e e10) {
        this.x(f10, e10);
    }
}

