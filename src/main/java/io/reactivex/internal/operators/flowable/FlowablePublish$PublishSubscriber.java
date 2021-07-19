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
import io.reactivex.internal.operators.flowable.FlowablePublish$InnerSubscriber;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class FlowablePublish$PublishSubscriber
extends AtomicInteger
implements e.a.o,
b {
    public static final FlowablePublish$InnerSubscriber[] EMPTY = new FlowablePublish$InnerSubscriber[0];
    public static final FlowablePublish$InnerSubscriber[] TERMINATED = new FlowablePublish$InnerSubscriber[0];
    private static final long serialVersionUID = -202316842419149694L;
    public final int bufferSize;
    public final AtomicReference current;
    public volatile o queue;
    public final AtomicBoolean shouldConnect;
    public int sourceMode;
    public final AtomicReference subscribers;
    public volatile Object terminalEvent;
    public final AtomicReference upstream;

    public FlowablePublish$PublishSubscriber(AtomicReference serializable, int n10) {
        AtomicReference<FlowablePublish$InnerSubscriber[]> atomicReference;
        this.upstream = atomicReference = new AtomicReference<FlowablePublish$InnerSubscriber[]>();
        FlowablePublish$InnerSubscriber[] flowablePublish$InnerSubscriberArray = EMPTY;
        this.subscribers = atomicReference = new AtomicReference<FlowablePublish$InnerSubscriber[]>(flowablePublish$InnerSubscriberArray);
        this.current = serializable;
        this.shouldConnect = serializable;
        this.bufferSize = n10;
    }

    public boolean add(FlowablePublish$InnerSubscriber flowablePublish$InnerSubscriber) {
        FlowablePublish$InnerSubscriber[] flowablePublish$InnerSubscriberArray;
        FlowablePublish$InnerSubscriber[] flowablePublish$InnerSubscriberArray2;
        Object object;
        boolean bl2;
        do {
            if ((flowablePublish$InnerSubscriberArray2 = (FlowablePublish$InnerSubscriber[])this.subscribers.get()) == (object = TERMINATED)) {
                return false;
            }
            int n10 = flowablePublish$InnerSubscriberArray2.length;
            int n11 = n10 + 1;
            flowablePublish$InnerSubscriberArray = new FlowablePublish$InnerSubscriber[n11];
            System.arraycopy(flowablePublish$InnerSubscriberArray2, 0, flowablePublish$InnerSubscriberArray, 0, n10);
            flowablePublish$InnerSubscriberArray[n10] = flowablePublish$InnerSubscriber;
        } while (!(bl2 = ((AtomicReference)(object = this.subscribers)).compareAndSet(flowablePublish$InnerSubscriberArray2, flowablePublish$InnerSubscriberArray)));
        return true;
    }

    public boolean checkTerminated(Object flowablePublish$InnerSubscriberArray, boolean n10) {
        if (flowablePublish$InnerSubscriberArray != null) {
            int n11;
            int n12 = NotificationLite.isComplete(flowablePublish$InnerSubscriberArray);
            d d10 = null;
            boolean bl2 = true;
            if (n12 != 0) {
                if (n10) {
                    this.current.compareAndSet(this, null);
                    flowablePublish$InnerSubscriberArray = this.subscribers;
                    FlowablePublish$InnerSubscriber[] flowablePublish$InnerSubscriberArray2 = TERMINATED;
                    flowablePublish$InnerSubscriberArray = flowablePublish$InnerSubscriberArray.getAndSet(flowablePublish$InnerSubscriberArray2);
                    n10 = flowablePublish$InnerSubscriberArray.length;
                    for (n11 = 0; n11 < n10; ++n11) {
                        d d11 = flowablePublish$InnerSubscriberArray[n11].child;
                        d11.onComplete();
                    }
                    return bl2;
                }
            } else {
                flowablePublish$InnerSubscriberArray = NotificationLite.getError(flowablePublish$InnerSubscriberArray);
                this.current.compareAndSet(this, null);
                FlowablePublish$InnerSubscriber[] flowablePublish$InnerSubscriberArray3 = this.subscribers;
                FlowablePublish$InnerSubscriber[] flowablePublish$InnerSubscriberArray4 = TERMINATED;
                flowablePublish$InnerSubscriberArray3 = flowablePublish$InnerSubscriberArray3.getAndSet(flowablePublish$InnerSubscriberArray4);
                n12 = flowablePublish$InnerSubscriberArray3.length;
                if (n12 != 0) {
                    n12 = flowablePublish$InnerSubscriberArray3.length;
                    while (n11 < n12) {
                        d10 = flowablePublish$InnerSubscriberArray3[n11].child;
                        d10.onError((Throwable)flowablePublish$InnerSubscriberArray);
                        ++n11;
                    }
                } else {
                    a.Y((Throwable)flowablePublish$InnerSubscriberArray);
                }
                return bl2;
            }
        }
        return false;
    }

    public void dispatch() {
        FlowablePublish$PublishSubscriber flowablePublish$PublishSubscriber = this;
        int n10 = this.getAndIncrement();
        if (n10 != 0) {
            return;
        }
        AtomicReference atomicReference = this.subscribers;
        Object object = (FlowablePublish$InnerSubscriber[])atomicReference.get();
        int n11 = 1;
        float f10 = Float.MIN_VALUE;
        Object object2 = object;
        int n12 = n11;
        block4: while (true) {
            Object object3;
            int n13;
            object = flowablePublish$PublishSubscriber.terminalEvent;
            Object object4 = flowablePublish$PublishSubscriber.queue;
            if (object4 != null && (n13 = object4.isEmpty()) == 0) {
                n13 = 0;
                object3 = null;
            } else {
                n13 = n11;
            }
            n10 = (int)(flowablePublish$PublishSubscriber.checkTerminated(object, n13 != 0) ? 1 : 0);
            if (n10 != 0) {
                return;
            }
            if (n13 == 0) {
                long l10;
                long l11;
                long l12;
                long l13;
                float f11;
                int n14;
                Object object5;
                long l14;
                n10 = ((FlowablePublish$InnerSubscriber[])object2).length;
                int n15 = ((FlowablePublish$InnerSubscriber[])object2).length;
                int n16 = 0;
                int n17 = 0;
                long l15 = Long.MAX_VALUE;
                while (true) {
                    l14 = Long.MIN_VALUE;
                    if (n16 >= n15) break;
                    object5 = object2[n16];
                    long l16 = ((AtomicLong)object5).get();
                    long l17 = l16 - l14;
                    Object object6 = l17 == 0L ? 0 : (l17 < 0L ? -1 : 1);
                    if (object6 != false) {
                        long l18 = ((FlowablePublish$InnerSubscriber)object5).emitted;
                        l18 = l16 - l18;
                        l15 = Math.min(l15, l18);
                    } else {
                        ++n17;
                    }
                    ++n16;
                }
                long l19 = 1L;
                if (n10 == n17) {
                    object = flowablePublish$PublishSubscriber.terminalEvent;
                    try {
                        object5 = object4.poll();
                    }
                    catch (Throwable throwable) {
                        object4 = throwable;
                        e.a.t0.a.b(throwable);
                        ((e)flowablePublish$PublishSubscriber.upstream.get()).cancel();
                        object = NotificationLite.error((Throwable)object4);
                        flowablePublish$PublishSubscriber.terminalEvent = object;
                        n14 = 0;
                        f11 = 0.0f;
                        object5 = null;
                    }
                    if (object5 == null) {
                        n14 = n11;
                        f11 = f10;
                    } else {
                        n14 = 0;
                        f11 = 0.0f;
                        object5 = null;
                    }
                    n10 = (int)(flowablePublish$PublishSubscriber.checkTerminated(object, n14 != 0) ? 1 : 0);
                    if (n10 != 0) {
                        return;
                    }
                    n10 = flowablePublish$PublishSubscriber.sourceMode;
                    if (n10 == n11) continue;
                    object = (e)flowablePublish$PublishSubscriber.upstream.get();
                    object.request(l19);
                    continue;
                }
                int n18 = 0;
                while ((n10 = (int)((l13 = (l12 = (long)n18) - l15) == 0L ? 0 : (l13 < 0L ? -1 : 1))) < 0) {
                    int n19;
                    float f12;
                    int n20;
                    Object object7;
                    long l20;
                    Object object8;
                    object = flowablePublish$PublishSubscriber.terminalEvent;
                    try {
                        object3 = object4.poll();
                    }
                    catch (Throwable throwable) {
                        object3 = throwable;
                        e.a.t0.a.b(throwable);
                        ((e)flowablePublish$PublishSubscriber.upstream.get()).cancel();
                        flowablePublish$PublishSubscriber.terminalEvent = object = NotificationLite.error((Throwable)object3);
                        n13 = 0;
                        object3 = null;
                    }
                    if (object3 == null) {
                        n14 = n11;
                        f11 = f10;
                    } else {
                        n14 = 0;
                        f11 = 0.0f;
                        object5 = null;
                    }
                    n10 = flowablePublish$PublishSubscriber.checkTerminated(object, n14 != 0);
                    if (n10 != 0) {
                        return;
                    }
                    if (n14 != 0) {
                        n13 = n14;
                        break;
                    }
                    object = NotificationLite.getValue(object3);
                    n13 = ((FlowablePublish$InnerSubscriber[])object2).length;
                    n17 = 0;
                    for (n16 = 0; n16 < n13; ++n16) {
                        object8 = object2[n16];
                        long l21 = ((AtomicLong)object8).get();
                        long l22 = l21 - l14;
                        Object object9 = l22 == 0L ? 0 : (l22 < 0L ? -1 : 1);
                        if (object9 != false) {
                            l20 = Long.MAX_VALUE;
                            long l23 = l21 - l20;
                            Object object10 = l23 == 0L ? 0 : (l23 < 0L ? -1 : 1);
                            if (object10 != false) {
                                object7 = object4;
                                n20 = n14;
                                f12 = f11;
                                ((FlowablePublish$InnerSubscriber)object8).emitted = l11 = ((FlowablePublish$InnerSubscriber)object8).emitted + l19;
                            } else {
                                object7 = object4;
                                n20 = n14;
                                f12 = f11;
                            }
                            object8 = ((FlowablePublish$InnerSubscriber)object8).child;
                            object8.onNext(object);
                        } else {
                            object7 = object4;
                            n20 = n14;
                            f12 = f11;
                            l20 = Long.MAX_VALUE;
                            n17 = 1;
                        }
                        object4 = object7;
                        n14 = n20;
                        f11 = f12;
                        n11 = 1;
                        f10 = Float.MIN_VALUE;
                    }
                    object7 = object4;
                    n20 = n14;
                    f12 = f11;
                    l20 = Long.MAX_VALUE;
                    ++n18;
                    object = (FlowablePublish$InnerSubscriber[])atomicReference.get();
                    if (n17 == 0 && object == object2) {
                        n13 = n14;
                        n11 = 1;
                        f10 = Float.MIN_VALUE;
                        continue;
                    }
                    if (n18 != 0 && (n11 = flowablePublish$PublishSubscriber.sourceMode) != (n19 = 1)) {
                        object8 = (e)flowablePublish$PublishSubscriber.upstream.get();
                        l11 = n18;
                        object8.request(l11);
                    }
                    object2 = object;
                    n11 = 1;
                    f10 = Float.MIN_VALUE;
                    continue block4;
                }
                if (n18 != 0) {
                    n10 = flowablePublish$PublishSubscriber.sourceMode;
                    n11 = 1;
                    f10 = Float.MIN_VALUE;
                    if (n10 != n11) {
                        object = (e)flowablePublish$PublishSubscriber.upstream.get();
                        object.request(l12);
                    }
                } else {
                    n11 = 1;
                    f10 = Float.MIN_VALUE;
                }
                if ((n10 = (int)((l10 = l15 - (l11 = 0L)) == 0L ? 0 : (l10 < 0L ? -1 : 1))) != 0 && n13 == 0) continue;
            }
            if ((n12 = flowablePublish$PublishSubscriber.addAndGet(n10 = -n12)) == 0) {
                return;
            }
            object = atomicReference.get();
            object2 = object;
            object2 = object;
        }
    }

    public void dispose() {
        FlowablePublish$InnerSubscriber[] flowablePublish$InnerSubscriberArray;
        Object object = this.subscribers.get();
        if (object != (flowablePublish$InnerSubscriberArray = TERMINATED) && (object = this.subscribers.getAndSet(flowablePublish$InnerSubscriberArray)) != flowablePublish$InnerSubscriberArray) {
            object = this.current;
            flowablePublish$InnerSubscriberArray = null;
            ((AtomicReference)object).compareAndSet(this, null);
            object = this.upstream;
            SubscriptionHelper.cancel((AtomicReference)object);
        }
    }

    public boolean isDisposed() {
        boolean bl2;
        FlowablePublish$InnerSubscriber[] flowablePublish$InnerSubscriberArray;
        Object v10 = this.subscribers.get();
        if (v10 == (flowablePublish$InnerSubscriberArray = TERMINATED)) {
            bl2 = true;
        } else {
            bl2 = false;
            v10 = null;
        }
        return bl2;
    }

    public void onComplete() {
        Object object = this.terminalEvent;
        if (object == null) {
            this.terminalEvent = object = NotificationLite.complete();
            this.dispatch();
        }
    }

    public void onError(Throwable object) {
        Object object2 = this.terminalEvent;
        if (object2 == null) {
            this.terminalEvent = object = NotificationLite.error((Throwable)object);
            this.dispatch();
        } else {
            a.Y((Throwable)object);
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
        this.dispatch();
    }

    public void onSubscribe(e object) {
        Object object2 = this.upstream;
        int n10 = SubscriptionHelper.setOnce((AtomicReference)object2, (e)object);
        if (n10 != 0) {
            int n11;
            n10 = object instanceof l;
            if (n10 != 0) {
                int n12;
                object2 = object;
                object2 = (l)object;
                n11 = object2.requestFusion(7);
                if (n11 == (n12 = 1)) {
                    this.sourceMode = n11;
                    this.queue = object2;
                    this.terminalEvent = object = NotificationLite.complete();
                    this.dispatch();
                    return;
                }
                n12 = 2;
                if (n11 == n12) {
                    this.sourceMode = n11;
                    this.queue = object2;
                    long l10 = this.bufferSize;
                    ((e)object).request(l10);
                    return;
                }
            }
            n11 = this.bufferSize;
            this.queue = object2 = new SpscArrayQueue(n11);
            n10 = this.bufferSize;
            long l11 = n10;
            object.request(l11);
        }
    }

    public void remove(FlowablePublish$InnerSubscriber flowablePublish$InnerSubscriber) {
        FlowablePublish$InnerSubscriber[] flowablePublish$InnerSubscriberArray;
        int n10;
        while ((n10 = (flowablePublish$InnerSubscriberArray = (FlowablePublish$InnerSubscriber[])this.subscribers.get()).length) != 0) {
            AtomicReference atomicReference;
            boolean bl2;
            FlowablePublish$InnerSubscriber[] flowablePublish$InnerSubscriberArray2;
            int n11;
            FlowablePublish$InnerSubscriber[] flowablePublish$InnerSubscriberArray3;
            int n12;
            int n13 = -1;
            int n14 = 0;
            for (n12 = 0; n12 < n10; ++n12) {
                flowablePublish$InnerSubscriberArray3 = flowablePublish$InnerSubscriberArray[n12];
                n11 = flowablePublish$InnerSubscriberArray3.equals(flowablePublish$InnerSubscriber);
                if (n11 == 0) continue;
                n13 = n12;
                break;
            }
            if (n13 < 0) {
                return;
            }
            n12 = 1;
            if (n10 == n12) {
                flowablePublish$InnerSubscriberArray2 = EMPTY;
            } else {
                n11 = n10 + -1;
                flowablePublish$InnerSubscriberArray3 = new FlowablePublish$InnerSubscriber[n11];
                System.arraycopy(flowablePublish$InnerSubscriberArray, 0, flowablePublish$InnerSubscriberArray3, 0, n13);
                n14 = n13 + 1;
                n10 = n10 - n13 - n12;
                System.arraycopy(flowablePublish$InnerSubscriberArray, n14, flowablePublish$InnerSubscriberArray3, n13, n10);
                flowablePublish$InnerSubscriberArray2 = flowablePublish$InnerSubscriberArray3;
            }
            if (!(bl2 = (atomicReference = this.subscribers).compareAndSet(flowablePublish$InnerSubscriberArray, flowablePublish$InnerSubscriberArray2))) continue;
        }
    }
}

