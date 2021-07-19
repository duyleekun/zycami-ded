/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.a1.a;
import e.a.w0.c.o;
import e.a.w0.i.b;
import i.g.c;
import i.g.d;
import i.g.e;
import io.reactivex.internal.operators.flowable.FlowableSwitchMap$SwitchMapInnerSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class FlowableSwitchMap$SwitchMapSubscriber
extends AtomicInteger
implements e.a.o,
e {
    public static final FlowableSwitchMap$SwitchMapInnerSubscriber CANCELLED;
    private static final long serialVersionUID = -3491074160481096299L;
    public final AtomicReference active;
    public final int bufferSize;
    public volatile boolean cancelled;
    public final boolean delayErrors;
    public volatile boolean done;
    public final d downstream;
    public final AtomicThrowable error;
    public final e.a.v0.o mapper;
    public final AtomicLong requested;
    public volatile long unique;
    public e upstream;

    static {
        FlowableSwitchMap$SwitchMapInnerSubscriber flowableSwitchMap$SwitchMapInnerSubscriber;
        CANCELLED = flowableSwitchMap$SwitchMapInnerSubscriber = new FlowableSwitchMap$SwitchMapInnerSubscriber(null, -1, 1);
        flowableSwitchMap$SwitchMapInnerSubscriber.cancel();
    }

    public FlowableSwitchMap$SwitchMapSubscriber(d object, e.a.v0.o o10, int n10, boolean bl2) {
        Serializable serializable;
        this.active = serializable = new Serializable();
        this.requested = serializable;
        this.downstream = object;
        this.mapper = o10;
        this.bufferSize = n10;
        this.delayErrors = bl2;
        this.error = object = new AtomicThrowable();
    }

    public void cancel() {
        boolean bl2 = this.cancelled;
        if (!bl2) {
            this.cancelled = bl2 = true;
            e e10 = this.upstream;
            e10.cancel();
            this.disposeInner();
        }
    }

    public void disposeInner() {
        FlowableSwitchMap$SwitchMapInnerSubscriber flowableSwitchMap$SwitchMapInnerSubscriber;
        FlowableSwitchMap$SwitchMapInnerSubscriber flowableSwitchMap$SwitchMapInnerSubscriber2 = (FlowableSwitchMap$SwitchMapInnerSubscriber)this.active.get();
        if (flowableSwitchMap$SwitchMapInnerSubscriber2 != (flowableSwitchMap$SwitchMapInnerSubscriber = CANCELLED) && (flowableSwitchMap$SwitchMapInnerSubscriber2 = this.active.getAndSet(flowableSwitchMap$SwitchMapInnerSubscriber)) != flowableSwitchMap$SwitchMapInnerSubscriber && flowableSwitchMap$SwitchMapInnerSubscriber2 != null) {
            flowableSwitchMap$SwitchMapInnerSubscriber2.cancel();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void drain() {
        FlowableSwitchMap$SwitchMapSubscriber flowableSwitchMap$SwitchMapSubscriber = this;
        int n10 = this.getAndIncrement();
        if (n10 != 0) {
            return;
        }
        d d10 = this.downstream;
        int n11 = 1;
        while (true) {
            block27: {
                boolean bl2;
                long l10;
                o o10;
                if ((n10 = (int)(flowableSwitchMap$SwitchMapSubscriber.cancelled ? 1 : 0)) != 0) {
                    return;
                }
                n10 = (int)(flowableSwitchMap$SwitchMapSubscriber.done ? 1 : 0);
                if (n10 != 0) {
                    n10 = (int)(flowableSwitchMap$SwitchMapSubscriber.delayErrors ? 1 : 0);
                    if (n10 != 0) {
                        Object v10 = flowableSwitchMap$SwitchMapSubscriber.active.get();
                        if (v10 == null) {
                            Throwable throwable = (Throwable)flowableSwitchMap$SwitchMapSubscriber.error.get();
                            if (throwable != null) {
                                Throwable throwable2 = flowableSwitchMap$SwitchMapSubscriber.error.terminate();
                                d10.onError(throwable2);
                                return;
                            }
                            d10.onComplete();
                            return;
                        }
                    } else {
                        Throwable throwable = (Throwable)flowableSwitchMap$SwitchMapSubscriber.error.get();
                        if (throwable != null) {
                            this.disposeInner();
                            Throwable throwable3 = flowableSwitchMap$SwitchMapSubscriber.error.terminate();
                            d10.onError(throwable3);
                            return;
                        }
                        Object v11 = flowableSwitchMap$SwitchMapSubscriber.active.get();
                        if (v11 == null) {
                            d10.onComplete();
                            return;
                        }
                    }
                }
                Object v12 = flowableSwitchMap$SwitchMapSubscriber.active.get();
                Object object = v12;
                object = (FlowableSwitchMap$SwitchMapInnerSubscriber)v12;
                o o11 = object != null ? (o10 = ((FlowableSwitchMap$SwitchMapInnerSubscriber)object).queue) : null;
                if (o11 == null) break block27;
                n10 = (int)(((FlowableSwitchMap$SwitchMapInnerSubscriber)object).done ? 1 : 0);
                if (n10 != 0) {
                    n10 = (int)(flowableSwitchMap$SwitchMapSubscriber.delayErrors ? 1 : 0);
                    if (n10 == 0) {
                        Throwable throwable = (Throwable)flowableSwitchMap$SwitchMapSubscriber.error.get();
                        if (throwable != null) {
                            this.disposeInner();
                            Throwable throwable4 = flowableSwitchMap$SwitchMapSubscriber.error.terminate();
                            d10.onError(throwable4);
                            return;
                        }
                        n10 = (int)(o11.isEmpty() ? 1 : 0);
                        if (n10 != 0) {
                            AtomicReference atomicReference = flowableSwitchMap$SwitchMapSubscriber.active;
                            atomicReference.compareAndSet(object, null);
                            continue;
                        }
                    } else {
                        n10 = (int)(o11.isEmpty() ? 1 : 0);
                        if (n10 != 0) {
                            AtomicReference atomicReference = flowableSwitchMap$SwitchMapSubscriber.active;
                            atomicReference.compareAndSet(object, null);
                            continue;
                        }
                    }
                }
                AtomicLong atomicLong = flowableSwitchMap$SwitchMapSubscriber.requested;
                long l11 = atomicLong.get();
                long l12 = l10 = 0L;
                while (true) {
                    boolean bl3;
                    Object object2;
                    block29: {
                        block28: {
                            block30: {
                                n10 = (int)(l12 == l11 ? 0 : (l12 < l11 ? -1 : 1));
                                bl2 = false;
                                if (n10 == 0) break;
                                n10 = (int)(flowableSwitchMap$SwitchMapSubscriber.cancelled ? 1 : 0);
                                if (n10 != 0) {
                                    return;
                                }
                                n10 = (int)(((FlowableSwitchMap$SwitchMapInnerSubscriber)object).done ? 1 : 0);
                                try {
                                    object2 = o11.poll();
                                }
                                catch (Throwable throwable) {
                                    object2 = throwable;
                                    e.a.t0.a.b(throwable);
                                    ((FlowableSwitchMap$SwitchMapInnerSubscriber)object).cancel();
                                    AtomicThrowable atomicThrowable = flowableSwitchMap$SwitchMapSubscriber.error;
                                    atomicThrowable.addThrowable((Throwable)object2);
                                    object2 = null;
                                    n10 = 1;
                                }
                                bl3 = object2 == null;
                                Object v13 = flowableSwitchMap$SwitchMapSubscriber.active.get();
                                if (object != v13) break block28;
                                if (n10 == 0) break block29;
                                n10 = (int)(flowableSwitchMap$SwitchMapSubscriber.delayErrors ? 1 : 0);
                                if (n10 != 0) break block30;
                                Throwable throwable = (Throwable)flowableSwitchMap$SwitchMapSubscriber.error.get();
                                if (throwable != null) {
                                    Throwable throwable5 = flowableSwitchMap$SwitchMapSubscriber.error.terminate();
                                    d10.onError(throwable5);
                                    return;
                                }
                                if (!bl3) break block29;
                                AtomicReference atomicReference = flowableSwitchMap$SwitchMapSubscriber.active;
                                atomicReference.compareAndSet(object, null);
                                break block28;
                            }
                            if (!bl3) break block29;
                            AtomicReference atomicReference = flowableSwitchMap$SwitchMapSubscriber.active;
                            atomicReference.compareAndSet(object, null);
                        }
                        bl2 = true;
                        break;
                    }
                    if (bl3) break;
                    d10.onNext(object2);
                    long l13 = 1L;
                    l12 += l13;
                }
                if ((n10 = (int)(l12 == l10 ? 0 : (l12 < l10 ? -1 : 1))) != 0 && (n10 = (int)(flowableSwitchMap$SwitchMapSubscriber.cancelled ? 1 : 0)) == 0) {
                    long l14 = Long.MAX_VALUE;
                    long l15 = l11 - l14;
                    n10 = (int)(l15 == 0L ? 0 : (l15 < 0L ? -1 : 1));
                    if (n10 != 0) {
                        AtomicLong atomicLong2 = flowableSwitchMap$SwitchMapSubscriber.requested;
                        l14 = -l12;
                        atomicLong2.addAndGet(l14);
                    }
                    ((FlowableSwitchMap$SwitchMapInnerSubscriber)object).request(l12);
                }
                if (bl2) continue;
            }
            if ((n11 = flowableSwitchMap$SwitchMapSubscriber.addAndGet(n10 = -n11)) == 0) break;
        }
    }

    public void onComplete() {
        boolean bl2 = this.done;
        if (bl2) {
            return;
        }
        this.done = true;
        this.drain();
    }

    public void onError(Throwable throwable) {
        AtomicThrowable atomicThrowable;
        boolean bl2 = this.done;
        if (!bl2 && (bl2 = (atomicThrowable = this.error).addThrowable(throwable))) {
            boolean bl3 = this.delayErrors;
            if (!bl3) {
                this.disposeInner();
            }
            this.done = bl3 = true;
            this.drain();
        } else {
            a.Y(throwable);
        }
    }

    public void onNext(Object object) {
        AtomicReference atomicReference;
        FlowableSwitchMap$SwitchMapInnerSubscriber flowableSwitchMap$SwitchMapInnerSubscriber;
        boolean bl2 = this.done;
        if (bl2) {
            return;
        }
        long l10 = this.unique;
        long l11 = 1L;
        this.unique = l10 += l11;
        Object object2 = (FlowableSwitchMap$SwitchMapInnerSubscriber)this.active.get();
        if (object2 != null) {
            ((FlowableSwitchMap$SwitchMapInnerSubscriber)object2).cancel();
        }
        object2 = this.mapper;
        object = object2.apply(object);
        object2 = "The publisher returned is null";
        object = e.a.w0.b.a.g(object, (String)object2);
        try {
            object = (c)object;
            int n10 = this.bufferSize;
            object2 = new FlowableSwitchMap$SwitchMapInnerSubscriber(this, l10, n10);
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            this.upstream.cancel();
            this.onError(throwable);
            return;
        }
        while ((flowableSwitchMap$SwitchMapInnerSubscriber = (FlowableSwitchMap$SwitchMapInnerSubscriber)this.active.get()) != (atomicReference = CANCELLED)) {
            atomicReference = this.active;
            bl2 = atomicReference.compareAndSet(flowableSwitchMap$SwitchMapInnerSubscriber, object2);
            if (!bl2) continue;
            object.subscribe((d)object2);
            break;
        }
        return;
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
            AtomicLong atomicLong = this.requested;
            b.a(atomicLong, l10);
            l10 = this.unique;
            long l11 = 0L;
            long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
            if (l12 == false) {
                e e10 = this.upstream;
                l11 = Long.MAX_VALUE;
                e10.request(l11);
            } else {
                this.drain();
            }
        }
    }
}

