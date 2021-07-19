/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.a1.a;
import e.a.d;
import e.a.g;
import e.a.g0;
import e.a.s0.b;
import e.a.v0.o;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import io.reactivex.internal.operators.observable.ObservableFlatMapCompletable$FlatMapCompletableMainObserver$InnerObserver;
import io.reactivex.internal.util.AtomicThrowable;

public final class ObservableFlatMapCompletable$FlatMapCompletableMainObserver
extends BasicIntQueueDisposable
implements g0 {
    private static final long serialVersionUID = 8443155186132538303L;
    public final boolean delayErrors;
    public volatile boolean disposed;
    public final g0 downstream;
    public final AtomicThrowable errors;
    public final o mapper;
    public final e.a.s0.a set;
    public b upstream;

    public ObservableFlatMapCompletable$FlatMapCompletableMainObserver(g0 object, o o10, boolean bl2) {
        this.downstream = object;
        this.mapper = o10;
        this.delayErrors = bl2;
        this.errors = object = new AtomicThrowable();
        this.set = object = new e.a.s0.a();
        this.lazySet(1);
    }

    public void clear() {
    }

    public void dispose() {
        this.disposed = true;
        this.upstream.dispose();
        this.set.dispose();
    }

    public void innerComplete(ObservableFlatMapCompletable$FlatMapCompletableMainObserver$InnerObserver observableFlatMapCompletable$FlatMapCompletableMainObserver$InnerObserver) {
        this.set.c(observableFlatMapCompletable$FlatMapCompletableMainObserver$InnerObserver);
        this.onComplete();
    }

    public void innerError(ObservableFlatMapCompletable$FlatMapCompletableMainObserver$InnerObserver observableFlatMapCompletable$FlatMapCompletableMainObserver$InnerObserver, Throwable throwable) {
        this.set.c(observableFlatMapCompletable$FlatMapCompletableMainObserver$InnerObserver);
        this.onError(throwable);
    }

    public boolean isDisposed() {
        return this.upstream.isDisposed();
    }

    public boolean isEmpty() {
        return true;
    }

    public void onComplete() {
        int n10 = this.decrementAndGet();
        if (n10 == 0) {
            Object object = this.errors.terminate();
            if (object != null) {
                g0 g02 = this.downstream;
                g02.onError((Throwable)object);
            } else {
                object = this.downstream;
                object.onComplete();
            }
        }
    }

    public void onError(Throwable throwable) {
        Object object = this.errors;
        boolean bl2 = ((AtomicThrowable)object).addThrowable(throwable);
        if (bl2) {
            int n10 = this.delayErrors;
            if (n10 != 0) {
                n10 = this.decrementAndGet();
                if (n10 == 0) {
                    throwable = this.errors.terminate();
                    object = this.downstream;
                    object.onError(throwable);
                }
            } else {
                this.dispose();
                throwable = null;
                n10 = this.getAndSet(0);
                if (n10 > 0) {
                    throwable = this.errors.terminate();
                    object = this.downstream;
                    object.onError(throwable);
                }
            }
        } else {
            a.Y(throwable);
        }
    }

    public void onNext(Object object) {
        e.a.s0.a a10;
        Object object2;
        try {
            object2 = this.mapper;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            this.upstream.dispose();
            this.onError(throwable);
            return;
        }
        object = object2.apply(object);
        object2 = "The mapper returned a null CompletableSource";
        object = e.a.w0.b.a.g(object, (String)object2);
        object = (g)object;
        this.getAndIncrement();
        object2 = new ObservableFlatMapCompletable$FlatMapCompletableMainObserver$InnerObserver(this);
        boolean bl2 = this.disposed;
        if (!bl2 && (bl2 = (a10 = this.set).b((b)object2))) {
            object.f((d)object2);
        }
    }

    public void onSubscribe(b object) {
        b b10 = this.upstream;
        boolean bl2 = DisposableHelper.validate(b10, (b)object);
        if (bl2) {
            this.upstream = object;
            object = this.downstream;
            object.onSubscribe(this);
        }
    }

    public Object poll() {
        return null;
    }

    public int requestFusion(int n10) {
        return n10 & 2;
    }
}

