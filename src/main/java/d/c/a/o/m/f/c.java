/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.o.m.f;

import d.c.a.j;
import d.c.a.s.k.c$a;
import d.c.a.s.k.g;

public final class c
extends j {
    public static c m(g g10) {
        c c10 = new c();
        return (c)c10.f(g10);
    }

    public static c n() {
        c c10 = new c();
        return c10.i();
    }

    public static c o(int n10) {
        c c10 = new c();
        return c10.j(n10);
    }

    public static c p(c$a c$a) {
        c c10 = new c();
        return c10.k(c$a);
    }

    public static c q(d.c.a.s.k.c c10) {
        c c11 = new c();
        return c11.l(c10);
    }

    public c i() {
        c$a c$a = new c$a();
        return this.k(c$a);
    }

    public c j(int n10) {
        c$a c$a = new c$a(n10);
        return this.k(c$a);
    }

    public c k(c$a object) {
        object = ((c$a)object).a();
        return this.l((d.c.a.s.k.c)object);
    }

    public c l(d.c.a.s.k.c c10) {
        return (c)this.f(c10);
    }
}

