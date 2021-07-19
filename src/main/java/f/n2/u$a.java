/*
 * Decompiled with CFR 0.151.
 */
package f.n2;

import f.h2.t.x0.a;
import f.n2.u;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class u$a
implements Iterator,
a {
    private final Iterator a;
    private int b;
    private Object c;
    public final /* synthetic */ u d;

    public u$a(u object) {
        this.d = object;
        this.a = object = u.d((u)object).iterator();
        this.b = -1;
    }

    private final void b() {
        Iterator iterator2 = this.a;
        boolean bl2 = iterator2.hasNext();
        if (bl2) {
            iterator2 = this.a.next();
            Boolean bl3 = (Boolean)u.c(this.d).invoke(iterator2);
            boolean bl4 = bl3;
            if (bl4) {
                this.b = 1;
                this.c = iterator2;
                return;
            }
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

