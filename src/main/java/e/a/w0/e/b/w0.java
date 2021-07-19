/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.b;

import e.a.a1.a;
import e.a.j;
import e.a.v0.o;
import e.a.w0.e.b.w0$a;
import i.g.c;
import i.g.d;
import i.g.e;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.ScalarSubscription;
import java.util.concurrent.Callable;

public final class w0 {
    private w0() {
        IllegalStateException illegalStateException = new IllegalStateException("No instances!");
        throw illegalStateException;
    }

    public static j a(Object object, o o10) {
        w0$a w0$a = new w0$a(object, o10);
        return a.P(w0$a);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static boolean b(c object, d d10, o object2) {
        boolean bl2;
        block8: {
            block7: {
                bl2 = object instanceof Callable;
                if (!bl2) return false;
                bl2 = true;
                try {
                    object = (Callable)object;
                    object = object.call();
                    if (object != null) break block7;
                }
                catch (Throwable throwable) {
                    e.a.t0.a.b(throwable);
                    EmptySubscription.error(throwable, d10);
                    return bl2;
                }
                EmptySubscription.complete(d10);
                return bl2;
            }
            try {
                object = object2.apply(object);
                object2 = "The mapper returned a null Publisher";
                object = e.a.w0.b.a.g(object, (String)object2);
                object = (c)object;
            }
            catch (Throwable throwable) {
                e.a.t0.a.b(throwable);
                EmptySubscription.error(throwable, d10);
                return bl2;
            }
            boolean bl3 = object instanceof Callable;
            if (!bl3) {
                object.subscribe(d10);
                return bl2;
            }
            try {
                object = (Callable)object;
                object = object.call();
                if (object != null) break block8;
            }
            catch (Throwable throwable) {
                e.a.t0.a.b(throwable);
                EmptySubscription.error(throwable, d10);
                return bl2;
            }
            EmptySubscription.complete(d10);
            return bl2;
        }
        object2 = new ScalarSubscription(d10, object);
        d10.onSubscribe((e)object2);
        return bl2;
    }
}

