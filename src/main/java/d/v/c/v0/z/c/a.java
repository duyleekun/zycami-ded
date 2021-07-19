/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.v0.z.c;

import d.v.c.v0.z.c.b;

public final class a
implements Runnable {
    public final /* synthetic */ b a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;

    public /* synthetic */ a(b b10, String string2, String string3) {
        this.a = b10;
        this.b = string2;
        this.c = string3;
    }

    public final void run() {
        b b10 = this.a;
        String string2 = this.b;
        String string3 = this.c;
        b10.k(string2, string3);
    }
}

