/*
 * Decompiled with CFR 0.151.
 */
package d.v.n;

import d.v.n.i;

public final class d
implements Runnable {
    public final /* synthetic */ i a;
    public final /* synthetic */ String b;

    public /* synthetic */ d(i i10, String string2) {
        this.a = i10;
        this.b = string2;
    }

    public final void run() {
        i i10 = this.a;
        String string2 = this.b;
        i10.n(string2);
    }
}

