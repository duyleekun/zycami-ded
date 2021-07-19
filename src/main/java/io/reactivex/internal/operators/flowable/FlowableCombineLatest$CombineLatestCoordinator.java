/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.a1.a;
import e.a.v0.o;
import e.a.w0.i.b;
import i.g.c;
import i.g.d;
import io.reactivex.internal.operators.flowable.FlowableCombineLatest$CombineLatestInnerSubscriber;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class FlowableCombineLatest$CombineLatestCoordinator
extends BasicIntQueueSubscription {
    private static final long serialVersionUID = -5082275438355852221L;
    public volatile boolean cancelled;
    public final o combiner;
    public int completedSources;
    public final boolean delayErrors;
    public volatile boolean done;
    public final d downstream;
    public final AtomicReference error;
    public final Object[] latest;
    public int nonEmptySources;
    public boolean outputFused;
    public final e.a.w0.f.a queue;
    public final AtomicLong requested;
    public final FlowableCombineLatest$CombineLatestInnerSubscriber[] subscribers;

    public FlowableCombineLatest$CombineLatestCoordinator(d object, o o10, int n10, int n11, boolean bl2) {
        this.downstream = object;
        this.combiner = o10;
        object = new FlowableCombineLatest$CombineLatestInnerSubscriber[n10];
        o10 = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            FlowableCombineLatest$CombineLatestInnerSubscriber flowableCombineLatest$CombineLatestInnerSubscriber = new FlowableCombineLatest$CombineLatestInnerSubscriber(this, i10, n11);
            object[i10] = flowableCombineLatest$CombineLatestInnerSubscriber;
        }
        this.subscribers = object;
        object = new Object[n10];
        this.latest = object;
        super(n11);
        this.queue = object;
        super();
        this.requested = object;
        super();
        this.error = object;
        this.delayErrors = bl2;
    }

    public void cancel() {
        this.cancelled = true;
        this.cancelAll();
    }

    public void cancelAll() {
        for (FlowableCombineLatest$CombineLatestInnerSubscriber flowableCombineLatest$CombineLatestInnerSubscriber : this.subscribers) {
            flowableCombineLatest$CombineLatestInnerSubscriber.cancel();
        }
    }

    public boolean checkTerminated(boolean bl2, boolean bl3, d d10, e.a.w0.f.a a10) {
        boolean bl4 = this.cancelled;
        boolean bl5 = true;
        if (bl4) {
            this.cancelAll();
            a10.clear();
            return bl5;
        }
        if (bl2) {
            bl2 = this.delayErrors;
            if (bl2) {
                if (bl3) {
                    Throwable throwable;
                    this.cancelAll();
                    Throwable throwable2 = ExceptionHelper.c(this.error);
                    if (throwable2 != null && throwable2 != (throwable = ExceptionHelper.a)) {
                        d10.onError(throwable2);
                    } else {
                        d10.onComplete();
                    }
                    return bl5;
                }
            } else {
                Throwable throwable;
                Throwable throwable3 = ExceptionHelper.c(this.error);
                if (throwable3 != null && throwable3 != (throwable = ExceptionHelper.a)) {
                    this.cancelAll();
                    a10.clear();
                    d10.onError(throwable3);
                    return bl5;
                }
                if (bl3) {
                    this.cancelAll();
                    d10.onComplete();
                    return bl5;
                }
            }
        }
        return false;
    }

    public void clear() {
        this.queue.clear();
    }

    public void drain() {
        int n10 = this.getAndIncrement();
        if (n10 != 0) {
            return;
        }
        n10 = (int)(this.outputFused ? 1 : 0);
        if (n10 != 0) {
            this.drainOutput();
        } else {
            this.drainAsync();
        }
    }

    public void drainAsync() {
        boolean bl2;
        d d10 = this.downstream;
        e.a.w0.f.a a10 = this.queue;
        boolean bl3 = bl2 = true;
        do {
            long l10;
            long l11;
            long l12;
            boolean bl4;
            long l13;
            long l14;
            AtomicLong atomicLong = this.requested;
            long l15 = atomicLong.get();
            long l16 = l14 = 0L;
            while ((l13 = l16 == l15 ? 0 : (l16 < l15 ? -1 : 1)) != false) {
                Object object;
                bl4 = this.done;
                Object object2 = a10.poll();
                boolean bl5 = object2 == null ? bl2 : false;
                if (bl4 = this.checkTerminated(bl4, bl5, d10, a10)) {
                    return;
                }
                if (bl5) break;
                Object object3 = (Object[])a10.poll();
                try {
                    object = this.combiner;
                }
                catch (Throwable throwable) {
                    e.a.t0.a.b(throwable);
                    this.cancelAll();
                    ExceptionHelper.a(this.error, throwable);
                    Throwable throwable2 = ExceptionHelper.c(this.error);
                    d10.onError(throwable2);
                    return;
                }
                object3 = object.apply(object3);
                object = "The combiner returned a null value";
                object3 = e.a.w0.b.a.g(object3, (String)object);
                d10.onNext(object3);
                object2 = (FlowableCombineLatest$CombineLatestInnerSubscriber)object2;
                ((FlowableCombineLatest$CombineLatestInnerSubscriber)object2).requestOne();
                long l17 = 1L;
                l16 += l17;
            }
            if (l13 == false) {
                l13 = (long)this.done;
                bl4 = a10.isEmpty();
                if ((l13 = (long)this.checkTerminated((boolean)l13, bl4, d10, a10)) != false) {
                    return;
                }
            }
            if ((l12 = l16 == l14 ? 0 : (l16 < l14 ? -1 : 1)) != false && (l11 = (l10 = l15 - (l14 = Long.MAX_VALUE)) == 0L ? 0 : (l10 < 0L ? -1 : 1)) != false) {
                atomicLong = this.requested;
                long l18 = -l16;
                atomicLong.addAndGet(l18);
            }
            bl3 = -bl3;
        } while (bl3 = this.addAndGet((int)(bl3 ? 1 : 0)));
    }

    public void drainOutput() {
        d d10 = this.downstream;
        e.a.w0.f.a a10 = this.queue;
        int n10 = 1;
        do {
            boolean bl2;
            if (bl2 = this.cancelled) {
                a10.clear();
                return;
            }
            Throwable throwable = (Throwable)this.error.get();
            if (throwable != null) {
                a10.clear();
                d10.onError(throwable);
                return;
            }
            bl2 = this.done;
            boolean bl3 = a10.isEmpty();
            if (!bl3) {
                d10.onNext(null);
            }
            if (bl2 && bl3) {
                d10.onComplete();
                return;
            }
            n10 = -n10;
        } while ((n10 = this.addAndGet(n10)) != 0);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void innerComplete(int n10) {
        synchronized (this) {
            Object[] objectArray = this.latest;
            Object object = objectArray[n10];
            int n11 = 1;
            if (object != null) {
                n10 = this.completedSources + n11;
                int n12 = objectArray.length;
                if (n10 != n12) {
                    this.completedSources = n10;
                    return;
                }
                this.done = n11;
            } else {
                this.done = n11;
            }
        }
        this.drain();
    }

    public void innerError(int n10, Throwable throwable) {
        AtomicReference atomicReference = this.error;
        boolean bl2 = ExceptionHelper.a(atomicReference, throwable);
        if (bl2) {
            boolean bl3 = this.delayErrors;
            if (!bl3) {
                this.cancelAll();
                n10 = 1;
                this.done = n10;
                this.drain();
            } else {
                this.innerComplete(n10);
            }
        } else {
            a.Y(throwable);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void innerValue(int n10, Object object) {
        // MONITORENTER : this
        Object object2 = this.latest;
        int n11 = this.nonEmptySources;
        Object object3 = object2[n10];
        if (object3 == null) {
            this.nonEmptySources = ++n11;
        }
        object2[n10] = object;
        int n12 = ((Object[])object2).length;
        if (n12 == n11) {
            object = this.queue;
            Object object4 = this.subscribers;
            object4 = object4[n10];
            object2 = object2.clone();
            ((e.a.w0.f.a)object).offer(object4, object2);
            n12 = 0;
            object = null;
        } else {
            n12 = 1;
        }
        // MONITOREXIT : this
        if (n12 != 0) {
            object = this.subscribers;
            Object object5 = object[n10];
            ((FlowableCombineLatest$CombineLatestInnerSubscriber)object5).requestOne();
            return;
        }
        this.drain();
    }

    public boolean isEmpty() {
        return this.queue.isEmpty();
    }

    public Object poll() {
        Object object = this.queue.poll();
        if (object == null) {
            return null;
        }
        Object object2 = (Object[])this.queue.poll();
        object2 = e.a.w0.b.a.g(this.combiner.apply(object2), "The combiner returned a null value");
        ((FlowableCombineLatest$CombineLatestInnerSubscriber)object).requestOne();
        return object2;
    }

    public void request(long l10) {
        boolean bl2 = SubscriptionHelper.validate(l10);
        if (bl2) {
            AtomicLong atomicLong = this.requested;
            b.a(atomicLong, l10);
            this.drain();
        }
    }

    public int requestFusion(int n10) {
        int n11 = n10 & 4;
        boolean bl2 = false;
        if (n11 != 0) {
            return 0;
        }
        if ((n10 &= 2) != 0) {
            bl2 = true;
        }
        this.outputFused = bl2;
        return n10;
    }

    public void subscribe(c[] cArray, int n10) {
        boolean bl2;
        FlowableCombineLatest$CombineLatestInnerSubscriber[] flowableCombineLatest$CombineLatestInnerSubscriberArray = this.subscribers;
        for (int i10 = 0; i10 < n10 && !(bl2 = this.done) && !(bl2 = this.cancelled); ++i10) {
            c c10 = cArray[i10];
            FlowableCombineLatest$CombineLatestInnerSubscriber flowableCombineLatest$CombineLatestInnerSubscriber = flowableCombineLatest$CombineLatestInnerSubscriberArray[i10];
            c10.subscribe(flowableCombineLatest$CombineLatestInnerSubscriber);
        }
    }
}

