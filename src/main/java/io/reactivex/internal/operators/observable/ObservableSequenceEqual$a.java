/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.g0;
import e.a.s0.b;
import e.a.w0.f.a;
import io.reactivex.internal.operators.observable.ObservableSequenceEqual$EqualCoordinator;

public final class ObservableSequenceEqual$a
implements g0 {
    public final ObservableSequenceEqual$EqualCoordinator a;
    public final a b;
    public final int c;
    public volatile boolean d;
    public Throwable e;

    public ObservableSequenceEqual$a(ObservableSequenceEqual$EqualCoordinator object, int n10, int n11) {
        this.a = object;
        this.c = n10;
        this.b = object = new a(n11);
    }

    public void onComplete() {
        this.d = true;
        this.a.drain();
    }

    public void onError(Throwable throwable) {
        this.e = throwable;
        this.d = true;
        this.a.drain();
    }

    public void onNext(Object object) {
        this.b.offer(object);
        this.a.drain();
    }

    public void onSubscribe(b b10) {
        ObservableSequenceEqual$EqualCoordinator observableSequenceEqual$EqualCoordinator = this.a;
        int n10 = this.c;
        observableSequenceEqual$EqualCoordinator.setDisposable(b10, n10);
    }
}

