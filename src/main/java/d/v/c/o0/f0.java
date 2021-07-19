/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.o0;

import d.v.c.o0.u0;
import java.util.List;

public final class f0
implements Runnable {
    public final /* synthetic */ u0 a;
    public final /* synthetic */ List b;
    public final /* synthetic */ boolean c;

    public /* synthetic */ f0(u0 u02, List list, boolean bl2) {
        this.a = u02;
        this.b = list;
        this.c = bl2;
    }

    public final void run() {
        u0 u02 = this.a;
        List list = this.b;
        boolean bl2 = this.c;
        u02.m(list, bl2);
    }
}

