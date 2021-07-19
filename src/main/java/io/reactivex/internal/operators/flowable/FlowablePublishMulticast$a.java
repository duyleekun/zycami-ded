/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.a1.a;
import e.a.j;
import e.a.s0.b;
import e.a.w0.c.l;
import e.a.w0.c.o;
import e.a.w0.i.n;
import i.g.d;
import i.g.e;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.operators.flowable.FlowablePublishMulticast$MulticastSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class FlowablePublishMulticast$a
extends j
implements e.a.o,
b {
    public static final FlowablePublishMulticast$MulticastSubscription[] m = new FlowablePublishMulticast$MulticastSubscription[0];
    public static final FlowablePublishMulticast$MulticastSubscription[] n = new FlowablePublishMulticast$MulticastSubscription[0];
    public final AtomicInteger b;
    public final AtomicReference c;
    public final int d;
    public final int e;
    public final boolean f;
    public final AtomicReference g;
    public volatile o h;
    public int i;
    public volatile boolean j;
    public Throwable k;
    public int l;

    public FlowablePublishMulticast$a(int n10, boolean bl2) {
        Serializable serializable;
        this.d = n10;
        int n11 = n10 >> 2;
        this.e = n10 -= n11;
        this.f = bl2;
        this.b = serializable = new AtomicInteger();
        this.g = serializable;
        FlowablePublishMulticast$MulticastSubscription[] flowablePublishMulticast$MulticastSubscriptionArray = m;
        super(flowablePublishMulticast$MulticastSubscriptionArray);
        this.c = serializable;
    }

    public boolean K8(FlowablePublishMulticast$MulticastSubscription flowablePublishMulticast$MulticastSubscription) {
        FlowablePublishMulticast$MulticastSubscription[] flowablePublishMulticast$MulticastSubscriptionArray;
        FlowablePublishMulticast$MulticastSubscription[] flowablePublishMulticast$MulticastSubscriptionArray2;
        Object object;
        boolean bl2;
        do {
            if ((flowablePublishMulticast$MulticastSubscriptionArray2 = (FlowablePublishMulticast$MulticastSubscription[])this.c.get()) == (object = n)) {
                return false;
            }
            int n10 = flowablePublishMulticast$MulticastSubscriptionArray2.length;
            int n11 = n10 + 1;
            flowablePublishMulticast$MulticastSubscriptionArray = new FlowablePublishMulticast$MulticastSubscription[n11];
            System.arraycopy(flowablePublishMulticast$MulticastSubscriptionArray2, 0, flowablePublishMulticast$MulticastSubscriptionArray, 0, n10);
            flowablePublishMulticast$MulticastSubscriptionArray[n10] = flowablePublishMulticast$MulticastSubscription;
        } while (!(bl2 = ((AtomicReference)(object = this.c)).compareAndSet(flowablePublishMulticast$MulticastSubscriptionArray2, flowablePublishMulticast$MulticastSubscriptionArray)));
        return true;
    }

    public void L8() {
        FlowablePublishMulticast$MulticastSubscription[] flowablePublishMulticast$MulticastSubscriptionArray = this.c;
        FlowablePublishMulticast$MulticastSubscription[] flowablePublishMulticast$MulticastSubscriptionArray2 = n;
        for (FlowablePublishMulticast$MulticastSubscription flowablePublishMulticast$MulticastSubscription : flowablePublishMulticast$MulticastSubscriptionArray.getAndSet(flowablePublishMulticast$MulticastSubscriptionArray2)) {
            long l10;
            long l11 = flowablePublishMulticast$MulticastSubscription.get();
            long l12 = l11 - (l10 = Long.MIN_VALUE);
            Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object == false) continue;
            d d10 = flowablePublishMulticast$MulticastSubscription.downstream;
            d10.onComplete();
        }
    }

    public void M8() {
        FlowablePublishMulticast$a flowablePublishMulticast$a = this;
        Object object = this.b;
        int n10 = ((AtomicInteger)object).getAndIncrement();
        if (n10 != 0) {
            return;
        }
        object = this.h;
        int n11 = this.l;
        int n12 = this.e;
        int n13 = this.i;
        int n14 = 1;
        n13 = n13 != n14 ? n14 : 0;
        AtomicReference atomicReference = flowablePublishMulticast$a.c;
        Object object2 = (FlowablePublishMulticast$MulticastSubscription[])atomicReference.get();
        int n15 = n14;
        while (true) {
            AtomicReference atomicReference2;
            block31: {
                Object object3;
                int n16 = ((FlowablePublishMulticast$MulticastSubscription[])object2).length;
                if (object != null && n16 != 0) {
                    long l10;
                    Object object4;
                    long l11;
                    long l12;
                    long l13;
                    int n17 = ((FlowablePublishMulticast$MulticastSubscription[])object2).length;
                    long l14 = l13 = Long.MAX_VALUE;
                    int n18 = 0;
                    while (true) {
                        l12 = Long.MIN_VALUE;
                        if (n18 >= n17) break;
                        object3 = object2[n18];
                        l11 = ((AtomicLong)object3).get();
                        atomicReference2 = atomicReference;
                        long l15 = ((FlowablePublishMulticast$MulticastSubscription)object3).emitted;
                        long l16 = (l11 -= l15) - l12;
                        object4 = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
                        if (object4 != 0) {
                            object4 = l14 == l11 ? 0 : (l14 < l11 ? -1 : 1);
                            if (object4 > 0) {
                                l14 = l11;
                            }
                        } else {
                            n16 += -1;
                        }
                        ++n18;
                        atomicReference = atomicReference2;
                        n14 = 1;
                    }
                    atomicReference2 = atomicReference;
                    long l17 = 0L;
                    if (n16 == 0) {
                        l14 = l17;
                    }
                    while ((l10 = l14 == l17 ? 0 : (l14 < l17 ? -1 : 1)) != false) {
                        Object object5;
                        Object object6;
                        n16 = (int)(this.isDisposed() ? 1 : 0);
                        if (n16 != 0) {
                            object.clear();
                            return;
                        }
                        n16 = (int)(flowablePublishMulticast$a.j ? 1 : 0);
                        if (n16 != 0 && (n17 = (int)(flowablePublishMulticast$a.f ? 1 : 0)) == 0 && (object6 = flowablePublishMulticast$a.k) != null) {
                            flowablePublishMulticast$a.N8((Throwable)object6);
                            return;
                        }
                        try {
                            object6 = object.poll();
                            n18 = object6 == null ? 1 : 0;
                            if (n16 != 0 && n18 != 0) {
                                object = flowablePublishMulticast$a.k;
                                if (object != null) {
                                    flowablePublishMulticast$a.N8((Throwable)object);
                                } else {
                                    this.L8();
                                }
                                return;
                            }
                            if (n18 != 0) break;
                        }
                        catch (Throwable throwable) {
                            object5 = throwable;
                            e.a.t0.a.b(throwable);
                            SubscriptionHelper.cancel(flowablePublishMulticast$a.g);
                            flowablePublishMulticast$a.N8((Throwable)object5);
                            return;
                        }
                        l10 = ((FlowablePublishMulticast$MulticastSubscription[])object2).length;
                        n16 = 0;
                        n18 = 0;
                        while (true) {
                            l11 = 1L;
                            if (n16 >= l10) break;
                            object3 = object2[n16];
                            long l18 = ((AtomicLong)object3).get();
                            long l19 = l18 - l12;
                            n14 = (int)(l19 == 0L ? 0 : (l19 < 0L ? -1 : 1));
                            if (n14 != 0) {
                                n14 = (int)(l18 == l13 ? 0 : (l18 < l13 ? -1 : 1));
                                if (n14 != 0) {
                                    ((FlowablePublishMulticast$MulticastSubscription)object3).emitted = l13 = ((FlowablePublishMulticast$MulticastSubscription)object3).emitted + l11;
                                }
                                object3 = ((FlowablePublishMulticast$MulticastSubscription)object3).downstream;
                                object3.onNext(object6);
                            } else {
                                n18 = 1;
                            }
                            ++n16;
                            l17 = 0L;
                            l13 = Long.MAX_VALUE;
                        }
                        l14 -= l11;
                        if (n13 != 0 && ++n11 == n12) {
                            object5 = (e)flowablePublishMulticast$a.g.get();
                            l17 = n12;
                            object5.request(l17);
                            n11 = 0;
                            object5 = null;
                        }
                        object3 = (FlowablePublishMulticast$MulticastSubscription[])atomicReference2.get();
                        if (n18 == 0 && object3 == object2) {
                            l17 = 0L;
                            l13 = Long.MAX_VALUE;
                            continue;
                        }
                        object2 = object3;
                        break block31;
                    }
                    if (l10 == false) {
                        Throwable throwable;
                        object4 = this.isDisposed();
                        if (object4 != 0) {
                            object.clear();
                            return;
                        }
                        object4 = flowablePublishMulticast$a.j;
                        if (object4 != 0 && (n14 = (int)(flowablePublishMulticast$a.f ? 1 : 0)) == 0 && (throwable = flowablePublishMulticast$a.k) != null) {
                            flowablePublishMulticast$a.N8(throwable);
                            return;
                        }
                        if (object4 != 0 && (object4 = (Object)object.isEmpty()) != 0) {
                            object = flowablePublishMulticast$a.k;
                            if (object != null) {
                                flowablePublishMulticast$a.N8((Throwable)object);
                            } else {
                                this.L8();
                            }
                            return;
                        }
                    }
                } else {
                    atomicReference2 = atomicReference;
                }
                flowablePublishMulticast$a.l = n11;
                object3 = flowablePublishMulticast$a.b;
                n14 = -n15;
                if ((n15 = ((AtomicInteger)object3).addAndGet(n14)) == 0) {
                    return;
                }
                if (object == null) {
                    object = flowablePublishMulticast$a.h;
                }
                object3 = atomicReference2.get();
                object2 = object3;
                object2 = (FlowablePublishMulticast$MulticastSubscription[])object3;
            }
            atomicReference = atomicReference2;
            n14 = 1;
        }
    }

    public void N8(Throwable throwable) {
        FlowablePublishMulticast$MulticastSubscription[] flowablePublishMulticast$MulticastSubscriptionArray = this.c;
        FlowablePublishMulticast$MulticastSubscription[] flowablePublishMulticast$MulticastSubscriptionArray2 = n;
        for (FlowablePublishMulticast$MulticastSubscription flowablePublishMulticast$MulticastSubscription : flowablePublishMulticast$MulticastSubscriptionArray.getAndSet(flowablePublishMulticast$MulticastSubscriptionArray2)) {
            long l10;
            long l11 = flowablePublishMulticast$MulticastSubscription.get();
            long l12 = l11 - (l10 = Long.MIN_VALUE);
            Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object == false) continue;
            d d10 = flowablePublishMulticast$MulticastSubscription.downstream;
            d10.onError(throwable);
        }
    }

    public void O8(FlowablePublishMulticast$MulticastSubscription flowablePublishMulticast$MulticastSubscription) {
        FlowablePublishMulticast$MulticastSubscription[] flowablePublishMulticast$MulticastSubscriptionArray;
        FlowablePublishMulticast$MulticastSubscription[] flowablePublishMulticast$MulticastSubscriptionArray2;
        AtomicReference atomicReference;
        boolean bl2;
        do {
            FlowablePublishMulticast$MulticastSubscription[] flowablePublishMulticast$MulticastSubscriptionArray3;
            int n10;
            int n11;
            if ((n11 = (flowablePublishMulticast$MulticastSubscriptionArray2 = (FlowablePublishMulticast$MulticastSubscription[])this.c.get()).length) == 0) {
                return;
            }
            int n12 = -1;
            int n13 = 0;
            for (n10 = 0; n10 < n11; ++n10) {
                flowablePublishMulticast$MulticastSubscriptionArray3 = flowablePublishMulticast$MulticastSubscriptionArray2[n10];
                if (flowablePublishMulticast$MulticastSubscriptionArray3 != flowablePublishMulticast$MulticastSubscription) continue;
                n12 = n10;
                break;
            }
            if (n12 < 0) {
                return;
            }
            n10 = 1;
            if (n11 == n10) {
                flowablePublishMulticast$MulticastSubscriptionArray = m;
                continue;
            }
            int n14 = n11 + -1;
            flowablePublishMulticast$MulticastSubscriptionArray3 = new FlowablePublishMulticast$MulticastSubscription[n14];
            System.arraycopy(flowablePublishMulticast$MulticastSubscriptionArray2, 0, flowablePublishMulticast$MulticastSubscriptionArray3, 0, n12);
            n13 = n12 + 1;
            n11 = n11 - n12 - n10;
            System.arraycopy(flowablePublishMulticast$MulticastSubscriptionArray2, n13, flowablePublishMulticast$MulticastSubscriptionArray3, n12, n11);
            flowablePublishMulticast$MulticastSubscriptionArray = flowablePublishMulticast$MulticastSubscriptionArray3;
        } while (!(bl2 = (atomicReference = this.c).compareAndSet(flowablePublishMulticast$MulticastSubscriptionArray2, flowablePublishMulticast$MulticastSubscriptionArray)));
    }

    public void dispose() {
        SubscriptionHelper.cancel(this.g);
        Object object = this.b;
        int n10 = ((AtomicInteger)object).getAndIncrement();
        if (n10 == 0 && (object = this.h) != null) {
            object.clear();
        }
    }

    public boolean isDisposed() {
        boolean bl2;
        SubscriptionHelper subscriptionHelper;
        Object v10 = this.g.get();
        if (v10 == (subscriptionHelper = SubscriptionHelper.CANCELLED)) {
            bl2 = true;
        } else {
            bl2 = false;
            v10 = null;
        }
        return bl2;
    }

    public void m6(d d10) {
        Serializable serializable = new FlowablePublishMulticast$MulticastSubscription(d10, this);
        d10.onSubscribe((e)((Object)serializable));
        boolean bl2 = this.K8((FlowablePublishMulticast$MulticastSubscription)serializable);
        if (bl2) {
            boolean bl3 = serializable.isCancelled();
            if (bl3) {
                this.O8((FlowablePublishMulticast$MulticastSubscription)serializable);
                return;
            }
            this.M8();
        } else {
            serializable = this.k;
            if (serializable != null) {
                d10.onError((Throwable)serializable);
            } else {
                d10.onComplete();
            }
        }
    }

    public void onComplete() {
        boolean bl2 = this.j;
        if (!bl2) {
            this.j = bl2 = true;
            this.M8();
        }
    }

    public void onError(Throwable throwable) {
        boolean bl2 = this.j;
        if (bl2) {
            e.a.a1.a.Y(throwable);
            return;
        }
        this.k = throwable;
        this.j = true;
        this.M8();
    }

    public void onNext(Object object) {
        o o10;
        boolean bl2;
        int n10 = this.j;
        if (n10 != 0) {
            return;
        }
        n10 = this.i;
        if (n10 == 0 && !(bl2 = (o10 = this.h).offer(object))) {
            ((e)this.g.get()).cancel();
            object = new MissingBackpressureException();
            this.onError((Throwable)object);
            return;
        }
        this.M8();
    }

    public void onSubscribe(e e10) {
        Object object = this.g;
        int n10 = SubscriptionHelper.setOnce((AtomicReference)object, e10);
        if (n10 != 0) {
            n10 = e10 instanceof l;
            if (n10 != 0) {
                int n11;
                object = e10;
                object = (l)e10;
                int n12 = object.requestFusion(3);
                if (n12 == (n11 = 1)) {
                    this.i = n12;
                    this.h = object;
                    this.j = n11;
                    this.M8();
                    return;
                }
                n11 = 2;
                if (n12 == n11) {
                    this.i = n12;
                    this.h = object;
                    n10 = this.d;
                    e.a.w0.i.n.j(e10, n10);
                    return;
                }
            }
            this.h = object = e.a.w0.i.n.c(this.d);
            n10 = this.d;
            e.a.w0.i.n.j(e10, n10);
        }
    }
}

