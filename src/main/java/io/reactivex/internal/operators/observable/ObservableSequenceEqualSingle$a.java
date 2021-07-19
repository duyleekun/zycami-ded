/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.g0;
import e.a.s0.b;
import e.a.w0.f.a;
import io.reactivex.internal.operators.observable.ObservableSequenceEqualSingle$EqualCoordinator;

public final class ObservableSequenceEqualSingle$a
implements g0 {
    public final ObservableSequenceEqualSingle$EqualCoordinator a;
    public final a b;
    public final int c;
    public volatile boolean d;
    public Throwable e;

    public ObservableSequenceEqualSingle$a(ObservableSequenceEqualSingle$EqualCoordinator object, int n10, int n11) {
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
        ObservableSequenceEqualSingle$EqualCoordinator observableSequenceEqualSingle$EqualCoordinator = this.a;
        int n10 = this.c;
        observableSequenceEqualSingle$EqualCoordinator.setDisposable(b10, n10);
    }
}

