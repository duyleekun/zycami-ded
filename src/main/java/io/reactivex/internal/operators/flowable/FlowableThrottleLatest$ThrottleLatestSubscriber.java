/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.h0$c;
import e.a.o;
import e.a.w0.i.b;
import i.g.d;
import i.g.e;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class FlowableThrottleLatest$ThrottleLatestSubscriber
extends AtomicInteger
implements o,
e,
Runnable {
    private static final long serialVersionUID = -8296689127439125014L;
    public volatile boolean cancelled;
    public volatile boolean done;
    public final d downstream;
    public final boolean emitLast;
    public long emitted;
    public Throwable error;
    public final AtomicReference latest;
    public final AtomicLong requested;
    public final long timeout;
    public volatile boolean timerFired;
    public boolean timerRunning;
    public final TimeUnit unit;
    public e upstream;
    public final h0$c worker;

    public FlowableThrottleLatest$ThrottleLatestSubscriber(d serializable, long l10, TimeUnit timeUnit, h0$c h0$c, boolean bl2) {
        this.downstream = serializable;
        this.timeout = l10;
        this.unit = timeUnit;
        this.worker = h0$c;
        this.emitLast = bl2;
        this.latest = serializable = new Serializable();
        this.requested = serializable;
    }

    public void cancel() {
        this.cancelled = true;
        this.upstream.cancel();
        Object object = this.worker;
        object.dispose();
        int n10 = this.getAndIncrement();
        if (n10 == 0) {
            object = this.latest;
            ((AtomicReference)object).lazySet(null);
        }
    }

    public void drain() {
        int n10;
        int n11 = this.getAndIncrement();
        if (n11 != 0) {
            return;
        }
        Serializable serializable = this.latest;
        Object object = this.requested;
        d d10 = this.downstream;
        int n12 = n10 = 1;
        while (true) {
            long l10;
            TimeUnit timeUnit;
            block18: {
                block17: {
                    boolean bl2;
                    block16: {
                        int n13;
                        Throwable throwable;
                        if (bl2 = this.cancelled) {
                            ((AtomicReference)serializable).lazySet(null);
                            return;
                        }
                        bl2 = this.done;
                        if (bl2 && (throwable = this.error) != null) {
                            ((AtomicReference)serializable).lazySet(null);
                            serializable = this.error;
                            d10.onError((Throwable)serializable);
                            this.worker.dispose();
                            return;
                        }
                        throwable = ((AtomicReference)serializable).get();
                        timeUnit = null;
                        if (throwable == null) {
                            n13 = n10;
                        } else {
                            n13 = 0;
                            throwable = null;
                        }
                        l10 = 1L;
                        if (bl2) {
                            if (n13 == 0 && (n10 = this.emitLast) != 0) {
                                serializable = ((AtomicReference)serializable).getAndSet(null);
                                long l11 = this.emitted;
                                long l12 = ((AtomicLong)object).get();
                                long l13 = l11 - l12;
                                Object object2 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
                                if (object2 != false) {
                                    this.emitted = l11 += l10;
                                    d10.onNext(serializable);
                                    d10.onComplete();
                                } else {
                                    object = "Could not emit final value due to lack of requests";
                                    serializable = new MissingBackpressureException((String)object);
                                    d10.onError((Throwable)serializable);
                                }
                            } else {
                                ((AtomicReference)serializable).lazySet(null);
                                d10.onComplete();
                            }
                            this.worker.dispose();
                            return;
                        }
                        if (n13 == 0) break block16;
                        bl2 = this.timerFired;
                        if (bl2) {
                            this.timerRunning = false;
                            this.timerFired = false;
                        }
                        break block17;
                    }
                    bl2 = this.timerRunning;
                    if (!bl2 || (bl2 = this.timerFired)) break block18;
                }
                n12 = -n12;
                if ((n12 = this.addAndGet(n12)) != 0) continue;
                return;
            }
            h0$c h0$c = ((AtomicReference)serializable).getAndSet(null);
            long l14 = this.emitted;
            long l15 = ((AtomicLong)object).get();
            long l16 = l14 - l15;
            Object object3 = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
            if (object3 == false) break;
            d10.onNext(h0$c);
            this.emitted = l14 += l10;
            this.timerFired = false;
            this.timerRunning = n10;
            h0$c = this.worker;
            l14 = this.timeout;
            timeUnit = this.unit;
            h0$c.c(this, l14, timeUnit);
        }
        this.upstream.cancel();
        serializable = new MissingBackpressureException("Could not emit value due to lack of requests");
        d10.onError((Throwable)serializable);
        this.worker.dispose();
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
        this.latest.set(object);
        this.drain();
    }

    public void onSubscribe(e e10) {
        Object object = this.upstream;
        boolean bl2 = SubscriptionHelper.validate((e)object, e10);
        if (bl2) {
            this.upstream = e10;
            object = this.downstream;
            object.onSubscribe(this);
            long l10 = Long.MAX_VALUE;
            e10.request(l10);
        }
    }

    public void request(long l10) {
        boolean bl2 = SubscriptionHelper.validate(l10);
        if (bl2) {
            AtomicLong atomicLong = this.requested;
            b.a(atomicLong, l10);
        }
    }

    public void run() {
        this.timerFired = true;
        this.drain();
    }
}

