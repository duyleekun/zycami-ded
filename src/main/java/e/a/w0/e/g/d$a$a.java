/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.g;

import e.a.l0;
import e.a.w0.e.g.d$a;

public final class d$a$a
implements Runnable {
    private final Throwable a;
    public final /* synthetic */ d$a b;

    public d$a$a(d$a a10, Throwable throwable) {
        this.b = a10;
        this.a = throwable;
    }

    public void run() {
        l0 l02 = this.b.b;
        Throwable throwable = this.a;
        l02.onError(throwable);
    }
}

