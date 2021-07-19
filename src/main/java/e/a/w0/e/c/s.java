/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.c;

import e.a.q;
import e.a.s0.b;
import e.a.s0.c;
import e.a.t;
import e.a.t0.a;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public final class s
extends q {
    public final Future a;
    public final long b;
    public final TimeUnit c;

    public s(Future future, long l10, TimeUnit timeUnit) {
        this.a = future;
        this.b = l10;
        this.c = timeUnit;
    }

    public void t1(t t10) {
        block14: {
            b b10 = e.a.s0.c.b();
            t10.onSubscribe(b10);
            boolean bl2 = b10.isDisposed();
            if (!bl2) {
                Future future;
                block13: {
                    long l10;
                    block12: {
                        l10 = this.b;
                        long l11 = 0L;
                        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
                        if (l12 > 0) break block12;
                        future = this.a;
                        future = future.get();
                        break block13;
                    }
                    Future future2 = this.a;
                    TimeUnit timeUnit = this.c;
                    try {
                        future = future2.get(l10, timeUnit);
                    }
                    catch (Throwable throwable) {
                        Throwable throwable2;
                        boolean bl3 = throwable instanceof ExecutionException;
                        if (bl3) {
                            throwable2 = throwable.getCause();
                        }
                        e.a.t0.a.b(throwable2);
                        boolean bl4 = b10.isDisposed();
                        if (bl4) break block14;
                        t10.onError(throwable2);
                    }
                }
                boolean bl5 = b10.isDisposed();
                if (!bl5) {
                    if (future == null) {
                        t10.onComplete();
                    } else {
                        t10.onSuccess(future);
                    }
                }
            }
        }
    }
}

