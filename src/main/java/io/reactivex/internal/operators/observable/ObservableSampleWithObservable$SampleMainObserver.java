/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.e0;
import e.a.g0;
import e.a.s0.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.observable.ObservableSampleWithObservable$a;
import java.util.concurrent.atomic.AtomicReference;

public abstract class ObservableSampleWithObservable$SampleMainObserver
extends AtomicReference
implements g0,
b {
    private static final long serialVersionUID = -3517602651313910099L;
    public final g0 downstream;
    public final AtomicReference other;
    public final e0 sampler;
    public b upstream;

    public ObservableSampleWithObservable$SampleMainObserver(g0 g02, e0 e02) {
        AtomicReference atomicReference;
        this.other = atomicReference = new AtomicReference();
        this.downstream = g02;
        this.sampler = e02;
    }

    public void complete() {
        this.upstream.dispose();
        this.completion();
    }

    public abstract void completion();

    public void dispose() {
        DisposableHelper.dispose(this.other);
        this.upstream.dispose();
    }

    public void emit() {
        Object var1_1 = this.getAndSet(null);
        if (var1_1 != null) {
            g0 g02 = this.downstream;
            g02.onNext(var1_1);
        }
    }

    public void error(Throwable throwable) {
        this.upstream.dispose();
        this.downstream.onError(throwable);
    }

    public boolean isDisposed() {
        boolean bl2;
        DisposableHelper disposableHelper;
        Object v10 = this.other.get();
        if (v10 == (disposableHelper = DisposableHelper.DISPOSED)) {
            bl2 = true;
        } else {
            bl2 = false;
            v10 = null;
        }
        return bl2;
    }

    public void onComplete() {
        DisposableHelper.dispose(this.other);
        this.completion();
    }

    public void onError(Throwable throwable) {
        DisposableHelper.dispose(this.other);
        this.downstream.onError(throwable);
    }

    public void onNext(Object object) {
        this.lazySet(object);
    }

    public void onSubscribe(b object) {
        Object object2 = this.upstream;
        boolean bl2 = DisposableHelper.validate((b)object2, (b)object);
        if (bl2) {
            this.upstream = object;
            this.downstream.onSubscribe(this);
            object = this.other.get();
            if (object == null) {
                object = this.sampler;
                object2 = new ObservableSampleWithObservable$a(this);
                object.subscribe((g0)object2);
            }
        }
    }

    public abstract void run();

    public boolean setOther(b b10) {
        return DisposableHelper.setOnce(this.other, b10);
    }
}

