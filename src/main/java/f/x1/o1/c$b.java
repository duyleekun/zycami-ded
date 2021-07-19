/*
 * Decompiled with CFR 0.151.
 */
package f.x1.o1;

import f.h2.t.f0;
import f.h2.t.x0.d;
import f.x1.o1.c;
import f.x1.o1.c$c;
import f.x1.o1.c$d;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class c$b
extends c$d
implements Iterator,
d {
    public c$b(c c10) {
        f0.p(c10, "map");
        super(c10);
    }

    public c$c i() {
        c c10;
        int n10;
        int n11 = this.b();
        if (n11 < (n10 = c.e(c10 = this.e()))) {
            n11 = this.b();
            n10 = n11 + 1;
            this.g(n10);
            this.h(n11);
            c10 = this.e();
            int n12 = this.c();
            c$c c$c = new c$c(c10, n12);
            this.f();
            return c$c;
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }

    public final void j(StringBuilder serializable) {
        Object object = "sb";
        f0.p(serializable, (String)object);
        int c10 = this.b();
        c c11 = this.e();
        int n10 = c.e(c11);
        if (c10 < n10) {
            int n11 = this.b();
            n10 = n11 + 1;
            this.g(n10);
            this.h(n11);
            object = c.c(this.e());
            n10 = this.c();
            object = object[n10];
            c11 = this.e();
            n10 = (int)(f0.g(object, c11) ? 1 : 0);
            String string2 = "(this Map)";
            if (n10 != 0) {
                ((StringBuilder)serializable).append(string2);
            } else {
                ((StringBuilder)serializable).append(object);
            }
            char c12 = '=';
            ((StringBuilder)serializable).append(c12);
            object = c.g(this.e());
            f0.m(object);
            n10 = this.c();
            object = object[n10];
            c11 = this.e();
            n10 = (int)(f0.g(object, c11) ? 1 : 0);
            if (n10 != 0) {
                ((StringBuilder)serializable).append(string2);
            } else {
                ((StringBuilder)serializable).append(object);
            }
            this.f();
            return;
        }
        serializable = new NoSuchElementException();
        throw serializable;
    }

    public final int k() {
        c c10;
        int n10;
        int n11 = this.b();
        if (n11 < (n10 = c.e(c10 = this.e()))) {
            n11 = this.b();
            n10 = n11 + 1;
            this.g(n10);
            this.h(n11);
            Object object = c.c(this.e());
            n10 = this.c();
            object = object[n10];
            n10 = 0;
            c10 = null;
            if (object != null) {
                n11 = object.hashCode();
            } else {
                n11 = 0;
                object = null;
            }
            Object object2 = c.g(this.e());
            f0.m(object2);
            int n12 = this.c();
            object2 = object2[n12];
            if (object2 != null) {
                n10 = object2.hashCode();
            }
            this.f();
            return n11 ^= n10;
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }
}

