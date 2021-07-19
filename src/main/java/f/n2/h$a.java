/*
 * Decompiled with CFR 0.151.
 */
package f.n2;

import f.h2.t.x0.a;
import f.n2.h;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class h$a
implements Iterator,
a {
    private final Iterator a;
    private int b;
    private Object c;
    public final /* synthetic */ h d;

    public h$a(h object) {
        this.d = object;
        this.a = object = h.e((h)object).iterator();
        this.b = -1;
    }

    private final void b() {
        Iterator iterator2;
        boolean bl2;
        while (bl2 = (iterator2 = this.a).hasNext()) {
            h h10;
            boolean bl3;
            iterator2 = this.a.next();
            Boolean bl4 = (Boolean)h.c(this.d).invoke(iterator2);
            boolean bl5 = bl4;
            if (bl5 != (bl3 = h.d(h10 = this.d))) continue;
            this.c = iterator2;
            this.b = 1;
            return;
        }
        this.b = 0;
    }

    public final Iterator c() {
        return this.a;
    }

    public final Object e() {
        return this.c;
    }

    public final int f() {
        return this.b;
    }

    public final void g(Object object) {
        this.c = object;
    }

    public final void h(int n10) {
        this.b = n10;
    }

    public boolean hasNext() {
        int n10 = this.b;
        int n11 = -1;
        if (n10 == n11) {
            this.b();
        }
        if ((n10 = this.b) != (n11 = 1)) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public Object next() {
        int n10 = this.b;
        int n11 = -1;
        if (n10 == n11) {
            this.b();
        }
        if ((n10 = this.b) != 0) {
            Object object = this.c;
            this.c = null;
            this.b = n11;
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

