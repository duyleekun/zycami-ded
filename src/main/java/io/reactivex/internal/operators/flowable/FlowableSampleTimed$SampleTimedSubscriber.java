/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.h0;
import e.a.o;
import e.a.w0.i.b;
import i.g.d;
import i.g.e;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public abstract class FlowableSampleTimed$SampleTimedSubscriber
extends AtomicReference
implements o,
e,
Runnable {
    private static final long serialVersionUID = -3517602651313910099L;
    public final d downstream;
    public final long period;
    public final AtomicLong requested;
    public final h0 scheduler;
    public final SequentialDisposable timer;
    public final TimeUnit unit;
    public e upstream;

    public FlowableSampleTimed$SampleTimedSubscriber(d d10, long l10, TimeUnit timeUnit, h0 h02) {
        Serializable serializable;
        this.requested = serializable = new AtomicLong();
        this.timer = serializable;
        this.downstream = d10;
        this.period = l10;
        this.unit = timeUnit;
        this.scheduler = h02;
    }

    public void cancel() {
        this.cancelTimer();
        this.upstream.cancel();
    }

    public void cancelTimer() {
        DisposableHelper.dispose(this.timer);
    }

    public abstract void complete();

    public void emit() {
        Object object = this.getAndSet(null);
        if (object != null) {
            long l10;
            Object object2 = this.requested;
            long l11 = ((AtomicLong)object2).get();
            long l12 = l11 - (l10 = 0L);
            Object object3 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object3 != false) {
                object2 = this.downstream;
                object2.onNext(object);
                object = this.requested;
                l11 = 1L;
                b.e((AtomicLong)object, l11);
            } else {
                this.cancel();
                object = this.downstream;
                String string2 = "Couldn't emit value due to lack of requests!";
                object2 = new MissingBackpressureException(string2);
                object.onError((Throwable)object2);
            }
        }
    }

    public void onComplete() {
        this.cancelTimer();
        this.complete();
    }

    public void onError(Throwable throwable) {
        this.cancelTimer();
        this.downstream.onError(throwable);
    }

    public void onNext(Object object) {
        this.lazySet(object);
    }

    public void onSubscribe(e e10) {
        Object object = this.upstream;
        boolean bl2 = SubscriptionHelper.validate((e)object, e10);
        if (bl2) {
            this.upstream = e10;
            this.downstream.onSubscribe(this);
            object = this.timer;
            Object object2 = this.scheduler;
            long l10 = this.period;
            TimeUnit timeUnit = this.unit;
            object2 = ((h0)object2).g(this, l10, l10, timeUnit);
            ((SequentialDisposable)object).replace((e.a.s0.b)object2);
            long l11 = Long.MAX_VALUE;
            e10.request(l11);
        }
    }

    public void request(long l10) {
        boolean bl2 = SubscriptionHelper.validate(l10);
        if (bl2) {
            AtomicLong atomicLong = this.requested;
            b.a(atomicLong, l10);
        }
    }
}

