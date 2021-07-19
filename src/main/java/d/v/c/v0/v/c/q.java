/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.v0.v.c;

import d.v.c.v0.v.c.s;

public final class q
implements Runnable {
    public final /* synthetic */ s a;
    public final /* synthetic */ long b;

    public /* synthetic */ q(s s10, long l10) {
        this.a = s10;
        this.b = l10;
    }

    public final void run() {
        s s10 = this.a;
        long l10 = this.b;
        s10.X(l10);
    }
}

