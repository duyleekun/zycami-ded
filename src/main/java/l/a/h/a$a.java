/*
 * Decompiled with CFR 0.151.
 */
package l.a.h;

import java.util.Map;
import l.a.h.a;
import l.a.h.c;

public class a$a
extends c {
    public final /* synthetic */ a d;

    public a$a(a a10) {
        this.d = a10;
    }

    public void a() {
        this.d.clear();
    }

    public Object b(int n10, int n11) {
        Object[] objectArray = this.d.b;
        n10 = (n10 << 1) + n11;
        return objectArray[n10];
    }

    public Map c() {
        return this.d;
    }

    public int d() {
        return this.d.c;
    }

    public int e(Object object) {
        return this.d.h(object);
    }

    public int f(Object object) {
        return this.d.j(object);
    }

    public void g(Object object, Object object2) {
        this.d.put(object, object2);
    }

    public void h(int n10) {
        this.d.m(n10);
    }

    public Object i(int n10, Object object) {
        return this.d.n(n10, object);
    }
}

