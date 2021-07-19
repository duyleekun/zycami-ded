/*
 * Decompiled with CFR 0.151.
 */
package f.n2;

import f.h2.s.l;
import f.h2.t.f0;
import f.h2.t.x0.a;
import f.n2.i;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class i$a
implements Iterator,
a {
    private final Iterator a;
    private Iterator b;
    public final /* synthetic */ i c;

    public i$a(i object) {
        this.c = object;
        this.a = object = i.d((i)object).iterator();
    }

    private final boolean b() {
        boolean bl2;
        block3: {
            l l10;
            boolean bl3;
            boolean bl4;
            Object object = this.b;
            if (object != null && !(bl4 = object.hasNext())) {
                bl4 = false;
                object = null;
                this.b = null;
            }
            do {
                object = this.b;
                bl2 = true;
                if (object != null) break block3;
                object = this.a;
                bl4 = object.hasNext();
                if (!bl4) {
                    return false;
                }
                object = this.a.next();
                l10 = i.c(this.c);
                l l11 = i.e(this.c);
                object = l11.invoke(object);
            } while (!(bl3 = (object = (Iterator)l10.invoke(object)).hasNext()));
            this.b = object;
        }
        return bl2;
    }

    public final Iterator c() {
        return this.b;
    }

    public final Iterator e() {
        return this.a;
    }

    public final void f(Iterator iterator2) {
        this.b = iterator2;
    }

    public boolean hasNext() {
        return this.b();
    }

    public Object next() {
        boolean bl2 = this.b();
        if (bl2) {
            Iterator iterator2 = this.b;
            f0.m(iterator2);
            return iterator2.next();
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }

    public void remove() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }
}

