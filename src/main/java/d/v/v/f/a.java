/*
 * Decompiled with CFR 0.151.
 */
package d.v.v.f;

import d.v.h.d.c;
import d.v.v.f.j;

public final class a
implements Runnable {
    public final /* synthetic */ j a;
    public final /* synthetic */ c b;
    public final /* synthetic */ String c;
    public final /* synthetic */ long d;

    public /* synthetic */ a(j j10, c c10, String string2, long l10) {
        this.a = j10;
        this.b = c10;
        this.c = string2;
        this.d = l10;
    }

    public final void run() {
        j j10 = this.a;
        c c10 = this.b;
        String string2 = this.c;
        long l10 = this.d;
        j10.L(c10, string2, l10);
    }
}

