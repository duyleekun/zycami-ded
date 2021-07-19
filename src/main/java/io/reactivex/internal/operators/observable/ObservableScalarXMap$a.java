/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.e0;
import e.a.g0;
import e.a.s0.b;
import e.a.v0.o;
import e.a.w0.b.a;
import e.a.z;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.operators.observable.ObservableScalarXMap$ScalarDisposable;
import java.util.concurrent.Callable;

public final class ObservableScalarXMap$a
extends z {
    public final Object a;
    public final o b;

    public ObservableScalarXMap$a(Object object, o o10) {
        this.a = object;
        this.b = o10;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void K5(g0 g02) {
        Object object = this.b;
        Object object2 = this.a;
        object = object.apply(object2);
        object2 = "The mapper returned a null ObservableSource";
        object = e.a.w0.b.a.g(object, (String)object2);
        try {
            object = (e0)object;
        }
        catch (Throwable throwable) {
            EmptyDisposable.error(throwable, g02);
            return;
        }
        boolean bl2 = object instanceof Callable;
        if (bl2) {
            block10: {
                try {
                    object = (Callable)object;
                }
                catch (Throwable throwable) {
                    e.a.t0.a.b(throwable);
                    EmptyDisposable.error(throwable, g02);
                    return;
                }
                object = object.call();
                if (object != null) break block10;
                EmptyDisposable.complete(g02);
                return;
            }
            object2 = new ObservableScalarXMap$ScalarDisposable(g02, object);
            g02.onSubscribe((b)object2);
            ((ObservableScalarXMap$ScalarDisposable)object2).run();
            return;
        }
        object.subscribe(g02);
        return;
    }
}

