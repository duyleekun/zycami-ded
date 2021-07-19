/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.o0;

import d.v.c.o0.u0;
import d.v.s.b.g$a;
import java.util.List;

public final class g0
implements Runnable {
    public final /* synthetic */ u0 a;
    public final /* synthetic */ List b;
    public final /* synthetic */ g$a c;

    public /* synthetic */ g0(u0 u02, List list, g$a g$a) {
        this.a = u02;
        this.b = list;
        this.c = g$a;
    }

    public final void run() {
        u0 u02 = this.a;
        List list = this.b;
        g$a g$a = this.c;
        u02.k(list, g$a);
    }
}

