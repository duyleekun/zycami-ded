/*
 * Decompiled with CFR 0.151.
 */
package f.n2;

import f.h2.t.f0;
import f.n2.k$a;
import f.n2.m;
import java.util.Iterator;

public final class k
implements m {
    private final m a;

    public k(m m10) {
        f0.p(m10, "sequence");
        this.a = m10;
    }

    public static final /* synthetic */ m c(k k10) {
        return k10.a;
    }

    public Iterator iterator() {
        k$a k$a = new k$a(this);
        return k$a;
    }
}

