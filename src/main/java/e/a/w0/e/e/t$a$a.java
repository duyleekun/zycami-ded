/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.g0;
import e.a.w0.e.e.t$a;

public final class t$a$a
implements Runnable {
    public final /* synthetic */ t$a a;

    public t$a$a(t$a a10) {
        this.a = a10;
    }

    public void run() {
        try {
            g0 g02 = this.a;
            g02 = ((t$a)g02).a;
            g02.onComplete();
            return;
        }
        finally {
            this.a.d.dispose();
        }
    }
}

