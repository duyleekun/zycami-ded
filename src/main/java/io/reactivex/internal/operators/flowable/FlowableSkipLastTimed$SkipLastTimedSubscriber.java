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

public final class FlowableSkipLastTimed$SkipLastTimedSubscriber
extends AtomicInteger
implements o,
e {
    private static final long serialVersionUID = -5677354903406201275L;
    public volatile boolean cancelled;
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

    public FlowableSkipLastTimed$SkipLastTimedSubscriber(d object, long l10, TimeUnit timeUnit, h0 h02, int n10, boolean bl2) {
        AtomicLong atomicLong;
        this.requested = atomicLong = new AtomicLong();
        this.downstream = object;
        this.time = l10;
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

    public boolean checkTerminated(boolean bl2, boolean bl3, d d10, boolean bl4) {
        boolean bl5 = this.cancelled;
        boolean bl6 = true;
        if (bl5) {
            this.queue.clear();
            return bl6;
        }
        if (bl2) {
            if (bl4) {
                if (bl3) {
                    Throwable throwable = this.error;
                    if (throwable != null) {
                        d10.onError(throwable);
                    } else {
                        d10.onComplete();
                    }
                    return bl6;
                }
            } else {
                Throwable throwable = this.error;
                if (throwable != null) {
                    this.queue.clear();
                    d10.onError(throwable);
                    return bl6;
                }
                if (bl3) {
                    d10.onComplete();
                    return bl6;
                }
            }
        }
        return false;
    }

    public void drain() {
        boolean bl2;
        FlowableSkipLastTimed$SkipLastTimedSubscriber flowableSkipLastTimed$SkipLastTimedSubscriber = this;
        int n10 = this.getAndIncrement();
        if (n10 != 0) {
            return;
        }
        d d10 = this.downstream;
        a a10 = this.queue;
        boolean bl3 = this.delayError;
        TimeUnit timeUnit = this.unit;
        h0 h02 = this.scheduler;
        long l10 = this.time;
        int n11 = 1;
        do {
            long l11;
            Object object;
            long l12;
            AtomicLong atomicLong = flowableSkipLastTimed$SkipLastTimedSubscriber.requested;
            long l13 = atomicLong.get();
            long l14 = 0L;
            while ((l12 = l14 == l13 ? 0 : (l14 < l13 ? -1 : 1)) != false) {
                long l15;
                long l16;
                long l17;
                bl2 = flowableSkipLastTimed$SkipLastTimedSubscriber.done;
                Long l18 = (Long)a10.peek();
                boolean bl4 = l18 == null;
                long l19 = h02.d(timeUnit);
                boolean bl5 = !bl4 && (l17 = (l16 = (l15 = l18.longValue()) - (l19 -= l10)) == 0L ? 0 : (l16 < 0L ? -1 : 1)) > 0 ? true : bl4;
                if (bl2 = flowableSkipLastTimed$SkipLastTimedSubscriber.checkTerminated(bl2, bl5, d10, bl3)) {
                    return;
                }
                if (bl5) break;
                a10.poll();
                object = a10.poll();
                d10.onNext(object);
                long l20 = 1L;
                l14 += l20;
            }
            if (!(bl2 = (l11 = l14 - (l13 = 0L)) == 0L ? 0 : (l11 < 0L ? -1 : 1))) continue;
            object = flowableSkipLastTimed$SkipLastTimedSubscriber.requested;
            b.e((AtomicLong)object, l14);
        } while ((n11 = flowableSkipLastTimed$SkipLastTimedSubscriber.addAndGet((int)((bl2 = -n11) ? 1 : 0))) != 0);
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
        Object object2 = this.scheduler;
        TimeUnit timeUnit = this.unit;
        long l10 = ((h0)object2).d(timeUnit);
        a a10 = this.queue;
        object2 = l10;
        a10.offer(object2, object);
        this.drain();
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
}

