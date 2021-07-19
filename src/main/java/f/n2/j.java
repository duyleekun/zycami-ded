/*
 * Decompiled with CFR 0.151.
 */
package f.n2;

import f.h2.s.a;
import f.h2.s.l;
import f.h2.t.f0;
import f.n2.j$a;
import f.n2.m;
import java.util.Iterator;

public final class j
implements m {
    private final a a;
    private final l b;

    public j(a a10, l l10) {
        f0.p(a10, "getInitialValue");
        f0.p(l10, "getNextValue");
        this.a = a10;
        this.b = l10;
    }

    public static final /* synthetic */ a c(j j10) {
        return j10.a;
    }

    public static final /* synthetic */ l d(j j10) {
        return j10.b;
    }

    public Iterator iterator() {
        j$a j$a = new j$a(this);
        return j$a;
    }
}

