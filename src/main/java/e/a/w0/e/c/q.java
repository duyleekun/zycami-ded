/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.c;

import e.a.a1.a;
import e.a.s0.b;
import e.a.s0.c;
import e.a.t;
import java.util.concurrent.Callable;

public final class q
extends e.a.q
implements Callable {
    public final Callable a;

    public q(Callable callable) {
        this.a = callable;
    }

    public Object call() {
        return this.a.call();
    }

    public void t1(t t10) {
        block8: {
            b b10 = c.b();
            t10.onSubscribe(b10);
            boolean bl2 = b10.isDisposed();
            if (!bl2) {
                Callable callable = this.a;
                try {
                    callable = callable.call();
                    boolean bl3 = b10.isDisposed();
                    if (!bl3) {
                        if (callable == null) {
                            t10.onComplete();
                        } else {
                            t10.onSuccess(callable);
                        }
                    }
                }
                catch (Throwable throwable) {
                    e.a.t0.a.b(throwable);
                    boolean bl4 = b10.isDisposed();
                    if (!bl4) {
                        t10.onError(throwable);
                        break block8;
                    }
                    e.a.a1.a.Y(throwable);
                }
            }
        }
    }
}

