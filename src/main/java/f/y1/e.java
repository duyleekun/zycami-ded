/*
 * Decompiled with CFR 0.151.
 */
package f.y1;

import f.h2.t.f0;
import f.y1.f;
import java.util.Comparator;

public final class e
implements Comparator {
    public static final e a;

    static {
        e e10;
        a = e10 = new e();
    }

    private e() {
    }

    public int a(Comparable comparable, Comparable comparable2) {
        f0.p(comparable, "a");
        f0.p(comparable2, "b");
        return comparable.compareTo(comparable2);
    }

    public final Comparator reversed() {
        return f.a;
    }
}

