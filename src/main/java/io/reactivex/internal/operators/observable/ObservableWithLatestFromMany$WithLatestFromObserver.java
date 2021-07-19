/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.a1.a;
import e.a.e0;
import e.a.g0;
import e.a.s0.b;
import e.a.v0.o;
import e.a.w0.i.g;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.observable.ObservableWithLatestFromMany$WithLatestInnerObserver;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;

public final class ObservableWithLatestFromMany$WithLatestFromObserver
extends AtomicInteger
implements g0,
b {
    private static final long serialVersionUID = 1577321883966341961L;
    public final o combiner;
    public volatile boolean done;
    public final g0 downstream;
    public final AtomicThrowable error;
    public final ObservableWithLatestFromMany$WithLatestInnerObserver[] observers;
    public final AtomicReference upstream;
    public final AtomicReferenceArray values;

    public ObservableWithLatestFromMany$WithLatestFromObserver(g0 object, o o10, int n10) {
        this.downstream = object;
        this.combiner = o10;
        object = new ObservableWithLatestFromMany$WithLatestInnerObserver[n10];
        o10 = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            ObservableWithLatestFromMany$WithLatestInnerObserver observableWithLatestFromMany$WithLatestInnerObserver;
            object[i10] = observableWithLatestFromMany$WithLatestInnerObserver = new ObservableWithLatestFromMany$WithLatestInnerObserver(this, i10);
        }
        this.observers = object;
        super(n10);
        this.values = object;
        super();
        this.upstream = object;
        super();
        this.error = object;
    }

    public void cancelAllBut(int n10) {
        int n11;
        ObservableWithLatestFromMany$WithLatestInnerObserver[] observableWithLatestFromMany$WithLatestInnerObserverArray = this.observers;
        for (int i10 = 0; i10 < (n11 = observableWithLatestFromMany$WithLatestInnerObserverArray.length); ++i10) {
            if (i10 == n10) continue;
            ObservableWithLatestFromMany$WithLatestInnerObserver observableWithLatestFromMany$WithLatestInnerObserver = observableWithLatestFromMany$WithLatestInnerObserverArray[i10];
            observableWithLatestFromMany$WithLatestInnerObserver.dispose();
        }
    }

    public void dispose() {
        DisposableHelper.dispose(this.upstream);
        for (ObservableWithLatestFromMany$WithLatestInnerObserver observableWithLatestFromMany$WithLatestInnerObserver : this.observers) {
            observableWithLatestFromMany$WithLatestInnerObserver.dispose();
        }
    }

    public void innerComplete(int n10, boolean bl2) {
        if (!bl2) {
            this.done = bl2 = true;
            this.cancelAllBut(n10);
            g0 g02 = this.downstream;
            AtomicThrowable atomicThrowable = this.error;
            g.a(g02, this, atomicThrowable);
        }
    }

    public void innerError(int n10, Throwable throwable) {
        this.done = true;
        DisposableHelper.dispose(this.upstream);
        this.cancelAllBut(n10);
        g0 g02 = this.downstream;
        AtomicThrowable atomicThrowable = this.error;
        g.c(g02, throwable, this, atomicThrowable);
    }

    public void innerNext(int n10, Object object) {
        this.values.set(n10, object);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((b)this.upstream.get());
    }

    public void onComplete() {
        int n10 = this.done;
        if (n10 == 0) {
            this.done = true;
            n10 = -1;
            this.cancelAllBut(n10);
            g0 g02 = this.downstream;
            AtomicThrowable atomicThrowable = this.error;
            g.a(g02, this, atomicThrowable);
        }
    }

    public void onError(Throwable throwable) {
        boolean bl2 = this.done;
        if (bl2) {
            a.Y(throwable);
            return;
        }
        this.done = true;
        this.cancelAllBut(-1);
        g0 g02 = this.downstream;
        AtomicThrowable atomicThrowable = this.error;
        g.c(g02, throwable, this, atomicThrowable);
    }

    public void onNext(Object object) {
        boolean bl2 = this.done;
        if (bl2) {
            return;
        }
        Object object2 = this.values;
        int n10 = ((AtomicReferenceArray)object2).length();
        int n11 = n10 + 1;
        Object[] objectArray = new Object[n11];
        int n12 = 0;
        objectArray[0] = object;
        while (n12 < n10) {
            object = ((AtomicReferenceArray)object2).get(n12);
            if (object == null) {
                return;
            }
            objectArray[++n12] = object;
        }
        try {
            object = this.combiner;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            this.dispose();
            this.onError(throwable);
            return;
        }
        object = object.apply(objectArray);
        object2 = "combiner returned a null value";
        object = e.a.w0.b.a.g(object, (String)object2);
        object2 = this.downstream;
        AtomicThrowable atomicThrowable = this.error;
        g.e((g0)object2, object, this, atomicThrowable);
    }

    public void onSubscribe(b b10) {
        DisposableHelper.setOnce(this.upstream, b10);
    }

    public void subscribe(e0[] e0Array, int n10) {
        Object object;
        boolean bl2;
        ObservableWithLatestFromMany$WithLatestInnerObserver[] observableWithLatestFromMany$WithLatestInnerObserverArray = this.observers;
        AtomicReference atomicReference = this.upstream;
        for (int i10 = 0; i10 < n10 && !(bl2 = DisposableHelper.isDisposed((b)(object = (b)atomicReference.get()))) && !(bl2 = this.done); ++i10) {
            object = e0Array[i10];
            ObservableWithLatestFromMany$WithLatestInnerObserver observableWithLatestFromMany$WithLatestInnerObserver = observableWithLatestFromMany$WithLatestInnerObserverArray[i10];
            object.subscribe(observableWithLatestFromMany$WithLatestInnerObserver);
        }
    }
}

