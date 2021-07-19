/*
 * Decompiled with CFR 0.151.
 */
package f.x1.o1;

import f.h2.t.f0;
import f.h2.t.x0.f;
import f.x1.o1.a;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public final class a$a
implements ListIterator,
f {
    private final a a;
    private int b;
    private int c;

    public a$a(a a10, int n10) {
        f0.p(a10, "list");
        this.a = a10;
        this.b = n10;
        this.c = -1;
    }

    public void add(Object object) {
        int n10;
        a a10 = this.a;
        int n11 = this.b;
        this.b = n10 = n11 + 1;
        a10.add(n11, object);
        this.c = -1;
    }

    public boolean hasNext() {
        int n10 = this.b;
        a a10 = this.a;
        int n11 = f.x1.o1.a.f(a10);
        n10 = n10 < n11 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasPrevious() {
        int n10 = this.b;
        n10 = n10 > 0 ? 1 : 0;
        return n10 != 0;
    }

    public Object next() {
        int n10 = this.b;
        a a10 = this.a;
        int n11 = f.x1.o1.a.f(a10);
        if (n10 < n11) {
            n10 = this.b;
            this.b = n11 = n10 + 1;
            this.c = n10;
            Object[] objectArray = f.x1.o1.a.e(this.a);
            n11 = f.x1.o1.a.g(this.a);
            int n12 = this.c;
            return objectArray[n11 += n12];
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }

    public int nextIndex() {
        return this.b;
    }

    public Object previous() {
        int n10 = this.b;
        if (n10 > 0) {
            this.b = n10 += -1;
            this.c = n10;
            Object[] objectArray = f.x1.o1.a.e(this.a);
            int n11 = f.x1.o1.a.g(this.a);
            int n12 = this.c;
            return objectArray[n11 += n12];
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }

    public int previousIndex() {
        return this.b + -1;
    }

    public void remove() {
        int n10 = this.c;
        int n11 = -1;
        boolean bl2 = n10 != n11;
        if (bl2) {
            this.a.remove(n10);
            this.b = n10 = this.c;
            this.c = n11;
            return;
        }
        String string2 = "Call next() or previous() before removing element from the iterator.".toString();
        IllegalStateException illegalStateException = new IllegalStateException(string2);
        throw illegalStateException;
    }

    public void set(Object object) {
        int n10 = this.c;
        int n11 = -1;
        n11 = n10 != n11 ? 1 : 0;
        if (n11 != 0) {
            this.a.set(n10, object);
            return;
        }
        String string2 = "Call next() or previous() before replacing element from the iterator.".toString();
        object = new IllegalStateException(string2);
        throw object;
    }
}

