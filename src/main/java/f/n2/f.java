/*
 * Decompiled with CFR 0.151.
 */
package f.n2;

import f.h2.s.l;
import f.h2.t.f0;
import f.n2.f$a;
import f.n2.m;
import java.util.Iterator;

public final class f
implements m {
    private final m a;
    private final l b;

    public f(m m10, l l10) {
        f0.p(m10, "sequence");
        f0.p(l10, "predicate");
        this.a = m10;
        this.b = l10;
    }

    public static final /* synthetic */ l c(f f10) {
        return f10.b;
    }

    public static final /* synthetic */ m d(f f10) {
        return f10.a;
    }

    public Iterator iterator() {
        f$a f$a = new f$a(this);
        return f$a;
    }
}

