/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.g0;
import e.a.w0.c.m;
import e.a.z;
import io.reactivex.internal.operators.observable.ObservableScalarXMap$ScalarDisposable;

public final class t0
extends z
implements m {
    private final Object a;

    public t0(Object object) {
        this.a = object;
    }

    public void K5(g0 g02) {
        Object object = this.a;
        ObservableScalarXMap$ScalarDisposable observableScalarXMap$ScalarDisposable = new ObservableScalarXMap$ScalarDisposable(g02, object);
        g02.onSubscribe(observableScalarXMap$ScalarDisposable);
        observableScalarXMap$ScalarDisposable.run();
    }

    public Object call() {
        return this.a;
    }
}

