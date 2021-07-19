/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.b;

import e.a.j;
import e.a.w0.b.a;
import i.g.c;
import i.g.d;
import io.reactivex.internal.subscriptions.EmptySubscription;
import java.util.concurrent.Callable;

public final class p
extends j {
    public final Callable b;

    public p(Callable callable) {
        this.b = callable;
    }

    public void m6(d d10) {
        Object object;
        try {
            object = this.b;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            EmptySubscription.error(throwable, d10);
            return;
        }
        object = object.call();
        String string2 = "The publisher supplied is null";
        object = e.a.w0.b.a.g(object, string2);
        ((c)object).subscribe(d10);
    }
}

