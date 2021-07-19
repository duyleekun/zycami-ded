/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.b;

import e.a.w0.c.n;
import e.a.w0.e.b.k1$a;

public final class k1$a$a
implements Runnable {
    public final long a;
    public final k1$a b;

    public k1$a$a(long l10, k1$a a10) {
        this.a = l10;
        this.b = a10;
    }

    public void run() {
        k1$a k1$a = this.b;
        boolean bl2 = k1$a.k(k1$a);
        if (!bl2) {
            n n10 = k1$a.l(k1$a);
            n10.offer(this);
        } else {
            k1$a.y0 = bl2 = true;
        }
        bl2 = k1$a.b();
        if (bl2) {
            k1$a.o();
        }
    }
}

