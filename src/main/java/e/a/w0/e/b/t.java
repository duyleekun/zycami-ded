/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.b;

import e.a.j;
import e.a.v0.o;
import e.a.w0.e.b.a;
import e.a.w0.e.b.t$a;
import i.g.d;
import io.reactivex.internal.subscriptions.EmptySubscription;
import java.util.Collection;
import java.util.concurrent.Callable;

public final class t
extends a {
    public final o c;
    public final Callable d;

    public t(j j10, o o10, Callable callable) {
        super(j10);
        this.c = o10;
        this.d = callable;
    }

    public void m6(d d10) {
        Object object;
        try {
            object = this.d;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            EmptySubscription.error(throwable, d10);
            return;
        }
        object = object.call();
        Object object2 = "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.";
        object = e.a.w0.b.a.g(object, (String)object2);
        object = (Collection)object;
        object2 = this.b;
        o o10 = this.c;
        t$a t$a = new t$a(d10, o10, (Collection)object);
        ((j)object2).l6(t$a);
    }
}

