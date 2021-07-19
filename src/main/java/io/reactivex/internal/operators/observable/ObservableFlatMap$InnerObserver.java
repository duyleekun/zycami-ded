/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.a1.a;
import e.a.g0;
import e.a.s0.b;
import e.a.w0.c.j;
import e.a.w0.c.o;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.observable.ObservableFlatMap$MergeObserver;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableFlatMap$InnerObserver
extends AtomicReference
implements g0 {
    private static final long serialVersionUID = -4606175640614850599L;
    public volatile boolean done;
    public int fusionMode;
    public final long id;
    public final ObservableFlatMap$MergeObserver parent;
    public volatile o queue;

    public ObservableFlatMap$InnerObserver(ObservableFlatMap$MergeObserver mergeObserver, long l10) {
        this.id = l10;
        this.parent = mergeObserver;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public void onComplete() {
        this.done = true;
        this.parent.drain();
    }

    public void onError(Throwable serializable) {
        AtomicThrowable atomicThrowable = this.parent.errors;
        boolean bl2 = atomicThrowable.addThrowable((Throwable)serializable);
        if (bl2) {
            boolean bl3;
            serializable = this.parent;
            bl2 = ((ObservableFlatMap$MergeObserver)serializable).delayErrors;
            if (!bl2) {
                ((ObservableFlatMap$MergeObserver)serializable).disposeAll();
            }
            this.done = bl3 = true;
            serializable = this.parent;
            ((ObservableFlatMap$MergeObserver)serializable).drain();
        } else {
            a.Y((Throwable)serializable);
        }
    }

    public void onNext(Object object) {
        int n10 = this.fusionMode;
        if (n10 == 0) {
            ObservableFlatMap$MergeObserver observableFlatMap$MergeObserver = this.parent;
            observableFlatMap$MergeObserver.tryEmit(object, this);
        } else {
            object = this.parent;
            ((ObservableFlatMap$MergeObserver)object).drain();
        }
    }

    public void onSubscribe(b b10) {
        int n10 = DisposableHelper.setOnce(this, b10);
        if (n10 != 0 && (n10 = b10 instanceof j) != 0) {
            int n11;
            n10 = (b10 = (j)b10).requestFusion(7);
            if (n10 == (n11 = 1)) {
                this.fusionMode = n10;
                this.queue = b10;
                this.done = n11;
                this.parent.drain();
                return;
            }
            n11 = 2;
            if (n10 == n11) {
                this.fusionMode = n10;
                this.queue = b10;
            }
        }
    }
}

