/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.a1.a;
import e.a.h0$c;
import e.a.o;
import e.a.s0.b;
import i.g.c;
import i.g.d;
import i.g.e;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.operators.flowable.FlowableTimeoutTimed$a;
import io.reactivex.internal.operators.flowable.FlowableTimeoutTimed$b;
import io.reactivex.internal.operators.flowable.FlowableTimeoutTimed$c;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class FlowableTimeoutTimed$TimeoutFallbackSubscriber
extends SubscriptionArbiter
implements o,
FlowableTimeoutTimed$b {
    private static final long serialVersionUID = 3764492702657003550L;
    public long consumed;
    public final d downstream;
    public c fallback;
    public final AtomicLong index;
    public final SequentialDisposable task;
    public final long timeout;
    public final TimeUnit unit;
    public final AtomicReference upstream;
    public final h0$c worker;

    public FlowableTimeoutTimed$TimeoutFallbackSubscriber(d serializable, long l10, TimeUnit timeUnit, h0$c h0$c, c c10) {
        super(true);
        this.downstream = serializable;
        this.timeout = l10;
        this.unit = timeUnit;
        this.worker = h0$c;
        this.fallback = c10;
        serializable = new Serializable();
        this.task = serializable;
        this.upstream = serializable = new Serializable();
        super();
        this.index = serializable;
    }

    public void cancel() {
        super.cancel();
        this.worker.dispose();
    }

    public void onComplete() {
        Object object = this.index;
        long l10 = Long.MAX_VALUE;
        long l11 = ((AtomicLong)object).getAndSet(l10);
        long l12 = l11 - l10;
        Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object2 != false) {
            this.task.dispose();
            this.downstream.onComplete();
            object = this.worker;
            object.dispose();
        }
    }

    public void onError(Throwable object) {
        Object object2 = this.index;
        long l10 = Long.MAX_VALUE;
        long l11 = ((AtomicLong)object2).getAndSet(l10);
        long l12 = l11 - l10;
        Object object3 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object3 != false) {
            this.task.dispose();
            object2 = this.downstream;
            object2.onError((Throwable)object);
            object = this.worker;
            object.dispose();
        } else {
            a.Y((Throwable)object);
        }
    }

    public void onNext(Object object) {
        long l10;
        long l11;
        AtomicLong atomicLong;
        boolean bl2;
        long l12;
        Object object2 = this.index;
        long l13 = ((AtomicLong)object2).get();
        long l14 = l13 - (l12 = Long.MAX_VALUE);
        Object object3 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
        if (object3 != false && (bl2 = (atomicLong = this.index).compareAndSet(l13, l11 = l13 + (l10 = 1L)))) {
            ((b)this.task.get()).dispose();
            this.consumed = l13 = this.consumed + l10;
            object2 = this.downstream;
            object2.onNext(object);
            this.startTimeout(l11);
        }
    }

    public void onSubscribe(e e10) {
        AtomicReference atomicReference = this.upstream;
        boolean bl2 = SubscriptionHelper.setOnce(atomicReference, e10);
        if (bl2) {
            this.setSubscription(e10);
        }
    }

    public void onTimeout(long l10) {
        Object object = this.index;
        long l11 = Long.MAX_VALUE;
        boolean bl2 = ((AtomicLong)object).compareAndSet(l10, l11);
        if (bl2) {
            Object object2 = this.upstream;
            SubscriptionHelper.cancel((AtomicReference)object2);
            l10 = this.consumed;
            long l12 = 0L;
            long l13 = l10 == l12 ? 0 : (l10 < l12 ? -1 : 1);
            if (l13 != false) {
                this.produced(l10);
            }
            object2 = this.fallback;
            this.fallback = null;
            object = this.downstream;
            FlowableTimeoutTimed$a flowableTimeoutTimed$a = new FlowableTimeoutTimed$a((d)object, this);
            object2.subscribe(flowableTimeoutTimed$a);
            object2 = this.worker;
            object2.dispose();
        }
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

