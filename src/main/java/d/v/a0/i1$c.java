/*
 * Decompiled with CFR 0.151.
 */
package d.v.a0;

import d.v.a0.a;
import d.v.a0.i0;
import d.v.a0.i1;
import d.v.a0.j0;
import d.v.a0.k0;
import d.v.a0.n1.b;
import d.v.k0.f.e.r;
import d.v.k0.g.d;
import d.v.z.l.e;

public class i1$c
implements r {
    public final /* synthetic */ e a;
    public final /* synthetic */ b b;
    public final /* synthetic */ i1 c;

    public i1$c(i1 i12, e e10, b b10) {
        this.c = i12;
        this.a = e10;
        this.b = b10;
    }

    public static /* synthetic */ void r(b b10) {
        b10.a();
    }

    public static /* synthetic */ void s(b b10, String string2, Throwable throwable, int n10) {
        b10.b(string2, throwable, n10);
    }

    public static /* synthetic */ void t(b b10) {
        b10.onStart();
    }

    public void a() {
        b b10 = this.b;
        if (b10 != null) {
            b10.getClass();
            j0 j02 = new j0(b10);
            b10 = this.b;
            d.j(j02, b10);
        }
    }

    public void b(String string2, Throwable throwable, int n10) {
        b b10 = this.b;
        if (b10 != null) {
            k0 k02 = new k0(b10, string2, throwable, n10);
            d.j(k02, b10);
        }
    }

    public void d() {
        Object object = this.c;
        Object object2 = this.a;
        i1.F((i1)object, (e)object2);
        object = this.b;
        if (object != null) {
            object.getClass();
            object2 = new a((b)object);
            object = this.b;
            d.j((Runnable)object2, object);
        }
    }

    public void onStart() {
        b b10 = this.b;
        if (b10 != null) {
            b10.getClass();
            i0 i02 = new i0(b10);
            b10 = this.b;
            d.j(i02, b10);
        }
    }
}

