/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.w0.f.a;
import e.a.w0.i.b;
import i.g.c;
import i.g.d;
import i.g.e;
import io.reactivex.internal.operators.flowable.FlowableGroupBy$GroupBySubscriber;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class FlowableGroupBy$State
extends BasicIntQueueSubscription
implements c {
    private static final long serialVersionUID = -3852313036005250360L;
    public final AtomicReference actual;
    public final AtomicBoolean cancelled;
    public final boolean delayError;
    public volatile boolean done;
    public Throwable error;
    public final Object key;
    public final AtomicBoolean once;
    public boolean outputFused;
    public final FlowableGroupBy$GroupBySubscriber parent;
    public int produced;
    public final a queue;
    public final AtomicLong requested;

    public FlowableGroupBy$State(int n10, FlowableGroupBy$GroupBySubscriber flowableGroupBy$GroupBySubscriber, Object object, boolean bl2) {
        Object object2 = new AtomicLong();
        this.requested = object2;
        this.cancelled = object2;
        super();
        this.actual = object2;
        super();
        this.once = object2;
        this.queue = object2 = new a(n10);
        this.parent = flowableGroupBy$GroupBySubscriber;
        this.key = object;
        this.delayError = bl2;
    }

    public void cancel() {
        Serializable serializable = this.cancelled;
        Object object = null;
        boolean bl2 = true;
        boolean bl3 = ((AtomicBoolean)serializable).compareAndSet(false, bl2);
        if (bl3) {
            serializable = this.parent;
            object = this.key;
            ((FlowableGroupBy$GroupBySubscriber)serializable).cancel(object);
            this.drain();
        }
    }

    public boolean checkTerminated(boolean object, boolean bl2, d d10, boolean bl3, long l10) {
        AtomicBoolean atomicBoolean = this.cancelled;
        boolean bl4 = atomicBoolean.get();
        boolean bl5 = true;
        if (bl4) {
            long l11;
            Object object2;
            while ((object2 = this.queue.poll()) != null) {
                l11 = 1L;
                l10 += l11;
            }
            l11 = 0L;
            long l12 = l10 - l11;
            object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object) {
                object2 = this.parent.upstream;
                object2.request(l10);
            }
            return bl5;
        }
        if (object) {
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
        }
        return false;
    }

    public void clear() {
        Object object;
        a a10 = this.queue;
        while ((object = a10.poll()) != null) {
            int n10;
            this.produced = n10 = this.produced + 1;
        }
        this.tryReplenish();
    }

    public void drain() {
        int n10 = this.getAndIncrement();
        if (n10 != 0) {
            return;
        }
        n10 = (int)(this.outputFused ? 1 : 0);
        if (n10 != 0) {
            this.drainFused();
        } else {
            this.drainNormal();
        }
    }

    public void drainFused() {
        Object object = this.queue;
        d d10 = (d)this.actual.get();
        int n10 = 1;
        while (true) {
            if (d10 != null) {
                Throwable throwable;
                boolean bl2;
                AtomicBoolean atomicBoolean = this.cancelled;
                boolean bl3 = atomicBoolean.get();
                if (bl3) {
                    return;
                }
                bl3 = this.done;
                if (bl3 && !(bl2 = this.delayError) && (throwable = this.error) != null) {
                    ((a)object).clear();
                    d10.onError(throwable);
                    return;
                }
                bl2 = false;
                throwable = null;
                d10.onNext(null);
                if (bl3) {
                    object = this.error;
                    if (object != null) {
                        d10.onError((Throwable)object);
                    } else {
                        d10.onComplete();
                    }
                    return;
                }
            }
            n10 = -n10;
            if ((n10 = this.addAndGet(n10)) == 0) {
                return;
            }
            if (d10 != null) continue;
            d10 = (d)this.actual.get();
        }
    }

    public void drainNormal() {
        Object object;
        FlowableGroupBy$State flowableGroupBy$State = this;
        a a10 = this.queue;
        boolean bl2 = this.delayError;
        Object object2 = object = (d)this.actual.get();
        int n10 = 1;
        while (true) {
            int n11;
            if (object2 != null) {
                long l10;
                boolean bl3;
                boolean bl4;
                long l11;
                long l12;
                object = flowableGroupBy$State.requested;
                long l13 = ((AtomicLong)object).get();
                long l14 = l12 = 0L;
                while ((l11 = l14 == l13 ? 0 : (l14 < l13 ? -1 : 1)) != false) {
                    boolean bl5;
                    bl4 = flowableGroupBy$State.done;
                    Object object3 = a10.poll();
                    if (object3 == null) {
                        bl5 = true;
                    } else {
                        n11 = 0;
                        object = null;
                        bl5 = false;
                    }
                    object = this;
                    bl3 = bl5;
                    n11 = (int)(this.checkTerminated(bl4, bl5, (d)object2, bl2, l14) ? 1 : 0);
                    if (n11 != 0) {
                        return;
                    }
                    if (bl5) break;
                    object2.onNext(object3);
                    l10 = 1L;
                    l14 += l10;
                }
                if (l11 == false) {
                    bl4 = flowableGroupBy$State.done;
                    bl3 = a10.isEmpty();
                    object = this;
                    n11 = (int)(this.checkTerminated(bl4, bl3, (d)object2, bl2, l14) ? 1 : 0);
                    if (n11 != 0) {
                        return;
                    }
                }
                if ((n11 = (int)(l14 == l12 ? 0 : (l14 < l12 ? -1 : 1))) != 0) {
                    l10 = Long.MAX_VALUE;
                    long l15 = l13 - l10;
                    n11 = (int)(l15 == 0L ? 0 : (l15 < 0L ? -1 : 1));
                    if (n11 != 0) {
                        object = flowableGroupBy$State.requested;
                        long l16 = -l14;
                        ((AtomicLong)object).addAndGet(l16);
                    }
                    object = flowableGroupBy$State.parent.upstream;
                    object.request(l14);
                }
            }
            if ((n10 = flowableGroupBy$State.addAndGet(n11 = -n10)) == 0) {
                return;
            }
            if (object2 != null) continue;
            object2 = object = flowableGroupBy$State.actual.get();
            object2 = (d)object;
        }
    }

    public boolean isEmpty() {
        a a10 = this.queue;
        boolean bl2 = a10.isEmpty();
        if (bl2) {
            this.tryReplenish();
            return true;
        }
        return false;
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
        this.queue.offer(object);
        this.drain();
    }

    public Object poll() {
        Object object = this.queue.poll();
        if (object != null) {
            int n10;
            this.produced = n10 = this.produced + 1;
            return object;
        }
        this.tryReplenish();
        return null;
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
        int n11 = 2;
        if ((n10 &= n11) != 0) {
            this.outputFused = true;
            return n11;
        }
        return 0;
    }

    public void subscribe(d d10) {
        Serializable serializable = this.once;
        String string2 = null;
        boolean bl2 = true;
        boolean bl3 = ((AtomicBoolean)serializable).compareAndSet(false, bl2);
        if (bl3) {
            d10.onSubscribe(this);
            serializable = this.actual;
            ((AtomicReference)serializable).lazySet(d10);
            this.drain();
        } else {
            string2 = "Only one Subscriber allowed!";
            serializable = new IllegalStateException(string2);
            EmptySubscription.error((Throwable)serializable, d10);
        }
    }

    public void tryReplenish() {
        int n10 = this.produced;
        if (n10 != 0) {
            this.produced = 0;
            e e10 = this.parent.upstream;
            long l10 = n10;
            e10.request(l10);
        }
    }
}

