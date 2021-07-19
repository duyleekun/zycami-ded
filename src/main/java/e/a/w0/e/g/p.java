/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.g;

import e.a.i0;
import e.a.l0;
import e.a.s0.b;
import e.a.s0.c;
import e.a.w0.b.a;
import java.util.concurrent.Callable;

public final class p
extends i0 {
    public final Callable a;

    public p(Callable callable) {
        this.a = callable;
    }

    public void e1(l0 l02) {
        Object object;
        b b10 = c.b();
        l02.onSubscribe(b10);
        boolean bl2 = b10.isDisposed();
        if (bl2) {
            return;
        }
        try {
            object = this.a;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            boolean bl3 = b10.isDisposed();
            if (!bl3) {
                l02.onError(throwable);
            } else {
                e.a.a1.a.Y(throwable);
            }
            return;
        }
        object = object.call();
        String string2 = "The callable returned a null value";
        object = e.a.w0.b.a.g(object, string2);
        boolean bl4 = b10.isDisposed();
        if (!bl4) {
            l02.onSuccess(object);
        }
    }
}

