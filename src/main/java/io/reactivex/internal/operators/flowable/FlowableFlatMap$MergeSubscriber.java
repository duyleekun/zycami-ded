/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.t0.a;
import e.a.w0.c.n;
import e.a.w0.c.o;
import e.a.w0.i.b;
import i.g.c;
import i.g.d;
import i.g.e;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.operators.flowable.FlowableFlatMap$InnerSubscriber;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ExceptionHelper;
import java.io.Serializable;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class FlowableFlatMap$MergeSubscriber
extends AtomicInteger
implements e.a.o,
e {
    public static final FlowableFlatMap$InnerSubscriber[] CANCELLED;
    public static final FlowableFlatMap$InnerSubscriber[] EMPTY;
    private static final long serialVersionUID = -2117620485640801370L;
    public final int bufferSize;
    public volatile boolean cancelled;
    public final boolean delayErrors;
    public volatile boolean done;
    public final d downstream;
    public final AtomicThrowable errs;
    public long lastId;
    public int lastIndex;
    public final e.a.v0.o mapper;
    public final int maxConcurrency;
    public volatile n queue;
    public final AtomicLong requested;
    public int scalarEmitted;
    public final int scalarLimit;
    public final AtomicReference subscribers;
    public long uniqueId;
    public e upstream;

    static {
        EMPTY = new FlowableFlatMap$InnerSubscriber[0];
        CANCELLED = new FlowableFlatMap$InnerSubscriber[0];
    }

    public FlowableFlatMap$MergeSubscriber(d flowableFlatMap$InnerSubscriberArray, e.a.v0.o o10, boolean bl2, int n10, int n11) {
        int n12;
        AtomicLong atomicLong;
        AtomicReference atomicReference = new AtomicThrowable();
        this.errs = atomicReference;
        this.subscribers = atomicReference;
        this.requested = atomicLong = new AtomicLong();
        this.downstream = flowableFlatMap$InnerSubscriberArray;
        this.mapper = o10;
        this.delayErrors = bl2;
        this.maxConcurrency = n10;
        this.bufferSize = n11;
        int n13 = n10 >> 1;
        this.scalarLimit = n12 = Math.max(1, n13);
        flowableFlatMap$InnerSubscriberArray = EMPTY;
        atomicReference.lazySet(flowableFlatMap$InnerSubscriberArray);
    }

    public boolean addInner(FlowableFlatMap$InnerSubscriber flowableFlatMap$InnerSubscriber) {
        FlowableFlatMap$InnerSubscriber[] flowableFlatMap$InnerSubscriberArray;
        FlowableFlatMap$InnerSubscriber[] flowableFlatMap$InnerSubscriberArray2;
        Object object;
        boolean bl2;
        do {
            if ((flowableFlatMap$InnerSubscriberArray2 = (FlowableFlatMap$InnerSubscriber[])this.subscribers.get()) == (object = CANCELLED)) {
                flowableFlatMap$InnerSubscriber.dispose();
                return false;
            }
            int n10 = flowableFlatMap$InnerSubscriberArray2.length;
            int n11 = n10 + 1;
            flowableFlatMap$InnerSubscriberArray = new FlowableFlatMap$InnerSubscriber[n11];
            System.arraycopy(flowableFlatMap$InnerSubscriberArray2, 0, flowableFlatMap$InnerSubscriberArray, 0, n10);
            flowableFlatMap$InnerSubscriberArray[n10] = flowableFlatMap$InnerSubscriber;
        } while (!(bl2 = ((AtomicReference)(object = this.subscribers)).compareAndSet(flowableFlatMap$InnerSubscriberArray2, flowableFlatMap$InnerSubscriberArray)));
        return true;
    }

    public void cancel() {
        int n10 = this.cancelled;
        if (n10 == 0) {
            this.cancelled = true;
            Object object = this.upstream;
            object.cancel();
            this.disposeAll();
            n10 = this.getAndIncrement();
            if (n10 == 0 && (object = this.queue) != null) {
                object.clear();
            }
        }
    }

    public boolean checkTerminate() {
        Object object;
        boolean bl2 = this.cancelled;
        boolean bl3 = true;
        if (bl2) {
            this.clearScalarQueue();
            return bl3;
        }
        bl2 = this.delayErrors;
        if (!bl2 && (object = this.errs.get()) != null) {
            this.clearScalarQueue();
            object = this.errs.terminate();
            Object object2 = ExceptionHelper.a;
            if (object != object2) {
                object2 = this.downstream;
                object2.onError((Throwable)object);
            }
            return bl3;
        }
        return false;
    }

    public void clearScalarQueue() {
        n n10 = this.queue;
        if (n10 != null) {
            n10.clear();
        }
    }

    public void disposeAll() {
        FlowableFlatMap$InnerSubscriber[] flowableFlatMap$InnerSubscriberArray;
        Object object;
        FlowableFlatMap$InnerSubscriber[] object2 = (FlowableFlatMap$InnerSubscriber[])this.subscribers.get();
        if (object2 != (object = CANCELLED) && (flowableFlatMap$InnerSubscriberArray = this.subscribers.getAndSet(object)) != object) {
            for (FlowableFlatMap$InnerSubscriber flowableFlatMap$InnerSubscriber : flowableFlatMap$InnerSubscriberArray) {
                flowableFlatMap$InnerSubscriber.dispose();
            }
            Throwable throwable = this.errs.terminate();
            if (throwable != null && throwable != (object = ExceptionHelper.a)) {
                e.a.a1.a.Y(throwable);
            }
        }
    }

    public void drain() {
        int n10 = this.getAndIncrement();
        if (n10 == 0) {
            this.drainLoop();
        }
    }

    public void drainLoop() {
        FlowableFlatMap$MergeSubscriber flowableFlatMap$MergeSubscriber = this;
        d d10 = this.downstream;
        int n10 = 1;
        while (true) {
            int n11;
            long l10;
            int n12;
            int n13;
            long l11;
            Object object;
            int n14;
            block48: {
                Object object2;
                Object object3;
                long l12;
                long l13;
                block45: {
                    FlowableFlatMap$InnerSubscriber[] flowableFlatMap$InnerSubscriberArray;
                    block44: {
                        Object object4;
                        Object object5;
                        Serializable serializable;
                        Object object6;
                        Object object7;
                        AtomicLong atomicLong;
                        block47: {
                            long l14;
                            block46: {
                                long l15;
                                if ((n14 = this.checkTerminate()) != 0) {
                                    return;
                                }
                                object = flowableFlatMap$MergeSubscriber.queue;
                                atomicLong = flowableFlatMap$MergeSubscriber.requested;
                                l11 = atomicLong.get();
                                long l16 = l11 - (l15 = Long.MAX_VALUE);
                                object7 = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
                                object7 = object7 == false ? (Object)1 : (Object)0;
                                long l17 = 1L;
                                l12 = l13 = 0L;
                                if (object != null) {
                                    while (true) {
                                        long l18;
                                        l15 = l13;
                                        n13 = 0;
                                        Object object8 = null;
                                        while ((l18 = l11 == l13 ? 0 : (l11 < l13 ? -1 : 1)) != false) {
                                            object3 = object.poll();
                                            n13 = this.checkTerminate();
                                            if (n13 != 0) {
                                                return;
                                            }
                                            if (object3 == null) {
                                                object8 = object3;
                                                break;
                                            }
                                            d10.onNext(object3);
                                            l12 += l17;
                                            l15 += l17;
                                            l11 -= l17;
                                            object8 = object3;
                                        }
                                        if ((n12 = (int)(l15 == l13 ? 0 : (l15 < l13 ? -1 : 1))) != 0) {
                                            if (object7 != false) {
                                                l11 = Long.MAX_VALUE;
                                            } else {
                                                atomicLong = flowableFlatMap$MergeSubscriber.requested;
                                                long l19 = -l15;
                                                l11 = atomicLong.addAndGet(l19);
                                            }
                                        }
                                        if ((object2 = l11 == l13 ? 0 : (l11 < l13 ? -1 : 1)) == false || object8 == null) break;
                                        l15 = Long.MAX_VALUE;
                                    }
                                }
                                n14 = flowableFlatMap$MergeSubscriber.done;
                                object6 = flowableFlatMap$MergeSubscriber.queue;
                                flowableFlatMap$InnerSubscriberArray = (FlowableFlatMap$InnerSubscriber[])flowableFlatMap$MergeSubscriber.subscribers.get();
                                n12 = flowableFlatMap$InnerSubscriberArray.length;
                                if (n14 != 0 && (object6 == null || (n14 = object6.isEmpty()) != 0) && n12 == 0) {
                                    object = flowableFlatMap$MergeSubscriber.errs.terminate();
                                    if (object != (serializable = ExceptionHelper.a)) {
                                        if (object == null) {
                                            d10.onComplete();
                                        } else {
                                            d10.onError((Throwable)object);
                                        }
                                    }
                                    return;
                                }
                                n13 = n10;
                                if (n12 == 0) break block45;
                                l10 = flowableFlatMap$MergeSubscriber.lastId;
                                n14 = flowableFlatMap$MergeSubscriber.lastIndex;
                                if (n12 <= n14) break block46;
                                object6 = flowableFlatMap$InnerSubscriberArray[n14];
                                l14 = ((FlowableFlatMap$InnerSubscriber)object6).id;
                                long l20 = l14 - l10;
                                object2 = l20 == 0L ? 0 : (l20 < 0L ? -1 : 1);
                                if (object2 == false) break block47;
                            }
                            if (n12 <= n14) {
                                n14 = 0;
                                object = null;
                            }
                            object6 = null;
                            for (object2 = (Object)0; object2 < n12; ++object2) {
                                object5 = flowableFlatMap$InnerSubscriberArray[n14];
                                l14 = ((FlowableFlatMap$InnerSubscriber)object5).id;
                                long l21 = l14 - l10;
                                object4 = l21 == 0L ? 0 : (l21 < 0L ? -1 : 1);
                                if (object4 == false) break;
                                if (++n14 != n12) continue;
                                n14 = 0;
                                object = null;
                            }
                            flowableFlatMap$MergeSubscriber.lastIndex = n14;
                            serializable = flowableFlatMap$InnerSubscriberArray[n14];
                            flowableFlatMap$MergeSubscriber.lastId = l10 = ((FlowableFlatMap$InnerSubscriber)serializable).id;
                        }
                        n11 = n14;
                        n14 = 0;
                        object = null;
                        for (n10 = 0; n10 < n12; n10 += object2) {
                            int n15;
                            block43: {
                                long l22;
                                object2 = this.checkTerminate();
                                if (object2 != false) {
                                    return;
                                }
                                object6 = flowableFlatMap$InnerSubscriberArray[n11];
                                object4 = 0;
                                object5 = null;
                                while (true) {
                                    long l23;
                                    boolean bl2;
                                    if (bl2 = this.checkTerminate()) {
                                        return;
                                    }
                                    o o10 = ((FlowableFlatMap$InnerSubscriber)object6).queue;
                                    if (o10 == null) {
                                        n15 = n12;
                                        break;
                                    }
                                    n15 = n12;
                                    Object object9 = object5;
                                    l22 = l13;
                                    while ((l23 = l11 == l13 ? 0 : (l11 < l13 ? -1 : 1)) != false) {
                                        try {
                                            Object object10 = o10.poll();
                                            if (object10 == null) {
                                                object9 = object10;
                                                l13 = 0L;
                                                break;
                                            }
                                            d10.onNext(object10);
                                            boolean bl3 = this.checkTerminate();
                                            if (bl3) {
                                                return;
                                            }
                                            long l24 = 1L;
                                            l11 -= l24;
                                            l22 += l24;
                                            object9 = object10;
                                            l13 = 0L;
                                        }
                                        catch (Throwable throwable) {
                                            object3 = throwable;
                                            a.b(throwable);
                                            ((FlowableFlatMap$InnerSubscriber)object6).dispose();
                                            object = flowableFlatMap$MergeSubscriber.errs;
                                            ((AtomicThrowable)object).addThrowable((Throwable)object3);
                                            n14 = (int)(flowableFlatMap$MergeSubscriber.delayErrors ? 1 : 0);
                                            if (n14 == 0) {
                                                object = flowableFlatMap$MergeSubscriber.upstream;
                                                object.cancel();
                                            }
                                            if ((n14 = (int)(this.checkTerminate() ? 1 : 0)) != 0) {
                                                return;
                                            }
                                            flowableFlatMap$MergeSubscriber.removeInner((FlowableFlatMap$InnerSubscriber)object6);
                                            ++n10;
                                            n14 = 1;
                                            object2 = 1;
                                            l22 = 1L;
                                            break block43;
                                        }
                                    }
                                    if (bl2 = l22 == l13 ? 0 : (l22 < l13 ? -1 : 1)) {
                                        if (object7 == false) {
                                            atomicLong = flowableFlatMap$MergeSubscriber.requested;
                                            l13 = -l22;
                                            l11 = atomicLong.addAndGet(l13);
                                        } else {
                                            l11 = Long.MAX_VALUE;
                                        }
                                        ((FlowableFlatMap$InnerSubscriber)object6).requestMore(l22);
                                        l22 = 0L;
                                    } else {
                                        l22 = l13;
                                    }
                                    bl2 = l11 == l22 ? 0 : (l11 < l22 ? -1 : 1);
                                    if (!bl2 || object9 == null) break;
                                    n12 = n15;
                                    object5 = object9;
                                    l13 = 0L;
                                }
                                n12 = (int)(((FlowableFlatMap$InnerSubscriber)object6).done ? 1 : 0);
                                object5 = ((FlowableFlatMap$InnerSubscriber)object6).queue;
                                if (n12 != 0 && (object5 == null || (n12 = (int)(object5.isEmpty() ? 1 : 0)) != 0)) {
                                    flowableFlatMap$MergeSubscriber.removeInner((FlowableFlatMap$InnerSubscriber)object6);
                                    n14 = (int)(this.checkTerminate() ? 1 : 0);
                                    if (n14 != 0) {
                                        return;
                                    }
                                    l22 = 1L;
                                    l12 += l22;
                                    n14 = 1;
                                } else {
                                    l22 = 1L;
                                }
                                l13 = 0L;
                                object2 = l11 == l13 ? 0 : (l11 < l13 ? -1 : 1);
                                if (object2 == false) {
                                    n12 = n14;
                                    object2 = 1;
                                    break block44;
                                }
                                if (++n11 == n15) {
                                    n11 = 0;
                                    serializable = null;
                                }
                                object2 = 1;
                            }
                            n12 = n15;
                            l13 = 0L;
                        }
                        object2 = 1;
                        n12 = n14;
                    }
                    flowableFlatMap$MergeSubscriber.lastIndex = n11;
                    object = flowableFlatMap$InnerSubscriberArray[n11];
                    flowableFlatMap$MergeSubscriber.lastId = l10 = ((FlowableFlatMap$InnerSubscriber)object).id;
                    l10 = l12;
                    l11 = 0L;
                    break block48;
                }
                object2 = 1;
                l11 = l13;
                l10 = l12;
                n12 = 0;
                object3 = null;
            }
            n14 = (int)(l10 == l11 ? 0 : (l10 < l11 ? -1 : 1));
            if (n14 != 0 && (n14 = (int)(flowableFlatMap$MergeSubscriber.cancelled ? 1 : 0)) == 0) {
                object = flowableFlatMap$MergeSubscriber.upstream;
                object.request(l10);
            }
            if (n12 != 0) {
                n10 = n13;
                continue;
            }
            n11 = n13;
            n14 = -n13;
            n10 = flowableFlatMap$MergeSubscriber.addAndGet(n14);
            if (n10 == 0) break;
        }
    }

    public o getInnerQueue(FlowableFlatMap$InnerSubscriber flowableFlatMap$InnerSubscriber) {
        o o10 = flowableFlatMap$InnerSubscriber.queue;
        if (o10 == null) {
            int n10 = this.bufferSize;
            flowableFlatMap$InnerSubscriber.queue = o10 = new SpscArrayQueue(n10);
        }
        return o10;
    }

    public o getMainQueue() {
        n n10 = this.queue;
        if (n10 == null) {
            int n11 = this.maxConcurrency;
            int n12 = -1 >>> 1;
            if (n11 == n12) {
                n12 = this.bufferSize;
                n10 = new e.a.w0.f.a(n12);
            } else {
                n12 = this.maxConcurrency;
                n10 = new SpscArrayQueue(n12);
            }
            this.queue = n10;
        }
        return n10;
    }

    public void innerError(FlowableFlatMap$InnerSubscriber atomicReference, Throwable flowableFlatMap$InnerSubscriberArray) {
        AtomicThrowable atomicThrowable = this.errs;
        int n10 = atomicThrowable.addThrowable((Throwable)flowableFlatMap$InnerSubscriberArray);
        if (n10 != 0) {
            int n11;
            ((FlowableFlatMap$InnerSubscriber)atomicReference).done = n11 = 1;
            boolean bl2 = this.delayErrors;
            if (!bl2) {
                this.upstream.cancel();
                atomicReference = this.subscribers;
                flowableFlatMap$InnerSubscriberArray = CANCELLED;
                atomicReference = atomicReference.getAndSet(flowableFlatMap$InnerSubscriberArray);
                n11 = ((AtomicReference)atomicReference).length;
                atomicThrowable = null;
                for (n10 = 0; n10 < n11; ++n10) {
                    AtomicReference atomicReference2 = atomicReference[n10];
                    ((FlowableFlatMap$InnerSubscriber)atomicReference2).dispose();
                }
            }
            this.drain();
        } else {
            e.a.a1.a.Y((Throwable)flowableFlatMap$InnerSubscriberArray);
        }
    }

    public void onComplete() {
        boolean bl2 = this.done;
        if (bl2) {
            return;
        }
        this.done = true;
        this.drain();
    }

    public void onError(Throwable serializable) {
        int n10 = this.done;
        if (n10 != 0) {
            e.a.a1.a.Y((Throwable)serializable);
            return;
        }
        FlowableFlatMap$InnerSubscriber[] flowableFlatMap$InnerSubscriberArray = this.errs;
        n10 = flowableFlatMap$InnerSubscriberArray.addThrowable((Throwable)serializable);
        if (n10 != 0) {
            this.done = true;
            boolean bl2 = this.delayErrors;
            if (!bl2) {
                serializable = this.subscribers;
                flowableFlatMap$InnerSubscriberArray = CANCELLED;
                for (Serializable serializable2 : ((AtomicReference)serializable).getAndSet(flowableFlatMap$InnerSubscriberArray)) {
                    ((FlowableFlatMap$InnerSubscriber)serializable2).dispose();
                }
            }
            this.drain();
        } else {
            e.a.a1.a.Y((Throwable)serializable);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void onNext(Object object) {
        long l10;
        int n10 = this.done;
        if (n10 != 0) {
            return;
        }
        Object object2 = this.mapper;
        object = object2.apply(object);
        object2 = "The mapper returned a null Publisher";
        object = e.a.w0.b.a.g(object, (String)object2);
        try {
            object = (c)object;
        }
        catch (Throwable throwable) {
            a.b(throwable);
            this.upstream.cancel();
            this.onError(throwable);
            return;
        }
        n10 = object instanceof Callable;
        if (n10 != 0) {
            block10: {
                try {
                    object = (Callable)object;
                }
                catch (Throwable throwable) {
                    a.b(throwable);
                    this.errs.addThrowable(throwable);
                    this.drain();
                    return;
                }
                object = object.call();
                if (object == null) break block10;
                this.tryEmitScalar(object);
                return;
            }
            int n11 = this.maxConcurrency;
            n10 = -1 >>> 1;
            if (n11 == n10 || (n11 = (int)(this.cancelled ? 1 : 0)) != 0) return;
            this.scalarEmitted = n11 = this.scalarEmitted + 1;
            n10 = this.scalarLimit;
            if (n11 != n10) return;
            n11 = 0;
            this.scalarEmitted = 0;
            object = this.upstream;
            long l11 = n10;
            object.request(l11);
            return;
        }
        long l12 = this.uniqueId;
        this.uniqueId = l10 = 1L + l12;
        object2 = new FlowableFlatMap$InnerSubscriber(this, l12);
        boolean bl2 = this.addInner((FlowableFlatMap$InnerSubscriber)object2);
        if (!bl2) return;
        object.subscribe((d)object2);
        return;
    }

    public void onSubscribe(e e10) {
        Object object = this.upstream;
        int n10 = SubscriptionHelper.validate((e)object, e10);
        if (n10 != 0) {
            this.upstream = e10;
            object = this.downstream;
            object.onSubscribe(this);
            n10 = this.cancelled;
            if (n10 == 0) {
                n10 = this.maxConcurrency;
                int n11 = -1 >>> 1;
                if (n10 == n11) {
                    long l10 = Long.MAX_VALUE;
                    e10.request(l10);
                } else {
                    long l11 = n10;
                    e10.request(l11);
                }
            }
        }
    }

    public void removeInner(FlowableFlatMap$InnerSubscriber flowableFlatMap$InnerSubscriber) {
        FlowableFlatMap$InnerSubscriber[] flowableFlatMap$InnerSubscriberArray;
        FlowableFlatMap$InnerSubscriber[] flowableFlatMap$InnerSubscriberArray2;
        AtomicReference atomicReference;
        boolean bl2;
        do {
            FlowableFlatMap$InnerSubscriber[] flowableFlatMap$InnerSubscriberArray3;
            int n10;
            int n11;
            if ((n11 = (flowableFlatMap$InnerSubscriberArray2 = (FlowableFlatMap$InnerSubscriber[])this.subscribers.get()).length) == 0) {
                return;
            }
            int n12 = -1;
            int n13 = 0;
            for (n10 = 0; n10 < n11; ++n10) {
                flowableFlatMap$InnerSubscriberArray3 = flowableFlatMap$InnerSubscriberArray2[n10];
                if (flowableFlatMap$InnerSubscriberArray3 != flowableFlatMap$InnerSubscriber) continue;
                n12 = n10;
                break;
            }
            if (n12 < 0) {
                return;
            }
            n10 = 1;
            if (n11 == n10) {
                flowableFlatMap$InnerSubscriberArray = EMPTY;
                continue;
            }
            int n14 = n11 + -1;
            flowableFlatMap$InnerSubscriberArray3 = new FlowableFlatMap$InnerSubscriber[n14];
            System.arraycopy(flowableFlatMap$InnerSubscriberArray2, 0, flowableFlatMap$InnerSubscriberArray3, 0, n12);
            n13 = n12 + 1;
            n11 = n11 - n12 - n10;
            System.arraycopy(flowableFlatMap$InnerSubscriberArray2, n13, flowableFlatMap$InnerSubscriberArray3, n12, n11);
            flowableFlatMap$InnerSubscriberArray = flowableFlatMap$InnerSubscriberArray3;
        } while (!(bl2 = (atomicReference = this.subscribers).compareAndSet(flowableFlatMap$InnerSubscriberArray2, flowableFlatMap$InnerSubscriberArray)));
    }

    public void request(long l10) {
        boolean bl2 = SubscriptionHelper.validate(l10);
        if (bl2) {
            AtomicLong atomicLong = this.requested;
            b.a(atomicLong, l10);
            this.drain();
        }
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public void tryEmit(Object var1_1, FlowableFlatMap$InnerSubscriber var2_2) {
        var3_3 = this.get();
        var4_4 = "Inner queue full?!";
        if (var3_3 != 0) ** GOTO lbl-1000
        var5_5 = null;
        var6_6 = 1;
        var3_3 = (int)this.compareAndSet(0, var6_6);
        if (var3_3 != 0) {
            var7_7 = this.requested.get();
            var5_5 = var2_2.queue;
            var9_8 = 0L;
            cfr_temp_0 = var7_7 - var9_8;
            var11_9 /* !! */  = (long)(cfr_temp_0 == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1));
            if (var11_9 /* !! */  != false && (var5_5 == null || (var11_9 /* !! */  = (long)var5_5.isEmpty()) != false)) {
                var5_5 = this.downstream;
                var5_5.onNext(var1_1);
                var12_10 = 0x7FFFFFFFFFFFFFFFL;
                var14_11 = (int)(var7_7 == var12_10 ? 0 : (var7_7 < var12_10 ? -1 : 1));
                if (var14_11 != 0) {
                    var1_1 = this.requested;
                    var1_1.decrementAndGet();
                }
                var12_10 = 1L;
                var2_2.requestMore(var12_10);
            } else {
                if (var5_5 == null) {
                    var5_5 = this.getInnerQueue(var2_2);
                }
                if ((var14_11 = var5_5.offer(var1_1)) == 0) {
                    var1_1 = new MissingBackpressureException(var4_4);
                    this.onError((Throwable)var1_1);
                    return;
                }
            }
            var14_11 = this.decrementAndGet();
            if (var14_11 == 0) {
                return;
            }
        } else lbl-1000:
        // 2 sources

        {
            if ((var5_5 = var2_2.queue) == null) {
                var6_6 = this.bufferSize;
                var5_5 = new SpscArrayQueue(var6_6);
                var2_2.queue = var5_5;
            }
            if ((var14_12 = var5_5.offer(var1_1)) == 0) {
                var1_1 = new MissingBackpressureException(var4_4);
                this.onError((Throwable)var1_1);
                return;
            }
            var14_12 = this.getAndIncrement();
            if (var14_12 != 0) {
                return;
            }
        }
        this.drainLoop();
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    public void tryEmitScalar(Object object) {
        block11: {
            int n10;
            o o10;
            Object object2;
            block8: {
                int n11;
                block10: {
                    void var10_11;
                    n n12;
                    block9: {
                        int n13;
                        boolean bl2;
                        int n14 = this.get();
                        object2 = "Scalar queue full?!";
                        if (n14 != 0) break block8;
                        n14 = 0;
                        o10 = null;
                        int n15 = 1;
                        boolean bl3 = this.compareAndSet(0, n15);
                        if (!bl3) break block8;
                        AtomicLong atomicLong = this.requested;
                        long l10 = atomicLong.get();
                        n12 = this.queue;
                        long l11 = 0L;
                        long l12 = l10 - l11;
                        Object object3 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
                        if (object3 == false || n12 != null && !(bl2 = n12.isEmpty())) break block9;
                        object2 = this.downstream;
                        object2.onNext(object);
                        long l13 = Long.MAX_VALUE;
                        n11 = (int)(l10 == l13 ? 0 : (l10 < l13 ? -1 : 1));
                        if (n11 != 0) {
                            object = this.requested;
                            ((AtomicLong)object).decrementAndGet();
                        }
                        if ((n11 = this.maxConcurrency) != (n13 = -1 >>> 1) && (n11 = (int)(this.cancelled ? 1 : 0)) == 0) {
                            this.scalarEmitted = n11 = this.scalarEmitted + n15;
                            n13 = this.scalarLimit;
                            if (n11 == n13) {
                                this.scalarEmitted = 0;
                                object = this.upstream;
                                long l14 = n13;
                                object.request(l14);
                            }
                        }
                        break block10;
                    }
                    if (n12 == null) {
                        o o11 = this.getMainQueue();
                    }
                    if ((n11 = var10_11.offer(object)) == 0) {
                        object = new IllegalStateException((String)object2);
                        this.onError((Throwable)object);
                        return;
                    }
                }
                if ((n11 = this.decrementAndGet()) == 0) {
                    return;
                }
                break block11;
            }
            if ((n10 = (o10 = this.getMainQueue()).offer(object)) == 0) {
                object = new IllegalStateException((String)object2);
                this.onError((Throwable)object);
                return;
            }
            n10 = this.getAndIncrement();
            if (n10 != 0) {
                return;
            }
        }
        this.drainLoop();
    }
}

