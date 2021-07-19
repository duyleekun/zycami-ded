/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.e0;
import e.a.g0;
import e.a.w0.e.e.a;
import e.a.w0.e.e.v1$a;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.Functions;
import java.util.Collection;
import java.util.concurrent.Callable;

public final class v1
extends a {
    public final Callable b;

    public v1(e0 object, int n10) {
        super((e0)object);
        this.b = object = Functions.f(n10);
    }

    public v1(e0 e02, Callable callable) {
        super(e02);
        this.b = callable;
    }

    public void K5(g0 g02) {
        Object object;
        try {
            object = this.b;
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
        v1$a v1$a = new v1$a(g02, (Collection)object);
        object2.subscribe(v1$a);
    }
}

