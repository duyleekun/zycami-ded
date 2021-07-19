/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.mixed;

import e.a.a1.a;
import e.a.d;
import e.a.g;
import e.a.s0.b;
import e.a.v0.o;
import e.a.w0.c.n;
import i.g.e;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.operators.mixed.FlowableConcatMapCompletable$ConcatMapCompletableObserver$ConcatMapInnerObserver;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.atomic.AtomicInteger;

public final class FlowableConcatMapCompletable$ConcatMapCompletableObserver
extends AtomicInteger
implements e.a.o,
b {
    private static final long serialVersionUID = 3610901111000061034L;
    public volatile boolean active;
    public int consumed;
    public volatile boolean disposed;
    public volatile boolean done;
    public final d downstream;
    public final ErrorMode errorMode;
    public final AtomicThrowable errors;
    public final FlowableConcatMapCompletable$ConcatMapCompletableObserver$ConcatMapInnerObserver inner;
    public final o mapper;
    public final int prefetch;
    public final n queue;
    public e upstream;

    public FlowableConcatMapCompletable$ConcatMapCompletableObserver(d object, o o10, ErrorMode errorMode, int n10) {
        this.downstream = object;
        this.mapper = o10;
        this.errorMode = errorMode;
        this.prefetch = n10;
        this.errors = object = new AtomicThrowable();
        this.inner = object = new FlowableConcatMapCompletable$ConcatMapCompletableObserver$ConcatMapInnerObserver(this);
        this.queue = object = new SpscArrayQueue(n10);
    }

    public void dispose() {
        this.disposed = true;
        this.upstream.cancel();
        Object object = this.inner;
        ((FlowableConcatMapCompletable$ConcatMapCompletableObserver$ConcatMapInnerObserver)object).dispose();
        int n10 = this.getAndIncrement();
        if (n10 == 0) {
            object = this.queue;
            object.clear();
        }
    }

    public void drain() {
        int n10 = this.getAndIncrement();
        if (n10 != 0) {
            return;
        }
        do {
            if ((n10 = (int)(this.disposed ? 1 : 0)) != 0) {
                this.queue.clear();
                return;
            }
            n10 = (int)(this.active ? 1 : 0);
            if (n10 != 0) continue;
            Object object = this.errorMode;
            Object object2 = ErrorMode.BOUNDARY;
            if (object == object2 && (object = this.errors.get()) != null) {
                this.queue.clear();
                object = this.errors.terminate();
                this.downstream.onError((Throwable)object);
                return;
            }
            n10 = (int)(this.done ? 1 : 0);
            object2 = this.queue.poll();
            e e10 = null;
            int n11 = 1;
            int n12 = object2 == null ? n11 : 0;
            if (n10 != 0 && n12 != 0) {
                object = this.errors.terminate();
                if (object != null) {
                    object2 = this.downstream;
                    object2.onError((Throwable)object);
                } else {
                    object = this.downstream;
                    object.onComplete();
                }
                return;
            }
            if (n12 != 0) continue;
            n10 = this.prefetch;
            n12 = n10 >> 1;
            n12 = this.consumed + n11;
            if (n12 == (n10 -= n12)) {
                this.consumed = 0;
                e10 = this.upstream;
                long l10 = n10;
                e10.request(l10);
            } else {
                this.consumed = n12;
            }
            try {
                object = this.mapper;
            }
            catch (Throwable throwable) {
                e.a.t0.a.b(throwable);
                this.queue.clear();
                this.upstream.cancel();
                this.errors.addThrowable(throwable);
                Throwable throwable2 = this.errors.terminate();
                this.downstream.onError(throwable2);
                return;
            }
            object = object.apply(object2);
            object2 = "The mapper returned a null CompletableSource";
            object = e.a.w0.b.a.g(object, (String)object2);
            object = (g)object;
            this.active = n11;
            object2 = this.inner;
            object.f((d)object2);
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
                this.upstream.cancel();
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
        boolean bl2 = object2.addThrowable((Throwable)object);
        if (bl2) {
            object = this.errorMode;
            object2 = ErrorMode.IMMEDIATE;
            if (object == object2) {
                int n10;
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
                boolean bl3;
                this.done = bl3 = true;
                this.drain();
            }
        } else {
            a.Y(object);
        }
    }

    public void onNext(Object object) {
        Object object2 = this.queue;
        boolean bl2 = object2.offer(object);
        if (bl2) {
            this.drain();
        } else {
            this.upstream.cancel();
            object2 = "Queue full?!";
            object = new MissingBackpressureException((String)object2);
            this.onError((Throwable)object);
        }
    }

    public void onSubscribe(e e10) {
        Object object = this.upstream;
        int n10 = SubscriptionHelper.validate((e)object, e10);
        if (n10 != 0) {
            this.upstream = e10;
            object = this.downstream;
            object.onSubscribe(this);
            n10 = this.prefetch;
            long l10 = n10;
            e10.request(l10);
        }
    }
}

