/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.a;

import e.a.a;
import e.a.d;
import e.a.s0.b;
import e.a.s0.c;

public final class i
extends a {
    public final e.a.v0.a a;

    public i(e.a.v0.a a10) {
        this.a = a10;
    }

    public void L0(d d10) {
        e.a.v0.a a10;
        b b10 = c.b();
        d10.onSubscribe(b10);
        try {
            a10 = this.a;
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
        a10.run();
        boolean bl3 = b10.isDisposed();
        if (!bl3) {
            d10.onComplete();
        }
    }
}

