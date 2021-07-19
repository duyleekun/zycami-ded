/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.parallel;

import e.a.a1.a;
import e.a.h0$c;
import e.a.o;
import e.a.w0.i.b;
import i.g.e;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public abstract class ParallelRunOn$BaseRunOnSubscriber
extends AtomicInteger
implements o,
e,
Runnable {
    private static final long serialVersionUID = 9222303586456402150L;
    public volatile boolean cancelled;
    public int consumed;
    public volatile boolean done;
    public Throwable error;
    public final int limit;
    public final int prefetch;
    public final SpscArrayQueue queue;
    public final AtomicLong requested;
    public e upstream;
    public final h0$c worker;

    public ParallelRunOn$BaseRunOnSubscriber(int n10, SpscArrayQueue spscArrayQueue, h0$c h0$c) {
        AtomicLong atomicLong;
        this.requested = atomicLong = new AtomicLong();
        this.prefetch = n10;
        this.queue = spscArrayQueue;
        int n11 = n10 >> 2;
        this.limit = n10 -= n11;
        this.worker = h0$c;
    }

    public final void cancel() {
        int n10 = this.cancelled;
        if (n10 == 0) {
            this.cancelled = true;
            this.upstream.cancel();
            Object object = this.worker;
            object.dispose();
            n10 = this.getAndIncrement();
            if (n10 == 0) {
                object = this.queue;
                ((SpscArrayQueue)object).clear();
            }
        }
    }

    public final void onComplete() {
        boolean bl2 = this.done;
        if (bl2) {
            return;
        }
        this.done = true;
        this.schedule();
    }

    public final void onError(Throwable throwable) {
        boolean bl2 = this.done;
        if (bl2) {
            a.Y(throwable);
            return;
        }
        this.error = throwable;
        this.done = true;
        this.schedule();
    }

    public final void onNext(Object object) {
        boolean bl2 = this.done;
        if (bl2) {
            return;
        }
        SpscArrayQueue spscArrayQueue = this.queue;
        boolean bl3 = spscArrayQueue.offer(object);
        if (!bl3) {
            this.upstream.cancel();
            object = new MissingBackpressureException("Queue is full?!");
            this.onError((Throwable)object);
            return;
        }
        this.schedule();
    }

    public final void request(long l10) {
        boolean bl2 = SubscriptionHelper.validate(l10);
        if (bl2) {
            AtomicLong atomicLong = this.requested;
            b.a(atomicLong, l10);
            this.schedule();
        }
    }

    public final void schedule() {
        int n10 = this.getAndIncrement();
        if (n10 == 0) {
            h0$c h0$c = this.worker;
            h0$c.b(this);
        }
    }
}

