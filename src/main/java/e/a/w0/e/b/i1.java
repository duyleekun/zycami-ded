/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.b;

import e.a.a1.a;
import e.a.i0;
import e.a.j;
import e.a.l0;
import e.a.w0.c.b;
import e.a.w0.e.b.i1$a;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.operators.flowable.FlowableToList;
import io.reactivex.internal.util.ArrayListSupplier;
import java.util.Collection;
import java.util.concurrent.Callable;

public final class i1
extends i0
implements b {
    public final j a;
    public final Callable b;

    public i1(j j10) {
        Callable callable = ArrayListSupplier.asCallable();
        this(j10, callable);
    }

    public i1(j j10, Callable callable) {
        this.a = j10;
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
        i1$a i1$a = new i1$a(l02, (Collection)object);
        ((j)object2).l6(i1$a);
    }

    public j l() {
        j j10 = this.a;
        Callable callable = this.b;
        FlowableToList flowableToList = new FlowableToList(j10, callable);
        return e.a.a1.a.P(flowableToList);
    }
}

