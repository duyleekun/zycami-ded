/*
 * Decompiled with CFR 0.151.
 */
package f.n2;

import f.h2.t.x0.a;
import f.n2.s;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class s$a
implements Iterator,
a {
    private final Iterator a;
    private int b;
    public final /* synthetic */ s c;

    public s$a(s object) {
        this.c = object;
        this.a = object = s.d((s)object).iterator();
    }

    private final void b() {
        Iterator iterator2;
        s s10;
        int n10;
        int n11;
        while ((n11 = this.b) < (n10 = s.e(s10 = this.c)) && (n11 = (int)((iterator2 = this.a).hasNext() ? 1 : 0)) != 0) {
            iterator2 = this.a;
            iterator2.next();
            this.b = n11 = this.b + 1;
        }
    }

    public final Iterator c() {
        return this.a;
    }

    public final int e() {
        return this.b;
    }

    public final void f(int n10) {
        this.b = n10;
    }

    public boolean hasNext() {
        Iterator iterator2;
        this.b();
        int n10 = this.b;
        s s10 = this.c;
        int n11 = s.c(s10);
        if (n10 < n11 && (n10 = (int)((iterator2 = this.a).hasNext() ? 1 : 0))) {
            n10 = 1;
        } else {
            n10 = 0;
            iterator2 = null;
        }
        return n10;
    }

    public Object next() {
        this.b();
        int n10 = this.b;
        s s10 = this.c;
        int n11 = s.c(s10);
        if (n10 < n11) {
            this.b = n10 = this.b + 1;
            return this.a.next();
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }

    public void remove() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }
}

