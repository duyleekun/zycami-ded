/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.processors;

import e.a.w0.i.a;
import e.a.w0.i.a$a;
import e.a.w0.i.b;
import i.g.d;
import i.g.e;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.processors.BehaviorProcessor;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;

public final class BehaviorProcessor$BehaviorSubscription
extends AtomicLong
implements e,
a$a {
    private static final long serialVersionUID = 3293175281126227086L;
    public volatile boolean cancelled;
    public final d downstream;
    public boolean emitting;
    public boolean fastPath;
    public long index;
    public boolean next;
    public a queue;
    public final BehaviorProcessor state;

    public BehaviorProcessor$BehaviorSubscription(d d10, BehaviorProcessor behaviorProcessor) {
        this.downstream = d10;
        this.state = behaviorProcessor;
    }

    public void cancel() {
        boolean bl2 = this.cancelled;
        if (!bl2) {
            this.cancelled = bl2 = true;
            BehaviorProcessor behaviorProcessor = this.state;
            behaviorProcessor.X8(this);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void emitFirst() {
        long l10;
        boolean bl2 = this.cancelled;
        if (bl2) {
            return;
        }
        // MONITORENTER : this
        bl2 = this.cancelled;
        if (bl2) {
            // MONITOREXIT : this
            return;
        }
        bl2 = this.next;
        if (bl2) {
            // MONITOREXIT : this
            return;
        }
        Object object = this.state;
        Lock lock = ((BehaviorProcessor)object).d;
        lock.lock();
        this.index = l10 = ((BehaviorProcessor)object).h;
        object = ((BehaviorProcessor)object).f;
        object = ((AtomicReference)object).get();
        lock.unlock();
        boolean bl3 = true;
        boolean bl4 = object != null ? bl3 : false;
        this.emitting = bl4;
        this.next = bl3;
        // MONITOREXIT : this
        if (object == null) return;
        bl2 = this.test(object);
        if (bl2) {
            return;
        }
        this.emitLoop();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void emitLoop() {
        boolean bl2;
        while (!(bl2 = this.cancelled)) {
            a a10;
            synchronized (this) {
                a10 = this.queue;
                if (a10 == null) {
                    bl2 = false;
                    a10 = null;
                    this.emitting = false;
                    return;
                }
                this.queue = null;
            }
            a10.d(this);
        }
        return;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void emitNext(Object object, long l10) {
        boolean bl2 = this.cancelled;
        if (bl2) {
            return;
        }
        bl2 = this.fastPath;
        if (!bl2) {
            Object object2;
            synchronized (this) {
                bl2 = this.cancelled;
                if (bl2) {
                    return;
                }
                long l11 = this.index;
                long l12 = l11 - l10;
                object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
                if (object2 == false) {
                    return;
                }
                object2 = this.emitting;
                if (object2 != false) {
                    a a10 = this.queue;
                    if (a10 == null) {
                        int n10 = 4;
                        this.queue = a10 = new a(n10);
                    }
                    a10.c(object);
                    return;
                }
                object2 = 1;
                this.next = object2;
            }
            this.fastPath = object2;
        }
        this.test(object);
    }

    public boolean isFull() {
        long l10;
        long l11 = this.get();
        long l12 = l11 - (l10 = 0L);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        object = object == false ? (Object)1 : (Object)0;
        return (boolean)object;
    }

    public void request(long l10) {
        boolean bl2 = SubscriptionHelper.validate(l10);
        if (bl2) {
            b.a(this, l10);
        }
    }

    public boolean test(Object object) {
        long l10;
        Object object2 = this.cancelled;
        boolean bl2 = true;
        if (object2) {
            return bl2;
        }
        object2 = NotificationLite.isComplete(object);
        if (object2) {
            this.downstream.onComplete();
            return bl2;
        }
        object2 = NotificationLite.isError(object);
        if (object2) {
            d d10 = this.downstream;
            object = NotificationLite.getError(object);
            d10.onError((Throwable)object);
            return bl2;
        }
        long l11 = this.get();
        long l12 = l11 - (l10 = 0L);
        object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object2) {
            d d11 = this.downstream;
            object = NotificationLite.getValue(object);
            d11.onNext(object);
            long l13 = Long.MAX_VALUE;
            long l14 = l11 == l13 ? 0 : (l11 < l13 ? -1 : 1);
            if (l14 != false) {
                this.decrementAndGet();
            }
            return false;
        }
        this.cancel();
        object = this.downstream;
        MissingBackpressureException missingBackpressureException = new MissingBackpressureException("Could not deliver value due to lack of requests");
        object.onError(missingBackpressureException);
        return bl2;
    }
}

