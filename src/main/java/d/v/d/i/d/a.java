/*
 * Decompiled with CFR 0.151.
 */
package d.v.d.i.d;

import d.v.d.i.d.c;

public final class a
implements Runnable {
    public final /* synthetic */ c a;
    public final /* synthetic */ byte[] b;

    public /* synthetic */ a(c c10, byte[] byArray) {
        this.a = c10;
        this.b = byArray;
    }

    public final void run() {
        c c10 = this.a;
        byte[] byArray = this.b;
        c10.s(byArray);
    }
}

