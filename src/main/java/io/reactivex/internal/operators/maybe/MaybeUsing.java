/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.maybe;

import e.a.a1.a;
import e.a.q;
import e.a.t;
import e.a.v0.g;
import e.a.v0.o;
import e.a.w;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.operators.maybe.MaybeUsing$UsingObserver;
import java.util.concurrent.Callable;

public final class MaybeUsing
extends q {
    public final Callable a;
    public final o b;
    public final g c;
    public final boolean d;

    public MaybeUsing(Callable callable, o o10, g g10, boolean bl2) {
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
    public void t1(t object) {
        Callable callable;
        try {
            callable = this.a;
            callable = callable.call();
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            EmptyDisposable.error(throwable, (t)object);
            return;
        }
        try {
            Object object3 = this.b;
            object3 = object3.apply(callable);
            Object object2 = "The sourceSupplier returned a null MaybeSource";
            object3 = e.a.w0.b.a.g(object3, (String)object2);
            object3 = (w)object3;
            g g10 = this.c;
            boolean bl2 = this.d;
            object2 = new MaybeUsing$UsingObserver((t)object, callable, g10, bl2);
            object3.g((t)object2);
            return;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            boolean bl3 = this.d;
            if (bl3) {
                try {
                    g g11 = this.c;
                    g11.accept(callable);
                }
                catch (Throwable throwable2) {
                    e.a.t0.a.b(throwable2);
                    Throwable[] throwableArray = new Throwable[]{throwable, throwable2};
                    CompositeException compositeException = new CompositeException(throwableArray);
                    EmptyDisposable.error((Throwable)compositeException, (t)object);
                    return;
                }
            }
            EmptyDisposable.error(throwable, (t)object);
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

