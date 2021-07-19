/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.t0.a;
import e.a.w0.c.l;
import e.a.w0.c.o;
import e.a.w0.i.b;
import i.g.d;
import i.g.e;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.io.Serializable;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class FlowableFlattenIterable$FlattenIterableSubscriber
extends BasicIntQueueSubscription
implements e.a.o {
    private static final long serialVersionUID = -3096000382929934955L;
    public volatile boolean cancelled;
    public int consumed;
    public Iterator current;
    public volatile boolean done;
    public final d downstream;
    public final AtomicReference error;
    public int fusionMode;
    public final int limit;
    public final e.a.v0.o mapper;
    public final int prefetch;
    public o queue;
    public final AtomicLong requested;
    public e upstream;

    public FlowableFlattenIterable$FlattenIterableSubscriber(d serializable, e.a.v0.o o10, int n10) {
        this.downstream = serializable;
        this.mapper = o10;
        this.prefetch = n10;
        int n11 = n10 >> 2;
        this.limit = n10 -= n11;
        this.error = serializable = new Serializable();
        this.requested = serializable;
    }

    public void cancel() {
        int n10 = this.cancelled;
        if (n10 == 0) {
            this.cancelled = true;
            Object object = this.upstream;
            object.cancel();
            n10 = this.getAndIncrement();
            if (n10 == 0) {
                object = this.queue;
                object.clear();
            }
        }
    }

    public boolean checkTerminated(boolean bl2, boolean bl3, d d10, o o10) {
        boolean bl4 = this.cancelled;
        boolean bl5 = true;
        if (bl4) {
            this.current = null;
            o10.clear();
            return bl5;
        }
        if (bl2) {
            Throwable throwable = (Throwable)this.error.get();
            if (throwable != null) {
                throwable = ExceptionHelper.c(this.error);
                this.current = null;
                o10.clear();
                d10.onError(throwable);
                return bl5;
            }
            if (bl3) {
                d10.onComplete();
                return bl5;
            }
        }
        return false;
    }

    public void clear() {
        this.current = null;
        this.queue.clear();
    }

    public void consumedOne(boolean n10) {
        if (n10 != 0) {
            n10 = this.consumed + 1;
            int n11 = this.limit;
            if (n10 == n11) {
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

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void drain() {
        FlowableFlattenIterable$FlattenIterableSubscriber flowableFlattenIterable$FlattenIterableSubscriber = this;
        int n10 = this.getAndIncrement();
        if (n10) {
            return;
        }
        d d10 = this.downstream;
        Object object = this.queue;
        n10 = this.fusionMode;
        Throwable throwable = null;
        int n11 = 1;
        if (n10 != n11) {
            n10 = n11;
        } else {
            n10 = 0;
            Object var7_7 = null;
        }
        Iterator iterator2 = flowableFlattenIterable$FlattenIterableSubscriber.current;
        int n12 = n11;
        while (true) {
            block31: {
                block30: {
                    long l10;
                    Object object2;
                    Object e10;
                    long l11;
                    long l12;
                    block29: {
                        if (iterator2 == null) {
                            Object object3;
                            boolean bl2 = flowableFlattenIterable$FlattenIterableSubscriber.done;
                            try {
                                object3 = object.poll();
                                int n13 = object3 == null ? n11 : 0;
                                bl2 = flowableFlattenIterable$FlattenIterableSubscriber.checkTerminated(bl2, n13 != 0, d10, (o)object);
                                if (bl2) {
                                    return;
                                }
                                if (object3 == null) break block29;
                            }
                            catch (Throwable throwable2) {
                                throwable = throwable2;
                                a.b(throwable2);
                                flowableFlattenIterable$FlattenIterableSubscriber.upstream.cancel();
                                ExceptionHelper.a(flowableFlattenIterable$FlattenIterableSubscriber.error, throwable);
                                Throwable throwable3 = ExceptionHelper.c(flowableFlattenIterable$FlattenIterableSubscriber.error);
                                flowableFlattenIterable$FlattenIterableSubscriber.current = null;
                                object.clear();
                                d10.onError(throwable3);
                                return;
                            }
                            try {
                                iterator2 = flowableFlattenIterable$FlattenIterableSubscriber.mapper;
                                iterator2 = iterator2.apply(object3);
                                iterator2 = (Iterable)((Object)iterator2);
                                iterator2 = iterator2.iterator();
                                bl2 = iterator2.hasNext();
                                if (!bl2) {
                                    flowableFlattenIterable$FlattenIterableSubscriber.consumedOne(n10 != 0);
                                    iterator2 = null;
                                    continue;
                                }
                                flowableFlattenIterable$FlattenIterableSubscriber.current = iterator2;
                            }
                            catch (Throwable throwable4) {
                                a.b(throwable4);
                                flowableFlattenIterable$FlattenIterableSubscriber.upstream.cancel();
                                ExceptionHelper.a(flowableFlattenIterable$FlattenIterableSubscriber.error, throwable4);
                                Throwable throwable5 = ExceptionHelper.c(flowableFlattenIterable$FlattenIterableSubscriber.error);
                                d10.onError(throwable5);
                                return;
                            }
                        }
                    }
                    if (iterator2 == null) break block30;
                    AtomicLong atomicLong = flowableFlattenIterable$FlattenIterableSubscriber.requested;
                    long l13 = atomicLong.get();
                    long l14 = l12 = 0L;
                    while ((l11 = l14 == l13 ? 0 : (l14 < l13 ? -1 : 1)) != false) {
                        l11 = (long)flowableFlattenIterable$FlattenIterableSubscriber.done;
                        if ((l11 = (long)flowableFlattenIterable$FlattenIterableSubscriber.checkTerminated((boolean)l11, false, d10, (o)object)) != false) {
                            return;
                        }
                        try {
                            e10 = iterator2.next();
                            object2 = "The iterator returned a null value";
                            object2 = e.a.w0.b.a.g(e10, (String)object2);
                            d10.onNext(object2);
                            n11 = flowableFlattenIterable$FlattenIterableSubscriber.done;
                            n11 = flowableFlattenIterable$FlattenIterableSubscriber.checkTerminated(n11 != 0, false, d10, (o)object);
                            if (n11) {
                                return;
                            }
                            long l15 = 1L;
                            l14 += l15;
                        }
                        catch (Throwable throwable6) {
                            a.b(throwable6);
                            flowableFlattenIterable$FlattenIterableSubscriber.current = null;
                            flowableFlattenIterable$FlattenIterableSubscriber.upstream.cancel();
                            ExceptionHelper.a(flowableFlattenIterable$FlattenIterableSubscriber.error, throwable6);
                            Throwable throwable7 = ExceptionHelper.c(flowableFlattenIterable$FlattenIterableSubscriber.error);
                            d10.onError(throwable7);
                            return;
                        }
                        try {
                            n11 = iterator2.hasNext();
                            if (!n11) {
                                flowableFlattenIterable$FlattenIterableSubscriber.consumedOne(n10 != 0);
                                flowableFlattenIterable$FlattenIterableSubscriber.current = null;
                                iterator2 = null;
                                break;
                            }
                            n11 = 1;
                        }
                        catch (Throwable throwable8) {
                            object = throwable8;
                            a.b(throwable8);
                            flowableFlattenIterable$FlattenIterableSubscriber.current = null;
                            flowableFlattenIterable$FlattenIterableSubscriber.upstream.cancel();
                            ExceptionHelper.a(flowableFlattenIterable$FlattenIterableSubscriber.error, (Throwable)object);
                            Throwable throwable9 = ExceptionHelper.c(flowableFlattenIterable$FlattenIterableSubscriber.error);
                            d10.onError(throwable9);
                            return;
                        }
                    }
                    if (!(n11 = l14 == l13 ? 0 : (l14 < l13 ? -1 : 1))) {
                        n11 = flowableFlattenIterable$FlattenIterableSubscriber.done;
                        l11 = (long)object.isEmpty();
                        if (l11 != false && iterator2 == null) {
                            l11 = 1;
                        } else {
                            l11 = 0;
                            e10 = null;
                        }
                        n11 = flowableFlattenIterable$FlattenIterableSubscriber.checkTerminated(n11 != 0, (boolean)l11, d10, (o)object);
                        if (n11) {
                            return;
                        }
                    }
                    if ((n11 = l14 == l12 ? 0 : (l14 < l12 ? -1 : 1)) && (n11 = (l10 = l13 - (l12 = Long.MAX_VALUE)) == 0L ? 0 : (l10 < 0L ? -1 : 1))) {
                        object2 = flowableFlattenIterable$FlattenIterableSubscriber.requested;
                        l13 = -l14;
                        ((AtomicLong)object2).addAndGet(l13);
                    }
                    if (iterator2 == null) break block31;
                }
                if (!(n12 = flowableFlattenIterable$FlattenIterableSubscriber.addAndGet(n11 = -n12))) {
                    return;
                }
            }
            n11 = 1;
        }
    }

    public boolean isEmpty() {
        boolean bl2;
        Object object = this.current;
        if (object == null && (bl2 = (object = this.queue).isEmpty())) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
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
        AtomicReference atomicReference;
        boolean bl2 = this.done;
        if (!bl2 && (bl2 = ExceptionHelper.a(atomicReference = this.error, throwable))) {
            boolean bl3;
            this.done = bl3 = true;
            this.drain();
        } else {
            e.a.a1.a.Y(throwable);
        }
    }

    public void onNext(Object object) {
        o o10;
        boolean bl2;
        int n10 = this.done;
        if (n10 != 0) {
            return;
        }
        n10 = this.fusionMode;
        if (n10 == 0 && !(bl2 = (o10 = this.queue).offer(object))) {
            object = new MissingBackpressureException("Queue is full?!");
            this.onError((Throwable)object);
            return;
        }
        this.drain();
    }

    public void onSubscribe(e e10) {
        Object object = this.upstream;
        int n10 = SubscriptionHelper.validate((e)object, e10);
        if (n10 != 0) {
            int n11;
            this.upstream = e10;
            n10 = e10 instanceof l;
            if (n10 != 0) {
                int n12;
                object = e10;
                object = (l)e10;
                n11 = object.requestFusion(3);
                if (n11 == (n12 = 1)) {
                    this.fusionMode = n11;
                    this.queue = object;
                    this.done = n12;
                    this.downstream.onSubscribe(this);
                    return;
                }
                n12 = 2;
                if (n11 == n12) {
                    this.fusionMode = n11;
                    this.queue = object;
                    this.downstream.onSubscribe(this);
                    long l10 = this.prefetch;
                    e10.request(l10);
                    return;
                }
            }
            n11 = this.prefetch;
            this.queue = object = new SpscArrayQueue(n11);
            object = this.downstream;
            object.onSubscribe(this);
            n10 = this.prefetch;
            long l11 = n10;
            e10.request(l11);
        }
    }

    public Object poll() {
        boolean bl2;
        Object object;
        Object object2 = this.current;
        while (object2 == null) {
            object2 = this.queue.poll();
            if (object2 == null) {
                return null;
            }
            object = this.mapper;
            boolean bl3 = (object2 = ((Iterable)object.apply(object2)).iterator()).hasNext();
            if (!bl3) {
                bl2 = false;
                object2 = null;
                continue;
            }
            this.current = object2;
            break;
        }
        object = object2.next();
        String string2 = "The iterator returned a null value";
        object = e.a.w0.b.a.g(object, string2);
        bl2 = object2.hasNext();
        if (!bl2) {
            this.current = null;
        }
        return object;
    }

    public void request(long l10) {
        boolean bl2 = SubscriptionHelper.validate(l10);
        if (bl2) {
            AtomicLong atomicLong = this.requested;
            b.a(atomicLong, l10);
            this.drain();
        }
    }

    public int requestFusion(int n10) {
        int n11 = 1;
        if ((n10 &= n11) != 0 && (n10 = this.fusionMode) == n11) {
            return n11;
        }
        return 0;
    }
}

