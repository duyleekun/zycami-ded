/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.single;

import e.a.a1.a;
import e.a.i0;
import e.a.l0;
import e.a.o0;
import e.a.v0.g;
import e.a.v0.o;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.operators.single.SingleUsing$UsingSingleObserver;
import java.util.concurrent.Callable;

public final class SingleUsing
extends i0 {
    public final Callable a;
    public final o b;
    public final g c;
    public final boolean d;

    public SingleUsing(Callable callable, o o10, g g10, boolean bl2) {
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
    public void e1(l0 object) {
        Callable callable;
        try {
            callable = this.a;
            callable = callable.call();
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            EmptyDisposable.error(throwable, (l0)object);
            return;
        }
        try {
            Object object3 = this.b;
            object3 = object3.apply(callable);
            Object object2 = "The singleFunction returned a null SingleSource";
            object3 = e.a.w0.b.a.g(object3, (String)object2);
            object3 = (o0)object3;
            boolean bl2 = this.d;
            g throwableArray = this.c;
            object2 = new SingleUsing$UsingSingleObserver((l0)object, callable, bl2, throwableArray);
            object3.f((l0)object2);
            return;
        }
        catch (Throwable throwable) {
            CompositeException compositeException;
            e.a.t0.a.b(throwable);
            boolean bl3 = this.d;
            if (bl3) {
                try {
                    g throwable2 = this.c;
                    throwable2.accept(callable);
                }
                catch (Throwable throwable2) {
                    CompositeException compositeException2;
                    e.a.t0.a.b(throwable2);
                    int n10 = 2;
                    Throwable[] throwableArray = new Throwable[n10];
                    throwableArray[0] = throwable;
                    int n11 = 1;
                    throwableArray[n11] = throwable2;
                    compositeException = compositeException2 = new CompositeException(throwableArray);
                }
            }
            EmptyDisposable.error((Throwable)compositeException, (l0)object);
            boolean bl4 = this.d;
            if (bl4) return;
            try {
                object = this.c;
                object.accept(callable);
                return;
            }
            catch (Throwable throwable3) {
                e.a.t0.a.b(throwable3);
                e.a.a1.a.Y(throwable3);
            }
            return;
        }
    }
}

