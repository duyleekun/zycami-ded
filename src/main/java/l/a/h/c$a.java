/*
 * Decompiled with CFR 0.151.
 */
package l.a.h;

import java.util.Iterator;
import java.util.NoSuchElementException;
import l.a.h.c;

public final class c$a
implements Iterator {
    public final int a;
    public int b;
    public int c;
    public boolean d = false;
    public final /* synthetic */ c e;

    public c$a(c c10, int n10) {
        int n11;
        this.e = c10;
        this.a = n10;
        this.b = n11 = c10.d();
    }

    public boolean hasNext() {
        int n10 = this.c;
        int n11 = this.b;
        n10 = n10 < n11 ? 1 : 0;
        return n10 != 0;
    }

    public Object next() {
        boolean bl2 = this.hasNext();
        if (bl2) {
            Object object = this.e;
            int n10 = this.c;
            int n11 = this.a;
            object = ((c)object).b(n10, n11);
            n10 = this.c;
            n11 = 1;
            this.c = n10 += n11;
            this.d = n11;
            return object;
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }

    public void remove() {
        int n10 = this.d;
        if (n10 != 0) {
            int n11;
            this.c = n10 = this.c + -1;
            this.b = n11 = this.b + -1;
            this.d = false;
            this.e.h(n10);
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException();
        throw illegalStateException;
    }
}

