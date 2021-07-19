/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.a;

import e.a.d;
import e.a.s0.b;
import e.a.w0.e.a.x$a;

public final class x$a$a
implements d {
    public final /* synthetic */ x$a a;

    public x$a$a(x$a x$a) {
        this.a = x$a;
    }

    public void onComplete() {
        this.a.b.dispose();
        this.a.c.onComplete();
    }

    public void onError(Throwable throwable) {
        this.a.b.dispose();
        this.a.c.onError(throwable);
    }

    public void onSubscribe(b b10) {
        this.a.b.b(b10);
    }
}

