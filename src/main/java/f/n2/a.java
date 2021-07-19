/*
 * Decompiled with CFR 0.151.
 */
package f.n2;

import f.h2.t.f0;
import f.n2.m;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

public final class a
implements m {
    private final AtomicReference a;

    public a(m m10) {
        AtomicReference<m> atomicReference;
        f0.p(m10, "sequence");
        this.a = atomicReference = new AtomicReference<m>(m10);
    }

    public Iterator iterator() {
        Object object = this.a.getAndSet(null);
        if (object != null) {
            return object.iterator();
        }
        object = new IllegalStateException("This sequence can be consumed only once.");
        throw object;
    }
}

