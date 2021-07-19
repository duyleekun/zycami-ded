/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.parallel;

import e.a.t0.a;
import e.a.w0.c.l;
import e.a.w0.c.o;
import i.g.d;
import i.g.e;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.operators.parallel.ParallelFromPublisher$ParallelDispatcher$a;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLongArray;

public final class ParallelFromPublisher$ParallelDispatcher
extends AtomicInteger
implements e.a.o {
    private static final long serialVersionUID = -4470634016609963609L;
    public volatile boolean cancelled;
    public volatile boolean done;
    public final long[] emissions;
    public Throwable error;
    public int index;
    public final int limit;
    public final int prefetch;
    public int produced;
    public o queue;
    public final AtomicLongArray requests;
    public int sourceMode;
    public final AtomicInteger subscriberCount;
    public final d[] subscribers;
    public e upstream;

    public ParallelFromPublisher$ParallelDispatcher(d[] objectArray, int n10) {
        AtomicLongArray atomicLongArray;
        AtomicInteger atomicInteger;
        this.subscriberCount = atomicInteger = new AtomicInteger();
        this.subscribers = objectArray;
        this.prefetch = n10;
        int n11 = n10 >> 2;
        this.limit = n10 -= n11;
        int n12 = objectArray.length;
        n11 = n12 + n12;
        int n13 = n11 + 1;
        this.requests = atomicLongArray = new AtomicLongArray(n13);
        long l10 = n12;
        atomicLongArray.lazySet(n11, l10);
        objectArray = new long[n12];
        this.emissions = (long[])objectArray;
    }

    public void cancel(int n10) {
        long l10;
        AtomicLongArray atomicLongArray = this.requests;
        long l11 = atomicLongArray.decrementAndGet(n10);
        long l12 = l11 - (l10 = 0L);
        if ((n10 = (int)(l12 == 0L ? 0 : (l12 < 0L ? -1 : 1))) == 0) {
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

    public void drain() {
        int n10 = this.getAndIncrement();
        if (n10 != 0) {
            return;
        }
        n10 = this.sourceMode;
        int n11 = 1;
        if (n10 == n11) {
            this.drainSync();
        } else {
            this.drainAsync();
        }
    }

    public void drainAsync() {
        int n10;
        ParallelFromPublisher$ParallelDispatcher parallelFromPublisher$ParallelDispatcher = this;
        o o10 = this.queue;
        d[] dArray = this.subscribers;
        Object object = this.requests;
        Object object2 = this.emissions;
        int n11 = ((long[])object2).length;
        int n12 = this.index;
        int n13 = this.produced;
        int n14 = n10 = 1;
        while (true) {
            int n15 = 0;
            int n16 = 0;
            Object object3 = null;
            do {
                block13: {
                    block12: {
                        long l10;
                        long l11;
                        Throwable throwable;
                        Object object4;
                        if ((object4 = parallelFromPublisher$ParallelDispatcher.cancelled) != 0) {
                            o10.clear();
                            return;
                        }
                        object4 = parallelFromPublisher$ParallelDispatcher.done;
                        if (object4 != 0 && (throwable = parallelFromPublisher$ParallelDispatcher.error) != null) {
                            o10.clear();
                            int n17 = dArray.length;
                            while (n15 < n17) {
                                object = dArray[n15];
                                object.onError(throwable);
                                ++n15;
                            }
                            return;
                        }
                        boolean bl2 = o10.isEmpty();
                        if (object4 != 0 && bl2) {
                            int n18 = dArray.length;
                            while (n15 < n18) {
                                object = dArray[n15];
                                object.onComplete();
                                ++n15;
                            }
                            return;
                        }
                        if (bl2) break;
                        long l12 = ((AtomicLongArray)object).get(n12);
                        long l13 = l12 - (l11 = object2[n12]);
                        object4 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
                        if (object4 == 0) break block12;
                        object4 = n11 + n12;
                        l12 = ((AtomicLongArray)object).get((int)object4);
                        long l14 = l12 - (l10 = 0L);
                        if ((object4 = (Object)(l14 == 0L ? 0 : (l14 < 0L ? -1 : 1))) != 0) break block12;
                        try {
                            object3 = o10.poll();
                            if (object3 == null) break;
                        }
                        catch (Throwable throwable2) {
                            object = throwable2;
                            a.b(throwable2);
                            e e10 = parallelFromPublisher$ParallelDispatcher.upstream;
                            e10.cancel();
                            int n19 = dArray.length;
                            while (n15 < n19) {
                                object2 = dArray[n15];
                                object2.onError((Throwable)object);
                                ++n15;
                            }
                            return;
                        }
                        d d10 = dArray[n12];
                        d10.onNext(object3);
                        long l15 = 1L;
                        object2[n12] = l11 += l15;
                        n16 = parallelFromPublisher$ParallelDispatcher.limit;
                        if (++n13 == n16) {
                            object3 = parallelFromPublisher$ParallelDispatcher.upstream;
                            l12 = n13;
                            object3.request(l12);
                            n13 = 0;
                        }
                        n16 = 0;
                        object3 = null;
                        break block13;
                    }
                    n16 += n10;
                }
                if (++n12 != n11) continue;
                n12 = 0;
            } while (n16 != n11);
            if ((n15 = this.get()) == n14) {
                parallelFromPublisher$ParallelDispatcher.index = n12;
                parallelFromPublisher$ParallelDispatcher.produced = n13;
                n14 = -n14;
                if ((n14 = parallelFromPublisher$ParallelDispatcher.addAndGet(n14)) != 0) continue;
                return;
            }
            n14 = n15;
        }
    }

    public void drainSync() {
        int n10;
        ParallelFromPublisher$ParallelDispatcher parallelFromPublisher$ParallelDispatcher = this;
        o o10 = this.queue;
        d[] dArray = this.subscribers;
        Object object = this.requests;
        Object object2 = this.emissions;
        int n11 = ((long[])object2).length;
        int n12 = this.index;
        int n13 = n10 = 1;
        while (true) {
            int n14 = 0;
            int n15 = 0;
            Object object3 = null;
            do {
                block12: {
                    block11: {
                        block10: {
                            long l10;
                            long l11;
                            Object object4;
                            if ((object4 = parallelFromPublisher$ParallelDispatcher.cancelled) != 0) {
                                o10.clear();
                                return;
                            }
                            object4 = o10.isEmpty();
                            if (object4 != 0) {
                                int n16 = dArray.length;
                                while (n14 < n16) {
                                    object = dArray[n14];
                                    object.onComplete();
                                    ++n14;
                                }
                                return;
                            }
                            long l12 = ((AtomicLongArray)object).get(n12);
                            long l13 = l12 - (l11 = object2[n12]);
                            object4 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
                            if (object4 == 0) break block11;
                            object4 = n11 + n12;
                            l12 = ((AtomicLongArray)object).get((int)object4);
                            long l14 = l12 - (l10 = 0L);
                            if ((object4 = (Object)(l14 == 0L ? 0 : (l14 < 0L ? -1 : 1))) != 0) break block11;
                            try {
                                object3 = o10.poll();
                                if (object3 != null) break block10;
                            }
                            catch (Throwable throwable) {
                                object = throwable;
                                a.b(throwable);
                                e e10 = parallelFromPublisher$ParallelDispatcher.upstream;
                                e10.cancel();
                                int n17 = dArray.length;
                                while (n14 < n17) {
                                    object2 = dArray[n14];
                                    object2.onError((Throwable)object);
                                    ++n14;
                                }
                                return;
                            }
                            int n18 = dArray.length;
                            while (n14 < n18) {
                                object = dArray[n14];
                                object.onComplete();
                                ++n14;
                            }
                            return;
                        }
                        d d10 = dArray[n12];
                        d10.onNext(object3);
                        long l15 = 1L;
                        object2[n12] = l11 += l15;
                        n15 = 0;
                        object3 = null;
                        break block12;
                    }
                    n15 += n10;
                }
                if (++n12 != n11) continue;
                n12 = 0;
            } while (n15 != n11);
            n14 = this.get();
            if (n14 == n13) {
                parallelFromPublisher$ParallelDispatcher.index = n12;
                n13 = -n13;
                if ((n13 = parallelFromPublisher$ParallelDispatcher.addAndGet(n13)) != 0) continue;
                return;
            }
            n13 = n14;
        }
    }

    public void onComplete() {
        this.done = true;
        this.drain();
    }

    public void onError(Throwable throwable) {
        this.error = throwable;
        this.done = true;
        this.drain();
    }

    public void onNext(Object object) {
        o o10;
        boolean bl2;
        int n10 = this.sourceMode;
        if (n10 == 0 && !(bl2 = (o10 = this.queue).offer(object))) {
            this.upstream.cancel();
            object = new MissingBackpressureException("Queue is full?");
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
                n11 = object.requestFusion(7);
                if (n11 == (n12 = 1)) {
                    this.sourceMode = n11;
                    this.queue = object;
                    this.done = n12;
                    this.setupSubscribers();
                    this.drain();
                    return;
                }
                n12 = 2;
                if (n11 == n12) {
                    this.sourceMode = n11;
                    this.queue = object;
                    this.setupSubscribers();
                    long l10 = this.prefetch;
                    e10.request(l10);
                    return;
                }
            }
            n11 = this.prefetch;
            this.queue = object = new SpscArrayQueue(n11);
            this.setupSubscribers();
            n10 = this.prefetch;
            long l11 = n10;
            e10.request(l11);
        }
    }

    public void setupSubscribers() {
        d[] dArray = this.subscribers;
        int n10 = dArray.length;
        int n11 = 0;
        while (n11 < n10) {
            boolean bl2 = this.cancelled;
            if (bl2) {
                return;
            }
            Object object = this.subscriberCount;
            int n12 = n11 + 1;
            ((AtomicInteger)object).lazySet(n12);
            object = dArray[n11];
            ParallelFromPublisher$ParallelDispatcher$a parallelFromPublisher$ParallelDispatcher$a = new ParallelFromPublisher$ParallelDispatcher$a(this, n11, n10);
            object.onSubscribe(parallelFromPublisher$ParallelDispatcher$a);
            n11 = n12;
        }
    }
}

