/*
 * Decompiled with CFR 0.151.
 */
package d.v.v.f;

import d.v.h.d.c;
import d.v.v.f.j;

public final class b
implements Runnable {
    public final /* synthetic */ j a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ c c;
    public final /* synthetic */ String d;
    public final /* synthetic */ long e;

    public /* synthetic */ b(j j10, boolean bl2, c c10, String string2, long l10) {
        this.a = j10;
        this.b = bl2;
        this.c = c10;
        this.d = string2;
        this.e = l10;
    }

    public final void run() {
        j j10 = this.a;
        boolean bl2 = this.b;
        c c10 = this.c;
        String string2 = this.d;
        long l10 = this.e;
        j10.N(bl2, c10, string2, l10);
    }
}

