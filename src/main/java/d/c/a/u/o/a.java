/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.u.o;

import androidx.core.util.Pools$Pool;
import androidx.core.util.Pools$SimplePool;
import androidx.core.util.Pools$SynchronizedPool;
import d.c.a.u.o.a$a;
import d.c.a.u.o.a$b;
import d.c.a.u.o.a$c;
import d.c.a.u.o.a$d;
import d.c.a.u.o.a$e;
import d.c.a.u.o.a$g;

public final class a {
    private static final String a = "FactoryPools";
    private static final int b = 20;
    private static final a$g c;

    static {
        a$a a$a = new a$a();
        c = a$a;
    }

    private a() {
    }

    private static Pools$Pool a(Pools$Pool pools$Pool, a$d a$d) {
        a$g a$g = d.c.a.u.o.a.c();
        return d.c.a.u.o.a.b(pools$Pool, a$d, a$g);
    }

    private static Pools$Pool b(Pools$Pool pools$Pool, a$d a$d, a$g a$g) {
        a$e a$e = new a$e(pools$Pool, a$d, a$g);
        return a$e;
    }

    private static a$g c() {
        return c;
    }

    public static Pools$Pool d(int n10, a$d a$d) {
        Pools$SimplePool pools$SimplePool = new Pools$SimplePool(n10);
        return d.c.a.u.o.a.a(pools$SimplePool, a$d);
    }

    public static Pools$Pool e(int n10, a$d a$d) {
        Pools$SynchronizedPool pools$SynchronizedPool = new Pools$SynchronizedPool(n10);
        return d.c.a.u.o.a.a(pools$SynchronizedPool, a$d);
    }

    public static Pools$Pool f() {
        return d.c.a.u.o.a.g(20);
    }

    public static Pools$Pool g(int n10) {
        Pools$SynchronizedPool pools$SynchronizedPool = new Pools$SynchronizedPool(n10);
        a$b a$b = new a$b();
        a$c a$c = new a$c();
        return d.c.a.u.o.a.b(pools$SynchronizedPool, a$b, a$c);
    }
}

