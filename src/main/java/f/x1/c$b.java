/*
 * Decompiled with CFR 0.151.
 */
package f.x1;

import f.h2.t.x0.a;
import f.x1.c;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class c$b
implements Iterator,
a {
    private int a;
    public final /* synthetic */ c b;

    public c$b(c c10) {
        this.b = c10;
    }

    public final int b() {
        return this.a;
    }

    public final void c(int n10) {
        this.a = n10;
    }

    public boolean hasNext() {
        int n10 = this.a;
        c c10 = this.b;
        int n11 = c10.size();
        n10 = n10 < n11 ? 1 : 0;
        return n10 != 0;
    }

    public Object next() {
        boolean bl2 = this.hasNext();
        if (bl2) {
            int n10;
            c c10 = this.b;
            int n11 = this.a;
            this.a = n10 = n11 + 1;
            return c10.get(n11);
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }

    public void remove() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }
}

