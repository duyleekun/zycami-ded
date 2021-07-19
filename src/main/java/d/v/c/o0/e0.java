/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.o0;

import d.v.c.o0.u0;
import java.util.List;
import java.util.function.IntPredicate;

public final class e0
implements IntPredicate {
    public final /* synthetic */ List a;

    public /* synthetic */ e0(List list) {
        this.a = list;
    }

    public final boolean test(int n10) {
        return u0.r(this.a, n10);
    }
}

