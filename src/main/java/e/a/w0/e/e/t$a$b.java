/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.g0;
import e.a.w0.e.e.t$a;

public final class t$a$b
implements Runnable {
    private final Throwable a;
    public final /* synthetic */ t$a b;

    public t$a$b(t$a t$a, Throwable throwable) {
        this.b = t$a;
        this.a = throwable;
    }

    public void run() {
        try {
            g0 g02 = this.b;
            g02 = ((t$a)g02).a;
            Throwable throwable = this.a;
            g02.onError(throwable);
            return;
        }
        finally {
            this.b.d.dispose();
        }
    }
}

