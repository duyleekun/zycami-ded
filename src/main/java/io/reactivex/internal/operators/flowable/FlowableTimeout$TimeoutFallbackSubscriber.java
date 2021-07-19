/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.a1.a;
import e.a.s0.b;
import e.a.v0.o;
import i.g.c;
import i.g.d;
import i.g.e;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.operators.flowable.FlowableTimeout$TimeoutConsumer;
import io.reactivex.internal.operators.flowable.FlowableTimeout$a;
import io.reactivex.internal.operators.flowable.FlowableTimeoutTimed$a;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class FlowableTimeout$TimeoutFallbackSubscriber
extends SubscriptionArbiter
implements e.a.o,
FlowableTimeout$a {
    private static final long serialVersionUID = 3764492702657003550L;
    public long consumed;
    public final d downstream;
    public c fallback;
    public final AtomicLong index;
    public final o itemTimeoutIndicator;
    public final SequentialDisposable task;
    public final AtomicReference upstream;

    public FlowableTimeout$TimeoutFallbackSubscriber(d serializable, o o10, c c10) {
        super(true);
        this.downstream = serializable;
        this.itemTimeoutIndicator = o10;
        serializable = new Serializable();
        this.task = serializable;
        this.upstream = serializable = new Serializable();
        this.fallback = c10;
        super();
        this.index = serializable;
    }

    public void cancel() {
        super.cancel();
        this.task.dispose();
    }

    public void onComplete() {
        Serializable serializable = this.index;
        long l10 = Long.MAX_VALUE;
        long l11 = ((AtomicLong)serializable).getAndSet(l10);
        long l12 = l11 - l10;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object != false) {
            this.task.dispose();
            this.downstream.onComplete();
            serializable = this.task;
            ((SequentialDisposable)serializable).dispose();
        }
    }

    public void onError(Throwable serializable) {
        Object object = this.index;
        long l10 = Long.MAX_VALUE;
        long l11 = ((AtomicLong)object).getAndSet(l10);
        long l12 = l11 - l10;
        Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object2 != false) {
            this.task.dispose();
            object = this.downstream;
            object.onError((Throwable)serializable);
            serializable = this.task;
            ((SequentialDisposable)serializable).dispose();
        } else {
            a.Y((Throwable)serializable);
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
            object2 = (b)this.task.get();
            if (object2 != null) {
                object2.dispose();
            }
            this.consumed = l13 = this.consumed + l10;
            object2 = this.downstream;
            object2.onNext(object);
            object2 = this.itemTimeoutIndicator;
            object = object2.apply(object);
            object2 = "The itemTimeoutIndicator returned a null Publisher.";
            object = e.a.w0.b.a.g(object, (String)object2);
            try {
                object = (c)object;
                object2 = new FlowableTimeout$TimeoutConsumer(l11, this);
                SequentialDisposable sequentialDisposable = this.task;
                boolean bl3 = sequentialDisposable.replace((b)object2);
                if (bl3) {
                    object.subscribe((d)object2);
                }
                return;
            }
            catch (Throwable throwable) {
                e.a.t0.a.b(throwable);
                ((e)this.upstream.get()).cancel();
                this.index.getAndSet(l12);
                object2 = this.downstream;
                object2.onError(throwable);
            }
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
            SubscriptionHelper.cancel(this.upstream);
            c c10 = this.fallback;
            FlowableTimeoutTimed$a flowableTimeoutTimed$a = null;
            this.fallback = null;
            long l12 = this.consumed;
            long l13 = 0L;
            long l14 = l12 == l13 ? 0 : (l12 < l13 ? -1 : 1);
            if (l14 != false) {
                this.produced(l12);
            }
            object = this.downstream;
            flowableTimeoutTimed$a = new FlowableTimeoutTimed$a((d)object, this);
            c10.subscribe(flowableTimeoutTimed$a);
        }
    }

    public void onTimeoutError(long l10, Throwable throwable) {
        AtomicLong atomicLong = this.index;
        long l11 = Long.MAX_VALUE;
        boolean bl2 = atomicLong.compareAndSet(l10, l11);
        if (bl2) {
            SubscriptionHelper.cancel(this.upstream);
            d d10 = this.downstream;
            d10.onError(throwable);
        } else {
            a.Y(throwable);
        }
    }

    public void startFirstTimeout(c c10) {
        long l10;
        FlowableTimeout$TimeoutConsumer flowableTimeout$TimeoutConsumer;
        SequentialDisposable sequentialDisposable;
        boolean bl2;
        if (c10 != null && (bl2 = (sequentialDisposable = this.task).replace(flowableTimeout$TimeoutConsumer = new FlowableTimeout$TimeoutConsumer(l10 = 0L, this)))) {
            c10.subscribe(flowableTimeout$TimeoutConsumer);
        }
    }
}

