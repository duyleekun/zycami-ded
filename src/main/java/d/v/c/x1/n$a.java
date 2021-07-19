/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.x1;

import d.v.c.x1.n;
import d.v.c.x1.n$b;

public final class n$a
implements Runnable {
    public final /* synthetic */ n$b a;

    public n$a(n$b b10) {
        this.a = b10;
    }

    public void run() {
        boolean bl2;
        int n10;
        n.a(true);
        int n11 = 0;
        while (n11 <= (n10 = 100) && !(bl2 = n.b())) {
            n$b n$b = this.a;
            n$b.onProgress(n11);
            if (n11 >= n10) {
                n.a(false);
            }
            n11 += 5;
            long l10 = 500L;
            try {
                Thread.sleep(l10);
            }
            catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }
        n.a(false);
    }
}

