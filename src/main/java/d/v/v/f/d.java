/*
 * Decompiled with CFR 0.151.
 */
package d.v.v.f;

import d.v.h.d.c;
import d.v.v.f.j;

public final class d
implements Runnable {
    public final /* synthetic */ j a;
    public final /* synthetic */ String b;
    public final /* synthetic */ c c;

    public /* synthetic */ d(j j10, String string2, c c10) {
        this.a = j10;
        this.b = string2;
        this.c = c10;
    }

    public final void run() {
        j j10 = this.a;
        String string2 = this.b;
        c c10 = this.c;
        j10.J(string2, c10);
    }
}

