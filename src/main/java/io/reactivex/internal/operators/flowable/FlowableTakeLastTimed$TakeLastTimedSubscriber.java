/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.h0;
import e.a.o;
import e.a.w0.f.a;
import e.a.w0.i.b;
import i.g.d;
import i.g.e;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public final class FlowableTakeLastTimed$TakeLastTimedSubscriber
extends AtomicInteger
implements o,
e {
    private static final long serialVersionUID = -5677354903406201275L;
    public volatile boolean cancelled;
    public final long count;
    public final boolean delayError;
    public volatile boolean done;
    public final d downstream;
    public Throwable error;
    public final a queue;
    public final AtomicLong requested;
    public final h0 scheduler;
    public final long time;
    public final TimeUnit unit;
    public e upstream;

    public FlowableTakeLastTimed$TakeLastTimedSubscriber(d object, long l10, long l11, TimeUnit timeUnit, h0 h02, int n10, boolean bl2) {
        AtomicLong atomicLong;
        this.requested = atomicLong = new AtomicLong();
        this.downstream = object;
        this.count = l10;
        this.time = l11;
        this.unit = timeUnit;
        this.scheduler = h02;
        this.queue = object = new a(n10);
        this.delayError = bl2;
    }

    public void cancel() {
        int n10 = this.cancelled;
        if (n10 == 0) {
            this.cancelled = true;
            Object object = this.upstream;
            object.cancel();
            n10 = this.getAndIncrement();
            if (n10 == 0) {
                object = this.queue;
                ((a)object).clear();
            }
        }
    }

    public boolean checkTerminated(boolean bl2, d d10, boolean bl3) {
        boolean bl4 = this.cancelled;
        boolean bl5 = true;
        if (bl4) {
            this.queue.clear();
            return bl5;
        }
        if (bl3) {
            if (bl2) {
                Throwable throwable = this.error;
                if (throwable != null) {
                    d10.onError(throwable);
                } else {
                    d10.onComplete();
                }
                return bl5;
            }
        } else {
            Throwable throwable = this.error;
            if (throwable != null) {
                this.queue.clear();
                d10.onError(throwable);
                return bl5;
            }
            if (bl2) {
                d10.onComplete();
                return bl5;
            }
        }
        return false;
    }

    public void drain() {
        boolean bl2;
        int n10 = this.getAndIncrement();
        if (n10 != 0) {
            return;
        }
        d d10 = this.downstream;
        a a10 = this.queue;
        boolean bl3 = this.delayError;
        boolean bl4 = bl2 = true;
        do {
            Object object;
            if (object = this.done) {
                long l10;
                object = a10.isEmpty();
                if (object = this.checkTerminated((boolean)object, d10, bl3)) {
                    return;
                }
                AtomicLong atomicLong = this.requested;
                long l11 = atomicLong.get();
                long l12 = l10 = 0L;
                while (true) {
                    Object object2;
                    Object object3;
                    if ((object3 = a10.peek()) == null) {
                        object2 = bl2;
                    } else {
                        object2 = false;
                        object3 = null;
                    }
                    object2 = this.checkTerminated((boolean)object2, d10, bl3);
                    if (object2) {
                        return;
                    }
                    object2 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
                    if (!object2) {
                        object = l12 == l10 ? 0 : (l12 < l10 ? -1 : 1);
                        if (!object) break;
                        atomicLong = this.requested;
                        b.e(atomicLong, l12);
                        break;
                    }
                    a10.poll();
                    object3 = a10.poll();
                    d10.onNext(object3);
                    long l13 = 1L;
                    l12 += l13;
                }
            }
            bl4 = -bl4;
        } while (bl4 = this.addAndGet((int)(bl4 ? 1 : 0)));
    }

    public void onComplete() {
        h0 h02 = this.scheduler;
        TimeUnit timeUnit = this.unit;
        long l10 = h02.d(timeUnit);
        a a10 = this.queue;
        this.trim(l10, a10);
        this.done = true;
        this.drain();
    }

    public void onError(Throwable throwable) {
        boolean bl2 = this.delayError;
        if (bl2) {
            h0 h02 = this.scheduler;
            TimeUnit timeUnit = this.unit;
            long l10 = h02.d(timeUnit);
            a a10 = this.queue;
            this.trim(l10, a10);
        }
        this.error = throwable;
        this.done = true;
        this.drain();
    }

    public void onNext(Object object) {
        a a10 = this.queue;
        h0 h02 = this.scheduler;
        TimeUnit timeUnit = this.unit;
        long l10 = h02.d(timeUnit);
        Long l11 = l10;
        a10.offer(l11, object);
        this.trim(l10, a10);
    }

    public void onSubscribe(e e10) {
        Object object = this.upstream;
        boolean bl2 = SubscriptionHelper.validate((e)object, e10);
        if (bl2) {
            this.upstream = e10;
            object = this.downstream;
            object.onSubscribe(this);
            long l10 = Long.MAX_VALUE;
            e10.request(l10);
        }
    }

    public void request(long l10) {
        boolean bl2 = SubscriptionHelper.validate(l10);
        if (bl2) {
            AtomicLong atomicLong = this.requested;
            b.a(atomicLong, l10);
            this.drain();
        }
    }

    public void trim(long l10, a a10) {
        long l11;
        long l12;
        Long l13;
        long l14;
        long l15;
        int n10;
        long l16 = this.time;
        long l17 = this.count;
        long l18 = Long.MAX_VALUE;
        long l19 = l17 == l18 ? 0 : (l17 < l18 ? -1 : 1);
        int n11 = 1;
        l19 = l19 == false ? (long)n11 : (long)0;
        while ((n10 = a10.isEmpty()) == 0 && ((n10 = (l15 = (l14 = (l13 = (Long)a10.peek()).longValue()) - (l12 = l10 - l16)) == 0L ? 0 : (l15 < 0L ? -1 : 1)) < 0 || l19 == false && (n10 = (int)((l11 = (l14 = (long)(a10.m() >> n11)) - l17) == 0L ? 0 : (l11 < 0L ? -1 : 1))) > 0)) {
            a10.poll();
            a10.poll();
        }
    }
}

