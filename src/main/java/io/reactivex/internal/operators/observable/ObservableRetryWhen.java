/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.d1.c;
import e.a.e0;
import e.a.g0;
import e.a.s0.b;
import e.a.v0.o;
import e.a.w0.e.e.a;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.operators.observable.ObservableRetryWhen$RepeatWhenObserver;
import io.reactivex.subjects.PublishSubject;

public final class ObservableRetryWhen
extends a {
    public final o b;

    public ObservableRetryWhen(e0 e02, o o10) {
        super(e02);
        this.b = o10;
    }

    public void K5(g0 g02) {
        Object object;
        c c10 = PublishSubject.n8().l8();
        try {
            object = this.b;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            EmptyDisposable.error(throwable, g02);
            return;
        }
        object = object.apply(c10);
        Object object2 = "The handler returned a null ObservableSource";
        object = e.a.w0.b.a.g(object, (String)object2);
        object = (e0)object;
        e0 e02 = this.a;
        object2 = new ObservableRetryWhen$RepeatWhenObserver(g02, c10, e02);
        g02.onSubscribe((b)object2);
        g02 = ((ObservableRetryWhen$RepeatWhenObserver)object2).inner;
        object.subscribe(g02);
        ((ObservableRetryWhen$RepeatWhenObserver)object2).subscribeNext();
    }
}

