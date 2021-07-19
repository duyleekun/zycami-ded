/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.d1;

import d.v.c.d1.e;
import d.v.c.d1.h;
import java.util.List;
import java.util.function.IntPredicate;

public final class b
implements IntPredicate {
    public final /* synthetic */ List a;
    public final /* synthetic */ e b;

    public /* synthetic */ b(List list, e e10) {
        this.a = list;
        this.b = e10;
    }

    public final boolean test(int n10) {
        List list = this.a;
        e e10 = this.b;
        return h.r(list, e10, n10);
    }
}

