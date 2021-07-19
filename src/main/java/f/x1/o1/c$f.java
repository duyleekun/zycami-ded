/*
 * Decompiled with CFR 0.151.
 */
package f.x1.o1;

import f.h2.t.f0;
import f.h2.t.x0.d;
import f.x1.o1.c;
import f.x1.o1.c$d;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class c$f
extends c$d
implements Iterator,
d {
    public c$f(c c10) {
        f0.p(c10, "map");
        super(c10);
    }

    public Object next() {
        c c10;
        int n10;
        int n11 = this.b();
        if (n11 < (n10 = c.e(c10 = this.e()))) {
            n11 = this.b();
            n10 = n11 + 1;
            this.g(n10);
            this.h(n11);
            Object object = c.g(this.e());
            f0.m(object);
            n10 = this.c();
            object = object[n10];
            this.f();
            return object;
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }
}

