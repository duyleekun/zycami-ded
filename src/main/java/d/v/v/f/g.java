/*
 * Decompiled with CFR 0.151.
 */
package d.v.v.f;

import d.v.h.d.c;
import d.v.v.f.k;

public final class g
implements Runnable {
    public final /* synthetic */ k a;
    public final /* synthetic */ c b;
    public final /* synthetic */ String c;
    public final /* synthetic */ long d;

    public /* synthetic */ g(k k10, c c10, String string2, long l10) {
        this.a = k10;
        this.b = c10;
        this.c = string2;
        this.d = l10;
    }

    public final void run() {
        k k10 = this.a;
        c c10 = this.b;
        String string2 = this.c;
        long l10 = this.d;
        k10.p(c10, string2, l10);
    }
}

