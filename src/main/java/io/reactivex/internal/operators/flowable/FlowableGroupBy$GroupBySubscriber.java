/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.a1.a;
import e.a.v0.o;
import e.a.w0.i.b;
import i.g.d;
import i.g.e;
import io.reactivex.internal.operators.flowable.FlowableGroupBy$b;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.io.Serializable;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public final class FlowableGroupBy$GroupBySubscriber
extends BasicIntQueueSubscription
implements e.a.o {
    public static final Object NULL_KEY;
    private static final long serialVersionUID = -3688291656102519502L;
    public final int bufferSize;
    public final AtomicBoolean cancelled;
    public final boolean delayError;
    public boolean done;
    public final d downstream;
    public Throwable error;
    public final Queue evictedGroups;
    public volatile boolean finished;
    public final AtomicInteger groupCount;
    public final Map groups;
    public final o keySelector;
    public boolean outputFused;
    public final e.a.w0.f.a queue;
    public final AtomicLong requested;
    public e upstream;
    public final o valueSelector;

    static {
        Object object;
        NULL_KEY = object = new Object();
    }

    public FlowableGroupBy$GroupBySubscriber(d object, o o10, o o11, int n10, boolean bl2, Map map, Queue queue) {
        Serializable serializable;
        this.cancelled = serializable = new AtomicBoolean();
        this.requested = serializable;
        super(1);
        this.groupCount = serializable;
        this.downstream = object;
        this.keySelector = o10;
        this.valueSelector = o11;
        this.bufferSize = n10;
        this.delayError = bl2;
        this.groups = map;
        this.evictedGroups = queue;
        this.queue = object = new e.a.w0.f.a(n10);
    }

    private void a() {
        Queue queue = this.evictedGroups;
        if (queue != null) {
            Object object;
            int n10 = 0;
            queue = null;
            while ((object = (FlowableGroupBy$b)this.evictedGroups.poll()) != null) {
                ((FlowableGroupBy$b)object).onComplete();
                ++n10;
            }
            if (n10 != 0) {
                object = this.groupCount;
                n10 = -n10;
                ((AtomicInteger)object).addAndGet(n10);
            }
        }
    }

    public void cancel() {
        Object object = this.cancelled;
        boolean bl2 = true;
        boolean n10 = ((AtomicBoolean)object).compareAndSet(false, bl2);
        if (n10) {
            this.a();
            object = this.groupCount;
            int n11 = ((AtomicInteger)object).decrementAndGet();
            if (n11 == 0) {
                object = this.upstream;
                object.cancel();
            }
        }
    }

    public void cancel(Object object) {
        if (object == null) {
            object = NULL_KEY;
        }
        Map map = this.groups;
        map.remove(object);
        object = this.groupCount;
        int n10 = ((AtomicInteger)object).decrementAndGet();
        if (n10 == 0) {
            object = this.upstream;
            object.cancel();
            n10 = (int)(this.outputFused ? 1 : 0);
            if (n10 == 0 && (n10 = this.getAndIncrement()) == 0) {
                object = this.queue;
                ((e.a.w0.f.a)object).clear();
            }
        }
    }

    public boolean checkTerminated(boolean bl2, boolean bl3, d d10, e.a.w0.f.a a10) {
        AtomicBoolean atomicBoolean = this.cancelled;
        boolean bl4 = atomicBoolean.get();
        boolean bl5 = true;
        if (bl4) {
            a10.clear();
            return bl5;
        }
        bl4 = this.delayError;
        if (bl4) {
            if (bl2 && bl3) {
                Throwable throwable = this.error;
                if (throwable != null) {
                    d10.onError(throwable);
                } else {
                    d10.onComplete();
                }
                return bl5;
            }
        } else if (bl2) {
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
            this.drainFused();
        } else {
            this.drainNormal();
        }
    }

    public void drainFused() {
        Object object = this.queue;
        d d10 = this.downstream;
        int n10 = 1;
        do {
            Throwable throwable;
            boolean bl2;
            AtomicBoolean atomicBoolean;
            boolean bl3;
            if (bl3 = (atomicBoolean = this.cancelled).get()) {
                return;
            }
            bl3 = this.finished;
            if (bl3 && !(bl2 = this.delayError) && (throwable = this.error) != null) {
                ((e.a.w0.f.a)object).clear();
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
            n10 = -n10;
        } while ((n10 = this.addAndGet(n10)) != 0);
    }

    public void drainNormal() {
        boolean bl2;
        e.a.w0.f.a a10 = this.queue;
        d d10 = this.downstream;
        boolean bl3 = bl2 = true;
        do {
            long l10;
            boolean bl4;
            long l11;
            long l12;
            Object object = this.requested;
            long l13 = ((AtomicLong)object).get();
            long l14 = l12 = 0L;
            while ((l11 = l14 == l13 ? 0 : (l14 < l13 ? -1 : 1)) != false) {
                bl4 = this.finished;
                e.a.u0.b b10 = (e.a.u0.b)a10.poll();
                boolean bl5 = b10 == null ? bl2 : false;
                if (bl4 = this.checkTerminated(bl4, bl5, d10, a10)) {
                    return;
                }
                if (bl5) break;
                d10.onNext(b10);
                long l15 = 1L;
                l14 += l15;
            }
            if (l11 == false) {
                l11 = (long)this.finished;
                bl4 = a10.isEmpty();
                if ((l11 = (long)this.checkTerminated((boolean)l11, bl4, d10, a10)) != false) {
                    return;
                }
            }
            if ((l10 = l14 == l12 ? 0 : (l14 < l12 ? -1 : 1)) != false) {
                l12 = Long.MAX_VALUE;
                long l16 = l13 - l12;
                Object object2 = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
                if (object2 != false) {
                    object = this.requested;
                    long l17 = -l14;
                    ((AtomicLong)object).addAndGet(l17);
                }
                object = this.upstream;
                object.request(l14);
            }
            bl3 = -bl3;
        } while (bl3 = this.addAndGet((int)(bl3 ? 1 : 0)));
    }

    public boolean isEmpty() {
        return this.queue.isEmpty();
    }

    public void onComplete() {
        boolean bl2 = this.done;
        if (!bl2) {
            boolean bl3;
            Object object = this.groups.values().iterator();
            while (bl3 = object.hasNext()) {
                FlowableGroupBy$b flowableGroupBy$b = (FlowableGroupBy$b)object.next();
                flowableGroupBy$b.onComplete();
            }
            this.groups.clear();
            object = this.evictedGroups;
            if (object != null) {
                object.clear();
            }
            this.done = bl2 = true;
            this.finished = bl2;
            this.drain();
        }
    }

    public void onError(Throwable throwable) {
        boolean bl2;
        boolean bl3 = this.done;
        if (bl3) {
            a.Y(throwable);
            return;
        }
        this.done = bl3 = true;
        Object object = this.groups.values().iterator();
        while (bl2 = object.hasNext()) {
            FlowableGroupBy$b flowableGroupBy$b = (FlowableGroupBy$b)object.next();
            flowableGroupBy$b.onError(throwable);
        }
        this.groups.clear();
        object = this.evictedGroups;
        if (object != null) {
            object.clear();
        }
        this.error = throwable;
        this.finished = bl3;
        this.drain();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onNext(Object object) {
        block7: {
            Object object3;
            AtomicBoolean atomicBoolean;
            int n10;
            Object object2;
            boolean bl2 = this.done;
            if (bl2) {
                return;
            }
            e.a.w0.f.a a10 = this.queue;
            try {
                object2 = this.keySelector;
                object2 = object2.apply(object);
                n10 = 0;
                atomicBoolean = null;
                object3 = object2 != null ? object2 : NULL_KEY;
            }
            catch (Throwable throwable) {
                e.a.t0.a.b(throwable);
                this.upstream.cancel();
                this.onError(throwable);
                return;
            }
            FlowableGroupBy$b flowableGroupBy$b = (FlowableGroupBy$b)this.groups.get(object3);
            if (flowableGroupBy$b == null) {
                atomicBoolean = this.cancelled;
                n10 = atomicBoolean.get();
                if (n10 != 0) {
                    return;
                }
                n10 = this.bufferSize;
                boolean bl3 = this.delayError;
                flowableGroupBy$b = FlowableGroupBy$b.L8(object2, n10, this, bl3);
                this.groups.put(object3, flowableGroupBy$b);
                object2 = this.groupCount;
                ((AtomicInteger)object2).getAndIncrement();
                n10 = 1;
            }
            try {
                object2 = this.valueSelector;
                object = object2.apply(object);
                object2 = "The valueSelector returned null";
                object = e.a.w0.b.a.g(object, (String)object2);
                flowableGroupBy$b.onNext(object);
                this.a();
                if (n10 == 0) break block7;
                a10.offer(flowableGroupBy$b);
            }
            catch (Throwable throwable) {
                e.a.t0.a.b(throwable);
                this.upstream.cancel();
                this.onError(throwable);
                return;
            }
            this.drain();
        }
    }

    public void onSubscribe(e e10) {
        Object object = this.upstream;
        int n10 = SubscriptionHelper.validate((e)object, e10);
        if (n10 != 0) {
            this.upstream = e10;
            object = this.downstream;
            object.onSubscribe(this);
            n10 = this.bufferSize;
            long l10 = n10;
            e10.request(l10);
        }
    }

    public e.a.u0.b poll() {
        return (e.a.u0.b)this.queue.poll();
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
}

