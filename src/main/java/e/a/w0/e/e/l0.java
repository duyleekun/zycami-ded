/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.g0;
import e.a.w0.b.a;
import e.a.z;
import io.reactivex.internal.observers.DeferredScalarDisposable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public final class l0
extends z {
    public final Future a;
    public final long b;
    public final TimeUnit c;

    public l0(Future future, long l10, TimeUnit timeUnit) {
        this.a = future;
        this.b = l10;
        this.c = timeUnit;
    }

    public void K5(g0 object) {
        block11: {
            DeferredScalarDisposable deferredScalarDisposable = new DeferredScalarDisposable((g0)object);
            object.onSubscribe(deferredScalarDisposable);
            boolean bl2 = deferredScalarDisposable.isDisposed();
            if (!bl2) {
                Object object2;
                Object object3;
                block10: {
                    block9: {
                        object3 = this.c;
                        if (object3 == null) break block9;
                        object2 = this.a;
                        long l10 = this.b;
                        object3 = object2.get(l10, (TimeUnit)((Object)object3));
                        break block10;
                    }
                    object3 = this.a;
                    object3 = object3.get();
                }
                object2 = "Future returned null";
                try {
                    object = e.a.w0.b.a.g(object3, (String)object2);
                    deferredScalarDisposable.complete(object);
                }
                catch (Throwable throwable) {
                    e.a.t0.a.b(throwable);
                    boolean bl3 = deferredScalarDisposable.isDisposed();
                    if (bl3) break block11;
                    object.onError(throwable);
                }
            }
        }
    }
}

