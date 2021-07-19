/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.a1.a;
import e.a.g0;
import e.a.s0.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.observable.ObservableConcatMap$ConcatMapDelayErrorObserver;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableConcatMap$ConcatMapDelayErrorObserver$DelayErrorInnerObserver
extends AtomicReference
implements g0 {
    private static final long serialVersionUID = 2620149119579502636L;
    public final g0 downstream;
    public final ObservableConcatMap$ConcatMapDelayErrorObserver parent;

    public ObservableConcatMap$ConcatMapDelayErrorObserver$DelayErrorInnerObserver(g0 g02, ObservableConcatMap$ConcatMapDelayErrorObserver concatMapDelayErrorObserver) {
        this.downstream = g02;
        this.parent = concatMapDelayErrorObserver;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public void onComplete() {
        ObservableConcatMap$ConcatMapDelayErrorObserver observableConcatMap$ConcatMapDelayErrorObserver = this.parent;
        observableConcatMap$ConcatMapDelayErrorObserver.active = false;
        observableConcatMap$ConcatMapDelayErrorObserver.drain();
    }

    public void onError(Throwable object) {
        ObservableConcatMap$ConcatMapDelayErrorObserver observableConcatMap$ConcatMapDelayErrorObserver = this.parent;
        AtomicThrowable atomicThrowable = observableConcatMap$ConcatMapDelayErrorObserver.error;
        boolean bl2 = atomicThrowable.addThrowable((Throwable)object);
        if (bl2) {
            boolean bl3 = observableConcatMap$ConcatMapDelayErrorObserver.tillTheEnd;
            if (!bl3) {
                object = observableConcatMap$ConcatMapDelayErrorObserver.upstream;
                object.dispose();
            }
            bl3 = false;
            object = null;
            observableConcatMap$ConcatMapDelayErrorObserver.active = false;
            observableConcatMap$ConcatMapDelayErrorObserver.drain();
        } else {
            a.Y((Throwable)object);
        }
    }

    public void onNext(Object object) {
        this.downstream.onNext(object);
    }

    public void onSubscribe(b b10) {
        DisposableHelper.replace(this, b10);
    }
}

