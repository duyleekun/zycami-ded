/*
 * Decompiled with CFR 0.151.
 */
package f.x1.o1;

import f.h2.t.f0;
import f.x1.o1.c;

public class c$d {
    private int a;
    private int b;
    private final c c;

    public c$d(c c10) {
        f0.p(c10, "map");
        this.c = c10;
        this.b = -1;
        this.f();
    }

    public final int b() {
        return this.a;
    }

    public final int c() {
        return this.b;
    }

    public final c e() {
        return this.c;
    }

    public final void f() {
        int[] nArray;
        c c10;
        int n10;
        int n11;
        while ((n11 = this.a) < (n10 = f.x1.o1.c.e(c10 = this.c)) && (n11 = (nArray = f.x1.o1.c.f(this.c))[n10 = this.a]) < 0) {
            this.a = ++n10;
        }
    }

    public final void g(int n10) {
        this.a = n10;
    }

    public final void h(int n10) {
        this.b = n10;
    }

    public final boolean hasNext() {
        int n10 = this.a;
        c c10 = this.c;
        int n11 = f.x1.o1.c.e(c10);
        n10 = n10 < n11 ? 1 : 0;
        return n10 != 0;
    }

    public final void remove() {
        this.c.p();
        c c10 = this.c;
        int n10 = this.b;
        f.x1.o1.c.h(c10, n10);
        this.b = -1;
    }
}

