/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.h7;

import d.v.c.s0.h7.k0;
import d.v.j.e.i.c1;
import java.util.List;
import java.util.function.IntFunction;

public final class h
implements IntFunction {
    public final /* synthetic */ c1 a;
    public final /* synthetic */ List b;

    public /* synthetic */ h(c1 c12, List list) {
        this.a = c12;
        this.b = list;
    }

    public final Object apply(int n10) {
        c1 c12 = this.a;
        List list = this.b;
        return k0.z(c12, list, n10);
    }
}

