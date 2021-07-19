/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.a1.a;
import e.a.o;
import e.a.s0.b;
import i.g.e;
import io.reactivex.internal.operators.flowable.FlowableReplay$InnerSubscription;
import io.reactivex.internal.operators.flowable.FlowableReplay$d;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.io.Serializable;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class FlowableReplay$ReplaySubscriber
extends AtomicReference
implements o,
b {
    public static final FlowableReplay$InnerSubscription[] EMPTY = new FlowableReplay$InnerSubscription[0];
    public static final FlowableReplay$InnerSubscription[] TERMINATED = new FlowableReplay$InnerSubscription[0];
    private static final long serialVersionUID = 7224554242710036740L;
    public final FlowableReplay$d buffer;
    public boolean done;
    public final AtomicInteger management;
    public long maxChildRequested;
    public long maxUpstreamRequested;
    public final AtomicBoolean shouldConnect;
    public final AtomicReference subscribers;

    public FlowableReplay$ReplaySubscriber(FlowableReplay$d serializable) {
        this.buffer = serializable;
        serializable = new Serializable();
        this.management = serializable;
        FlowableReplay$InnerSubscription[] flowableReplay$InnerSubscriptionArray = EMPTY;
        this.subscribers = serializable = new Serializable(flowableReplay$InnerSubscriptionArray);
        this.shouldConnect = serializable;
    }

    public boolean add(FlowableReplay$InnerSubscription flowableReplay$InnerSubscription) {
        FlowableReplay$InnerSubscription[] flowableReplay$InnerSubscriptionArray;
        FlowableReplay$InnerSubscription[] flowableReplay$InnerSubscriptionArray2;
        Object object;
        boolean bl2;
        Objects.requireNonNull(flowableReplay$InnerSubscription);
        do {
            if ((flowableReplay$InnerSubscriptionArray2 = (FlowableReplay$InnerSubscription[])this.subscribers.get()) == (object = TERMINATED)) {
                return false;
            }
            int n10 = flowableReplay$InnerSubscriptionArray2.length;
            int n11 = n10 + 1;
            flowableReplay$InnerSubscriptionArray = new FlowableReplay$InnerSubscription[n11];
            System.arraycopy(flowableReplay$InnerSubscriptionArray2, 0, flowableReplay$InnerSubscriptionArray, 0, n10);
            flowableReplay$InnerSubscriptionArray[n10] = flowableReplay$InnerSubscription;
        } while (!(bl2 = ((AtomicReference)(object = this.subscribers)).compareAndSet(flowableReplay$InnerSubscriptionArray2, flowableReplay$InnerSubscriptionArray)));
        return true;
    }

    public void dispose() {
        AtomicReference atomicReference = this.subscribers;
        FlowableReplay$InnerSubscription[] flowableReplay$InnerSubscriptionArray = TERMINATED;
        atomicReference.set(flowableReplay$InnerSubscriptionArray);
        SubscriptionHelper.cancel(this);
    }

    public boolean isDisposed() {
        boolean bl2;
        FlowableReplay$InnerSubscription[] flowableReplay$InnerSubscriptionArray;
        Object v10 = this.subscribers.get();
        if (v10 == (flowableReplay$InnerSubscriptionArray = TERMINATED)) {
            bl2 = true;
        } else {
            bl2 = false;
            v10 = null;
        }
        return bl2;
    }

    public void manageRequests() {
        Object object;
        AtomicInteger atomicInteger = this.management;
        int n10 = atomicInteger.getAndIncrement();
        if (n10 != 0) {
            return;
        }
        n10 = 1;
        do {
            long l10;
            Object object2;
            if ((object2 = this.isDisposed()) != 0) {
                return;
            }
            object = (FlowableReplay$InnerSubscription[])this.subscribers.get();
            long l11 = this.maxChildRequested;
            int n11 = ((FlowableReplay$InnerSubscription[])object).length;
            long l12 = l11;
            for (int i10 = 0; i10 < n11; ++i10) {
                AtomicLong atomicLong = object[i10].totalRequested;
                l10 = atomicLong.get();
                l12 = Math.max(l12, l10);
            }
            long l13 = this.maxUpstreamRequested;
            object = (e)this.get();
            l10 = 0L;
            long l14 = (l11 = l12 - l11) - l10;
            Object object3 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
            if (object3 != false) {
                this.maxChildRequested = l12;
                if (object != null) {
                    Object object4 = l13 == l10 ? 0 : (l13 < l10 ? -1 : 1);
                    if (object4 != false) {
                        this.maxUpstreamRequested = l10;
                        object.request(l13 += l11);
                    } else {
                        object.request(l11);
                    }
                } else {
                    long l15 = (l13 += l11) - l10;
                    object2 = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
                    if (object2 < 0) {
                        l13 = Long.MAX_VALUE;
                    }
                    this.maxUpstreamRequested = l13;
                }
            } else {
                Object object5 = l13 == l10 ? 0 : (l13 < l10 ? -1 : 1);
                if (object5 != false && object != null) {
                    this.maxUpstreamRequested = l10;
                    object.request(l13);
                }
            }
            object = this.management;
            n10 = -n10;
        } while ((n10 = ((AtomicInteger)object).addAndGet(n10)) != 0);
    }

    public void onComplete() {
        boolean bl2 = this.done;
        if (!bl2) {
            this.done = bl2 = true;
            this.buffer.complete();
            FlowableReplay$InnerSubscription[] flowableReplay$InnerSubscriptionArray = this.subscribers;
            FlowableReplay$InnerSubscription[] flowableReplay$InnerSubscriptionArray2 = TERMINATED;
            for (FlowableReplay$InnerSubscription flowableReplay$InnerSubscription : flowableReplay$InnerSubscriptionArray.getAndSet(flowableReplay$InnerSubscriptionArray2)) {
                FlowableReplay$d flowableReplay$d = this.buffer;
                flowableReplay$d.replay(flowableReplay$InnerSubscription);
            }
        }
    }

    public void onError(Throwable serializable) {
        int n10 = this.done;
        if (n10 == 0) {
            this.done = true;
            this.buffer.error((Throwable)serializable);
            serializable = this.subscribers;
            FlowableReplay$InnerSubscription[] flowableReplay$InnerSubscriptionArray = TERMINATED;
            for (Serializable serializable2 : ((AtomicReference)serializable).getAndSet(flowableReplay$InnerSubscriptionArray)) {
                FlowableReplay$d flowableReplay$d = this.buffer;
                flowableReplay$d.replay((FlowableReplay$InnerSubscription)serializable2);
            }
        } else {
            a.Y((Throwable)serializable);
        }
    }

    public void onNext(Object flowableReplay$InnerSubscriptionArray) {
        int n10 = this.done;
        if (n10 == 0) {
            FlowableReplay$d flowableReplay$d = this.buffer;
            flowableReplay$d.next(flowableReplay$InnerSubscriptionArray);
            for (FlowableReplay$InnerSubscription flowableReplay$InnerSubscription : (FlowableReplay$InnerSubscription[])this.subscribers.get()) {
                FlowableReplay$d flowableReplay$d2 = this.buffer;
                flowableReplay$d2.replay(flowableReplay$InnerSubscription);
            }
        }
    }

    public void onSubscribe(e flowableReplay$InnerSubscriptionArray) {
        boolean bl2 = SubscriptionHelper.setOnce(this, (e)flowableReplay$InnerSubscriptionArray);
        if (bl2) {
            this.manageRequests();
            for (FlowableReplay$InnerSubscription flowableReplay$InnerSubscription : (FlowableReplay$InnerSubscription[])this.subscribers.get()) {
                FlowableReplay$d flowableReplay$d = this.buffer;
                flowableReplay$d.replay(flowableReplay$InnerSubscription);
            }
        }
    }

    public void remove(FlowableReplay$InnerSubscription flowableReplay$InnerSubscription) {
        FlowableReplay$InnerSubscription[] flowableReplay$InnerSubscriptionArray;
        FlowableReplay$InnerSubscription[] flowableReplay$InnerSubscriptionArray2;
        AtomicReference atomicReference;
        boolean bl2;
        do {
            int n10;
            FlowableReplay$InnerSubscription[] flowableReplay$InnerSubscriptionArray3;
            int n11;
            int n12;
            if ((n12 = (flowableReplay$InnerSubscriptionArray2 = (FlowableReplay$InnerSubscription[])this.subscribers.get()).length) == 0) {
                return;
            }
            int n13 = -1;
            int n14 = 0;
            for (n11 = 0; n11 < n12; ++n11) {
                flowableReplay$InnerSubscriptionArray3 = flowableReplay$InnerSubscriptionArray2[n11];
                n10 = flowableReplay$InnerSubscriptionArray3.equals(flowableReplay$InnerSubscription);
                if (n10 == 0) continue;
                n13 = n11;
                break;
            }
            if (n13 < 0) {
                return;
            }
            n11 = 1;
            if (n12 == n11) {
                flowableReplay$InnerSubscriptionArray = EMPTY;
                continue;
            }
            n10 = n12 + -1;
            flowableReplay$InnerSubscriptionArray3 = new FlowableReplay$InnerSubscription[n10];
            System.arraycopy(flowableReplay$InnerSubscriptionArray2, 0, flowableReplay$InnerSubscriptionArray3, 0, n13);
            n14 = n13 + 1;
            n12 = n12 - n13 - n11;
            System.arraycopy(flowableReplay$InnerSubscriptionArray2, n14, flowableReplay$InnerSubscriptionArray3, n13, n12);
            flowableReplay$InnerSubscriptionArray = flowableReplay$InnerSubscriptionArray3;
        } while (!(bl2 = (atomicReference = this.subscribers).compareAndSet(flowableReplay$InnerSubscriptionArray2, flowableReplay$InnerSubscriptionArray)));
    }
}

