/*
 * Decompiled with CFR 0.151.
 */
package f.x1;

import f.h2.t.f0;
import f.h2.t.x0.a;
import f.x1.i0;
import java.util.Iterator;
import kotlin.collections.CollectionsKt__CollectionsKt;

public final class k0
implements Iterator,
a {
    private int a;
    private final Iterator b;

    public k0(Iterator iterator2) {
        f0.p(iterator2, "iterator");
        this.b = iterator2;
    }

    public final i0 b() {
        int n10;
        int n11 = this.a;
        this.a = n10 = n11 + 1;
        if (n11 < 0) {
            CollectionsKt__CollectionsKt.W();
        }
        Object e10 = this.b.next();
        i0 i02 = new i0(n11, e10);
        return i02;
    }

    public final boolean hasNext() {
        return this.b.hasNext();
    }

    public void remove() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }
}

