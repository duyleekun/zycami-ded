/*
 * Decompiled with CFR 0.151.
 */
package f.n2;

import f.h2.s.l;
import f.h2.t.x0.a;
import f.n2.w;
import java.util.Iterator;

public final class w$a
implements Iterator,
a {
    private final Iterator a;
    public final /* synthetic */ w b;

    public w$a(w object) {
        this.b = object;
        this.a = object = w.c((w)object).iterator();
    }

    public final Iterator b() {
        return this.a;
    }

    public boolean hasNext() {
        return this.a.hasNext();
    }

    public Object next() {
        l l10 = w.d(this.b);
        Object e10 = this.a.next();
        return l10.invoke(e10);
    }

    public void remove() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }
}

