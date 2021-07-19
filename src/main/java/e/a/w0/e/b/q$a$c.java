/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.b;

import e.a.w0.e.b.q$a;
import i.g.d;

public final class q$a$c
implements Runnable {
    private final Object a;
    public final /* synthetic */ q$a b;

    public q$a$c(q$a q$a, Object object) {
        this.b = q$a;
        this.a = object;
    }

    public void run() {
        d d10 = this.b.a;
        Object object = this.a;
        d10.onNext(object);
    }
}

