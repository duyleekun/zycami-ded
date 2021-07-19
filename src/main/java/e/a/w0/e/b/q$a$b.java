/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.b;

import e.a.w0.e.b.q$a;
import i.g.d;

public final class q$a$b
implements Runnable {
    private final Throwable a;
    public final /* synthetic */ q$a b;

    public q$a$b(q$a q$a, Throwable throwable) {
        this.b = q$a;
        this.a = throwable;
    }

    public void run() {
        try {
            d d10 = this.b;
            d10 = ((q$a)d10).a;
            Throwable throwable = this.a;
            d10.onError(throwable);
            return;
        }
        finally {
            this.b.d.dispose();
        }
    }
}

