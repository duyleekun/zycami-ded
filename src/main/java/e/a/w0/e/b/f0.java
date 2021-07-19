/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.b;

import e.a.j;
import e.a.t0.a;
import i.g.d;
import i.g.e;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import java.io.Serializable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public final class f0
extends j {
    public final Future b;
    public final long c;
    public final TimeUnit d;

    public f0(Future future, long l10, TimeUnit timeUnit) {
        this.b = future;
        this.c = l10;
        this.d = timeUnit;
    }

    public void m6(d d10) {
        Object object;
        Serializable serializable;
        block11: {
            block10: {
                serializable = new DeferredScalarSubscription(d10);
                d10.onSubscribe((e)((Object)serializable));
                try {
                    object = this.d;
                    if (object == null) break block10;
                }
                catch (Throwable throwable) {
                    e.a.t0.a.b(throwable);
                    boolean bl2 = serializable.isCancelled();
                    if (!bl2) {
                        d10.onError(throwable);
                    }
                    return;
                }
                Future future = this.b;
                long l10 = this.c;
                object = future.get(l10, (TimeUnit)((Object)object));
                break block11;
            }
            object = this.b;
            object = object.get();
        }
        if (object == null) {
            object = "The future returned null";
            serializable = new NullPointerException((String)object);
            d10.onError((Throwable)serializable);
        } else {
            serializable.complete(object);
        }
    }
}

