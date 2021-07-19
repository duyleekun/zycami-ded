/*
 * Decompiled with CFR 0.151.
 */
package f.n2;

import f.h2.s.l;
import f.h2.t.f0;
import f.n2.m;
import f.n2.u$a;
import java.util.Iterator;

public final class u
implements m {
    private final m a;
    private final l b;

    public u(m m10, l l10) {
        f0.p(m10, "sequence");
        f0.p(l10, "predicate");
        this.a = m10;
        this.b = l10;
    }

    public static final /* synthetic */ l c(u u10) {
        return u10.b;
    }

    public static final /* synthetic */ m d(u u10) {
        return u10.a;
    }

    public Iterator iterator() {
        u$a u$a = new u$a(this);
        return u$a;
    }
}

