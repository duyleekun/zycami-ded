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
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class FlowableJoin$JoinSubscription
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

    public FlowableJoin$JoinSubscription(d serializable, e.a.v0.o o10, e.a.v0.o o11, c c10) {
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

    public void drain() {
        FlowableJoin$JoinSubscription flowableJoin$JoinSubscription = this;
        int n10 = this.getAndIncrement();
        if (n10 != 0) {
            return;
        }
        e.a.w0.f.a a10 = this.queue;
        d d10 = this.downstream;
        int n11 = n10 = 1;
        while (true) {
            block40: {
                Object object;
                Object object2;
                Serializable serializable;
                int n12;
                Object object3;
                block41: {
                    long l10;
                    long l11;
                    c c10;
                    long l12;
                    long l13;
                    int n13;
                    String string2;
                    String string3;
                    long l14;
                    Object object4;
                    int n14;
                    block39: {
                        boolean bl2;
                        int n15;
                        if ((n15 = flowableJoin$JoinSubscription.cancelled) != 0) {
                            a10.clear();
                            return;
                        }
                        object3 = (Throwable)flowableJoin$JoinSubscription.error.get();
                        if (object3 != null) {
                            a10.clear();
                            this.cancelAll();
                            flowableJoin$JoinSubscription.errorAll(d10);
                            return;
                        }
                        object3 = flowableJoin$JoinSubscription.active;
                        n15 = ((AtomicInteger)object3).get();
                        n12 = 0;
                        serializable = null;
                        if (n15 == 0) {
                            n15 = n10;
                        } else {
                            n15 = 0;
                            object3 = null;
                        }
                        object2 = (Integer)a10.poll();
                        if (object2 == null) {
                            n14 = n10;
                        } else {
                            n14 = 0;
                            object4 = null;
                        }
                        if (n15 != 0 && n14 != 0) {
                            flowableJoin$JoinSubscription.lefts.clear();
                            flowableJoin$JoinSubscription.rights.clear();
                            flowableJoin$JoinSubscription.disposables.dispose();
                            d10.onComplete();
                            return;
                        }
                        if (n14 != 0) {
                            n11 = -n11;
                            if ((n11 = flowableJoin$JoinSubscription.addAndGet(n11)) != 0) continue;
                            return;
                        }
                        object3 = a10.poll();
                        object4 = LEFT_VALUE;
                        l14 = 1L;
                        string3 = "Could not emit value due to lack of requests";
                        string2 = "The resultSelector returned a null value";
                        if (object2 != object4) break block39;
                        n12 = flowableJoin$JoinSubscription.leftIndex;
                        flowableJoin$JoinSubscription.leftIndex = n13 = n12 + 1;
                        object2 = flowableJoin$JoinSubscription.lefts;
                        object4 = n12;
                        object2.put(object4, object3);
                        object2 = flowableJoin$JoinSubscription.leftEnd;
                        object2 = object2.apply(object3);
                        object4 = "The leftEnd returned a null Publisher";
                        object2 = e.a.w0.b.a.g(object2, (String)object4);
                        try {
                            object2 = (i.g.c)object2;
                            object4 = new FlowableGroupJoin$LeftRightEndSubscriber(flowableJoin$JoinSubscription, n10 != 0, n12);
                            flowableJoin$JoinSubscription.disposables.b((e.a.s0.b)object4);
                        }
                        catch (Throwable throwable) {
                            flowableJoin$JoinSubscription.fail(throwable, d10, a10);
                            return;
                        }
                        object2.subscribe((d)object4);
                        serializable = (Throwable)flowableJoin$JoinSubscription.error.get();
                        if (serializable != null) {
                            a10.clear();
                            this.cancelAll();
                            flowableJoin$JoinSubscription.errorAll(d10);
                            return;
                        }
                        serializable = flowableJoin$JoinSubscription.requested;
                        l13 = ((AtomicLong)serializable).get();
                        object4 = flowableJoin$JoinSubscription.rights.values().iterator();
                        l12 = 0L;
                        while (bl2 = object4.hasNext()) {
                            object = object4.next();
                            try {
                                c10 = flowableJoin$JoinSubscription.resultSelector;
                            }
                            catch (Throwable throwable) {
                                flowableJoin$JoinSubscription.fail(throwable, d10, a10);
                                return;
                            }
                            object = c10.apply(object3, object);
                            object = e.a.w0.b.a.g(object, string2);
                            l11 = l12 == l13 ? 0 : (l12 < l13 ? -1 : 1);
                            if (l11 != false) {
                                d10.onNext(object);
                                l12 += l14;
                                n10 = 1;
                                continue;
                            }
                            object = flowableJoin$JoinSubscription.error;
                            MissingBackpressureException missingBackpressureException = new MissingBackpressureException(string3);
                            ExceptionHelper.a((AtomicReference)object, missingBackpressureException);
                            a10.clear();
                            this.cancelAll();
                            flowableJoin$JoinSubscription.errorAll(d10);
                            return;
                        }
                        l10 = 0L;
                        long l15 = l12 - l10;
                        n10 = (int)(l15 == 0L ? 0 : (l15 < 0L ? -1 : 1));
                        if (n10 != 0) {
                            object = flowableJoin$JoinSubscription.requested;
                            b.e((AtomicLong)object, l12);
                        }
                        break block40;
                    }
                    object = RIGHT_VALUE;
                    if (object2 != object) break block41;
                    n10 = flowableJoin$JoinSubscription.rightIndex;
                    flowableJoin$JoinSubscription.rightIndex = n13 = n10 + 1;
                    object2 = flowableJoin$JoinSubscription.rights;
                    object4 = n10;
                    object2.put(object4, object3);
                    object2 = flowableJoin$JoinSubscription.rightEnd;
                    object2 = object2.apply(object3);
                    object4 = "The rightEnd returned a null Publisher";
                    object2 = e.a.w0.b.a.g(object2, (String)object4);
                    try {
                        object2 = (i.g.c)object2;
                        object4 = new FlowableGroupJoin$LeftRightEndSubscriber(flowableJoin$JoinSubscription, false, n10);
                        flowableJoin$JoinSubscription.disposables.b((e.a.s0.b)object4);
                    }
                    catch (Throwable throwable) {
                        flowableJoin$JoinSubscription.fail(throwable, d10, a10);
                        return;
                    }
                    object2.subscribe((d)object4);
                    object = (Throwable)flowableJoin$JoinSubscription.error.get();
                    if (object != null) {
                        a10.clear();
                        this.cancelAll();
                        flowableJoin$JoinSubscription.errorAll(d10);
                        return;
                    }
                    l13 = flowableJoin$JoinSubscription.requested.get();
                    object = flowableJoin$JoinSubscription.lefts.values().iterator();
                    l12 = 0L;
                    while ((n14 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                        object4 = object.next();
                        try {
                            c10 = flowableJoin$JoinSubscription.resultSelector;
                        }
                        catch (Throwable throwable) {
                            flowableJoin$JoinSubscription.fail(throwable, d10, a10);
                            return;
                        }
                        object4 = c10.apply(object4, object3);
                        object4 = e.a.w0.b.a.g(object4, string2);
                        l11 = l12 == l13 ? 0 : (l12 < l13 ? -1 : 1);
                        if (l11 != false) {
                            d10.onNext(object4);
                            l12 += l14;
                            continue;
                        }
                        object = flowableJoin$JoinSubscription.error;
                        MissingBackpressureException missingBackpressureException = new MissingBackpressureException(string3);
                        ExceptionHelper.a((AtomicReference)object, missingBackpressureException);
                        a10.clear();
                        this.cancelAll();
                        flowableJoin$JoinSubscription.errorAll(d10);
                        return;
                    }
                    l10 = 0L;
                    long l16 = l12 - l10;
                    n10 = (int)(l16 == 0L ? 0 : (l16 < 0L ? -1 : 1));
                    if (n10 != 0) {
                        object = flowableJoin$JoinSubscription.requested;
                        b.e((AtomicLong)object, l12);
                    }
                    break block40;
                }
                object = LEFT_CLOSE;
                if (object2 == object) {
                    object3 = (FlowableGroupJoin$LeftRightEndSubscriber)object3;
                    object = flowableJoin$JoinSubscription.lefts;
                    n12 = ((FlowableGroupJoin$LeftRightEndSubscriber)object3).index;
                    serializable = Integer.valueOf(n12);
                    object.remove(serializable);
                    object = flowableJoin$JoinSubscription.disposables;
                    ((e.a.s0.a)object).a((e.a.s0.b)object3);
                } else {
                    object = RIGHT_CLOSE;
                    if (object2 == object) {
                        object3 = (FlowableGroupJoin$LeftRightEndSubscriber)object3;
                        object = flowableJoin$JoinSubscription.rights;
                        n12 = ((FlowableGroupJoin$LeftRightEndSubscriber)object3).index;
                        serializable = Integer.valueOf(n12);
                        object.remove(serializable);
                        object = flowableJoin$JoinSubscription.disposables;
                        ((e.a.s0.a)object).a((e.a.s0.b)object3);
                    }
                }
            }
            n10 = 1;
        }
    }

    public void errorAll(d d10) {
        Throwable throwable = ExceptionHelper.c(this.error);
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

