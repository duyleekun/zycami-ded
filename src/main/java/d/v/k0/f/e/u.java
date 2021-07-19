/*
 * Decompiled with CFR 0.151.
 */
package d.v.k0.f.e;

import d.v.k0.f.e.g;
import d.v.k0.f.e.m;
import d.v.k0.f.e.n;
import d.v.k0.f.e.o;
import d.v.k0.f.e.u$b;
import d.v.k0.f.e.u$c;
import e.a.c1.b;
import e.a.h0;
import e.a.z;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import m.a.a;

public class u {
    private final Map a;
    private e.a.s0.b b;
    private u$b c;

    public u() {
        ConcurrentHashMap concurrentHashMap;
        this.a = concurrentHashMap = new ConcurrentHashMap();
    }

    private u$c c(String string2) {
        return (u$c)this.a.get(string2);
    }

    private boolean d(u$c u$c) {
        return u$c.k();
    }

    public static /* synthetic */ void f(String string2, u$c u$c) {
        u$c.a();
    }

    private /* synthetic */ void g(String string2, u$c a10) {
        boolean bl2 = this.d((u$c)a10);
        if (bl2) {
            int n10;
            a10 = this.l(string2);
            Object object = this.c;
            if (object != null && (n10 = (object = this.b).isDisposed()) == 0) {
                n10 = 1;
                object = new Object[n10];
                object[0] = a10;
                String string3 = "\u5b58\u6d3b\u5bf9\u8c61\u4e22\u5931\uff0c%s";
                m.a.a.b(string3, (Object[])object);
                object = this.c;
                object.a(string2, a10);
            }
        }
    }

    private /* synthetic */ void i(Long object) {
        object = this.a;
        n n10 = new n(this);
        object.forEach(n10);
    }

    private d.v.k0.f.d.a l(String string2) {
        return (d.v.k0.f.d.a)this.a.remove(string2);
    }

    public void a() {
        Object object = this.a.size();
        Object object2 = new Object[]{object};
        m.a.a.b("\u6e05\u6389\u626b\u63cf\u5230\u7684\u6570\u636e,%s", (Object[])object2);
        object2 = this.a;
        object = m.a;
        object2.forEach(object);
        this.a.clear();
    }

    public boolean b(String string2) {
        return this.a.containsKey(string2);
    }

    public boolean e(String object) {
        boolean bl2;
        if ((object = this.c((String)object)) != null && !(bl2 = this.d((u$c)object))) {
            bl2 = false;
            object = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public /* synthetic */ void h(String string2, u$c u$c) {
        this.g(string2, u$c);
    }

    public /* synthetic */ void j(Long l10) {
        this.i(l10);
    }

    public d.v.k0.f.d.a k(byte[] byArray, String string2, String string3) {
        u$c u$c = new u$c(null);
        u$c.g(byArray).h(string2).i(string3);
        long l10 = System.currentTimeMillis();
        u$c.l(l10);
        this.a.put(string2, u$c);
        return u$c;
    }

    public void m(u$b u$b) {
        this.c = u$b;
    }

    public void n() {
        this.o();
        Object object = new Object[]{this};
        m.a.a.b("\u5f00\u59cb\u5b58\u6d3b\u65f6\u95f4\u76d1\u542c------------------,%s", (Object[])object);
        object = TimeUnit.MILLISECONDS;
        object = z.l3(100, 1000L, (TimeUnit)((Object)object));
        Object object2 = new o(this);
        object = ((z)object).f2((e.a.v0.g)object2);
        object2 = e.a.c1.b.d();
        object = ((z)object).L5((h0)object2);
        object2 = new g(this);
        this.b = object = ((z)object).X1((e.a.v0.a)object2).a();
    }

    public void o() {
        e.a.s0.b b10 = this.b;
        if (b10 != null) {
            b10.dispose();
        }
    }

    public void p(String object) {
        object = this.c((String)object);
        long l10 = System.currentTimeMillis();
        ((u$c)object).l(l10);
    }
}

