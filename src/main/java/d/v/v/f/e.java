/*
 * Decompiled with CFR 0.151.
 */
package d.v.v.f;

import d.v.h.d.c;
import d.v.v.f.k;

public final class e
implements Runnable {
    public final /* synthetic */ k a;
    public final /* synthetic */ String b;
    public final /* synthetic */ c c;

    public /* synthetic */ e(k k10, String string2, c c10) {
        this.a = k10;
        this.b = string2;
        this.c = c10;
    }

    public final void run() {
        k k10 = this.a;
        String string2 = this.b;
        c c10 = this.c;
        k10.n(string2, c10);
    }
}

