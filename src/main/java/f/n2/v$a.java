/*
 * Decompiled with CFR 0.151.
 */
package f.n2;

import f.h2.s.p;
import f.h2.t.x0.a;
import f.n2.v;
import java.util.Iterator;
import kotlin.collections.CollectionsKt__CollectionsKt;

public final class v$a
implements Iterator,
a {
    private final Iterator a;
    private int b;
    public final /* synthetic */ v c;

    public v$a(v object) {
        this.c = object;
        this.a = object = v.c((v)object).iterator();
    }

    public final int b() {
        return this.b;
    }

    public final Iterator c() {
        return this.a;
    }

    public final void e(int n10) {
        this.b = n10;
    }

    public boolean hasNext() {
        return this.a.hasNext();
    }

    public Object next() {
        int n10;
        p p10 = v.d(this.c);
        int n11 = this.b;
        this.b = n10 = n11 + 1;
        if (n11 < 0) {
            CollectionsKt__CollectionsKt.W();
        }
        Integer n12 = n11;
        Object e10 = this.a.next();
        return p10.invoke(n12, e10);
    }

    public void remove() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }
}

