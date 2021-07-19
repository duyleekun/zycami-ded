/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.g0;
import e.a.w0.e.e.t$a;

public final class t$a$c
implements Runnable {
    private final Object a;
    public final /* synthetic */ t$a b;

    public t$a$c(t$a t$a, Object object) {
        this.b = t$a;
        this.a = object;
    }

    public void run() {
        g0 g02 = this.b.a;
        Object object = this.a;
        g02.onNext(object);
    }
}

