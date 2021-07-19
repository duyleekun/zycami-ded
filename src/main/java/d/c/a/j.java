/*
 * Decompiled with CFR 0.151.
 */
package d.c.a;

import d.c.a.s.k.e;
import d.c.a.s.k.g;
import d.c.a.s.k.h;
import d.c.a.s.k.i;
import d.c.a.s.k.j$a;
import d.c.a.u.k;

public abstract class j
implements Cloneable {
    private g a;

    public j() {
        g g10;
        this.a = g10 = e.c();
    }

    private j d() {
        return this;
    }

    public final j a() {
        Object object;
        try {
            object = super.clone();
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            RuntimeException runtimeException = new RuntimeException(cloneNotSupportedException);
            throw runtimeException;
        }
        return (j)object;
    }

    public final j b() {
        g g10 = e.c();
        return this.f(g10);
    }

    public final g c() {
        return this.a;
    }

    public final j e(int n10) {
        h h10 = new h(n10);
        return this.f(h10);
    }

    public final j f(g g10) {
        this.a = g10 = (g)k.d(g10);
        return this.d();
    }

    public final j g(j.a a10) {
        i i10 = new i(a10);
        return this.f(i10);
    }
}

