/*
 * Decompiled with CFR 0.151.
 */
package f.n2;

import f.h2.s.p;
import f.h2.t.f0;
import f.n2.l$a;
import f.n2.m;
import java.util.Iterator;

public final class l
implements m {
    private final m a;
    private final m b;
    private final p c;

    public l(m m10, m m11, p p10) {
        f0.p(m10, "sequence1");
        f0.p(m11, "sequence2");
        f0.p(p10, "transform");
        this.a = m10;
        this.b = m11;
        this.c = p10;
    }

    public static final /* synthetic */ m c(l l10) {
        return l10.a;
    }

    public static final /* synthetic */ m d(l l10) {
        return l10.b;
    }

    public static final /* synthetic */ p e(l l10) {
        return l10.c;
    }

    public Iterator iterator() {
        l$a l$a = new l$a(this);
        return l$a;
    }
}

