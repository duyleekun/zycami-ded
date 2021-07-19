/*
 * Decompiled with CFR 0.151.
 */
package d.v.k0.f.e;

import d.v.k0.f.d.a;
import d.v.k0.f.e.s;
import d.v.k0.f.e.t;
import d.v.k0.f.e.u;
import d.v.k0.g.d;
import e.a.g0;
import e.a.s0.b;

public class t$a
implements g0 {
    public final /* synthetic */ t a;

    public t$a(t t10) {
        this.a = t10;
    }

    public void a(a a10) {
        Object object = t.j(this.a);
        if (object != null) {
            String string2;
            object = t.k(this.a);
            boolean bl2 = ((u)object).e(string2 = a10.d());
            if (bl2) {
                object = t.j(this.a);
                object.g(a10);
            } else {
                object = t.j(this.a);
                object.f(a10);
            }
        }
    }

    public void onComplete() {
        s s10 = t.j(this.a);
        if (s10 != null) {
            s10 = t.j(this.a);
            s10.a();
        }
    }

    public void onError(Throwable throwable) {
        s s10 = t.j(this.a);
        d.h("\u626b\u63cf\u5f02\u5e38", throwable, 200, s10);
    }

    public void onSubscribe(b object) {
        e.a.s0.a a10 = t.i(this.a);
        a10.b((b)object);
        object = t.j(this.a);
        if (object != null) {
            object = t.j(this.a);
            object.onStart();
        }
        t.k(this.a).n();
    }
}

