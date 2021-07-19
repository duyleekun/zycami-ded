/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.parallel;

import e.a.a1.a;
import e.a.w0.i.b;
import i.g.d;
import i.g.e;
import io.reactivex.internal.operators.parallel.ParallelSortedJoin$SortedJoinInnerSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class ParallelSortedJoin$SortedJoinSubscription
extends AtomicInteger
implements e {
    private static final long serialVersionUID = 3481980673745556697L;
    public volatile boolean cancelled;
    public final Comparator comparator;
    public final d downstream;
    public final AtomicReference error;
    public final int[] indexes;
    public final List[] lists;
    public final AtomicInteger remaining;
    public final AtomicLong requested;
    public final ParallelSortedJoin$SortedJoinInnerSubscriber[] subscribers;

    public ParallelSortedJoin$SortedJoinSubscription(d objectArray, int n10, Comparator comparator) {
        Serializable serializable;
        this.requested = serializable = new AtomicLong();
        this.remaining = serializable;
        super();
        this.error = serializable;
        this.downstream = objectArray;
        this.comparator = comparator;
        objectArray = new ParallelSortedJoin$SortedJoinInnerSubscriber[n10];
        comparator = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            super(this, i10);
            objectArray[i10] = serializable;
        }
        this.subscribers = objectArray;
        objectArray = new List[n10];
        this.lists = objectArray;
        objectArray = new int[n10];
        this.indexes = (int[])objectArray;
        this.remaining.lazySet(n10);
    }

    public void cancel() {
        int n10 = this.cancelled;
        if (n10 == 0) {
            this.cancelled = true;
            this.cancelAll();
            n10 = this.getAndIncrement();
            if (n10 == 0) {
                Object[] objectArray = this.lists;
                Arrays.fill(objectArray, null);
            }
        }
    }

    public void cancelAll() {
        for (ParallelSortedJoin$SortedJoinInnerSubscriber parallelSortedJoin$SortedJoinInnerSubscriber : this.subscribers) {
            parallelSortedJoin$SortedJoinInnerSubscriber.cancel();
        }
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void drain() {
        ParallelSortedJoin$SortedJoinSubscription parallelSortedJoin$SortedJoinSubscription = this;
        int n10 = this.getAndIncrement();
        if (n10 != 0) {
            return;
        }
        d d10 = this.downstream;
        Object object = this.lists;
        int[] nArray = this.indexes;
        int n11 = nArray.length;
        int n12 = 1;
        while (true) {
            long l10;
            long l11;
            long l12;
            int n13;
            int n14;
            Object object2;
            int n15;
            int n16;
            Object object3;
            long l13;
            AtomicLong atomicLong = parallelSortedJoin$SortedJoinSubscription.requested;
            long l14 = atomicLong.get();
            long l15 = 0L;
            while (true) {
                void var17_17;
                l13 = l15 == l14 ? 0 : (l15 < l14 ? -1 : 1);
                int n17 = 0;
                if (l13 == false) break;
                l13 = (long)parallelSortedJoin$SortedJoinSubscription.cancelled;
                if (l13 != false) {
                    Arrays.fill((Object[])object, null);
                    return;
                }
                object3 = (Throwable)parallelSortedJoin$SortedJoinSubscription.error.get();
                if (object3 != null) {
                    this.cancelAll();
                    Arrays.fill((Object[])object, null);
                    d10.onError((Throwable)object3);
                    return;
                }
                l13 = -1;
                n16 = 0;
                Object var17_18 = null;
                for (n15 = 0; n15 < n11; ++n15) {
                    block23: {
                        object2 = object[n15];
                        n14 = nArray[n15];
                        n17 = object2.size();
                        if (n17 != n14) {
                            if (var17_17 == null) {
                                Object e10 = object2.get(n14);
                            } else {
                                Object e11 = object2.get(n14);
                                try {
                                    object2 = parallelSortedJoin$SortedJoinSubscription.comparator;
                                    n13 = object2.compare(var17_17, e11);
                                    if (n13 > 0) {
                                        n13 = 1;
                                    } else {
                                        n13 = 0;
                                        object2 = null;
                                    }
                                    if (n13 == 0) break block23;
                                    Object e12 = e11;
                                }
                                catch (Throwable throwable) {
                                    e.a.t0.a.b(throwable);
                                    this.cancelAll();
                                    n11 = 0;
                                    Arrays.fill((Object[])object, null);
                                    object = parallelSortedJoin$SortedJoinSubscription.error;
                                    boolean bl2 = ((AtomicReference)object).compareAndSet(null, throwable);
                                    if (!bl2) {
                                        a.Y(throwable);
                                    }
                                    Throwable throwable2 = (Throwable)parallelSortedJoin$SortedJoinSubscription.error.get();
                                    d10.onError(throwable2);
                                    return;
                                }
                            }
                            l13 = n15;
                        }
                    }
                    n17 = 0;
                }
                if (var17_17 == null) {
                    Arrays.fill((Object[])object, null);
                    d10.onComplete();
                    return;
                }
                d10.onNext(var17_17);
                n14 = nArray[l13];
                n16 = 1;
                nArray[l13] = n14 += n16;
                l12 = 1L;
                l15 += l12;
            }
            n16 = 1;
            if (l13 == false) {
                block24: {
                    n14 = parallelSortedJoin$SortedJoinSubscription.cancelled;
                    if (n14 != 0) {
                        Arrays.fill((Object[])object, null);
                        return;
                    }
                    n14 = 0;
                    Object var21_27 = null;
                    object2 = (Throwable)parallelSortedJoin$SortedJoinSubscription.error.get();
                    if (object2 != null) {
                        this.cancelAll();
                        Arrays.fill((Object[])object, null);
                        d10.onError((Throwable)object2);
                        return;
                    }
                    Object var21_28 = null;
                    for (n14 = 0; n14 < n11; ++n14) {
                        n13 = nArray[n14];
                        object3 = object[n14];
                        l13 = object3.size();
                        if (n13 == l13) continue;
                        n15 = 0;
                        break block24;
                    }
                    n15 = n16;
                }
                if (n15 != 0) {
                    Arrays.fill((Object[])object, null);
                    d10.onComplete();
                    return;
                }
            }
            if ((n14 = (l11 = l15 - (l12 = 0L)) == 0L ? 0 : (l11 < 0L ? -1 : 1)) != 0 && (n14 = (int)((l10 = l14 - (l12 = Long.MAX_VALUE)) == 0L ? 0 : (l10 < 0L ? -1 : 1))) != 0) {
                AtomicLong atomicLong2 = parallelSortedJoin$SortedJoinSubscription.requested;
                l14 = -l15;
                atomicLong2.addAndGet(l14);
            }
            if ((n14 = this.get()) == n12) {
                n14 = -n12;
                if ((n14 = parallelSortedJoin$SortedJoinSubscription.addAndGet(n14)) == 0) {
                    return;
                }
            }
            n12 = n14;
        }
    }

    public void innerError(Throwable throwable) {
        AtomicReference atomicReference = this.error;
        boolean bl2 = atomicReference.compareAndSet(null, throwable);
        if (bl2) {
            this.drain();
        } else {
            atomicReference = this.error.get();
            if (throwable != atomicReference) {
                a.Y(throwable);
            }
        }
    }

    public void innerNext(List object, int n10) {
        List[] listArray = this.lists;
        listArray[n10] = object;
        object = this.remaining;
        int n11 = ((AtomicInteger)object).decrementAndGet();
        if (n11 == 0) {
            this.drain();
        }
    }

    public void request(long l10) {
        boolean bl2 = SubscriptionHelper.validate(l10);
        if (bl2) {
            AtomicLong atomicLong = this.requested;
            b.a(atomicLong, l10);
            AtomicInteger atomicInteger = this.remaining;
            int n10 = atomicInteger.get();
            if (n10 == 0) {
                this.drain();
            }
        }
    }
}

