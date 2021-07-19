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
import io.reactivex.internal.operators.observable.ObservableFlatMapCompletableCompletable$FlatMapCompletableMainObserver$InnerObserver;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableFlatMapCompletableCompletable$FlatMapCompletableMainObserver
extends AtomicInteger
implements b,
g0 {
    private static final long serialVersionUID = 8443155186132538303L;
    public final boolean delayErrors;
    public volatile boolean disposed;
    public final d downstream;
    public final AtomicThrowable errors;
    public final o mapper;
    public final e.a.s0.a set;
    public b upstream;

    public ObservableFlatMapCompletableCompletable$FlatMapCompletableMainObserver(d object, o o10, boolean bl2) {
        this.downstream = object;
        this.mapper = o10;
        this.delayErrors = bl2;
        this.errors = object = new AtomicThrowable();
        this.set = object = new e.a.s0.a();
        this.lazySet(1);
    }

    public void dispose() {
        this.disposed = true;
        this.upstream.dispose();
        this.set.dispose();
    }

    public void innerComplete(ObservableFlatMapCompletableCompletable$FlatMapCompletableMainObserver$InnerObserver observableFlatMapCompletableCompletable$FlatMapCompletableMainObserver$InnerObserver) {
        this.set.c(observableFlatMapCompletableCompletable$FlatMapCompletableMainObserver$InnerObserver);
        this.onComplete();
    }

    public void innerError(ObservableFlatMapCompletableCompletable$FlatMapCompletableMainObserver$InnerObserver observableFlatMapCompletableCompletable$FlatMapCompletableMainObserver$InnerObserver, Throwable throwable) {
        this.set.c(observableFlatMapCompletableCompletable$FlatMapCompletableMainObserver$InnerObserver);
        this.onError(throwable);
    }

    public boolean isDisposed() {
        return this.upstream.isDisposed();
    }

    public void onComplete() {
        int n10 = this.decrementAndGet();
        if (n10 == 0) {
            Object object = this.errors.terminate();
            if (object != null) {
                d d10 = this.downstream;
                d10.onError((Throwable)object);
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
        object2 = new ObservableFlatMapCompletableCompletable$FlatMapCompletableMainObserver$InnerObserver(this);
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
}

