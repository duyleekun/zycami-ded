/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.j;
import e.a.o;
import e.a.w0.e.b.a;
import i.g.d;
import i.g.e;
import io.reactivex.internal.operators.flowable.FlowableCache$CacheSubscription;
import io.reactivex.internal.operators.flowable.FlowableCache$a;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class FlowableCache
extends a
implements o {
    public static final FlowableCache$CacheSubscription[] l = new FlowableCache$CacheSubscription[0];
    public static final FlowableCache$CacheSubscription[] m = new FlowableCache$CacheSubscription[0];
    public final AtomicBoolean c;
    public final int d;
    public final AtomicReference e;
    public volatile long f;
    public final FlowableCache$a g;
    public FlowableCache$a h;
    public int i;
    public Throwable j;
    public volatile boolean k;

    public FlowableCache(j atomicReference, int n10) {
        super((j)((Object)atomicReference));
        this.d = n10;
        atomicReference = new AtomicReference<FlowableCache$CacheSubscription[]>();
        this.c = atomicReference;
        atomicReference = new AtomicReference<FlowableCache$CacheSubscription[]>(n10);
        this.g = atomicReference;
        this.h = atomicReference;
        FlowableCache$CacheSubscription[] flowableCache$CacheSubscriptionArray = l;
        this.e = atomicReference = new AtomicReference<FlowableCache$CacheSubscription[]>(flowableCache$CacheSubscriptionArray);
    }

    public void K8(FlowableCache$CacheSubscription flowableCache$CacheSubscription) {
        FlowableCache$CacheSubscription[] flowableCache$CacheSubscriptionArray;
        FlowableCache$CacheSubscription[] flowableCache$CacheSubscriptionArray2;
        Object object;
        boolean bl2;
        do {
            if ((flowableCache$CacheSubscriptionArray2 = (FlowableCache$CacheSubscription[])this.e.get()) == (object = m)) {
                return;
            }
            int n10 = flowableCache$CacheSubscriptionArray2.length;
            int n11 = n10 + 1;
            flowableCache$CacheSubscriptionArray = new FlowableCache$CacheSubscription[n11];
            System.arraycopy(flowableCache$CacheSubscriptionArray2, 0, flowableCache$CacheSubscriptionArray, 0, n10);
            flowableCache$CacheSubscriptionArray[n10] = flowableCache$CacheSubscription;
        } while (!(bl2 = ((AtomicReference)(object = this.e)).compareAndSet(flowableCache$CacheSubscriptionArray2, flowableCache$CacheSubscriptionArray)));
    }

    public long L8() {
        return this.f;
    }

    public boolean M8() {
        FlowableCache$CacheSubscription[] flowableCache$CacheSubscriptionArray = (FlowableCache$CacheSubscription[])this.e.get();
        boolean bl2 = flowableCache$CacheSubscriptionArray.length;
        if (bl2) {
            bl2 = true;
        } else {
            bl2 = false;
            flowableCache$CacheSubscriptionArray = null;
        }
        return bl2;
    }

    public boolean N8() {
        return this.c.get();
    }

    public void O8(FlowableCache$CacheSubscription flowableCache$CacheSubscription) {
        FlowableCache$CacheSubscription[] flowableCache$CacheSubscriptionArray;
        FlowableCache$CacheSubscription[] flowableCache$CacheSubscriptionArray2;
        AtomicReference atomicReference;
        boolean bl2;
        do {
            FlowableCache$CacheSubscription[] flowableCache$CacheSubscriptionArray3;
            int n10;
            int n11;
            if ((n11 = (flowableCache$CacheSubscriptionArray2 = (FlowableCache$CacheSubscription[])this.e.get()).length) == 0) {
                return;
            }
            int n12 = -1;
            int n13 = 0;
            for (n10 = 0; n10 < n11; ++n10) {
                flowableCache$CacheSubscriptionArray3 = flowableCache$CacheSubscriptionArray2[n10];
                if (flowableCache$CacheSubscriptionArray3 != flowableCache$CacheSubscription) continue;
                n12 = n10;
                break;
            }
            if (n12 < 0) {
                return;
            }
            n10 = 1;
            if (n11 == n10) {
                flowableCache$CacheSubscriptionArray = l;
                continue;
            }
            int n14 = n11 + -1;
            flowableCache$CacheSubscriptionArray3 = new FlowableCache$CacheSubscription[n14];
            System.arraycopy(flowableCache$CacheSubscriptionArray2, 0, flowableCache$CacheSubscriptionArray3, 0, n12);
            n13 = n12 + 1;
            n11 = n11 - n12 - n10;
            System.arraycopy(flowableCache$CacheSubscriptionArray2, n13, flowableCache$CacheSubscriptionArray3, n12, n11);
            flowableCache$CacheSubscriptionArray = flowableCache$CacheSubscriptionArray3;
        } while (!(bl2 = (atomicReference = this.e).compareAndSet(flowableCache$CacheSubscriptionArray2, flowableCache$CacheSubscriptionArray)));
    }

    public void P8(FlowableCache$CacheSubscription flowableCache$CacheSubscription) {
        int n10;
        FlowableCache flowableCache = this;
        Serializable serializable = flowableCache$CacheSubscription;
        int n11 = flowableCache$CacheSubscription.getAndIncrement();
        if (n11 != 0) {
            return;
        }
        long l10 = flowableCache$CacheSubscription.index;
        int n12 = flowableCache$CacheSubscription.offset;
        FlowableCache$a flowableCache$a = flowableCache$CacheSubscription.node;
        AtomicLong atomicLong = flowableCache$CacheSubscription.requested;
        d d10 = flowableCache$CacheSubscription.downstream;
        int n13 = this.d;
        int n14 = n10 = 1;
        while (true) {
            Object object = flowableCache.k;
            long l11 = flowableCache.f;
            long l12 = l11 - l10;
            Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            object2 = object2 == false ? (Object)n10 : (Object)0;
            if (object && object2 != false) {
                ((FlowableCache$CacheSubscription)serializable).node = null;
                serializable = flowableCache.j;
                if (serializable != null) {
                    d10.onError((Throwable)serializable);
                } else {
                    d10.onComplete();
                }
                return;
            }
            if (object2 == false) {
                long l13;
                long l14 = atomicLong.get();
                long l15 = l14 - (l13 = Long.MIN_VALUE);
                Object object3 = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
                if (object3 == false) {
                    ((FlowableCache$CacheSubscription)serializable).node = null;
                    return;
                }
                object = l14 == l10 ? 0 : (l14 < l10 ? -1 : 1);
                if (object) {
                    if (n12 == n13) {
                        flowableCache$a = flowableCache$a.b;
                        n12 = 0;
                    }
                    Object object4 = flowableCache$a.a[n12];
                    d10.onNext(object4);
                    n12 += n10;
                    l14 = 1L;
                    l10 += l14;
                    continue;
                }
            }
            ((FlowableCache$CacheSubscription)serializable).index = l10;
            ((FlowableCache$CacheSubscription)serializable).offset = n12;
            ((FlowableCache$CacheSubscription)serializable).node = flowableCache$a;
            n14 = -n14;
            if ((n14 = ((AtomicInteger)serializable).addAndGet(n14)) == 0) break;
        }
    }

    public void m6(d object) {
        boolean bl2;
        FlowableCache$CacheSubscription flowableCache$CacheSubscription = new FlowableCache$CacheSubscription((d)object, this);
        object.onSubscribe(flowableCache$CacheSubscription);
        this.K8(flowableCache$CacheSubscription);
        object = this.c;
        boolean bl3 = ((AtomicBoolean)object).get();
        if (!bl3 && (bl3 = ((AtomicBoolean)(object = this.c)).compareAndSet(false, bl2 = true))) {
            object = this.b;
            ((j)object).l6(this);
        } else {
            this.P8(flowableCache$CacheSubscription);
        }
    }

    public void onComplete() {
        boolean bl2;
        this.k = bl2 = true;
        FlowableCache$CacheSubscription[] flowableCache$CacheSubscriptionArray = this.e;
        FlowableCache$CacheSubscription[] flowableCache$CacheSubscriptionArray2 = m;
        for (FlowableCache$CacheSubscription flowableCache$CacheSubscription : flowableCache$CacheSubscriptionArray.getAndSet(flowableCache$CacheSubscriptionArray2)) {
            this.P8(flowableCache$CacheSubscription);
        }
    }

    public void onError(Throwable serializable) {
        boolean bl2;
        int n10 = this.k;
        if (n10 != 0) {
            e.a.a1.a.Y((Throwable)serializable);
            return;
        }
        this.j = serializable;
        this.k = bl2 = true;
        serializable = this.e;
        FlowableCache$CacheSubscription[] flowableCache$CacheSubscriptionArray = m;
        for (Serializable serializable2 : ((AtomicReference)serializable).getAndSet(flowableCache$CacheSubscriptionArray)) {
            this.P8((FlowableCache$CacheSubscription)serializable2);
        }
    }

    public void onNext(Object flowableCache$CacheSubscriptionArray) {
        Object object;
        int n10 = this.i;
        int n11 = this.d;
        int n12 = 0;
        int n13 = 1;
        if (n10 == n11) {
            object = new FlowableCache$a(n10);
            Object[] objectArray = object.a;
            objectArray[0] = flowableCache$CacheSubscriptionArray;
            this.i = n13;
            flowableCache$CacheSubscriptionArray = this.h;
            flowableCache$CacheSubscriptionArray.b = object;
            this.h = object;
        } else {
            object = this.h.a;
            object[n10] = flowableCache$CacheSubscriptionArray;
            this.i = n10 += n13;
        }
        long l10 = this.f;
        long l11 = 1L;
        this.f = l10 += l11;
        flowableCache$CacheSubscriptionArray = (FlowableCache$CacheSubscription[])this.e.get();
        n10 = flowableCache$CacheSubscriptionArray.length;
        while (n12 < n10) {
            object = flowableCache$CacheSubscriptionArray[n12];
            this.P8((FlowableCache$CacheSubscription)object);
            ++n12;
        }
    }

    public void onSubscribe(e e10) {
        e10.request(Long.MAX_VALUE);
    }
}

