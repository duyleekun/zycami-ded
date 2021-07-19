/*
 * Decompiled with CFR 0.151.
 */
package d.v.j.e.i;

import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public final class s0
implements Predicate {
    public static final /* synthetic */ s0 a;

    static {
        s0 s02;
        a = s02 = new s0();
    }

    public final boolean test(Object object) {
        return Objects.nonNull((List)object);
    }
}

