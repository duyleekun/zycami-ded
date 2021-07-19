/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.o.k;

import androidx.core.util.Pools$Pool;
import d.c.a.o.c;
import d.c.a.o.k.i$b$a;
import d.c.a.o.k.j;
import d.c.a.o.k.k;
import d.c.a.o.k.n$a;
import d.c.a.o.k.z.a;
import d.c.a.u.e;
import d.c.a.u.o.a$d;

public class i$b {
    public final a a;
    public final a b;
    public final a c;
    public final a d;
    public final k e;
    public final n$a f;
    public final Pools$Pool g;

    public i$b(a a10, a a11, a a12, a a13, k k10, n$a n$a) {
        Object object = new i$b$a(this);
        this.g = object = d.c.a.u.o.a.e(150, (a$d)object);
        this.a = a10;
        this.b = a11;
        this.c = a12;
        this.d = a13;
        this.e = k10;
        this.f = n$a;
    }

    public j a(c c10, boolean bl2, boolean bl3, boolean bl4, boolean bl5) {
        Object object = d.c.a.u.k.d((j)this.g.acquire());
        return ((j)object).l(c10, bl2, bl3, bl4, bl5);
    }

    public void b() {
        d.c.a.u.e.c(this.a);
        d.c.a.u.e.c(this.b);
        d.c.a.u.e.c(this.c);
        d.c.a.u.e.c(this.d);
    }
}

