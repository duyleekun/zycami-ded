/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.mixed;

import e.a.a1.a;
import e.a.d;
import e.a.g;
import e.a.g0;
import e.a.s0.b;
import e.a.w0.c.j;
import e.a.w0.c.o;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.mixed.ObservableConcatMapCompletable$ConcatMapCompletableObserver$ConcatMapInnerObserver;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableConcatMapCompletable$ConcatMapCompletableObserver
extends AtomicInteger
implements g0,
b {
    private static final long serialVersionUID = 3610901111000061034L;
    public volatile boolean active;
    public volatile boolean disposed;
    public volatile boolean done;
    public final d downstream;
    public final ErrorMode errorMode;
    public final AtomicThrowable errors;
    public final ObservableConcatMapCompletable$ConcatMapCompletableObserver$ConcatMapInnerObserver inner;
    public final e.a.v0.o mapper;
    public final int prefetch;
    public o queue;
    public b upstream;

    public ObservableConcatMapCompletable$ConcatMapCompletableObserver(d object, e.a.v0.o o10, ErrorMode errorMode, int n10) {
        this.downstream = object;
        this.mapper = o10;
        this.errorMode = errorMode;
        this.prefetch = n10;
        this.errors = object = new AtomicThrowable();
        this.inner = object = new ObservableConcatMapCompletable$ConcatMapCompletableObserver$ConcatMapInnerObserver(this);
    }

    public void dispose() {
        this.disposed = true;
        this.upstream.dispose();
        Object object = this.inner;
        ((ObservableConcatMapCompletable$ConcatMapCompletableObserver$ConcatMapInnerObserver)object).dispose();
        int n10 = this.getAndIncrement();
        if (n10 == 0) {
            object = this.queue;
            object.clear();
        }
    }

    public void drain() {
        int n10;
        int n11 = this.getAndIncrement();
        if (n11 != 0) {
            return;
        }
        Object object = this.errors;
        Object object2 = this.errorMode;
        do {
            boolean bl2;
            Object object3;
            boolean bl3;
            Object object4;
            block14: {
                Object object5;
                if ((n10 = this.disposed) != 0) {
                    this.queue.clear();
                    return;
                }
                n10 = this.active;
                if (n10 != 0) continue;
                object4 = ErrorMode.BOUNDARY;
                bl3 = true;
                if (object2 == object4 && (object4 = ((AtomicReference)object).get()) != null) {
                    this.disposed = bl3;
                    this.queue.clear();
                    object = ((AtomicThrowable)object).terminate();
                    this.downstream.onError((Throwable)object);
                    return;
                }
                n10 = (int)(this.done ? 1 : 0);
                object3 = null;
                try {
                    object5 = this.queue;
                }
                catch (Throwable throwable) {
                    e.a.t0.a.b(throwable);
                    this.disposed = bl3;
                    this.queue.clear();
                    this.upstream.dispose();
                    ((AtomicThrowable)object).addThrowable(throwable);
                    object = ((AtomicThrowable)object).terminate();
                    this.downstream.onError((Throwable)object);
                    return;
                }
                object5 = object5.poll();
                if (object5 == null) break block14;
                object3 = this.mapper;
                object3 = object3.apply(object5);
                object5 = "The mapper returned a null CompletableSource";
                object3 = e.a.w0.b.a.g(object3, (String)object5);
                object3 = (g)object3;
                bl2 = false;
                object5 = null;
            }
            bl2 = bl3;
            if (n10 != 0 && bl2) {
                this.disposed = bl3;
                if ((object = ((AtomicThrowable)object).terminate()) != null) {
                    object2 = this.downstream;
                    object2.onError((Throwable)object);
                } else {
                    object = this.downstream;
                    object.onComplete();
                }
                return;
            }
            if (bl2) continue;
            this.active = bl3;
            object4 = this.inner;
            object3.f((d)object4);
        } while ((n10 = this.decrementAndGet()) != 0);
    }

    public void innerComplete() {
        this.active = false;
        this.drain();
    }

    public void innerError(Throwable object) {
        Object object2 = this.errors;
        boolean bl2 = object2.addThrowable((Throwable)object);
        if (bl2) {
            object = this.errorMode;
            object2 = ErrorMode.IMMEDIATE;
            if (object == object2) {
                int n10;
                this.disposed = n10 = 1;
                this.upstream.dispose();
                object = this.errors.terminate();
                object2 = ExceptionHelper.a;
                if (object != object2) {
                    object2 = this.downstream;
                    object2.onError((Throwable)object);
                }
                if ((n10 = this.getAndIncrement()) == 0) {
                    object = this.queue;
                    object.clear();
                }
            } else {
                boolean bl3 = false;
                object = null;
                this.active = false;
                this.drain();
            }
        } else {
            a.Y(object);
        }
    }

    public boolean isDisposed() {
        return this.disposed;
    }

    public void onComplete() {
        this.done = true;
        this.drain();
    }

    public void onError(Throwable object) {
        Object object2 = this.errors;
        boolean bl2 = ((AtomicThrowable)object2).addThrowable((Throwable)object);
        if (bl2) {
            object = this.errorMode;
            object2 = ErrorMode.IMMEDIATE;
            boolean bl3 = true;
            if (object == object2) {
                int n10;
                this.disposed = bl3;
                this.inner.dispose();
                object = this.errors.terminate();
                object2 = ExceptionHelper.a;
                if (object != object2) {
                    object2 = this.downstream;
                    object2.onError((Throwable)object);
                }
                if ((n10 = this.getAndIncrement()) == 0) {
                    object = this.queue;
                    object.clear();
                }
            } else {
                this.done = bl3;
                this.drain();
            }
        } else {
            a.Y((Throwable)object);
        }
    }

    public void onNext(Object object) {
        if (object != null) {
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
                    this.queue = object;
                    this.done = n11;
                    this.downstream.onSubscribe(this);
                    this.drain();
                    return;
                }
                n11 = 2;
                if (n10 == n11) {
                    this.queue = object;
                    this.downstream.onSubscribe(this);
                    return;
                }
            }
            n10 = this.prefetch;
            this.queue = object = new e.a.w0.f.a(n10);
            object = this.downstream;
            object.onSubscribe(this);
        }
    }
}

