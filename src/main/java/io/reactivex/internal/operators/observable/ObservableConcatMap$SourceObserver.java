/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.a1.a;
import e.a.e0;
import e.a.g0;
import e.a.s0.b;
import e.a.w0.c.j;
import e.a.w0.c.o;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.observable.ObservableConcatMap$SourceObserver$InnerObserver;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableConcatMap$SourceObserver
extends AtomicInteger
implements g0,
b {
    private static final long serialVersionUID = 8828587559905699186L;
    public volatile boolean active;
    public final int bufferSize;
    public volatile boolean disposed;
    public volatile boolean done;
    public final g0 downstream;
    public int fusionMode;
    public final ObservableConcatMap$SourceObserver$InnerObserver inner;
    public final e.a.v0.o mapper;
    public o queue;
    public b upstream;

    public ObservableConcatMap$SourceObserver(g0 g02, e.a.v0.o object, int n10) {
        this.downstream = g02;
        this.mapper = object;
        this.bufferSize = n10;
        this.inner = object = new ObservableConcatMap$SourceObserver$InnerObserver(g02, this);
    }

    public void dispose() {
        this.disposed = true;
        this.inner.dispose();
        Object object = this.upstream;
        object.dispose();
        int n10 = this.getAndIncrement();
        if (n10 == 0) {
            object = this.queue;
            object.clear();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void drain() {
        int n10 = this.getAndIncrement();
        if (n10 != 0) {
            return;
        }
        do {
            boolean bl2;
            Object object2;
            if ((n10 = (int)(this.disposed ? 1 : 0)) != 0) {
                this.queue.clear();
                return;
            }
            n10 = (int)(this.active ? 1 : 0);
            if (n10 != 0) continue;
            n10 = (int)(this.done ? 1 : 0);
            try {
                object2 = this.queue;
                object2 = object2.poll();
                bl2 = true;
                boolean bl3 = object2 == null ? bl2 : false;
                if (n10 != 0 && bl3) {
                    this.disposed = bl2;
                    this.downstream.onComplete();
                    return;
                }
                if (bl3) continue;
            }
            catch (Throwable throwable) {
                e.a.t0.a.b(throwable);
                this.dispose();
                this.queue.clear();
                this.downstream.onError(throwable);
                return;
            }
            try {
                Object object = this.mapper;
                object = object.apply(object2);
                object2 = "The mapper returned a null ObservableSource";
                object = e.a.w0.b.a.g(object, (String)object2);
                object = (e0)object;
                this.active = bl2;
                object2 = this.inner;
                object.subscribe((g0)object2);
            }
            catch (Throwable throwable) {
                e.a.t0.a.b(throwable);
                this.dispose();
                this.queue.clear();
                this.downstream.onError(throwable);
                return;
            }
        } while ((n10 = this.decrementAndGet()) != 0);
    }

    public void innerComplete() {
        this.active = false;
        this.drain();
    }

    public boolean isDisposed() {
        return this.disposed;
    }

    public void onComplete() {
        boolean bl2 = this.done;
        if (bl2) {
            return;
        }
        this.done = true;
        this.drain();
    }

    public void onError(Throwable throwable) {
        boolean bl2 = this.done;
        if (bl2) {
            a.Y(throwable);
            return;
        }
        this.done = true;
        this.dispose();
        this.downstream.onError(throwable);
    }

    public void onNext(Object object) {
        int n10 = this.done;
        if (n10 != 0) {
            return;
        }
        n10 = this.fusionMode;
        if (n10 == 0) {
            o o10 = this.queue;
            o10.offer(object);
        }
        this.drain();
    }

    public void onSubscribe(b object) {
        b b10 = this.upstream;
        int n10 = DisposableHelper.validate(b10, (b)object);
        if (n10 != 0) {
            this.upstream = object;
            n10 = object instanceof j;
            if (n10 != 0) {
                int n11;
                n10 = (object = (j)object).requestFusion(3);
                if (n10 == (n11 = 1)) {
                    this.fusionMode = n10;
                    this.queue = object;
                    this.done = n11;
                    this.downstream.onSubscribe(this);
                    this.drain();
                    return;
                }
                n11 = 2;
                if (n10 == n11) {
                    this.fusionMode = n10;
                    this.queue = object;
                    this.downstream.onSubscribe(this);
                    return;
                }
            }
            n10 = this.bufferSize;
            this.queue = object = new e.a.w0.f.a(n10);
            object = this.downstream;
            object.onSubscribe(this);
        }
    }
}

