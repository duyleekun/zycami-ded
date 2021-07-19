/*
 * Decompiled with CFR 0.151.
 */
package f.n2;

import f.h2.s.l;
import f.h2.t.f0;
import f.n2.i$a;
import f.n2.m;
import java.util.Iterator;

public final class i
implements m {
    private final m a;
    private final l b;
    private final l c;

    public i(m m10, l l10, l l11) {
        f0.p(m10, "sequence");
        f0.p(l10, "transformer");
        f0.p(l11, "iterator");
        this.a = m10;
        this.b = l10;
        this.c = l11;
    }

    public static final /* synthetic */ l c(i i10) {
        return i10.c;
    }

    public static final /* synthetic */ m d(i i10) {
        return i10.a;
    }

    public static final /* synthetic */ l e(i i10) {
        return i10.b;
    }

    public Iterator iterator() {
        i$a i$a = new i$a(this);
        return i$a;
    }
}

