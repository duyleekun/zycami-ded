/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.a1.a;
import e.a.o;
import i.g.b;
import i.g.d;
import i.g.e;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.processors.UnicastProcessor;
import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public final class FlowableWindow$WindowOverlapSubscriber
extends AtomicInteger
implements o,
e,
Runnable {
    private static final long serialVersionUID = 2428527070996323976L;
    public final int bufferSize;
    public volatile boolean cancelled;
    public volatile boolean done;
    public final d downstream;
    public Throwable error;
    public final AtomicBoolean firstRequest;
    public long index;
    public final AtomicBoolean once;
    public long produced;
    public final e.a.w0.f.a queue;
    public final AtomicLong requested;
    public final long size;
    public final long skip;
    public e upstream;
    public final ArrayDeque windows;
    public final AtomicInteger wip;

    public FlowableWindow$WindowOverlapSubscriber(d serializable, long l10, long l11, int n10) {
        super(1);
        this.downstream = serializable;
        this.size = l10;
        this.skip = l11;
        serializable = new Serializable(n10);
        this.queue = serializable;
        this.windows = serializable = new Serializable();
        super();
        this.once = serializable;
        super();
        this.firstRequest = serializable;
        super();
        this.requested = serializable;
        super();
        this.wip = serializable;
        this.bufferSize = n10;
    }

    public void cancel() {
        boolean bl2;
        this.cancelled = bl2 = true;
        AtomicBoolean atomicBoolean = this.once;
        if (bl2 = atomicBoolean.compareAndSet(false, bl2)) {
            this.run();
        }
    }

    public boolean checkTerminated(boolean bl2, boolean bl3, d d10, e.a.w0.f.a a10) {
        boolean bl4 = this.cancelled;
        boolean bl5 = true;
        if (bl4) {
            a10.clear();
            return bl5;
        }
        if (bl2) {
            Throwable throwable = this.error;
            if (throwable != null) {
                a10.clear();
                d10.onError(throwable);
                return bl5;
            }
            if (bl3) {
                d10.onComplete();
                return bl5;
            }
        }
        return false;
    }

    public void drain() {
        Number number;
        int n10;
        Object object = this.wip;
        int n11 = ((AtomicInteger)object).getAndIncrement();
        if (n11 != 0) {
            return;
        }
        object = this.downstream;
        e.a.w0.f.a a10 = this.queue;
        int n12 = n10 = 1;
        do {
            long l10;
            long l11;
            long l12;
            boolean bl2;
            long l13;
            long l14;
            number = this.requested;
            long l15 = ((AtomicLong)number).get();
            long l16 = l14 = 0L;
            while ((l13 = l16 == l15 ? 0 : (l16 < l15 ? -1 : 1)) != false) {
                bl2 = this.done;
                UnicastProcessor unicastProcessor = (UnicastProcessor)a10.poll();
                int n13 = unicastProcessor == null ? n10 : 0;
                if (bl2 = this.checkTerminated(bl2, n13 != 0, (d)object, a10)) {
                    return;
                }
                if (n13 != 0) break;
                object.onNext(unicastProcessor);
                long l17 = 1L;
                l16 += l17;
            }
            if (l13 == false) {
                l13 = (long)this.done;
                bl2 = a10.isEmpty();
                if ((l13 = (long)this.checkTerminated((boolean)l13, bl2, (d)object, a10)) != false) {
                    return;
                }
            }
            if ((l12 = l16 == l14 ? 0 : (l16 < l14 ? -1 : 1)) != false && (l11 = (l10 = l15 - (l14 = Long.MAX_VALUE)) == 0L ? 0 : (l10 < 0L ? -1 : 1)) != false) {
                number = this.requested;
                long l18 = -l16;
                ((AtomicLong)number).addAndGet(l18);
            }
            number = this.wip;
            n12 = -n12;
        } while ((n12 = ((AtomicInteger)number).addAndGet(n12)) != 0);
    }

    public void onComplete() {
        boolean bl2;
        boolean bl3 = this.done;
        if (bl3) {
            return;
        }
        Iterator iterator2 = this.windows.iterator();
        while (bl2 = iterator2.hasNext()) {
            b b10 = (b)iterator2.next();
            b10.onComplete();
        }
        this.windows.clear();
        this.done = true;
        this.drain();
    }

    public void onError(Throwable throwable) {
        boolean bl2;
        boolean bl3 = this.done;
        if (bl3) {
            a.Y(throwable);
            return;
        }
        Iterator iterator2 = this.windows.iterator();
        while (bl2 = iterator2.hasNext()) {
            b b10 = (b)iterator2.next();
            b10.onError(throwable);
        }
        this.windows.clear();
        this.error = throwable;
        this.done = true;
        this.drain();
    }

    public void onNext(Object object) {
        long l10;
        boolean bl2;
        boolean bl3 = this.done;
        if (bl3) {
            return;
        }
        long l11 = this.index;
        long l12 = 0L;
        long l13 = l11 - l12;
        Object object2 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object2 == false && (object2 = (Object)this.cancelled) == false) {
            this.getAndIncrement();
            object2 = this.bufferSize;
            UnicastProcessor unicastProcessor = UnicastProcessor.S8((int)object2, this);
            this.windows.offer(unicastProcessor);
            e.a.w0.f.a a10 = this.queue;
            a10.offer(unicastProcessor);
            this.drain();
        }
        long l14 = 1L;
        l11 += l14;
        Iterator iterator2 = this.windows.iterator();
        while (bl2 = iterator2.hasNext()) {
            b b10 = (b)iterator2.next();
            b10.onNext(object);
        }
        long l15 = this.produced + l14;
        long l16 = l15 - (l14 = this.size);
        Object object3 = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
        if (object3 == false) {
            l14 = this.skip;
            this.produced = l15 -= l14;
            object = (b)this.windows.poll();
            if (object != null) {
                object.onComplete();
            }
        } else {
            this.produced = l15;
        }
        this.index = (object3 = (l10 = l11 - (l14 = this.skip)) == 0L ? 0 : (l10 < 0L ? -1 : 1)) == false ? l12 : l11;
    }

    public void onSubscribe(e object) {
        e e10 = this.upstream;
        boolean bl2 = SubscriptionHelper.validate(e10, (e)object);
        if (bl2) {
            this.upstream = object;
            object = this.downstream;
            object.onSubscribe(this);
        }
    }

    public void request(long l10) {
        boolean bl2 = SubscriptionHelper.validate(l10);
        if (bl2) {
            boolean bl3;
            e.a.w0.i.b.a(this.requested, l10);
            Object object = this.firstRequest;
            bl2 = ((AtomicBoolean)object).get();
            if (!bl2 && (bl2 = ((AtomicBoolean)(object = this.firstRequest)).compareAndSet(false, bl3 = true))) {
                long l11 = this.skip;
                long l12 = 1L;
                l10 -= l12;
                l10 = e.a.w0.i.b.d(l11, l10);
                l11 = this.size;
                l10 = e.a.w0.i.b.c(l11, l10);
                object = this.upstream;
                object.request(l10);
            } else {
                long l13 = this.skip;
                l10 = e.a.w0.i.b.d(l13, l10);
                object = this.upstream;
                object.request(l10);
            }
            this.drain();
        }
    }

    public void run() {
        int n10 = this.decrementAndGet();
        if (n10 == 0) {
            e e10 = this.upstream;
            e10.cancel();
        }
    }
}

