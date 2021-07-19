/*
 * Decompiled with CFR 0.151.
 */
package f.n2;

import f.h2.s.l;
import f.h2.t.f0;
import f.n2.b;
import f.n2.m;
import java.util.Iterator;

public final class c
implements m {
    private final m a;
    private final l b;

    public c(m m10, l l10) {
        f0.p(m10, "source");
        f0.p(l10, "keySelector");
        this.a = m10;
        this.b = l10;
    }

    public Iterator iterator() {
        Iterator iterator2 = this.a.iterator();
        l l10 = this.b;
        b b10 = new b(iterator2, l10);
        return b10;
    }
}

