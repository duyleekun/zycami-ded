/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.b;

import e.a.w0.e.b.q$a;
import i.g.d;

public final class q$a$a
implements Runnable {
    public final /* synthetic */ q$a a;

    public q$a$a(q$a a10) {
        this.a = a10;
    }

    public void run() {
        try {
            d d10 = this.a;
            d10 = ((q$a)d10).a;
            d10.onComplete();
            return;
        }
        finally {
            this.a.d.dispose();
        }
    }
}

