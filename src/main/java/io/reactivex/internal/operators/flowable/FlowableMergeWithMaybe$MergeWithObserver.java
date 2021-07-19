/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.a1.a;
import e.a.j;
import e.a.o;
import e.a.w0.c.n;
import e.a.w0.i.b;
import i.g.d;
import i.g.e;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.flowable.FlowableMergeWithMaybe$MergeWithObserver$OtherObserver;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class FlowableMergeWithMaybe$MergeWithObserver
extends AtomicInteger
implements o,
e {
    public static final int OTHER_STATE_CONSUMED_OR_EMPTY = 2;
    public static final int OTHER_STATE_HAS_VALUE = 1;
    private static final long serialVersionUID = -4592979584110982903L;
    public volatile boolean cancelled;
    public int consumed;
    public final d downstream;
    public long emitted;
    public final AtomicThrowable error;
    public final int limit;
    public volatile boolean mainDone;
    public final AtomicReference mainSubscription;
    public final FlowableMergeWithMaybe$MergeWithObserver$OtherObserver otherObserver;
    public volatile int otherState;
    public final int prefetch;
    public volatile n queue;
    public final AtomicLong requested;
    public Object singleItem;

    public FlowableMergeWithMaybe$MergeWithObserver(d serializable) {
        int n10;
        this.downstream = serializable;
        this.mainSubscription = serializable = new AtomicReference();
        this.otherObserver = serializable = new FlowableMergeWithMaybe$MergeWithObserver$OtherObserver(this);
        this.error = serializable;
        super();
        this.requested = serializable;
        this.prefetch = n10 = j.f0();
        int n11 = n10 >> 2;
        this.limit = n10 -= n11;
    }

    public void cancel() {
        this.cancelled = true;
        SubscriptionHelper.cancel(this.mainSubscription);
        FlowableMergeWithMaybe$MergeWithObserver$OtherObserver flowableMergeWithMaybe$MergeWithObserver$OtherObserver = this.otherObserver;
        DisposableHelper.dispose(flowableMergeWithMaybe$MergeWithObserver$OtherObserver);
        int n10 = this.getAndIncrement();
        if (n10 == 0) {
            n10 = 0;
            flowableMergeWithMaybe$MergeWithObserver$OtherObserver = null;
            this.queue = null;
            this.singleItem = null;
        }
    }

    public void drain() {
        int n10 = this.getAndIncrement();
        if (n10 == 0) {
            this.drainLoop();
        }
    }

    public void drainLoop() {
        int n10;
        FlowableMergeWithMaybe$MergeWithObserver flowableMergeWithMaybe$MergeWithObserver = this;
        d d10 = this.downstream;
        long l10 = this.emitted;
        int n11 = this.consumed;
        int n12 = this.limit;
        int n13 = n10 = 1;
        while (true) {
            boolean bl2;
            Object object;
            int n14;
            long l11;
            Object object2 = flowableMergeWithMaybe$MergeWithObserver.requested;
            long l12 = ((AtomicLong)object2).get();
            while (true) {
                l11 = l10 == l12 ? 0 : (l10 < l12 ? -1 : 1);
                n14 = 2;
                if (l11 == false) break;
                int n15 = flowableMergeWithMaybe$MergeWithObserver.cancelled;
                if (n15 != 0) {
                    flowableMergeWithMaybe$MergeWithObserver.singleItem = null;
                    flowableMergeWithMaybe$MergeWithObserver.queue = null;
                    return;
                }
                Object v10 = flowableMergeWithMaybe$MergeWithObserver.error.get();
                if (v10 != null) {
                    flowableMergeWithMaybe$MergeWithObserver.singleItem = null;
                    flowableMergeWithMaybe$MergeWithObserver.queue = null;
                    Throwable throwable = flowableMergeWithMaybe$MergeWithObserver.error.terminate();
                    d10.onError(throwable);
                    return;
                }
                n15 = flowableMergeWithMaybe$MergeWithObserver.otherState;
                long l13 = 1L;
                if (n15 == n10) {
                    Object object3 = flowableMergeWithMaybe$MergeWithObserver.singleItem;
                    flowableMergeWithMaybe$MergeWithObserver.singleItem = null;
                    flowableMergeWithMaybe$MergeWithObserver.otherState = n14;
                    d10.onNext(object3);
                    l10 += l13;
                    continue;
                }
                n10 = (int)(flowableMergeWithMaybe$MergeWithObserver.mainDone ? 1 : 0);
                object = flowableMergeWithMaybe$MergeWithObserver.queue;
                if (object != null) {
                    object = object.poll();
                } else {
                    bl2 = false;
                    object = null;
                }
                boolean bl3 = object == null;
                if (n10 != 0 && bl3 && n15 == n14) {
                    flowableMergeWithMaybe$MergeWithObserver.queue = null;
                    d10.onComplete();
                    return;
                }
                if (bl3) break;
                d10.onNext(object);
                l10 += l13;
                if (++n11 == n12) {
                    e e10 = (e)flowableMergeWithMaybe$MergeWithObserver.mainSubscription.get();
                    long l14 = n12;
                    e10.request(l14);
                    n11 = 0;
                    e10 = null;
                }
                n10 = 1;
            }
            if (l11 == false) {
                boolean bl4;
                n10 = flowableMergeWithMaybe$MergeWithObserver.cancelled;
                if (n10 != 0) {
                    flowableMergeWithMaybe$MergeWithObserver.singleItem = null;
                    flowableMergeWithMaybe$MergeWithObserver.queue = null;
                    return;
                }
                Object v11 = flowableMergeWithMaybe$MergeWithObserver.error.get();
                if (v11 != null) {
                    flowableMergeWithMaybe$MergeWithObserver.singleItem = null;
                    flowableMergeWithMaybe$MergeWithObserver.queue = null;
                    Throwable throwable = flowableMergeWithMaybe$MergeWithObserver.error.terminate();
                    d10.onError(throwable);
                    return;
                }
                n10 = (int)(flowableMergeWithMaybe$MergeWithObserver.mainDone ? 1 : 0);
                object2 = flowableMergeWithMaybe$MergeWithObserver.queue;
                if (object2 != null && !(bl4 = object2.isEmpty())) {
                    bl2 = false;
                    object = null;
                } else {
                    bl2 = true;
                }
                if (n10 != 0 && bl2 && (n10 = flowableMergeWithMaybe$MergeWithObserver.otherState) == n14) {
                    flowableMergeWithMaybe$MergeWithObserver.queue = null;
                    d10.onComplete();
                    return;
                }
            }
            flowableMergeWithMaybe$MergeWithObserver.emitted = l10;
            flowableMergeWithMaybe$MergeWithObserver.consumed = n11;
            n10 = -n13;
            if ((n13 = flowableMergeWithMaybe$MergeWithObserver.addAndGet(n10)) == 0) {
                return;
            }
            n10 = 1;
        }
    }

    public n getOrCreateQueue() {
        n n10 = this.queue;
        if (n10 == null) {
            int n11 = j.f0();
            this.queue = n10 = new SpscArrayQueue(n11);
        }
        return n10;
    }

    public void onComplete() {
        this.mainDone = true;
        this.drain();
    }

    public void onError(Throwable serializable) {
        AtomicThrowable atomicThrowable = this.error;
        boolean bl2 = atomicThrowable.addThrowable((Throwable)serializable);
        if (bl2) {
            serializable = this.otherObserver;
            DisposableHelper.dispose((AtomicReference)serializable);
            this.drain();
        } else {
            a.Y(serializable);
        }
    }

    public void onNext(Object object) {
        Object object2 = null;
        int n10 = 1;
        boolean bl2 = this.compareAndSet(0, n10);
        if (bl2) {
            int n11;
            long l10 = this.emitted;
            Object object3 = this.requested;
            long l11 = ((AtomicLong)object3).get();
            long l12 = l11 - l10;
            Object object4 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object4 != false) {
                boolean bl3;
                object3 = this.queue;
                if (object3 != null && !(bl3 = object3.isEmpty())) {
                    object3.offer(object);
                } else {
                    l11 = 1L;
                    this.emitted = l10 += l11;
                    d d10 = this.downstream;
                    d10.onNext(object);
                    n11 = this.consumed + n10;
                    n10 = this.limit;
                    if (n11 == n10) {
                        this.consumed = 0;
                        object2 = (e)this.mainSubscription.get();
                        long l13 = n11;
                        object2.request(l13);
                    } else {
                        this.consumed = n11;
                    }
                }
            } else {
                object2 = this.getOrCreateQueue();
                object2.offer(object);
            }
            n11 = this.decrementAndGet();
            if (n11 == 0) {
                return;
            }
        } else {
            object2 = this.getOrCreateQueue();
            object2.offer(object);
            int n12 = this.getAndIncrement();
            if (n12 != 0) {
                return;
            }
        }
        this.drainLoop();
    }

    public void onSubscribe(e e10) {
        AtomicReference atomicReference = this.mainSubscription;
        long l10 = this.prefetch;
        SubscriptionHelper.setOnce(atomicReference, e10, l10);
    }

    public void otherComplete() {
        this.otherState = 2;
        this.drain();
    }

    public void otherError(Throwable serializable) {
        AtomicThrowable atomicThrowable = this.error;
        boolean bl2 = atomicThrowable.addThrowable((Throwable)serializable);
        if (bl2) {
            serializable = this.mainSubscription;
            SubscriptionHelper.cancel((AtomicReference)serializable);
            this.drain();
        } else {
            a.Y(serializable);
        }
    }

    public void otherSuccess(Object object) {
        Object object2 = null;
        int n10 = 1;
        Object object3 = this.compareAndSet(0, n10);
        if (object3) {
            long l10 = this.emitted;
            object2 = this.requested;
            long l11 = ((AtomicLong)object2).get();
            long l12 = l11 - l10;
            object3 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object3) {
                int n11;
                long l13 = 1L;
                this.emitted = l10 += l13;
                object2 = this.downstream;
                object2.onNext(object);
                this.otherState = n11 = 2;
            } else {
                this.singleItem = object;
                this.otherState = n10;
                int n12 = this.decrementAndGet();
                if (n12 == 0) {
                    return;
                }
            }
        } else {
            this.singleItem = object;
            this.otherState = n10;
            int n13 = this.getAndIncrement();
            if (n13 != 0) {
                return;
            }
        }
        this.drainLoop();
    }

    public void request(long l10) {
        b.a(this.requested, l10);
        this.drain();
    }
}

