/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.j;
import e.a.t0.a;
import e.a.v0.c;
import e.a.w0.c.o;
import e.a.w0.i.b;
import i.g.d;
import i.g.e;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.operators.flowable.FlowableGroupJoin$LeftRightEndSubscriber;
import io.reactivex.internal.operators.flowable.FlowableGroupJoin$LeftRightSubscriber;
import io.reactivex.internal.operators.flowable.FlowableGroupJoin$a;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.processors.UnicastProcessor;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class FlowableGroupJoin$GroupJoinSubscription
extends AtomicInteger
implements e,
FlowableGroupJoin$a {
    public static final Integer LEFT_CLOSE;
    public static final Integer LEFT_VALUE;
    public static final Integer RIGHT_CLOSE;
    public static final Integer RIGHT_VALUE;
    private static final long serialVersionUID = -6071216598687999801L;
    public final AtomicInteger active;
    public volatile boolean cancelled;
    public final e.a.s0.a disposables;
    public final d downstream;
    public final AtomicReference error;
    public final e.a.v0.o leftEnd;
    public int leftIndex;
    public final Map lefts;
    public final e.a.w0.f.a queue;
    public final AtomicLong requested;
    public final c resultSelector;
    public final e.a.v0.o rightEnd;
    public int rightIndex;
    public final Map rights;

    static {
        LEFT_VALUE = 1;
        RIGHT_VALUE = 2;
        LEFT_CLOSE = 3;
        RIGHT_CLOSE = 4;
    }

    public FlowableGroupJoin$GroupJoinSubscription(d serializable, e.a.v0.o o10, e.a.v0.o o11, c c10) {
        this.downstream = serializable;
        serializable = new Serializable();
        this.requested = serializable;
        serializable = new Serializable();
        this.disposables = serializable;
        int n10 = j.f0();
        serializable = new Serializable(n10);
        this.queue = serializable;
        this.lefts = serializable = new Serializable();
        this.rights = serializable = new Serializable();
        this.error = serializable;
        this.leftEnd = o10;
        this.rightEnd = o11;
        this.resultSelector = c10;
        super(2);
        this.active = serializable;
    }

    public void cancel() {
        int n10 = this.cancelled;
        if (n10 != 0) {
            return;
        }
        this.cancelled = true;
        this.cancelAll();
        n10 = this.getAndIncrement();
        if (n10 == 0) {
            e.a.w0.f.a a10 = this.queue;
            a10.clear();
        }
    }

    public void cancelAll() {
        this.disposables.dispose();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void drain() {
        boolean bl2;
        int n10 = this.getAndIncrement();
        if (n10 != 0) {
            return;
        }
        Object object = this.queue;
        d d10 = this.downstream;
        boolean bl3 = bl2 = true;
        block6: while (true) {
            Object object2;
            int n11;
            Object object3;
            boolean bl4;
            boolean bl5;
            if (bl5 = this.cancelled) {
                ((e.a.w0.f.a)object).clear();
                return;
            }
            Object object4 = (Throwable)this.error.get();
            if (object4 != null) {
                ((e.a.w0.f.a)object).clear();
                this.cancelAll();
                this.errorAll(d10);
                return;
            }
            object4 = this.active;
            bl5 = ((AtomicInteger)object4).get();
            Object object5 = null;
            if (!bl5) {
                bl5 = bl2;
            } else {
                bl5 = false;
                object4 = null;
            }
            Object object6 = (Integer)((e.a.w0.f.a)object).poll();
            if (object6 == null) {
                bl4 = bl2;
            } else {
                bl4 = false;
                object3 = null;
            }
            if (bl5 && bl4) {
                object = this.lefts.values().iterator();
                while (true) {
                    if (!(bl2 = (boolean)object.hasNext())) {
                        this.lefts.clear();
                        this.rights.clear();
                        this.disposables.dispose();
                        d10.onComplete();
                        return;
                    }
                    UnicastProcessor unicastProcessor = (UnicastProcessor)object.next();
                    unicastProcessor.onComplete();
                }
            }
            if (bl4) {
                bl3 = -bl3;
                if (bl3 = this.addAndGet((int)(bl3 ? 1 : 0))) continue;
                return;
            }
            object4 = ((e.a.w0.f.a)object).poll();
            object3 = LEFT_VALUE;
            if (object6 == object3) {
                long l10;
                long l11;
                object5 = UnicastProcessor.Q8();
                n11 = this.leftIndex;
                bl4 = n11 + 1;
                this.leftIndex = bl4;
                object3 = this.lefts;
                object2 = n11;
                object3.put(object2, object5);
                try {
                    object3 = this.leftEnd;
                    object3 = object3.apply(object4);
                    object2 = "The leftEnd returned a null Publisher";
                    object3 = e.a.w0.b.a.g(object3, (String)object2);
                    object3 = (i.g.c)object3;
                    object2 = new FlowableGroupJoin$LeftRightEndSubscriber(this, bl2, n11);
                    this.disposables.b((e.a.s0.b)object2);
                }
                catch (Throwable throwable) {
                    this.fail(throwable, d10, (o)object);
                    return;
                }
                object3.subscribe((d)object2);
                object6 = (Throwable)this.error.get();
                if (object6 != null) {
                    ((e.a.w0.f.a)object).clear();
                    this.cancelAll();
                    this.errorAll(d10);
                    return;
                }
                try {
                    object6 = this.resultSelector;
                    object4 = object6.apply(object4, object5);
                    object6 = "The resultSelector returned a null value";
                    object4 = e.a.w0.b.a.g(object4, (String)object6);
                    object6 = this.requested;
                    l11 = ((AtomicLong)object6).get();
                    l10 = 0L;
                }
                catch (Throwable throwable) {
                    this.fail(throwable, d10, (o)object);
                    return;
                }
                n11 = (int)(l11 == l10 ? 0 : (l11 < l10 ? -1 : 1));
                if (n11 == 0) {
                    MissingBackpressureException missingBackpressureException = new MissingBackpressureException("Could not emit value due to lack of requests");
                    this.fail(missingBackpressureException, d10, (o)object);
                    return;
                }
                d10.onNext(object4);
                object4 = this.requested;
                l11 = 1L;
                b.e((AtomicLong)object4, l11);
                object4 = this.rights.values().iterator();
                while (true) {
                    if ((n11 = (int)(object4.hasNext() ? 1 : 0)) == 0) continue block6;
                    object6 = object4.next();
                    ((UnicastProcessor)object5).onNext(object6);
                }
            }
            object3 = RIGHT_VALUE;
            if (object6 == object3) {
                n11 = this.rightIndex;
                bl4 = n11 + 1;
                this.rightIndex = bl4;
                object3 = this.rights;
                object2 = n11;
                object3.put(object2, object4);
                try {
                    object3 = this.rightEnd;
                    object3 = object3.apply(object4);
                    object2 = "The rightEnd returned a null Publisher";
                    object3 = e.a.w0.b.a.g(object3, (String)object2);
                    object3 = (i.g.c)object3;
                    object2 = new FlowableGroupJoin$LeftRightEndSubscriber(this, false, n11);
                    this.disposables.b((e.a.s0.b)object2);
                }
                catch (Throwable throwable) {
                    this.fail(throwable, d10, (o)object);
                    return;
                }
                object3.subscribe((d)object2);
                object5 = (Throwable)this.error.get();
                if (object5 != null) {
                    ((e.a.w0.f.a)object).clear();
                    this.cancelAll();
                    this.errorAll(d10);
                    return;
                }
                object5 = this.lefts.values().iterator();
                while (true) {
                    if ((n11 = (int)(object5.hasNext() ? 1 : 0)) == 0) continue block6;
                    object6 = (UnicastProcessor)object5.next();
                    ((UnicastProcessor)object6).onNext(object4);
                }
            }
            object5 = LEFT_CLOSE;
            if (object6 == object5) {
                object4 = (FlowableGroupJoin$LeftRightEndSubscriber)object4;
                object5 = this.lefts;
                n11 = ((FlowableGroupJoin$LeftRightEndSubscriber)object4).index;
                object6 = n11;
                object5 = (UnicastProcessor)object5.remove(object6);
                object6 = this.disposables;
                ((e.a.s0.a)object6).a((e.a.s0.b)object4);
                if (object5 == null) continue;
                ((UnicastProcessor)object5).onComplete();
                continue;
            }
            object5 = RIGHT_CLOSE;
            if (object6 != object5) continue;
            object4 = (FlowableGroupJoin$LeftRightEndSubscriber)object4;
            object5 = this.rights;
            n11 = ((FlowableGroupJoin$LeftRightEndSubscriber)object4).index;
            object6 = n11;
            object5.remove(object6);
            object5 = this.disposables;
            ((e.a.s0.a)object5).a((e.a.s0.b)object4);
        }
    }

    public void errorAll(d d10) {
        boolean bl2;
        Throwable throwable = ExceptionHelper.c(this.error);
        Iterator iterator2 = this.lefts.values().iterator();
        while (bl2 = iterator2.hasNext()) {
            UnicastProcessor unicastProcessor = (UnicastProcessor)iterator2.next();
            unicastProcessor.onError(throwable);
        }
        this.lefts.clear();
        this.rights.clear();
        d10.onError(throwable);
    }

    public void fail(Throwable throwable, d d10, o o10) {
        a.b(throwable);
        ExceptionHelper.a(this.error, throwable);
        o10.clear();
        this.cancelAll();
        this.errorAll(d10);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void innerClose(boolean bl2, FlowableGroupJoin$LeftRightEndSubscriber flowableGroupJoin$LeftRightEndSubscriber) {
        synchronized (this) {
            e.a.w0.f.a a10 = this.queue;
            Integer n10 = bl2 ? LEFT_CLOSE : RIGHT_CLOSE;
            a10.offer(n10, flowableGroupJoin$LeftRightEndSubscriber);
        }
        this.drain();
    }

    public void innerCloseError(Throwable throwable) {
        AtomicReference atomicReference = this.error;
        boolean bl2 = ExceptionHelper.a(atomicReference, throwable);
        if (bl2) {
            this.drain();
        } else {
            e.a.a1.a.Y(throwable);
        }
    }

    public void innerComplete(FlowableGroupJoin$LeftRightSubscriber flowableGroupJoin$LeftRightSubscriber) {
        this.disposables.c(flowableGroupJoin$LeftRightSubscriber);
        this.active.decrementAndGet();
        this.drain();
    }

    public void innerError(Throwable serializable) {
        AtomicReference atomicReference = this.error;
        boolean bl2 = ExceptionHelper.a(atomicReference, (Throwable)serializable);
        if (bl2) {
            serializable = this.active;
            ((AtomicInteger)serializable).decrementAndGet();
            this.drain();
        } else {
            e.a.a1.a.Y((Throwable)serializable);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void innerValue(boolean bl2, Object object) {
        synchronized (this) {
            e.a.w0.f.a a10 = this.queue;
            Integer n10 = bl2 ? LEFT_VALUE : RIGHT_VALUE;
            a10.offer(n10, object);
        }
        this.drain();
    }

    public void request(long l10) {
        boolean bl2 = SubscriptionHelper.validate(l10);
        if (bl2) {
            AtomicLong atomicLong = this.requested;
            b.a(atomicLong, l10);
        }
    }
}

