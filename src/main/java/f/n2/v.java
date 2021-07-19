/*
 * Decompiled with CFR 0.151.
 */
package f.n2;

import f.h2.s.p;
import f.h2.t.f0;
import f.n2.m;
import f.n2.v$a;
import java.util.Iterator;

public final class v
implements m {
    private final m a;
    private final p b;

    public v(m m10, p p10) {
        f0.p(m10, "sequence");
        f0.p(p10, "transformer");
        this.a = m10;
        this.b = p10;
    }

    public static final /* synthetic */ m c(v v10) {
        return v10.a;
    }

    public static final /* synthetic */ p d(v v10) {
        return v10.b;
    }

    public Iterator iterator() {
        v$a v$a = new v$a(this);
        return v$a;
    }
}

