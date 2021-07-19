/*
 * Decompiled with CFR 0.151.
 */
package f.n2;

import f.h2.t.f0;
import f.h2.t.x0.a;
import f.n2.j;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public final class j$a
implements Iterator,
a {
    private Object a;
    private int b = -2;
    public final /* synthetic */ j c;

    public j$a(j j10) {
        this.c = j10;
    }

    private final void b() {
        Object object;
        int n10 = this.b;
        int n11 = -2;
        if (n10 == n11) {
            object = j.c(this.c).invoke();
        } else {
            object = j.d(this.c);
            Object object2 = this.a;
            f0.m(object2);
            object = object.invoke(object2);
        }
        this.a = object;
        if (object == null) {
            n10 = 0;
            object = null;
        } else {
            n10 = 1;
        }
        this.b = n10;
    }

    public final Object c() {
        return this.a;
    }

    public final int e() {
        return this.b;
    }

    public final void f(Object object) {
        this.a = object;
    }

    public final void g(int n10) {
        this.b = n10;
    }

    public boolean hasNext() {
        int n10;
        int n11 = this.b;
        if (n11 < 0) {
            this.b();
        }
        if ((n11 = this.b) != (n10 = 1)) {
            n10 = 0;
        }
        return n10 != 0;
    }

    public Object next() {
        int n10 = this.b;
        if (n10 < 0) {
            this.b();
        }
        if ((n10 = this.b) != 0) {
            Object object = this.a;
            Objects.requireNonNull(object, "null cannot be cast to non-null type T");
            this.b = -1;
            return object;
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }

    public void remove() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }
}

