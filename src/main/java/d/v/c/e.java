/*
 * Decompiled with CFR 0.151.
 */
package d.v.c;

import d.v.c.i0;

public final class e
implements Runnable {
    public final /* synthetic */ i0 a;
    public final /* synthetic */ int b;

    public /* synthetic */ e(i0 i02, int n10) {
        this.a = i02;
        this.b = n10;
    }

    public final void run() {
        i0 i02 = this.a;
        int n10 = this.b;
        i02.s(n10);
    }
}

