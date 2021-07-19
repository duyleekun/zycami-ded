/*
 * Decompiled with CFR 0.151.
 */
package d.v.n.l;

import d.v.n.l.d;

public final class b
implements Runnable {
    public final /* synthetic */ d a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;

    public /* synthetic */ b(d d10, String string2, String string3) {
        this.a = d10;
        this.b = string2;
        this.c = string3;
    }

    public final void run() {
        d d10 = this.a;
        String string2 = this.b;
        String string3 = this.c;
        d10.m(string2, string3);
    }
}

