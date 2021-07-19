/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.a1.a;
import e.a.h0$c;
import e.a.w0.c.o;
import e.a.w0.i.b;
import i.g.d;
import i.g.e;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;

public abstract class FlowableObserveOn$BaseObserveOnSubscriber
extends BasicIntQueueSubscription
implements e.a.o,
Runnable {
    private static final long serialVersionUID = -8241002408341274697L;
    public volatile boolean cancelled;
    public final boolean delayError;
    public volatile boolean done;
    public Throwable error;
    public final int limit;
    public boolean outputFused;
    public final int prefetch;
    public long produced;
    public o queue;
    public final AtomicLong requested;
    public int sourceMode;
    public e upstream;
    public final h0$c worker;

    public FlowableObserveOn$BaseObserveOnSubscriber(h0$c object, boolean bl2, int n10) {
        this.worker = object;
        this.delayError = bl2;
        this.prefetch = n10;
        this.requested = object = new AtomicLong();
        int n11 = n10 >> 2;
        this.limit = n10 -= n11;
    }

    public final void cancel() {
        int n10 = this.cancelled;
        if (n10 != 0) {
            return;
        }
        this.cancelled = true;
        this.upstream.cancel();
        Object object = this.worker;
        object.dispose();
        n10 = this.outputFused;
        if (n10 == 0 && (n10 = this.getAndIncrement()) == 0) {
            object = this.queue;
            object.clear();
        }
    }

    public final boolean checkTerminated(boolean bl2, boolean bl3, d d10) {
        boolean bl4 = this.cancelled;
        boolean bl5 = true;
        if (bl4) {
            this.clear();
            return bl5;
        }
        if (bl2) {
            bl2 = this.delayError;
            if (bl2) {
                if (bl3) {
                    this.cancelled = bl5;
                    Throwable throwable = this.error;
                    if (throwable != null) {
                        d10.onError(throwable);
                    } else {
                        d10.onComplete();
                    }
                    this.worker.dispose();
                    return bl5;
                }
            } else {
                Throwable throwable = this.error;
                if (throwable != null) {
                    this.cancelled = bl5;
                    this.clear();
                    d10.onError(throwable);
                    this.worker.dispose();
                    return bl5;
                }
                if (bl3) {
                    this.cancelled = bl5;
                    d10.onComplete();
                    this.worker.dispose();
                    return bl5;
                }
            }
        }
        return false;
    }

    public final void clear() {
        this.queue.clear();
    }

    public final boolean isEmpty() {
        return this.queue.isEmpty();
    }

    public final void onComplete() {
        boolean bl2 = this.done;
        if (!bl2) {
            this.done = bl2 = true;
            this.trySchedule();
        }
    }

    public final void onError(Throwable throwable) {
        boolean bl2 = this.done;
        if (bl2) {
            a.Y(throwable);
            return;
        }
        this.error = throwable;
        this.done = true;
        this.trySchedule();
    }

    public final void onNext(Object object) {
        int n10 = this.done;
        if (n10 != 0) {
            return;
        }
        n10 = this.sourceMode;
        int n11 = 2;
        if (n10 == n11) {
            this.trySchedule();
            return;
        }
        Object object2 = this.queue;
        boolean bl2 = object2.offer(object);
        if (!bl2) {
            this.upstream.cancel();
            object2 = "Queue is full?!";
            this.error = object = new MissingBackpressureException((String)object2);
            this.done = bl2 = true;
        }
        this.trySchedule();
    }

    public final void request(long l10) {
        boolean bl2 = SubscriptionHelper.validate(l10);
        if (bl2) {
            AtomicLong atomicLong = this.requested;
            b.a(atomicLong, l10);
            this.trySchedule();
        }
    }

    public final int requestFusion(int n10) {
        int n11 = 2;
        if ((n10 &= n11) != 0) {
            this.outputFused = true;
            return n11;
        }
        return 0;
    }

    public final void run() {
        int n10 = this.outputFused;
        if (n10 != 0) {
            this.runBackfused();
        } else {
            n10 = this.sourceMode;
            int n11 = 1;
            if (n10 == n11) {
                this.runSync();
            } else {
                this.runAsync();
            }
        }
    }

    public abstract void runAsync();

    public abstract void runBackfused();

    public abstract void runSync();

    public final void trySchedule() {
        int n10 = this.getAndIncrement();
        if (n10 != 0) {
            return;
        }
        this.worker.b(this);
    }
}

