/*
 * Decompiled with CFR 0.151.
 */
package f.n2;

import f.h2.s.p;
import f.h2.t.x0.a;
import f.n2.l;
import java.util.Iterator;

public final class l$a
implements Iterator,
a {
    private final Iterator a;
    private final Iterator b;
    public final /* synthetic */ l c;

    public l$a(l object) {
        Iterator iterator2;
        this.c = object;
        this.a = iterator2 = l.c((l)object).iterator();
        this.b = object = l.d((l)object).iterator();
    }

    public final Iterator b() {
        return this.a;
    }

    public final Iterator c() {
        return this.b;
    }

    public boolean hasNext() {
        Iterator iterator2 = this.a;
        boolean bl2 = iterator2.hasNext();
        if (bl2 && (bl2 = (iterator2 = this.b).hasNext())) {
            bl2 = true;
        } else {
            bl2 = false;
            iterator2 = null;
        }
        return bl2;
    }

    public Object next() {
        p p10 = l.e(this.c);
        Object e10 = this.a.next();
        Object e11 = this.b.next();
        return p10.invoke(e10, e11);
    }

    public void remove() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }
}

