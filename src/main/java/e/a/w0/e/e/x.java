/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.e0;
import e.a.g0;
import e.a.v0.o;
import e.a.w0.e.e.a;
import e.a.w0.e.e.x$a;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.Collection;
import java.util.concurrent.Callable;

public final class x
extends a {
    public final o b;
    public final Callable c;

    public x(e0 e02, o o10, Callable callable) {
        super(e02);
        this.b = o10;
        this.c = callable;
    }

    public void K5(g0 g02) {
        Object object;
        try {
            object = this.c;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            EmptyDisposable.error(throwable, g02);
            return;
        }
        object = object.call();
        Object object2 = "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.";
        object = e.a.w0.b.a.g(object, (String)object2);
        object = (Collection)object;
        object2 = this.a;
        o o10 = this.b;
        x$a x$a = new x$a(g02, o10, (Collection)object);
        object2.subscribe(x$a);
    }
}

