/*
 * Decompiled with CFR 0.151.
 */
package f.x1;

import f.h2.t.f0;
import f.h2.t.x0.a;
import f.x1.k0;
import java.util.Iterator;

public final class j0
implements Iterable,
a {
    private final f.h2.s.a a;

    public j0(f.h2.s.a a10) {
        f0.p(a10, "iteratorFactory");
        this.a = a10;
    }

    public Iterator iterator() {
        Iterator iterator2 = (Iterator)this.a.invoke();
        k0 k02 = new k0(iterator2);
        return k02;
    }
}

