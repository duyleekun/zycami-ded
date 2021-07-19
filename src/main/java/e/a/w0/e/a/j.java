/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.a;

import e.a.a;
import e.a.d;
import e.a.s0.b;
import e.a.s0.c;
import java.util.concurrent.Callable;

public final class j
extends a {
    public final Callable a;

    public j(Callable callable) {
        this.a = callable;
    }

    public void L0(d d10) {
        Callable callable;
        b b10 = c.b();
        d10.onSubscribe(b10);
        try {
            callable = this.a;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            boolean bl2 = b10.isDisposed();
            if (!bl2) {
                d10.onError(throwable);
            } else {
                e.a.a1.a.Y(throwable);
            }
            return;
        }
        callable.call();
        boolean bl3 = b10.isDisposed();
        if (!bl3) {
            d10.onComplete();
        }
    }
}

