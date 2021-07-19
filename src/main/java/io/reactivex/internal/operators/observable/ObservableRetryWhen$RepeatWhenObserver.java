/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.d1.c;
import e.a.e0;
import e.a.g0;
import e.a.s0.b;
import e.a.w0.i.g;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.observable.ObservableRetryWhen$RepeatWhenObserver$InnerRepeatObserver;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableRetryWhen$RepeatWhenObserver
extends AtomicInteger
implements g0,
b {
    private static final long serialVersionUID = 802743776666017014L;
    public volatile boolean active;
    public final g0 downstream;
    public final AtomicThrowable error;
    public final ObservableRetryWhen$RepeatWhenObserver$InnerRepeatObserver inner;
    public final c signaller;
    public final e0 source;
    public final AtomicReference upstream;
    public final AtomicInteger wip;

    public ObservableRetryWhen$RepeatWhenObserver(g0 atomicReference, c c10, e0 e02) {
        this.downstream = atomicReference;
        this.signaller = c10;
        this.source = e02;
        atomicReference = new AtomicReference();
        this.wip = atomicReference;
        atomicReference = new AtomicReference();
        this.error = atomicReference;
        atomicReference = new AtomicReference(this);
        this.inner = atomicReference;
        this.upstream = atomicReference = new AtomicReference();
    }

    public void dispose() {
        DisposableHelper.dispose(this.upstream);
        DisposableHelper.dispose(this.inner);
    }

    public void innerComplete() {
        DisposableHelper.dispose(this.upstream);
        g0 g02 = this.downstream;
        AtomicThrowable atomicThrowable = this.error;
        g.a(g02, this, atomicThrowable);
    }

    public void innerError(Throwable throwable) {
        DisposableHelper.dispose(this.upstream);
        g0 g02 = this.downstream;
        AtomicThrowable atomicThrowable = this.error;
        g.c(g02, throwable, this, atomicThrowable);
    }

    public void innerNext() {
        this.subscribeNext();
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((b)this.upstream.get());
    }

    public void onComplete() {
        DisposableHelper.dispose(this.inner);
        g0 g02 = this.downstream;
        AtomicThrowable atomicThrowable = this.error;
        g.a(g02, this, atomicThrowable);
    }

    public void onError(Throwable throwable) {
        DisposableHelper.replace(this.upstream, null);
        this.active = false;
        this.signaller.onNext(throwable);
    }

    public void onNext(Object object) {
        g0 g02 = this.downstream;
        AtomicThrowable atomicThrowable = this.error;
        g.e(g02, object, this, atomicThrowable);
    }

    public void onSubscribe(b b10) {
        DisposableHelper.replace(this.upstream, b10);
    }

    public void subscribeNext() {
        Object object = this.wip;
        int n10 = ((AtomicInteger)object).getAndIncrement();
        if (n10 == 0) {
            do {
                if ((n10 = (int)(this.isDisposed() ? 1 : 0)) != 0) {
                    return;
                }
                n10 = (int)(this.active ? 1 : 0);
                if (n10 != 0) continue;
                n10 = 1;
                this.active = n10;
                object = this.source;
                object.subscribe(this);
            } while ((n10 = ((AtomicInteger)(object = this.wip)).decrementAndGet()) != 0);
        }
    }
}

