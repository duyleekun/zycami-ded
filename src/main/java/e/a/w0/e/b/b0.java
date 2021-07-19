/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.b;

import e.a.j;
import e.a.w0.b.a;
import i.g.d;
import io.reactivex.internal.subscriptions.EmptySubscription;
import java.util.concurrent.Callable;

public final class b0
extends j {
    public final Callable b;

    public b0(Callable callable) {
        this.b = callable;
    }

    public void m6(d d10) {
        Object object = this.b;
        object = object.call();
        String string2 = "Callable returned null throwable. Null values are generally not allowed in 2.x operators and sources.";
        object = e.a.w0.b.a.g(object, string2);
        try {
            object = (Throwable)object;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
        }
        EmptySubscription.error((Throwable)object, d10);
    }
}

