/*
 * Decompiled with CFR 0.151.
 */
package f.n2;

import f.h2.s.l;
import f.h2.t.f0;
import f.h2.t.u;
import f.n2.h$a;
import f.n2.m;
import java.util.Iterator;

public final class h
implements m {
    private final m a;
    private final boolean b;
    private final l c;

    public h(m m10, boolean bl2, l l10) {
        f0.p(m10, "sequence");
        f0.p(l10, "predicate");
        this.a = m10;
        this.b = bl2;
        this.c = l10;
    }

    public /* synthetic */ h(m m10, boolean bl2, l l10, int n10, u u10) {
        if ((n10 &= 2) != 0) {
            bl2 = true;
        }
        this(m10, bl2, l10);
    }

    public static final /* synthetic */ l c(h h10) {
        return h10.c;
    }

    public static final /* synthetic */ boolean d(h h10) {
        return h10.b;
    }

    public static final /* synthetic */ m e(h h10) {
        return h10.a;
    }

    public Iterator iterator() {
        h$a h$a = new h$a(this);
        return h$a;
    }
}

