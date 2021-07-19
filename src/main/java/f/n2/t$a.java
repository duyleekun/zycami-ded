/*
 * Decompiled with CFR 0.151.
 */
package f.n2;

import f.h2.t.x0.a;
import f.n2.t;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class t$a
implements Iterator,
a {
    private int a;
    private final Iterator b;
    public final /* synthetic */ t c;

    public t$a(t object) {
        int n10;
        this.c = object;
        this.a = n10 = t.c((t)object);
        this.b = object = t.d((t)object).iterator();
    }

    public final Iterator b() {
        return this.b;
    }

    public final int c() {
        return this.a;
    }

    public final void e(int n10) {
        this.a = n10;
    }

    public boolean hasNext() {
        Iterator iterator2;
        int n10 = this.a;
        if (n10 > 0 && (n10 = (int)((iterator2 = this.b).hasNext() ? 1 : 0))) {
            n10 = 1;
        } else {
            n10 = 0;
            iterator2 = null;
        }
        return n10 != 0;
    }

    public Object next() {
        int n10 = this.a;
        if (n10 != 0) {
            this.a = n10 += -1;
            return this.b.next();
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }

    public void remove() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }
}

