/*
 * Decompiled with CFR 0.151.
 */
package f.y1;

import f.h2.t.f0;
import java.util.Comparator;

public final class g
implements Comparator {
    private final Comparator a;

    public g(Comparator comparator) {
        f0.p(comparator, "comparator");
        this.a = comparator;
    }

    public final Comparator a() {
        return this.a;
    }

    public int compare(Object object, Object object2) {
        return this.a.compare(object2, object);
    }

    public final Comparator reversed() {
        return this.a;
    }
}

