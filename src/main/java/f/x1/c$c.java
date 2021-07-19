/*
 * Decompiled with CFR 0.151.
 */
package f.x1;

import f.h2.t.x0.a;
import f.x1.c;
import f.x1.c$a;
import f.x1.c$b;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class c$c
extends c$b
implements ListIterator,
a {
    public final /* synthetic */ c c;

    public c$c(c c10, int n10) {
        this.c = c10;
        super(c10);
        c$a c$a = f.x1.c.a;
        int n11 = c10.size();
        c$a.c(n10, n11);
        this.c(n10);
    }

    public void add(Object object) {
        object = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw object;
    }

    public boolean hasPrevious() {
        int n10 = this.b();
        n10 = n10 > 0 ? 1 : 0;
        return n10 != 0;
    }

    public int nextIndex() {
        return this.b();
    }

    public Object previous() {
        boolean bl2 = this.hasPrevious();
        if (bl2) {
            c c10 = this.c;
            int n10 = this.b() + -1;
            this.c(n10);
            n10 = this.b();
            return c10.get(n10);
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }

    public int previousIndex() {
        return this.b() + -1;
    }

    public void set(Object object) {
        object = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw object;
    }
}

