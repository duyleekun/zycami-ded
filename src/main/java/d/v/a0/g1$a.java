/*
 * Decompiled with CFR 0.151.
 */
package d.v.a0;

import d.v.a0.c;
import d.v.a0.d;
import d.v.a0.g1;
import d.v.a0.h1;
import d.v.a0.n1.e;
import d.v.a0.n1.h.a;
import d.v.z.l.i;
import d.v.z.n.g;
import d.v.z.n.h;

public class g1$a
implements e {
    public final /* synthetic */ g1 a;

    public g1$a(g1 g12) {
        this.a = g12;
    }

    public static /* synthetic */ void f(long l10, d.v.z.n.e e10) {
        ((d.v.z.l.g)e10.getData()).l(l10, l10);
    }

    private /* synthetic */ void g(h object) {
        a a10 = g1.B(this.a);
        object = (i)((g)object).getData();
        a10.a((i)object);
    }

    public void a(h1 h12) {
    }

    public void b(h1 h12) {
        long l10 = System.currentTimeMillis();
        g1 g12 = this.a;
        c c10 = new c(l10);
        g12.p(h12, c10);
    }

    public void c(h1 object) {
        Object object2 = this.a;
        boolean bl2 = ((g1)object2).isConnected();
        if (!bl2) {
            return;
        }
        bl2 = ((g)(object = (h)((h1)object).b())).c();
        if (!bl2) {
            return;
        }
        object2 = g1.B(this.a);
        if (object2 != null) {
            object2 = new d(this, (h)object);
            object = g1.B(this.a);
            d.v.k0.g.d.j((Runnable)object2, object);
        }
    }

    public void d(h1 h12) {
    }

    public void e(h1 h12) {
        g1.C(this.a, h12, true);
    }

    public /* synthetic */ void h(h h10) {
        this.g(h10);
    }
}

