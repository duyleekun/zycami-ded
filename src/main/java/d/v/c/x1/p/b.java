/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.x1.p;

import d.v.c.x1.p.a;
import d.v.c.x1.p.b$b;

public class b {
    private Object a;

    public static /* synthetic */ Object a(b b10) {
        return b10.a;
    }

    public void b(Object object) {
        this.a = object;
    }

    public void c() {
        this.a = null;
    }

    public a d() {
        b$b b$b = new b$b(this, this, null);
        return b$b;
    }

    public Object e() {
        return this.a;
    }

    public void f(a object) {
        object = b$b.a((b$b)object);
        this.b(object);
    }
}

