/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.t0.a;
import e.a.w0.c.o;
import e.a.w0.h.g;
import e.a.w0.i.b;
import i.g.c;
import i.g.d;
import i.g.e;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscribers.InnerQueuedSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public final class FlowableConcatMapEager$ConcatMapEagerDelayErrorSubscriber
extends AtomicInteger
implements e.a.o,
e,
g {
    private static final long serialVersionUID = -4255299542215038287L;
    public volatile boolean cancelled;
    public volatile InnerQueuedSubscriber current;
    public volatile boolean done;
    public final d downstream;
    public final ErrorMode errorMode;
    public final AtomicThrowable errors;
    public final e.a.v0.o mapper;
    public final int maxConcurrency;
    public final int prefetch;
    public final AtomicLong requested;
    public final e.a.w0.f.a subscribers;
    public e upstream;

    public FlowableConcatMapEager$ConcatMapEagerDelayErrorSubscriber(d object, e.a.v0.o o10, int n10, int n11, ErrorMode errorMode) {
        this.downstream = object;
        this.mapper = o10;
        this.maxConcurrency = n10;
        this.prefetch = n11;
        this.errorMode = errorMode;
        int n12 = Math.min(n11, n10);
        this.subscribers = object = new e.a.w0.f.a(n12);
        this.errors = object = new AtomicThrowable();
        this.requested = object = new AtomicLong();
    }

    public void cancel() {
        boolean bl2 = this.cancelled;
        if (bl2) {
            return;
        }
        this.cancelled = true;
        this.upstream.cancel();
        this.drainAndCancel();
    }

    public void cancelAll() {
        InnerQueuedSubscriber innerQueuedSubscriber = this.current;
        this.current = null;
        if (innerQueuedSubscriber != null) {
            innerQueuedSubscriber.cancel();
        }
        while ((innerQueuedSubscriber = (InnerQueuedSubscriber)this.subscribers.poll()) != null) {
            innerQueuedSubscriber.cancel();
        }
    }

    public void drain() {
        FlowableConcatMapEager$ConcatMapEagerDelayErrorSubscriber flowableConcatMapEager$ConcatMapEagerDelayErrorSubscriber = this;
        int n10 = this.getAndIncrement();
        if (n10 != 0) {
            return;
        }
        Object object = this.current;
        d d10 = this.downstream;
        Object object2 = this.errorMode;
        int n11 = 1;
        while (true) {
            long l10;
            long l11;
            int n12;
            long l12;
            o o10;
            InnerQueuedSubscriber innerQueuedSubscriber;
            AtomicLong atomicLong = flowableConcatMapEager$ConcatMapEagerDelayErrorSubscriber.requested;
            long l13 = atomicLong.get();
            if (object == null) {
                object = ErrorMode.END;
                if (object2 != object && (object = (Throwable)flowableConcatMapEager$ConcatMapEagerDelayErrorSubscriber.errors.get()) != null) {
                    this.cancelAll();
                    object = flowableConcatMapEager$ConcatMapEagerDelayErrorSubscriber.errors.terminate();
                    d10.onError((Throwable)object);
                    return;
                }
                n10 = (int)(flowableConcatMapEager$ConcatMapEagerDelayErrorSubscriber.done ? 1 : 0);
                innerQueuedSubscriber = (InnerQueuedSubscriber)flowableConcatMapEager$ConcatMapEagerDelayErrorSubscriber.subscribers.poll();
                if (n10 != 0 && innerQueuedSubscriber == null) {
                    object = flowableConcatMapEager$ConcatMapEagerDelayErrorSubscriber.errors.terminate();
                    if (object != null) {
                        d10.onError((Throwable)object);
                    } else {
                        d10.onComplete();
                    }
                    return;
                }
                if (innerQueuedSubscriber != null) {
                    flowableConcatMapEager$ConcatMapEagerDelayErrorSubscriber.current = innerQueuedSubscriber;
                }
            } else {
                innerQueuedSubscriber = object;
            }
            if (innerQueuedSubscriber != null && (o10 = innerQueuedSubscriber.queue()) != null) {
                boolean bl2;
                Object object3;
                long l14;
                block24: {
                    l12 = 0L;
                    while (true) {
                        l14 = l12 == l13 ? 0 : (l12 < l13 ? -1 : 1);
                        n12 = n11;
                        l11 = 1L;
                        if (l14 == false) break;
                        n10 = (int)(flowableConcatMapEager$ConcatMapEagerDelayErrorSubscriber.cancelled ? 1 : 0);
                        if (n10 != 0) {
                            this.cancelAll();
                            return;
                        }
                        object = ErrorMode.IMMEDIATE;
                        if (object2 == object && (object = (Throwable)flowableConcatMapEager$ConcatMapEagerDelayErrorSubscriber.errors.get()) != null) {
                            flowableConcatMapEager$ConcatMapEagerDelayErrorSubscriber.current = null;
                            innerQueuedSubscriber.cancel();
                            this.cancelAll();
                            object = flowableConcatMapEager$ConcatMapEagerDelayErrorSubscriber.errors.terminate();
                            d10.onError((Throwable)object);
                            return;
                        }
                        n10 = (int)(innerQueuedSubscriber.isDone() ? 1 : 0);
                        try {
                            object3 = o10.poll();
                            bl2 = object3 == null;
                            if (n10 != 0 && bl2) {
                                flowableConcatMapEager$ConcatMapEagerDelayErrorSubscriber.current = null;
                                object = flowableConcatMapEager$ConcatMapEagerDelayErrorSubscriber.upstream;
                                object.request(l11);
                                innerQueuedSubscriber = null;
                                n10 = 1;
                                break block24;
                            }
                            if (bl2) break;
                            d10.onNext(object3);
                            l12 += l11;
                            innerQueuedSubscriber.requestOne();
                            n11 = n12;
                        }
                        catch (Throwable throwable) {
                            object2 = throwable;
                            a.b(throwable);
                            flowableConcatMapEager$ConcatMapEagerDelayErrorSubscriber.current = null;
                            innerQueuedSubscriber.cancel();
                            this.cancelAll();
                            d10.onError(throwable);
                            return;
                        }
                    }
                    n10 = 0;
                    object = null;
                }
                if (l14 == false) {
                    boolean bl3 = flowableConcatMapEager$ConcatMapEagerDelayErrorSubscriber.cancelled;
                    if (bl3) {
                        this.cancelAll();
                        return;
                    }
                    object3 = ErrorMode.IMMEDIATE;
                    if (object2 == object3 && (object3 = (Throwable)flowableConcatMapEager$ConcatMapEagerDelayErrorSubscriber.errors.get()) != null) {
                        flowableConcatMapEager$ConcatMapEagerDelayErrorSubscriber.current = null;
                        innerQueuedSubscriber.cancel();
                        this.cancelAll();
                        object = flowableConcatMapEager$ConcatMapEagerDelayErrorSubscriber.errors.terminate();
                        d10.onError((Throwable)object);
                        return;
                    }
                    bl3 = innerQueuedSubscriber.isDone();
                    bl2 = o10.isEmpty();
                    if (bl3 && bl2) {
                        flowableConcatMapEager$ConcatMapEagerDelayErrorSubscriber.current = null;
                        object = flowableConcatMapEager$ConcatMapEagerDelayErrorSubscriber.upstream;
                        object.request(l11);
                        innerQueuedSubscriber = null;
                        n10 = 1;
                    }
                }
                l11 = 0L;
            } else {
                n12 = n11;
                n10 = 0;
                object = null;
                l11 = 0L;
                l12 = 0L;
            }
            long l15 = l12 == l11 ? 0 : (l12 < l11 ? -1 : 1);
            if (l15 != false && (l15 = (l10 = l13 - (l11 = Long.MAX_VALUE)) == 0L ? 0 : (l10 < 0L ? -1 : 1)) != false) {
                AtomicLong atomicLong2 = flowableConcatMapEager$ConcatMapEagerDelayErrorSubscriber.requested;
                long l16 = -l12;
                atomicLong2.addAndGet(l16);
            }
            if (n10 != 0) {
                object = innerQueuedSubscriber;
                n11 = n12;
                continue;
            }
            l15 = n12;
            n10 = -n12;
            n11 = flowableConcatMapEager$ConcatMapEagerDelayErrorSubscriber.addAndGet(n10);
            if (n11 == 0) {
                return;
            }
            object = innerQueuedSubscriber;
        }
    }

    public void drainAndCancel() {
        int n10 = this.getAndIncrement();
        if (n10 == 0) {
            do {
                this.cancelAll();
            } while ((n10 = this.decrementAndGet()) != 0);
        }
    }

    public void innerComplete(InnerQueuedSubscriber innerQueuedSubscriber) {
        innerQueuedSubscriber.setDone();
        this.drain();
    }

    public void innerError(InnerQueuedSubscriber object, Throwable object2) {
        AtomicThrowable atomicThrowable = this.errors;
        boolean bl2 = atomicThrowable.addThrowable((Throwable)object2);
        if (bl2) {
            ((InnerQueuedSubscriber)object).setDone();
            object = this.errorMode;
            object2 = ErrorMode.END;
            if (object != object2) {
                object = this.upstream;
                object.cancel();
            }
            this.drain();
        } else {
            e.a.a1.a.Y(object2);
        }
    }

    public void innerNext(InnerQueuedSubscriber innerQueuedSubscriber, Object object) {
        o o10 = innerQueuedSubscriber.queue();
        boolean bl2 = o10.offer(object);
        if (bl2) {
            this.drain();
        } else {
            innerQueuedSubscriber.cancel();
            object = new MissingBackpressureException();
            this.innerError(innerQueuedSubscriber, (Throwable)object);
        }
    }

    public void onComplete() {
        this.done = true;
        this.drain();
    }

    public void onError(Throwable throwable) {
        AtomicThrowable atomicThrowable = this.errors;
        boolean bl2 = atomicThrowable.addThrowable(throwable);
        if (bl2) {
            boolean bl3;
            this.done = bl3 = true;
            this.drain();
        } else {
            e.a.a1.a.Y(throwable);
        }
    }

    public void onNext(Object object) {
        Object object2;
        try {
            object2 = this.mapper;
        }
        catch (Throwable throwable) {
            a.b(throwable);
            this.upstream.cancel();
            this.onError(throwable);
            return;
        }
        object = object2.apply(object);
        object2 = "The mapper returned a null Publisher";
        object = e.a.w0.b.a.g(object, (String)object2);
        object = (c)object;
        int n10 = this.prefetch;
        object2 = new InnerQueuedSubscriber(this, n10);
        n10 = (int)(this.cancelled ? 1 : 0);
        if (n10 != 0) {
            return;
        }
        e.a.w0.f.a a10 = this.subscribers;
        a10.offer(object2);
        object.subscribe((d)object2);
        boolean bl2 = this.cancelled;
        if (bl2) {
            ((InnerQueuedSubscriber)object2).cancel();
            this.drainAndCancel();
        }
    }

    public void onSubscribe(e e10) {
        Object object = this.upstream;
        int n10 = SubscriptionHelper.validate((e)object, e10);
        if (n10 != 0) {
            this.upstream = e10;
            object = this.downstream;
            object.onSubscribe(this);
            n10 = this.maxConcurrency;
            int n11 = -1 >>> 1;
            long l10 = n10 == n11 ? Long.MAX_VALUE : (long)n10;
            e10.request(l10);
        }
    }

    public void request(long l10) {
        boolean bl2 = SubscriptionHelper.validate(l10);
        if (bl2) {
            AtomicLong atomicLong = this.requested;
            b.a(atomicLong, l10);
            this.drain();
        }
    }
}

