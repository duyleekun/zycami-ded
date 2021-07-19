/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.a1.a;
import e.a.e0;
import e.a.g0;
import e.a.s0.b;
import e.a.v0.o;
import e.a.z;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.operators.observable.ObservableScalarXMap$ScalarDisposable;
import io.reactivex.internal.operators.observable.ObservableScalarXMap$a;
import java.util.concurrent.Callable;

public final class ObservableScalarXMap {
    private ObservableScalarXMap() {
        IllegalStateException illegalStateException = new IllegalStateException("No instances!");
        throw illegalStateException;
    }

    public static z a(Object object, o o10) {
        ObservableScalarXMap$a observableScalarXMap$a = new ObservableScalarXMap$a(object, o10);
        return a.R(observableScalarXMap$a);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static boolean b(e0 object, g0 g02, o object2) {
        boolean bl2;
        block8: {
            block7: {
                bl2 = object instanceof Callable;
                if (!bl2) return false;
                bl2 = true;
                try {
                    object = (Callable)object;
                    object = object.call();
                    if (object != null) break block7;
                }
                catch (Throwable throwable) {
                    e.a.t0.a.b(throwable);
                    EmptyDisposable.error(throwable, g02);
                    return bl2;
                }
                EmptyDisposable.complete(g02);
                return bl2;
            }
            try {
                object = object2.apply(object);
                object2 = "The mapper returned a null ObservableSource";
                object = e.a.w0.b.a.g(object, (String)object2);
                object = (e0)object;
            }
            catch (Throwable throwable) {
                e.a.t0.a.b(throwable);
                EmptyDisposable.error(throwable, g02);
                return bl2;
            }
            boolean bl3 = object instanceof Callable;
            if (!bl3) {
                object.subscribe(g02);
                return bl2;
            }
            try {
                object = (Callable)object;
                object = object.call();
                if (object != null) break block8;
            }
            catch (Throwable throwable) {
                e.a.t0.a.b(throwable);
                EmptyDisposable.error(throwable, g02);
                return bl2;
            }
            EmptyDisposable.complete(g02);
            return bl2;
        }
        object2 = new ObservableScalarXMap$ScalarDisposable(g02, object);
        g02.onSubscribe((b)object2);
        ((ObservableScalarXMap$ScalarDisposable)object2).run();
        return bl2;
    }
}

