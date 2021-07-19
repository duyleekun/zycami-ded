/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.g0;
import e.a.s0.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.subjects.PublishSubject;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservablePublishSelector$a
implements g0 {
    public final PublishSubject a;
    public final AtomicReference b;

    public ObservablePublishSelector$a(PublishSubject publishSubject, AtomicReference atomicReference) {
        this.a = publishSubject;
        this.b = atomicReference;
    }

    public void onComplete() {
        this.a.onComplete();
    }

    public void onError(Throwable throwable) {
        this.a.onError(throwable);
    }

    public void onNext(Object object) {
        this.a.onNext(object);
    }

    public void onSubscribe(b b10) {
        DisposableHelper.setOnce(this.b, b10);
    }
}

