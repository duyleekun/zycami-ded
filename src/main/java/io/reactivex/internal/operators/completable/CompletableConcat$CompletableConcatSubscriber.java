/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.completable;

import e.a.a1.a;
import e.a.d;
import e.a.g;
import e.a.j;
import e.a.s0.b;
import e.a.w0.c.l;
import e.a.w0.c.o;
import i.g.e;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.completable.CompletableConcat$CompletableConcatSubscriber$ConcatInnerObserver;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public final class CompletableConcat$CompletableConcatSubscriber
extends AtomicInteger
implements e.a.o,
b {
    private static final long serialVersionUID = 9032184911934499404L;
    public volatile boolean active;
    public int consumed;
    public volatile boolean done;
    public final d downstream;
    public final CompletableConcat$CompletableConcatSubscriber$ConcatInnerObserver inner;
    public final int limit;
    public final AtomicBoolean once;
    public final int prefetch;
    public o queue;
    public int sourceFused;
    public e upstream;

    public CompletableConcat$CompletableConcatSubscriber(d object, int n10) {
        this.downstream = object;
        this.prefetch = n10;
        super(this);
        this.inner = object;
        this.once = object = new AtomicBoolean();
        int n11 = n10 >> 2;
        this.limit = n10 -= n11;
    }

    public void dispose() {
        this.upstream.cancel();
        DisposableHelper.dispose(this.inner);
    }

    public void drain() {
        int n10 = this.getAndIncrement();
        if (n10 != 0) {
            return;
        }
        do {
            Object object;
            boolean bl2;
            boolean bl3;
            Object object2;
            block8: {
                if ((n10 = (int)(this.isDisposed() ? 1 : 0)) != 0) {
                    return;
                }
                n10 = (int)(this.active ? 1 : 0);
                if (n10 != 0) continue;
                n10 = (int)(this.done ? 1 : 0);
                try {
                    object2 = this.queue;
                }
                catch (Throwable throwable) {
                    e.a.t0.a.b(throwable);
                    this.innerError(throwable);
                    return;
                }
                object2 = object2.poll();
                object2 = (g)object2;
                bl3 = true;
                bl2 = object2 == null ? bl3 : false;
                if (n10 == 0 || !bl2) break block8;
                object = this.once;
                n10 = (int)(((AtomicBoolean)object).compareAndSet(false, bl3) ? 1 : 0);
                if (n10 != 0) {
                    object = this.downstream;
                    object.onComplete();
                }
                return;
            }
            if (bl2) continue;
            this.active = bl3;
            object = this.inner;
            object2.f((d)object);
            this.request();
        } while ((n10 = this.decrementAndGet()) != 0);
    }

    public void innerComplete() {
        this.active = false;
        this.drain();
    }

    public void innerError(Throwable throwable) {
        Object object = this.once;
        boolean bl2 = true;
        boolean bl3 = ((AtomicBoolean)object).compareAndSet(false, bl2);
        if (bl3) {
            this.upstream.cancel();
            object = this.downstream;
            object.onError(throwable);
        } else {
            a.Y(throwable);
        }
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((b)this.inner.get());
    }

    public void onComplete() {
        this.done = true;
        this.drain();
    }

    public void onError(Throwable throwable) {
        Object object = this.once;
        boolean bl2 = true;
        boolean bl3 = ((AtomicBoolean)object).compareAndSet(false, bl2);
        if (bl3) {
            DisposableHelper.dispose(this.inner);
            object = this.downstream;
            object.onError(throwable);
        } else {
            a.Y(throwable);
        }
    }

    public void onNext(g object) {
        o o10;
        boolean bl2;
        int n10 = this.sourceFused;
        if (n10 == 0 && !(bl2 = (o10 = this.queue).offer(object))) {
            object = new MissingBackpressureException();
            this.onError((Throwable)object);
            return;
        }
        this.drain();
    }

    public void onSubscribe(e e10) {
        Object object = this.upstream;
        int n10 = SubscriptionHelper.validate((e)object, e10);
        if (n10 != 0) {
            this.upstream = e10;
            n10 = this.prefetch;
            int n11 = -1 >>> 1;
            long l10 = n10 == n11 ? Long.MAX_VALUE : (long)n10;
            n10 = e10 instanceof l;
            if (n10 != 0) {
                int n12;
                object = e10;
                object = (l)e10;
                int n13 = object.requestFusion(3);
                if (n13 == (n12 = 1)) {
                    this.sourceFused = n13;
                    this.queue = object;
                    this.done = n12;
                    this.downstream.onSubscribe(this);
                    this.drain();
                    return;
                }
                n12 = 2;
                if (n13 == n12) {
                    this.sourceFused = n13;
                    this.queue = object;
                    this.downstream.onSubscribe(this);
                    e10.request(l10);
                    return;
                }
            }
            if ((n10 = this.prefetch) == n11) {
                n11 = j.f0();
                this.queue = object = new e.a.w0.f.a(n11);
            } else {
                n11 = this.prefetch;
                this.queue = object = new SpscArrayQueue(n11);
            }
            object = this.downstream;
            object.onSubscribe(this);
            e10.request(l10);
        }
    }

    public void request() {
        int n10 = this.sourceFused;
        int n11 = 1;
        if (n10 != n11) {
            n10 = this.consumed + n11;
            if (n10 == (n11 = this.limit)) {
                n11 = 0;
                this.consumed = 0;
                e e10 = this.upstream;
                long l10 = n10;
                e10.request(l10);
            } else {
                this.consumed = n10;
            }
        }
    }
}

