/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.a1.a;
import e.a.e0;
import e.a.i0;
import e.a.l0;
import e.a.w0.c.d;
import e.a.w0.e.e.v1;
import e.a.w0.e.e.w1$a;
import e.a.z;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.Functions;
import java.util.Collection;
import java.util.concurrent.Callable;

public final class w1
extends i0
implements d {
    public final e0 a;
    public final Callable b;

    public w1(e0 object, int n10) {
        this.a = object;
        this.b = object = Functions.f(n10);
    }

    public w1(e0 e02, Callable callable) {
        this.a = e02;
        this.b = callable;
    }

    public void e1(l0 l02) {
        Object object;
        try {
            object = this.b;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            EmptyDisposable.error(throwable, l02);
            return;
        }
        object = object.call();
        Object object2 = "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.";
        object = e.a.w0.b.a.g(object, (String)object2);
        object = (Collection)object;
        object2 = this.a;
        w1$a w1$a = new w1$a(l02, (Collection)object);
        object2.subscribe(w1$a);
    }

    public z i() {
        e0 e02 = this.a;
        Callable callable = this.b;
        v1 v12 = new v1(e02, callable);
        return e.a.a1.a.R(v12);
    }
}

