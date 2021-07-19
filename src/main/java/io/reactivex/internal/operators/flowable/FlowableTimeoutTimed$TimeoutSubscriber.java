/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.a1.a;
import e.a.h0$c;
import e.a.o;
import e.a.s0.b;
import i.g.d;
import i.g.e;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.operators.flowable.FlowableTimeoutTimed$b;
import io.reactivex.internal.operators.flowable.FlowableTimeoutTimed$c;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class FlowableTimeoutTimed$TimeoutSubscriber
extends AtomicLong
implements o,
e,
FlowableTimeoutTimed$b {
    private static final long serialVersionUID = 3764492702657003550L;
    public final d downstream;
    public final AtomicLong requested;
    public final SequentialDisposable task;
    public final long timeout;
    public final TimeUnit unit;
    public final AtomicReference upstream;
    public final h0$c worker;

    public FlowableTimeoutTimed$TimeoutSubscriber(d serializable, long l10, TimeUnit timeUnit, h0$c h0$c) {
        this.downstream = serializable;
        this.timeout = l10;
        this.unit = timeUnit;
        this.worker = h0$c;
        serializable = new Serializable();
        this.task = serializable;
        this.upstream = serializable = new Serializable();
        this.requested = serializable;
    }

    public void cancel() {
        SubscriptionHelper.cancel(this.upstream);
        this.worker.dispose();
    }

    public void onComplete() {
        long l10 = Long.MAX_VALUE;
        long l11 = this.getAndSet(l10);
        long l12 = l11 - l10;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object != false) {
            this.task.dispose();
            this.downstream.onComplete();
            h0$c h0$c = this.worker;
            h0$c.dispose();
        }
    }

    public void onError(Throwable object) {
        long l10 = Long.MAX_VALUE;
        long l11 = this.getAndSet(l10);
        long l12 = l11 - l10;
        Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object2 != false) {
            this.task.dispose();
            d d10 = this.downstream;
            d10.onError((Throwable)object);
            object = this.worker;
            object.dispose();
        } else {
            a.Y((Throwable)object);
        }
    }

    public void onNext(Object object) {
        boolean bl2;
        long l10;
        long l11 = this.get();
        long l12 = l11 - (l10 = Long.MAX_VALUE);
        Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object2 != false && (bl2 = this.compareAndSet(l11, l10 = 1L + l11))) {
            ((b)this.task.get()).dispose();
            d d10 = this.downstream;
            d10.onNext(object);
            this.startTimeout(l10);
        }
    }

    public void onSubscribe(e e10) {
        AtomicReference atomicReference = this.upstream;
        AtomicLong atomicLong = this.requested;
        SubscriptionHelper.deferredSetOnce(atomicReference, atomicLong, e10);
    }

    public void onTimeout(long l10) {
        long l11 = Long.MAX_VALUE;
        boolean bl2 = this.compareAndSet(l10, l11);
        if (bl2) {
            SubscriptionHelper.cancel(this.upstream);
            Object object = this.downstream;
            l11 = this.timeout;
            TimeUnit timeUnit = this.unit;
            String string2 = ExceptionHelper.e(l11, timeUnit);
            TimeoutException timeoutException = new TimeoutException(string2);
            object.onError(timeoutException);
            object = this.worker;
            object.dispose();
        }
    }

    public void request(long l10) {
        AtomicReference atomicReference = this.upstream;
        AtomicLong atomicLong = this.requested;
        SubscriptionHelper.deferredRequest(atomicReference, atomicLong, l10);
    }

    public void startTimeout(long l10) {
        SequentialDisposable sequentialDisposable = this.task;
        h0$c h0$c = this.worker;
        FlowableTimeoutTimed$c flowableTimeoutTimed$c = new FlowableTimeoutTimed$c(l10, this);
        l10 = this.timeout;
        TimeUnit timeUnit = this.unit;
        b b10 = h0$c.c(flowableTimeoutTimed$c, l10, timeUnit);
        sequentialDisposable.replace(b10);
    }
}

