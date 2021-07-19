/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.b;

import e.a.j;
import e.a.w0.b.a;
import i.g.d;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import java.util.concurrent.Callable;

public final class e0
extends j
implements Callable {
    public final Callable b;

    public e0(Callable callable) {
        this.b = callable;
    }

    public Object call() {
        return e.a.w0.b.a.g(this.b.call(), "The callable returned a null value");
    }

    public void m6(d object) {
        Callable callable;
        DeferredScalarSubscription deferredScalarSubscription = new DeferredScalarSubscription((d)object);
        object.onSubscribe(deferredScalarSubscription);
        try {
            callable = this.b;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            boolean bl2 = deferredScalarSubscription.isCancelled();
            if (bl2) {
                e.a.a1.a.Y(throwable);
            } else {
                object.onError(throwable);
            }
            return;
        }
        callable = callable.call();
        String string2 = "The callable returned a null value";
        object = e.a.w0.b.a.g(callable, string2);
        deferredScalarSubscription.complete(object);
    }
}

