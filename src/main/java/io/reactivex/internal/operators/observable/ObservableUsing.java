/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.e0;
import e.a.g0;
import e.a.v0.g;
import e.a.v0.o;
import e.a.w0.b.a;
import e.a.z;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.operators.observable.ObservableUsing$UsingObserver;
import java.util.concurrent.Callable;

public final class ObservableUsing
extends z {
    public final Callable a;
    public final o b;
    public final g c;
    public final boolean d;

    public ObservableUsing(Callable callable, o o10, g g10, boolean bl2) {
        this.a = callable;
        this.b = o10;
        this.c = g10;
        this.d = bl2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void K5(g0 g02) {
        Callable callable;
        try {
            callable = this.a;
            callable = callable.call();
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            EmptyDisposable.error(throwable, g02);
            return;
        }
        try {
            Object object2 = this.b;
            object2 = object2.apply(callable);
            Object object = "The sourceSupplier returned a null ObservableSource";
            object2 = e.a.w0.b.a.g(object2, (String)object);
            object2 = (e0)object2;
            g g10 = this.c;
            boolean bl2 = this.d;
            object = new ObservableUsing$UsingObserver(g02, callable, g10, bl2);
            object2.subscribe((g0)object);
            return;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            try {
                g g11 = this.c;
                g11.accept(callable);
            }
            catch (Throwable throwable2) {
                e.a.t0.a.b(throwable2);
                Throwable[] throwableArray = new Throwable[]{throwable, throwable2};
                CompositeException compositeException = new CompositeException(throwableArray);
                EmptyDisposable.error((Throwable)compositeException, g02);
                return;
            }
            EmptyDisposable.error(throwable, g02);
            return;
        }
    }
}

