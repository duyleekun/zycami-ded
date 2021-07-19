/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.c;

import e.a.a1.a;
import e.a.q;
import e.a.s0.b;
import e.a.s0.c;
import java.util.concurrent.Callable;

public final class t
extends q
implements Callable {
    public final Runnable a;

    public t(Runnable runnable) {
        this.a = runnable;
    }

    public Object call() {
        this.a.run();
        return null;
    }

    public void t1(e.a.t t10) {
        block6: {
            b b10 = c.b();
            t10.onSubscribe(b10);
            boolean bl2 = b10.isDisposed();
            if (!bl2) {
                Runnable runnable = this.a;
                try {
                    runnable.run();
                    boolean bl3 = b10.isDisposed();
                    if (!bl3) {
                        t10.onComplete();
                    }
                }
                catch (Throwable throwable) {
                    e.a.t0.a.b(throwable);
                    boolean bl4 = b10.isDisposed();
                    if (!bl4) {
                        t10.onError(throwable);
                        break block6;
                    }
                    e.a.a1.a.Y(throwable);
                }
            }
        }
    }
}

