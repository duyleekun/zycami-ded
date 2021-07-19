/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.e1;

import d.v.c.e1.u;
import d.v.h.f.a;
import java.util.List;
import java.util.function.IntPredicate;

public final class n
implements IntPredicate {
    public final /* synthetic */ a a;
    public final /* synthetic */ String b;
    public final /* synthetic */ List c;
    public final /* synthetic */ String d;

    public /* synthetic */ n(a a10, String string2, List list, String string3) {
        this.a = a10;
        this.b = string2;
        this.c = list;
        this.d = string3;
    }

    public final boolean test(int n10) {
        a a10 = this.a;
        String string2 = this.b;
        List list = this.c;
        String string3 = this.d;
        return u.I(a10, string2, list, string3, n10);
    }
}

