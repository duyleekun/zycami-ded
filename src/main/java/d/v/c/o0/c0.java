/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.o0;

import d.v.c.o0.u0;
import java.util.List;

public final class c0
implements Runnable {
    public final /* synthetic */ u0 a;
    public final /* synthetic */ List b;

    public /* synthetic */ c0(u0 u02, List list) {
        this.a = u02;
        this.b = list;
    }

    public final void run() {
        u0 u02 = this.a;
        List list = this.b;
        u02.o(list);
    }
}

