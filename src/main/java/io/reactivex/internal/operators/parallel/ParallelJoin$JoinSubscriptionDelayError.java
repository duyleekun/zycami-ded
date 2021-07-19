/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.parallel;

import i.g.d;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.operators.parallel.ParallelJoin$JoinInnerSubscriber;
import io.reactivex.internal.operators.parallel.ParallelJoin$JoinSubscriptionBase;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public final class ParallelJoin$JoinSubscriptionDelayError
extends ParallelJoin$JoinSubscriptionBase {
    private static final long serialVersionUID = -5737965195918321883L;

    public ParallelJoin$JoinSubscriptionDelayError(d d10, int n10, int n11) {
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
        ParallelJoin$JoinSubscriptionDelayError parallelJoin$JoinSubscriptionDelayError = this;
        Object object = this.subscribers;
        int n10 = ((ParallelJoin$JoinInnerSubscriber[])object).length;
        d d10 = this.downstream;
        int n11 = 1;
        while (true) {
            long l10;
            long l11;
            Object object2;
            Serializable serializable;
            AtomicInteger atomicInteger;
            long l12;
            long l13;
            AtomicLong atomicLong = parallelJoin$JoinSubscriptionDelayError.requested;
            long l14 = atomicLong.get();
            long l15 = l13 = 0L;
            block1: while ((l12 = l15 == l14 ? 0 : (l15 < l14 ? -1 : 1)) != false) {
                l12 = (long)parallelJoin$JoinSubscriptionDelayError.cancelled;
                if (l12 != false) {
                    this.cleanup();
                    return;
                }
                atomicInteger = parallelJoin$JoinSubscriptionDelayError.done;
                l12 = atomicInteger.get();
                if (l12 == false) {
                    l12 = 1;
                } else {
                    l12 = 0;
                    atomicInteger = null;
                }
                boolean bl2 = true;
                for (int i10 = 0; i10 < n10; ++i10) {
                    serializable = object[i10];
                    object2 = ((ParallelJoin$JoinInnerSubscriber)serializable).queue;
                    if (object2 == null || (object2 = object2.poll()) == null) continue;
                    d10.onNext(object2);
                    ((ParallelJoin$JoinInnerSubscriber)serializable).requestOne();
                    long l16 = 1L;
                    long l17 = (l15 += l16) - l14;
                    l11 = l17 == 0L ? 0 : (l17 < 0L ? -1 : 1);
                    if (l11 == false) break block1;
                    bl2 = false;
                }
                if (l12 != false && bl2) {
                    object = (Throwable)parallelJoin$JoinSubscriptionDelayError.errors.get();
                    if (object != null) {
                        object = parallelJoin$JoinSubscriptionDelayError.errors.terminate();
                        d10.onError((Throwable)object);
                    } else {
                        d10.onComplete();
                    }
                    return;
                }
                if (!bl2) continue;
            }
            if ((l11 = l15 == l14 ? 0 : (l15 < l14 ? -1 : 1)) == false) {
                boolean bl3;
                block20: {
                    l11 = (long)parallelJoin$JoinSubscriptionDelayError.cancelled;
                    if (l11 != false) {
                        this.cleanup();
                        return;
                    }
                    serializable = parallelJoin$JoinSubscriptionDelayError.done;
                    l11 = ((AtomicInteger)serializable).get();
                    if (l11 == false) {
                        l11 = 1;
                    } else {
                        l11 = 0;
                        serializable = null;
                    }
                    atomicInteger = null;
                    for (l12 = (long)0; l12 < n10; ++l12) {
                        object2 = object[l12].queue;
                        if (object2 == null || (bl3 = object2.isEmpty())) continue;
                        bl3 = false;
                        object2 = null;
                        break block20;
                    }
                    bl3 = true;
                }
                if (l11 != false && bl3) {
                    object = (Throwable)parallelJoin$JoinSubscriptionDelayError.errors.get();
                    if (object != null) {
                        object = parallelJoin$JoinSubscriptionDelayError.errors.terminate();
                        d10.onError((Throwable)object);
                    } else {
                        d10.onComplete();
                    }
                    return;
                }
            }
            if ((l11 = l15 == l13 ? 0 : (l15 < l13 ? -1 : 1)) != false && (l11 = (l10 = l14 - (l13 = Long.MAX_VALUE)) == 0L ? 0 : (l10 < 0L ? -1 : 1)) != false) {
                serializable = parallelJoin$JoinSubscriptionDelayError.requested;
                l14 = -l15;
                ((AtomicLong)serializable).addAndGet(l14);
            }
            if ((l11 = (long)this.get()) == n11) {
                l11 = -n11;
                if ((l11 = (long)parallelJoin$JoinSubscriptionDelayError.addAndGet((int)l11)) == false) {
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
        this.errors.addThrowable(throwable);
        this.done.decrementAndGet();
        this.drain();
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
                var5_5 = var1_1.getQueue();
                var13_11 = var5_5.offer(var2_2);
                if (!var13_11) {
                    var1_1.cancel();
                    var1_1 = this.errors;
                    var2_2 = new MissingBackpressureException(var4_4);
                    var1_1.addThrowable((Throwable)var2_2);
                    this.done.decrementAndGet();
                    this.drainLoop();
                    return;
                }
            }
            var14_13 = this.decrementAndGet();
            if (var14_13 == 0) {
                return;
            }
        } else lbl-1000:
        // 2 sources

        {
            if (!(var13_12 = (var5_5 = var1_1.getQueue()).offer(var2_2)) && (var14_14 = var1_1.cancel()) != 0) {
                var1_1 = this.errors;
                var2_2 = new MissingBackpressureException(var4_4);
                var1_1.addThrowable((Throwable)var2_2);
                var1_1 = this.done;
                var1_1.decrementAndGet();
            }
            if ((var14_14 = this.getAndIncrement()) != 0) {
                return;
            }
        }
        this.drainLoop();
    }
}

