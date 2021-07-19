/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.o.m.d;

import d.c.a.j;
import d.c.a.s.k.b;
import d.c.a.s.k.c;
import d.c.a.s.k.c$a;
import d.c.a.s.k.g;

public final class i
extends j {
    public static i n(g g10) {
        i i10 = new i();
        return (i)i10.f(g10);
    }

    public static i o() {
        i i10 = new i();
        return i10.i();
    }

    public static i p(int n10) {
        i i10 = new i();
        return i10.j(n10);
    }

    public static i q(c$a c$a) {
        i i10 = new i();
        return i10.k(c$a);
    }

    public static i r(c c10) {
        i i10 = new i();
        return i10.l(c10);
    }

    public static i s(g g10) {
        i i10 = new i();
        return i10.m(g10);
    }

    public i i() {
        c$a c$a = new c$a();
        return this.k(c$a);
    }

    public i j(int n10) {
        c$a c$a = new c$a(n10);
        return this.k(c$a);
    }

    public i k(c$a object) {
        object = ((c$a)object).a();
        return this.m((g)object);
    }

    public i l(c c10) {
        return this.m(c10);
    }

    public i m(g g10) {
        b b10 = new b(g10);
        return (i)this.f(b10);
    }
}

