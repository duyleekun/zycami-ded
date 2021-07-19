/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.g0;
import e.a.s0.b;
import e.a.w0.f.a;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.observable.ObservableZip$ZipCoordinator;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableZip$a
implements g0 {
    public final ObservableZip$ZipCoordinator a;
    public final a b;
    public volatile boolean c;
    public Throwable d;
    public final AtomicReference e;

    public ObservableZip$a(ObservableZip$ZipCoordinator object, int n10) {
        AtomicReference atomicReference;
        this.e = atomicReference = new AtomicReference();
        this.a = object;
        this.b = object = new a(n10);
    }

    public void a() {
        DisposableHelper.dispose(this.e);
    }

    public void onComplete() {
        this.c = true;
        this.a.drain();
    }

    public void onError(Throwable throwable) {
        this.d = throwable;
        this.c = true;
        this.a.drain();
    }

    public void onNext(Object object) {
        this.b.offer(object);
        this.a.drain();
    }

    public void onSubscribe(b b10) {
        DisposableHelper.setOnce(this.e, b10);
    }
}

