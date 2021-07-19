/*
 * Decompiled with CFR 0.151.
 */
package f.n2;

import f.h2.s.l;
import f.h2.t.f0;
import f.n2.i;
import f.n2.m;
import f.n2.w$a;
import java.util.Iterator;

public final class w
implements m {
    private final m a;
    private final l b;

    public w(m m10, l l10) {
        f0.p(m10, "sequence");
        f0.p(l10, "transformer");
        this.a = m10;
        this.b = l10;
    }

    public static final /* synthetic */ m c(w w10) {
        return w10.a;
    }

    public static final /* synthetic */ l d(w w10) {
        return w10.b;
    }

    public final m e(l l10) {
        f0.p(l10, "iterator");
        m m10 = this.a;
        l l11 = this.b;
        i i10 = new i(m10, l11, l10);
        return i10;
    }

    public Iterator iterator() {
        w$a w$a = new w$a(this);
        return w$a;
    }
}

