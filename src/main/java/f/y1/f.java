/*
 * Decompiled with CFR 0.151.
 */
package f.y1;

import f.h2.t.f0;
import f.y1.e;
import java.util.Comparator;

public final class f
implements Comparator {
    public static final f a;

    static {
        f f10;
        a = f10 = new f();
    }

    private f() {
    }

    public int a(Comparable comparable, Comparable comparable2) {
        f0.p(comparable, "a");
        f0.p(comparable2, "b");
        return comparable2.compareTo(comparable);
    }

    public final Comparator reversed() {
        return e.a;
    }
}

