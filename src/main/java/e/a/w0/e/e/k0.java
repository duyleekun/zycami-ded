/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.g0;
import e.a.w0.b.a;
import e.a.z;
import io.reactivex.internal.observers.DeferredScalarDisposable;
import java.util.concurrent.Callable;

public final class k0
extends z
implements Callable {
    public final Callable a;

    public k0(Callable callable) {
        this.a = callable;
    }

    public void K5(g0 object) {
        Callable callable;
        DeferredScalarDisposable deferredScalarDisposable = new DeferredScalarDisposable((g0)object);
        object.onSubscribe(deferredScalarDisposable);
        boolean bl2 = deferredScalarDisposable.isDisposed();
        if (bl2) {
            return;
        }
        try {
            callable = this.a;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            boolean bl3 = deferredScalarDisposable.isDisposed();
            if (!bl3) {
                object.onError(throwable);
            } else {
                e.a.a1.a.Y(throwable);
            }
            return;
        }
        callable = callable.call();
        String string2 = "Callable returned null";
        object = e.a.w0.b.a.g(callable, string2);
        deferredScalarDisposable.complete(object);
    }

    public Object call() {
        return e.a.w0.b.a.g(this.a.call(), "The callable returned a null value");
    }
}

