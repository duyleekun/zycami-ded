/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.b;

import e.a.j;
import e.a.v0.o;
import e.a.w0.b.a;
import i.g.c;
import i.g.d;
import i.g.e;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.ScalarSubscription;
import java.util.concurrent.Callable;

public final class w0$a
extends j {
    public final Object b;
    public final o c;

    public w0$a(Object object, o o10) {
        this.b = object;
        this.c = o10;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void m6(d d10) {
        Object object = this.c;
        Object object2 = this.b;
        object = object.apply(object2);
        object2 = "The mapper returned a null Publisher";
        object = e.a.w0.b.a.g(object, (String)object2);
        try {
            object = (c)object;
        }
        catch (Throwable throwable) {
            EmptySubscription.error(throwable, d10);
            return;
        }
        boolean bl2 = object instanceof Callable;
        if (bl2) {
            block10: {
                try {
                    object = (Callable)object;
                }
                catch (Throwable throwable) {
                    e.a.t0.a.b(throwable);
                    EmptySubscription.error(throwable, d10);
                    return;
                }
                object = object.call();
                if (object != null) break block10;
                EmptySubscription.complete(d10);
                return;
            }
            object2 = new ScalarSubscription(d10, object);
            d10.onSubscribe((e)object2);
            return;
        }
        object.subscribe(d10);
        return;
    }
}

