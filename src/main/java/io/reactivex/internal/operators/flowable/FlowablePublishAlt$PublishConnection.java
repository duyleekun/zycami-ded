/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.a1.a;
import e.a.s0.b;
import e.a.w0.c.l;
import e.a.w0.c.o;
import i.g.d;
import i.g.e;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.operators.flowable.FlowablePublishAlt$InnerSubscription;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class FlowablePublishAlt$PublishConnection
extends AtomicInteger
implements e.a.o,
b {
    public static final FlowablePublishAlt$InnerSubscription[] EMPTY = new FlowablePublishAlt$InnerSubscription[0];
    public static final FlowablePublishAlt$InnerSubscription[] TERMINATED = new FlowablePublishAlt$InnerSubscription[0];
    private static final long serialVersionUID = -1672047311619175801L;
    public final int bufferSize;
    public final AtomicBoolean connect;
    public int consumed;
    public final AtomicReference current;
    public volatile boolean done;
    public Throwable error;
    public volatile o queue;
    public int sourceMode;
    public final AtomicReference subscribers;
    public final AtomicReference upstream;

    public FlowablePublishAlt$PublishConnection(AtomicReference atomicReference, int n10) {
        this.current = atomicReference;
        atomicReference = new AtomicReference<FlowablePublishAlt$InnerSubscription[]>();
        this.upstream = atomicReference;
        this.connect = atomicReference;
        this.bufferSize = n10;
        FlowablePublishAlt$InnerSubscription[] flowablePublishAlt$InnerSubscriptionArray = EMPTY;
        this.subscribers = atomicReference = new AtomicReference<FlowablePublishAlt$InnerSubscription[]>(flowablePublishAlt$InnerSubscriptionArray);
    }

    public boolean add(FlowablePublishAlt$InnerSubscription flowablePublishAlt$InnerSubscription) {
        FlowablePublishAlt$InnerSubscription[] flowablePublishAlt$InnerSubscriptionArray;
        FlowablePublishAlt$InnerSubscription[] flowablePublishAlt$InnerSubscriptionArray2;
        Object object;
        boolean bl2;
        do {
            if ((flowablePublishAlt$InnerSubscriptionArray2 = (FlowablePublishAlt$InnerSubscription[])this.subscribers.get()) == (object = TERMINATED)) {
                return false;
            }
            int n10 = flowablePublishAlt$InnerSubscriptionArray2.length;
            int n11 = n10 + 1;
            flowablePublishAlt$InnerSubscriptionArray = new FlowablePublishAlt$InnerSubscription[n11];
            System.arraycopy(flowablePublishAlt$InnerSubscriptionArray2, 0, flowablePublishAlt$InnerSubscriptionArray, 0, n10);
            flowablePublishAlt$InnerSubscriptionArray[n10] = flowablePublishAlt$InnerSubscription;
        } while (!(bl2 = ((AtomicReference)(object = this.subscribers)).compareAndSet(flowablePublishAlt$InnerSubscriptionArray2, flowablePublishAlt$InnerSubscriptionArray)));
        return true;
    }

    public boolean checkTerminated(boolean bl2, boolean n10) {
        if (bl2 && n10 != 0) {
            Serializable serializable = this.error;
            if (serializable != null) {
                this.signalError((Throwable)serializable);
            } else {
                serializable = this.subscribers;
                FlowablePublishAlt$InnerSubscription[] flowablePublishAlt$InnerSubscriptionArray = TERMINATED;
                for (Serializable serializable2 : ((AtomicReference)serializable).getAndSet(flowablePublishAlt$InnerSubscriptionArray)) {
                    boolean bl3 = ((FlowablePublishAlt$InnerSubscription)serializable2).isCancelled();
                    if (bl3) continue;
                    d d10 = ((FlowablePublishAlt$InnerSubscription)serializable2).downstream;
                    d10.onComplete();
                }
            }
            return true;
        }
        return false;
    }

    public void dispose() {
        AtomicReference atomicReference = this.subscribers;
        FlowablePublishAlt$InnerSubscription[] flowablePublishAlt$InnerSubscriptionArray = TERMINATED;
        atomicReference.getAndSet(flowablePublishAlt$InnerSubscriptionArray);
        this.current.compareAndSet(this, null);
        SubscriptionHelper.cancel(this.upstream);
    }

    public void drain() {
        FlowablePublishAlt$PublishConnection flowablePublishAlt$PublishConnection = this;
        int n10 = this.getAndIncrement();
        if (n10 != 0) {
            return;
        }
        Object object = this.queue;
        int n11 = this.consumed;
        int n12 = this.bufferSize;
        int n13 = n12 >> 2;
        n12 -= n13;
        n13 = this.sourceMode;
        int n14 = 1;
        n13 = n13 != n14 ? n14 : 0;
        int n15 = n14;
        o o10 = object;
        n10 = n11;
        block2: while (true) {
            int n16;
            if (o10 != null) {
                Object object2;
                long l10 = Long.MAX_VALUE;
                FlowablePublishAlt$InnerSubscription[] flowablePublishAlt$InnerSubscriptionArray = (FlowablePublishAlt$InnerSubscription[])flowablePublishAlt$PublishConnection.subscribers.get();
                int n17 = flowablePublishAlt$InnerSubscriptionArray.length;
                int n18 = 0;
                for (int i10 = 0; i10 < n17; ++i10) {
                    long l11;
                    object2 = flowablePublishAlt$InnerSubscriptionArray[i10];
                    long l12 = ((AtomicLong)object2).get();
                    long l13 = l12 - (l11 = Long.MIN_VALUE);
                    Object object3 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
                    if (object3 == false) continue;
                    long l14 = ((FlowablePublishAlt$InnerSubscription)object2).emitted;
                    l14 = l12 - l14;
                    l10 = Math.min(l14, l10);
                    n18 = n14;
                }
                long l15 = 0L;
                if (n18 == 0) {
                    l10 = l15;
                }
                while ((n18 = l10 == l15 ? 0 : (l10 < l15 ? -1 : 1)) != 0) {
                    FlowablePublishAlt$InnerSubscription flowablePublishAlt$InnerSubscription;
                    long l16;
                    int n19;
                    n18 = flowablePublishAlt$PublishConnection.done;
                    try {
                        object2 = o10.poll();
                        n19 = object2 == null ? n14 : 0;
                        n18 = flowablePublishAlt$PublishConnection.checkTerminated(n18 != 0, n19 != 0);
                        if (n18 != 0) {
                            return;
                        }
                        if (n19 != 0) break;
                    }
                    catch (Throwable throwable) {
                        Throwable throwable2 = throwable;
                        e.a.t0.a.b(throwable);
                        ((e)flowablePublishAlt$PublishConnection.upstream.get()).cancel();
                        o10.clear();
                        flowablePublishAlt$PublishConnection.done = n14;
                        flowablePublishAlt$PublishConnection.signalError(throwable2);
                        return;
                    }
                    n18 = flowablePublishAlt$InnerSubscriptionArray.length;
                    n19 = 0;
                    while (true) {
                        l16 = 1L;
                        if (n19 >= n18) break;
                        flowablePublishAlt$InnerSubscription = flowablePublishAlt$InnerSubscriptionArray[n19];
                        boolean bl2 = flowablePublishAlt$InnerSubscription.isCancelled();
                        if (!bl2) {
                            d d10 = flowablePublishAlt$InnerSubscription.downstream;
                            d10.onNext(object2);
                            flowablePublishAlt$InnerSubscription.emitted = l15 = flowablePublishAlt$InnerSubscription.emitted + l16;
                        }
                        ++n19;
                        l15 = 0L;
                    }
                    if (n13 != 0 && ++n10 == n12) {
                        object = (e)flowablePublishAlt$PublishConnection.upstream.get();
                        l15 = n12;
                        object.request(l15);
                        n10 = 0;
                        object = null;
                    }
                    l10 -= l16;
                    flowablePublishAlt$InnerSubscription = flowablePublishAlt$PublishConnection.subscribers.get();
                    if (flowablePublishAlt$InnerSubscriptionArray != flowablePublishAlt$InnerSubscription) continue block2;
                    l15 = 0L;
                }
                n16 = (int)(flowablePublishAlt$PublishConnection.done ? 1 : 0);
                boolean bl3 = o10.isEmpty();
                if ((n16 = flowablePublishAlt$PublishConnection.checkTerminated(n16 != 0, bl3)) != 0) {
                    return;
                }
            }
            flowablePublishAlt$PublishConnection.consumed = n10;
            n16 = -n15;
            if ((n15 = flowablePublishAlt$PublishConnection.addAndGet(n16)) == 0) {
                return;
            }
            if (o10 != null) continue;
            o10 = flowablePublishAlt$PublishConnection.queue;
        }
    }

    public boolean isDisposed() {
        boolean bl2;
        FlowablePublishAlt$InnerSubscription[] flowablePublishAlt$InnerSubscriptionArray;
        Object v10 = this.subscribers.get();
        if (v10 == (flowablePublishAlt$InnerSubscriptionArray = TERMINATED)) {
            bl2 = true;
        } else {
            bl2 = false;
            v10 = null;
        }
        return bl2;
    }

    public void onComplete() {
        this.done = true;
        this.drain();
    }

    public void onError(Throwable throwable) {
        boolean bl2 = this.done;
        if (bl2) {
            a.Y(throwable);
        } else {
            boolean bl3;
            this.error = throwable;
            this.done = bl3 = true;
            this.drain();
        }
    }

    public void onNext(Object object) {
        o o10;
        boolean bl2;
        int n10 = this.sourceMode;
        if (n10 == 0 && !(bl2 = (o10 = this.queue).offer(object))) {
            object = new MissingBackpressureException("Prefetch queue is full?!");
            this.onError((Throwable)object);
            return;
        }
        this.drain();
    }

    public void onSubscribe(e e10) {
        Object object = this.upstream;
        int n10 = SubscriptionHelper.setOnce((AtomicReference)object, e10);
        if (n10 != 0) {
            int n11;
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
                    this.drain();
                    return;
                }
                n12 = 2;
                if (n11 == n12) {
                    this.sourceMode = n11;
                    this.queue = object;
                    long l10 = this.bufferSize;
                    e10.request(l10);
                    return;
                }
            }
            n11 = this.bufferSize;
            this.queue = object = new SpscArrayQueue(n11);
            n10 = this.bufferSize;
            long l11 = n10;
            e10.request(l11);
        }
    }

    public void remove(FlowablePublishAlt$InnerSubscription flowablePublishAlt$InnerSubscription) {
        FlowablePublishAlt$InnerSubscription[] flowablePublishAlt$InnerSubscriptionArray;
        int n10;
        while ((n10 = (flowablePublishAlt$InnerSubscriptionArray = (FlowablePublishAlt$InnerSubscription[])this.subscribers.get()).length) != 0) {
            AtomicReference atomicReference;
            boolean bl2;
            FlowablePublishAlt$InnerSubscription[] flowablePublishAlt$InnerSubscriptionArray2;
            FlowablePublishAlt$InnerSubscription[] flowablePublishAlt$InnerSubscriptionArray3;
            int n11;
            int n12 = -1;
            int n13 = 0;
            for (n11 = 0; n11 < n10; ++n11) {
                flowablePublishAlt$InnerSubscriptionArray3 = flowablePublishAlt$InnerSubscriptionArray[n11];
                if (flowablePublishAlt$InnerSubscriptionArray3 != flowablePublishAlt$InnerSubscription) continue;
                n12 = n11;
                break;
            }
            if (n12 < 0) {
                return;
            }
            n11 = 1;
            if (n10 == n11) {
                flowablePublishAlt$InnerSubscriptionArray2 = EMPTY;
            } else {
                int n14 = n10 + -1;
                flowablePublishAlt$InnerSubscriptionArray3 = new FlowablePublishAlt$InnerSubscription[n14];
                System.arraycopy(flowablePublishAlt$InnerSubscriptionArray, 0, flowablePublishAlt$InnerSubscriptionArray3, 0, n12);
                n13 = n12 + 1;
                n10 = n10 - n12 - n11;
                System.arraycopy(flowablePublishAlt$InnerSubscriptionArray, n13, flowablePublishAlt$InnerSubscriptionArray3, n12, n10);
                flowablePublishAlt$InnerSubscriptionArray2 = flowablePublishAlt$InnerSubscriptionArray3;
            }
            if (!(bl2 = (atomicReference = this.subscribers).compareAndSet(flowablePublishAlt$InnerSubscriptionArray, flowablePublishAlt$InnerSubscriptionArray2))) continue;
        }
    }

    public void signalError(Throwable throwable) {
        FlowablePublishAlt$InnerSubscription[] flowablePublishAlt$InnerSubscriptionArray = this.subscribers;
        FlowablePublishAlt$InnerSubscription[] flowablePublishAlt$InnerSubscriptionArray2 = TERMINATED;
        for (FlowablePublishAlt$InnerSubscription flowablePublishAlt$InnerSubscription : flowablePublishAlt$InnerSubscriptionArray.getAndSet(flowablePublishAlt$InnerSubscriptionArray2)) {
            boolean bl2 = flowablePublishAlt$InnerSubscription.isCancelled();
            if (bl2) continue;
            d d10 = flowablePublishAlt$InnerSubscription.downstream;
            d10.onError(throwable);
        }
    }
}

