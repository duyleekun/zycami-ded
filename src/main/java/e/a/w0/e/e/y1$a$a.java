/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.w0.c.n;
import e.a.w0.e.e.y1$a;

public final class y1$a$a
implements Runnable {
    public final long a;
    public final y1$a b;

    public y1$a$a(long l10, y1$a a10) {
        this.a = l10;
        this.b = a10;
    }

    public void run() {
        y1$a y1$a = this.b;
        boolean bl2 = y1$a.i(y1$a);
        if (!bl2) {
            n n10 = y1$a.k(y1$a);
            n10.offer(this);
        } else {
            y1$a.V = bl2 = true;
        }
        bl2 = y1$a.b();
        if (bl2) {
            y1$a.m();
        }
    }
}

