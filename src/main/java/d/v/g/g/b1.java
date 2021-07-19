/*
 * Decompiled with CFR 0.151.
 */
package d.v.g.g;

import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

public final class b1
implements Predicate {
    public static final /* synthetic */ b1 a;

    static {
        b1 b12;
        a = b12 = new b1();
    }

    public final boolean test(Object object) {
        return Objects.nonNull((Map.Entry)object);
    }
}

