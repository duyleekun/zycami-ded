/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.o.l;

import d.c.a.o.l.m$a;
import d.c.a.o.l.m$b;
import d.c.a.u.h;

public class m {
    private static final int b = 250;
    private final h a;

    public m() {
        this(250L);
    }

    public m(long l10) {
        m$a m$a = new m$a(this, l10);
        this.a = m$a;
    }

    public void a() {
        this.a.b();
    }

    public Object b(Object object, int n10, int n11) {
        object = m$b.a(object, n10, n11);
        Object object2 = this.a.j(object);
        ((m$b)object).c();
        return object2;
    }

    public void c(Object object, int n10, int n11, Object object2) {
        object = m$b.a(object, n10, n11);
        this.a.n(object, object2);
    }
}

