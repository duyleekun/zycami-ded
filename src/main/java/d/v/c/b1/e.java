/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.b1;

import d.v.c.b1.s;

public final class e
implements Runnable {
    public final /* synthetic */ s a;
    public final /* synthetic */ long b;

    public /* synthetic */ e(s s10, long l10) {
        this.a = s10;
        this.b = l10;
    }

    public final void run() {
        s s10 = this.a;
        long l10 = this.b;
        s10.k(l10);
    }
}

