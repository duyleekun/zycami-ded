/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.mixed;

import e.a.a1.a;
import e.a.l0;
import e.a.o0;
import e.a.v0.o;
import e.a.w0.c.n;
import e.a.w0.i.b;
import i.g.d;
import i.g.e;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.operators.mixed.FlowableConcatMapSingle$ConcatMapSingleSubscriber$ConcatMapSingleObserver;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public final class FlowableConcatMapSingle$ConcatMapSingleSubscriber
extends AtomicInteger
implements e.a.o,
e {
    public static final int STATE_ACTIVE = 1;
    public static final int STATE_INACTIVE = 0;
    public static final int STATE_RESULT_VALUE = 2;
    private static final long serialVersionUID = -9140123220065488293L;
    public volatile boolean cancelled;
    public int consumed;
    public volatile boolean done;
    public final d downstream;
    public long emitted;
    public final ErrorMode errorMode;
    public final AtomicThrowable errors;
    public final FlowableConcatMapSingle$ConcatMapSingleSubscriber$ConcatMapSingleObserver inner;
    public Object item;
    public final o mapper;
    public final int prefetch;
    public final n queue;
    public final AtomicLong requested;
    public volatile int state;
    public e upstream;

    public FlowableConcatMapSingle$ConcatMapSingleSubscriber(d object, o o10, int n10, ErrorMode errorMode) {
        this.downstream = object;
        this.mapper = o10;
        this.prefetch = n10;
        this.errorMode = errorMode;
        this.requested = object = new AtomicLong();
        this.errors = object = new AtomicThrowable();
        this.inner = object = new FlowableConcatMapSingle$ConcatMapSingleSubscriber$ConcatMapSingleObserver(this);
        this.queue = object = new SpscArrayQueue(n10);
    }

    public void cancel() {
        this.cancelled = true;
        this.upstream.cancel();
        FlowableConcatMapSingle$ConcatMapSingleSubscriber$ConcatMapSingleObserver flowableConcatMapSingle$ConcatMapSingleSubscriber$ConcatMapSingleObserver = this.inner;
        flowableConcatMapSingle$ConcatMapSingleSubscriber$ConcatMapSingleObserver.dispose();
        int n10 = this.getAndIncrement();
        if (n10 == 0) {
            this.queue.clear();
            n10 = 0;
            flowableConcatMapSingle$ConcatMapSingleSubscriber$ConcatMapSingleObserver = null;
            this.item = null;
        }
    }

    public void drain() {
        int n10 = this.getAndIncrement();
        if (n10 != 0) {
            return;
        }
        d d10 = this.downstream;
        Object object = this.errorMode;
        n n11 = this.queue;
        AtomicThrowable atomicThrowable = this.errors;
        AtomicLong atomicLong = this.requested;
        int n12 = this.prefetch;
        int n13 = n12 >> 1;
        n12 -= n13;
        int n14 = n13 = 1;
        while (true) {
            int n15 = this.cancelled;
            Object object2 = null;
            if (n15 != 0) {
                n11.clear();
                this.item = null;
            } else {
                Object object3;
                int n16;
                n15 = this.state;
                Object object4 = atomicThrowable.get();
                if (object4 != null && (object == (object4 = ErrorMode.IMMEDIATE) || object == (object4 = ErrorMode.BOUNDARY) && n15 == 0)) {
                    n11.clear();
                    this.item = null;
                    object = atomicThrowable.terminate();
                    d10.onError((Throwable)object);
                    return;
                }
                object4 = null;
                if (n15 == 0) {
                    n15 = (int)(this.done ? 1 : 0);
                    object2 = n11.poll();
                    n16 = object2 == null ? n13 : 0;
                    if (n15 != 0 && n16 != 0) {
                        object = atomicThrowable.terminate();
                        if (object == null) {
                            d10.onComplete();
                        } else {
                            d10.onError((Throwable)object);
                        }
                        return;
                    }
                    if (n16 == 0) {
                        n15 = this.consumed + n13;
                        if (n15 == n12) {
                            this.consumed = 0;
                            object3 = this.upstream;
                            long l10 = n12;
                            object3.request(l10);
                        } else {
                            this.consumed = n15;
                        }
                        try {
                            object3 = this.mapper;
                        }
                        catch (Throwable throwable) {
                            e.a.t0.a.b(throwable);
                            this.upstream.cancel();
                            n11.clear();
                            atomicThrowable.addThrowable(throwable);
                            Throwable throwable2 = atomicThrowable.terminate();
                            d10.onError(throwable2);
                            return;
                        }
                        object3 = object3.apply(object2);
                        object2 = "The mapper returned a null SingleSource";
                        object3 = e.a.w0.b.a.g(object3, (String)object2);
                        object3 = (o0)object3;
                        this.state = n13;
                        object2 = this.inner;
                        object3.f((l0)object2);
                    }
                } else {
                    long l11;
                    long l12;
                    long l13;
                    n16 = 2;
                    if (n15 == n16 && (n15 = (int)((l13 = (l12 = this.emitted) - (l11 = atomicLong.get())) == 0L ? 0 : (l13 < 0L ? -1 : 1))) != 0) {
                        object3 = this.item;
                        this.item = null;
                        d10.onNext(object3);
                        long l14 = 1L;
                        this.emitted = l12 += l14;
                        this.state = 0;
                        continue;
                    }
                }
            }
            n14 = -n14;
            if ((n14 = this.addAndGet(n14)) == 0) break;
        }
    }

    public void innerError(Throwable object) {
        Object object2 = this.errors;
        boolean bl2 = object2.addThrowable((Throwable)object);
        if (bl2) {
            object = this.errorMode;
            object2 = ErrorMode.END;
            if (object != object2) {
                object = this.upstream;
                object.cancel();
            }
            object = null;
            this.state = 0;
            this.drain();
        } else {
            a.Y(object);
        }
    }

    public void innerSuccess(Object object) {
        this.item = object;
        this.state = 2;
        this.drain();
    }

    public void onComplete() {
        this.done = true;
        this.drain();
    }

    public void onError(Throwable object) {
        Object object2 = this.errors;
        boolean bl2 = object2.addThrowable((Throwable)object);
        if (bl2) {
            boolean bl3;
            object = this.errorMode;
            object2 = ErrorMode.IMMEDIATE;
            if (object == object2) {
                object = this.inner;
                ((FlowableConcatMapSingle$ConcatMapSingleSubscriber$ConcatMapSingleObserver)object).dispose();
            }
            this.done = bl3 = true;
            this.drain();
        } else {
            a.Y(object);
        }
    }

    public void onNext(Object object) {
        n n10 = this.queue;
        boolean bl2 = n10.offer(object);
        if (!bl2) {
            this.upstream.cancel();
            object = new MissingBackpressureException("queue full?!");
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
            object = this.downstream;
            object.onSubscribe(this);
            n10 = this.prefetch;
            long l10 = n10;
            e10.request(l10);
        }
    }

    public void request(long l10) {
        b.a(this.requested, l10);
        this.drain();
    }
}

