/*
 * Decompiled with CFR 0.151.
 */
package f.j2;

import f.h2.t.f0;
import f.j2.f;
import f.m2.n;

public abstract class c
implements f {
    private Object a;

    public c(Object object) {
        this.a = object;
    }

    public Object a(Object object, n n10) {
        f0.p(n10, "property");
        return this.a;
    }

    public void b(Object object, n n10, Object object2) {
        f0.p(n10, "property");
        object = this.a;
        boolean bl2 = this.d(n10, object, object2);
        if (!bl2) {
            return;
        }
        this.a = object2;
        this.c(n10, object, object2);
    }

    public void c(n n10, Object object, Object object2) {
        f0.p(n10, "property");
    }

    public boolean d(n n10, Object object, Object object2) {
        f0.p(n10, "property");
        return true;
    }
}

