/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.v0.y.b;

import d.v.c.v0.y.b.e;

public final class c
implements Runnable {
    public final /* synthetic */ e a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;

    public /* synthetic */ c(e e10, String string2, String string3) {
        this.a = e10;
        this.b = string2;
        this.c = string3;
    }

    public final void run() {
        e e10 = this.a;
        String string2 = this.b;
        String string3 = this.c;
        e10.x(string2, string3);
    }
}

