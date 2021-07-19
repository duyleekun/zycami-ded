/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.a;

import e.a.a;
import e.a.d;
import e.a.s0.b;
import e.a.s0.c;

public final class m
extends a {
    public final Runnable a;

    public m(Runnable runnable) {
        this.a = runnable;
    }

    public void L0(d d10) {
        Runnable runnable;
        b b10 = c.b();
        d10.onSubscribe(b10);
        try {
            runnable = this.a;
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
        runnable.run();
        boolean bl3 = b10.isDisposed();
        if (!bl3) {
            d10.onComplete();
        }
    }
}

