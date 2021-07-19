/*
 * Decompiled with CFR 0.151.
 */
package f.n2;

import f.h2.t.x0.a;
import f.n2.k;
import f.x1.i0;
import java.util.Iterator;
import kotlin.collections.CollectionsKt__CollectionsKt;

public final class k$a
implements Iterator,
a {
    private final Iterator a;
    private int b;
    public final /* synthetic */ k c;

    public k$a(k object) {
        this.c = object;
        this.a = object = k.c((k)object).iterator();
    }

    public final int b() {
        return this.b;
    }

    public final Iterator c() {
        return this.a;
    }

    public i0 e() {
        int n10;
        int n11 = this.b;
        this.b = n10 = n11 + 1;
        if (n11 < 0) {
            CollectionsKt__CollectionsKt.W();
        }
        Object e10 = this.a.next();
        i0 i02 = new i0(n11, e10);
        return i02;
    }

    public final void f(int n10) {
        this.b = n10;
    }

    public boolean hasNext() {
        return this.a.hasNext();
    }

    public void remove() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }
}

