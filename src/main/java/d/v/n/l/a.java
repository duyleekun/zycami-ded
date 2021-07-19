/*
 * Decompiled with CFR 0.151.
 */
package d.v.n.l;

import d.v.n.l.d;

public final class a
implements Runnable {
    public final /* synthetic */ d a;
    public final /* synthetic */ String b;

    public /* synthetic */ a(d d10, String string2) {
        this.a = d10;
        this.b = string2;
    }

    public final void run() {
        d d10 = this.a;
        String string2 = this.b;
        d10.o(string2);
    }
}

