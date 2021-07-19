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
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.operators.observable.ObservableReplay$b;
import io.reactivex.internal.operators.observable.ObserverResourceWrapper;
import java.util.concurrent.Callable;

public final class ObservableReplay$c
extends z {
    private final Callable a;
    private final o b;

    public ObservableReplay$c(Callable callable, o o10) {
        this.a = callable;
        this.b = o10;
    }

    public void K5(g0 object) {
        Object object2;
        try {
            object2 = this.a;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            EmptyDisposable.error(throwable, (g0)object);
            return;
        }
        object2 = object2.call();
        Object object3 = "The connectableFactory returned a null ConnectableObservable";
        object2 = e.a.w0.b.a.g(object2, (String)object3);
        object2 = (e.a.x0.a)object2;
        object3 = this.b;
        object3 = object3.apply(object2);
        Object object4 = "The selector returned a null ObservableSource";
        object3 = e.a.w0.b.a.g(object3, (String)object4);
        object3 = (e0)object3;
        object4 = new ObserverResourceWrapper((g0)object);
        object3.subscribe((g0)object4);
        object = new ObservableReplay$b((ObserverResourceWrapper)object4);
        ((e.a.x0.a)object2).l8((g)object);
    }
}

