/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.parallel;

import e.a.a1.a;
import i.g.d;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.operators.parallel.ParallelJoin$JoinInnerSubscriber;
import io.reactivex.internal.operators.parallel.ParallelJoin$JoinSubscriptionBase;
import io.reactivex.internal.util.AtomicThrowable;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public final class ParallelJoin$JoinSubscription
extends ParallelJoin$JoinSubscriptionBase {
    private static final long serialVersionUID = 6312374661811000451L;

    public ParallelJoin$JoinSubscription(d d10, int n10, int n11) {
        super(d10, n10, n11);
    }

    public void drain() {
        int n10 = this.getAndIncrement();
        if (n10 != 0) {
            return;
        }
        this.drainLoop();
    }

    public void drainLoop() {
        ParallelJoin$JoinSubscription parallelJoin$JoinSubscription = this;
        ParallelJoin$JoinInnerSubscriber[] parallelJoin$JoinInnerSubscriberArray = this.subscribers;
        int n10 = parallelJoin$JoinInnerSubscriberArray.length;
        d d10 = this.downstream;
        int n11 = 1;
        while (true) {
            long l10;
            Object object;
            Serializable serializable;
            long l11;
            Serializable serializable2;
            long l12;
            long l13;
            AtomicLong atomicLong = parallelJoin$JoinSubscription.requested;
            long l14 = atomicLong.get();
            long l15 = l13 = 0L;
            block1: while ((l12 = l15 == l14 ? 0 : (l15 < l14 ? -1 : 1)) != false) {
                l12 = (long)parallelJoin$JoinSubscription.cancelled;
                if (l12 != false) {
                    this.cleanup();
                    return;
                }
                serializable2 = (Throwable)parallelJoin$JoinSubscription.errors.get();
                if (serializable2 != null) {
                    this.cleanup();
                    d10.onError((Throwable)serializable2);
                    return;
                }
                serializable2 = parallelJoin$JoinSubscription.done;
                l12 = ((AtomicInteger)serializable2).get();
                if (l12 == false) {
                    l12 = 1;
                } else {
                    l12 = 0;
                    serializable2 = null;
                }
                boolean bl2 = true;
                for (int i10 = 0; i10 < (l11 = (long)parallelJoin$JoinInnerSubscriberArray.length); ++i10) {
                    serializable = parallelJoin$JoinInnerSubscriberArray[i10];
                    object = ((ParallelJoin$JoinInnerSubscriber)serializable).queue;
                    if (object == null || (object = object.poll()) == null) continue;
                    d10.onNext(object);
                    ((ParallelJoin$JoinInnerSubscriber)serializable).requestOne();
                    long l16 = 1L;
                    long l17 = (l15 += l16) - l14;
                    l11 = l17 == 0L ? 0 : (l17 < 0L ? -1 : 1);
                    if (l11 == false) break block1;
                    bl2 = false;
                }
                if (l12 != false && bl2) {
                    d10.onComplete();
                    return;
                }
                if (!bl2) continue;
            }
            if ((l11 = l15 == l14 ? 0 : (l15 < l14 ? -1 : 1)) == false) {
                boolean bl3;
                block18: {
                    l11 = (long)parallelJoin$JoinSubscription.cancelled;
                    if (l11 != false) {
                        this.cleanup();
                        return;
                    }
                    serializable = (Throwable)parallelJoin$JoinSubscription.errors.get();
                    if (serializable != null) {
                        this.cleanup();
                        d10.onError((Throwable)serializable);
                        return;
                    }
                    serializable = parallelJoin$JoinSubscription.done;
                    l11 = ((AtomicInteger)serializable).get();
                    if (l11 == false) {
                        l11 = 1;
                    } else {
                        l11 = 0;
                        serializable = null;
                    }
                    serializable2 = null;
                    for (l12 = (long)0; l12 < n10; ++l12) {
                        object = parallelJoin$JoinInnerSubscriberArray[l12].queue;
                        if (object == null || (bl3 = object.isEmpty())) continue;
                        bl3 = false;
                        object = null;
                        break block18;
                    }
                    bl3 = true;
                }
                if (l11 != false && bl3) {
                    d10.onComplete();
                    return;
                }
            }
            if ((l11 = l15 == l13 ? 0 : (l15 < l13 ? -1 : 1)) != false && (l11 = (l10 = l14 - (l13 = Long.MAX_VALUE)) == 0L ? 0 : (l10 < 0L ? -1 : 1)) != false) {
                serializable = parallelJoin$JoinSubscription.requested;
                l14 = -l15;
                ((AtomicLong)serializable).addAndGet(l14);
            }
            if ((l11 = (long)this.get()) == n11) {
                l11 = -n11;
                if ((l11 = (long)parallelJoin$JoinSubscription.addAndGet((int)l11)) == false) {
                    return;
                }
            }
            n11 = (int)l11;
        }
    }

    public void onComplete() {
        this.done.decrementAndGet();
        this.drain();
    }

    public void onError(Throwable throwable) {
        AtomicThrowable atomicThrowable = this.errors;
        boolean bl2 = atomicThrowable.compareAndSet(null, throwable);
        if (bl2) {
            this.cancelAll();
            this.drain();
        } else {
            atomicThrowable = this.errors.get();
            if (throwable != atomicThrowable) {
                a.Y(throwable);
            }
        }
    }

    /*
     * Unable to fully structure code
     */
    public void onNext(ParallelJoin$JoinInnerSubscriber var1_1, Object var2_2) {
        var3_3 = this.get();
        var4_4 = "Queue full?!";
        if (var3_3 != 0) ** GOTO lbl-1000
        var5_5 = null;
        var6_6 = 1;
        var3_3 = (int)this.compareAndSet(0, var6_6);
        if (var3_3 != 0) {
            var5_5 = this.requested;
            var7_7 = var5_5.get();
            cfr_temp_0 = var7_7 - (var9_8 = 0L);
            var3_3 = (int)(cfr_temp_0 == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1));
            if (var3_3 != 0) {
                var5_5 = this.downstream;
                var5_5.onNext(var2_2);
                var2_2 = this.requested;
                var11_9 = var2_2.get();
                var7_7 = 0x7FFFFFFFFFFFFFFFL;
                var13_10 = var11_9 == var7_7 ? 0 : (var11_9 < var7_7 ? -1 : 1);
                if (var13_10 != false) {
                    var2_2 = this.requested;
                    var2_2.decrementAndGet();
                }
                var11_9 = 1L;
                var1_1.request(var11_9);
            } else {
                var14_12 = (var1_1 = var1_1.getQueue()).offer(var2_2);
                if (var14_12 == 0) {
                    this.cancelAll();
                    var1_1 = new MissingBackpressureException(var4_4);
                    var2_2 = this.errors;
                    var3_3 = 0;
                    var5_5 = null;
                    var13_11 = var2_2.compareAndSet(null, var1_1);
                    if (var13_11) {
                        var2_2 = this.downstream;
                        var2_2.onError((Throwable)var1_1);
                    } else {
                        a.Y((Throwable)var1_1);
                    }
                    return;
                }
            }
            var14_12 = this.decrementAndGet();
            if (var14_12 == 0) {
                return;
            }
        } else lbl-1000:
        // 2 sources

        {
            if ((var14_13 = (var1_1 = var1_1.getQueue()).offer(var2_2)) == 0) {
                this.cancelAll();
                var1_1 = new MissingBackpressureException(var4_4);
                this.onError((Throwable)var1_1);
                return;
            }
            var14_13 = this.getAndIncrement();
            if (var14_13 != 0) {
                return;
            }
        }
        this.drainLoop();
    }
}

