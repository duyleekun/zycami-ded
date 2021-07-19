/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.a1.a;
import e.a.g0;
import e.a.s0.b;
import e.a.w0.c.n;
import e.a.z;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.observable.ObservableMergeWithMaybe$MergeWithObserver$OtherObserver;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableMergeWithMaybe$MergeWithObserver
extends AtomicInteger
implements g0,
b {
    public static final int OTHER_STATE_CONSUMED_OR_EMPTY = 2;
    public static final int OTHER_STATE_HAS_VALUE = 1;
    private static final long serialVersionUID = -4592979584110982903L;
    public volatile boolean disposed;
    public final g0 downstream;
    public final AtomicThrowable error;
    public final AtomicReference mainDisposable;
    public volatile boolean mainDone;
    public final ObservableMergeWithMaybe$MergeWithObserver$OtherObserver otherObserver;
    public volatile int otherState;
    public volatile n queue;
    public Object singleItem;

    public ObservableMergeWithMaybe$MergeWithObserver(g0 atomicReference) {
        this.downstream = atomicReference;
        this.mainDisposable = atomicReference = new AtomicReference();
        this.otherObserver = atomicReference = new ObservableMergeWithMaybe$MergeWithObserver$OtherObserver(this);
        this.error = atomicReference;
    }

    public void dispose() {
        this.disposed = true;
        DisposableHelper.dispose(this.mainDisposable);
        ObservableMergeWithMaybe$MergeWithObserver$OtherObserver observableMergeWithMaybe$MergeWithObserver$OtherObserver = this.otherObserver;
        DisposableHelper.dispose(observableMergeWithMaybe$MergeWithObserver$OtherObserver);
        int n10 = this.getAndIncrement();
        if (n10 == 0) {
            n10 = 0;
            observableMergeWithMaybe$MergeWithObserver$OtherObserver = null;
            this.queue = null;
            this.singleItem = null;
        }
    }

    public void drain() {
        int n10 = this.getAndIncrement();
        if (n10 == 0) {
            this.drainLoop();
        }
    }

    public void drainLoop() {
        int n10;
        g0 g02 = this.downstream;
        int n11 = n10 = 1;
        while (true) {
            int n12;
            if ((n12 = this.disposed) != 0) {
                this.singleItem = null;
                this.queue = null;
                return;
            }
            Object object = this.error.get();
            if (object != null) {
                this.singleItem = null;
                this.queue = null;
                Throwable throwable = this.error.terminate();
                g02.onError(throwable);
                return;
            }
            n12 = this.otherState;
            int n13 = 2;
            if (n12 == n10) {
                object = this.singleItem;
                this.singleItem = null;
                this.otherState = n13;
                g02.onNext(object);
                n12 = n13;
            }
            boolean bl2 = this.mainDone;
            Object object2 = this.queue;
            object2 = object2 != null ? object2.poll() : null;
            int n14 = object2 == null ? n10 : 0;
            if (bl2 && n14 != 0 && n12 == n13) {
                this.queue = null;
                g02.onComplete();
                return;
            }
            if (n14 != 0) {
                n11 = -n11;
                if ((n11 = this.addAndGet(n11)) != 0) continue;
                return;
            }
            g02.onNext(object2);
        }
    }

    public n getOrCreateQueue() {
        n n10 = this.queue;
        if (n10 == null) {
            int n11 = z.b0();
            this.queue = n10 = new e.a.w0.f.a(n11);
        }
        return n10;
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((b)this.mainDisposable.get());
    }

    public void onComplete() {
        this.mainDone = true;
        this.drain();
    }

    public void onError(Throwable serializable) {
        AtomicThrowable atomicThrowable = this.error;
        boolean bl2 = atomicThrowable.addThrowable((Throwable)serializable);
        if (bl2) {
            serializable = this.otherObserver;
            DisposableHelper.dispose((AtomicReference)serializable);
            this.drain();
        } else {
            a.Y(serializable);
        }
    }

    public void onNext(Object object) {
        Object object2 = null;
        int n10 = 1;
        boolean bl2 = this.compareAndSet(0, n10);
        if (bl2) {
            object2 = this.downstream;
            object2.onNext(object);
            int n11 = this.decrementAndGet();
            if (n11 == 0) {
                return;
            }
        } else {
            object2 = this.getOrCreateQueue();
            object2.offer(object);
            int n12 = this.getAndIncrement();
            if (n12 != 0) {
                return;
            }
        }
        this.drainLoop();
    }

    public void onSubscribe(b b10) {
        DisposableHelper.setOnce(this.mainDisposable, b10);
    }

    public void otherComplete() {
        this.otherState = 2;
        this.drain();
    }

    public void otherError(Throwable serializable) {
        AtomicThrowable atomicThrowable = this.error;
        boolean bl2 = atomicThrowable.addThrowable((Throwable)serializable);
        if (bl2) {
            serializable = this.mainDisposable;
            DisposableHelper.dispose((AtomicReference)serializable);
            this.drain();
        } else {
            a.Y(serializable);
        }
    }

    public void otherSuccess(Object object) {
        g0 g02 = null;
        int n10 = 1;
        boolean bl2 = this.compareAndSet(0, n10);
        if (bl2) {
            int n11;
            g02 = this.downstream;
            g02.onNext(object);
            this.otherState = n11 = 2;
        } else {
            this.singleItem = object;
            this.otherState = n10;
            int n12 = this.getAndIncrement();
            if (n12 != 0) {
                return;
            }
        }
        this.drainLoop();
    }
}

