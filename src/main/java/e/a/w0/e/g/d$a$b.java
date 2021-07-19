/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.g;

import e.a.l0;
import e.a.w0.e.g.d$a;

public final class d$a$b
implements Runnable {
    private final Object a;
    public final /* synthetic */ d$a b;

    public d$a$b(d$a d$a, Object object) {
        this.b = d$a;
        this.a = object;
    }

    public void run() {
        l0 l02 = this.b.b;
        Object object = this.a;
        l02.onSuccess(object);
    }
}

