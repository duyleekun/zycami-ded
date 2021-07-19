/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.v0.r.b;

import d.v.c.v0.r.b.g;

public final class d
implements Runnable {
    public final /* synthetic */ g a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;

    public /* synthetic */ d(g g10, String string2, String string3) {
        this.a = g10;
        this.b = string2;
        this.c = string3;
    }

    public final void run() {
        g g10 = this.a;
        String string2 = this.b;
        String string3 = this.c;
        g10.D(string2, string3);
    }
}

