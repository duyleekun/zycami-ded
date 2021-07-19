/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.o.l;

import d.c.a.o.f;
import d.c.a.o.j.d;
import d.c.a.o.l.b$b;
import d.c.a.o.l.b$c;
import d.c.a.o.l.n;
import d.c.a.o.l.n$a;
import d.c.a.t.e;

public class b
implements n {
    private final b$b a;

    public b(b$b b$b) {
        this.a = b$b;
    }

    public n$a c(byte[] byArray, int n10, int n11, f object) {
        e e10 = new e(byArray);
        b$b b$b = this.a;
        object = new b$c(byArray, b$b);
        n$a n$a = new n$a(e10, (d)object);
        return n$a;
    }

    public boolean d(byte[] byArray) {
        return true;
    }
}

