/*
 * Decompiled with CFR 0.151.
 */
package f.n2;

import f.h2.t.x0.a;
import f.n2.f;
import java.util.Iterator;

public final class f$a
implements Iterator,
a {
    private final Iterator a;
    private int b;
    private Object c;
    public final /* synthetic */ f d;

    public f$a(f object) {
        this.d = object;
        this.a = object = f.d((f)object).iterator();
        this.b = -1;
    }

    private final void b() {
        Iterator iterator2;
        boolean bl2;
        while (bl2 = (iterator2 = this.a).hasNext()) {
            iterator2 = this.a.next();
            Boolean bl3 = (Boolean)f.c(this.d).invoke(iterator2);
            boolean bl4 = bl3;
            if (bl4) continue;
            this.c = iterator2;
            this.b = 1;
            return;
        }
        this.b = 0;
    }

    public final int c() {
        return this.b;
    }

    public final Iterator e() {
        return this.a;
    }

    public final Object f() {
        return this.c;
    }

    public final void g(int n10) {
        this.b = n10;
    }

    public final void h(Object object) {
        this.c = object;
    }

    public boolean hasNext() {
        Iterator iterator2;
        int n10 = this.b;
        int n11 = -1;
        if (n10 == n11) {
            this.b();
        }
        if ((n10 = this.b) != (n11 = 1) && !(n10 = (iterator2 = this.a).hasNext())) {
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
        if ((n10 = this.b) == (n11 = 1)) {
            Object object = this.c;
            this.c = null;
            this.b = 0;
            return object;
        }
        return this.a.next();
    }

    public void remove() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }
}

