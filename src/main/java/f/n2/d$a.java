/*
 * Decompiled with CFR 0.151.
 */
package f.n2;

import f.h2.t.x0.a;
import f.n2.d;
import java.util.Iterator;

public final class d$a
implements Iterator,
a {
    private final Iterator a;
    private int b;
    public final /* synthetic */ d c;

    public d$a(d d10) {
        int n10;
        Iterator iterator2;
        this.c = d10;
        this.a = iterator2 = d.d(d10).iterator();
        this.b = n10 = d.c(d10);
    }

    private final void b() {
        Iterator iterator2;
        int n10;
        while ((n10 = this.b) > 0 && (n10 = (int)((iterator2 = this.a).hasNext() ? 1 : 0)) != 0) {
            iterator2 = this.a;
            iterator2.next();
            this.b = n10 = this.b + -1;
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
        this.b();
        return this.a.hasNext();
    }

    public Object next() {
        this.b();
        return this.a.next();
    }

    public void remove() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }
}

