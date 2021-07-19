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
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.io.Serializable;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class FlowableTimeout$TimeoutSubscriber
extends AtomicLong
implements e.a.o,
e,
FlowableTimeout$a {
    private static final long serialVersionUID = 3764492702657003550L;
    public final d downstream;
    public final o itemTimeoutIndicator;
    public final AtomicLong requested;
    public final SequentialDisposable task;
    public final AtomicReference upstream;

    public FlowableTimeout$TimeoutSubscriber(d serializable, o o10) {
        this.downstream = serializable;
        this.itemTimeoutIndicator = o10;
        serializable = new Serializable();
        this.task = serializable;
        this.upstream = serializable = new Serializable();
        this.requested = serializable;
    }

    public void cancel() {
        SubscriptionHelper.cancel(this.upstream);
        this.task.dispose();
    }

    public void onComplete() {
        long l10 = Long.MAX_VALUE;
        long l11 = this.getAndSet(l10);
        long l12 = l11 - l10;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object != false) {
            this.task.dispose();
            d d10 = this.downstream;
            d10.onComplete();
        }
    }

    public void onError(Throwable throwable) {
        long l10 = Long.MAX_VALUE;
        long l11 = this.getAndSet(l10);
        long l12 = l11 - l10;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object != false) {
            this.task.dispose();
            d d10 = this.downstream;
            d10.onError(throwable);
        } else {
            a.Y(throwable);
        }
    }

    public void onNext(Object object) {
        long l10;
        boolean bl2;
        long l11;
        long l12 = this.get();
        long l13 = l12 - (l11 = Long.MAX_VALUE);
        Object object2 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object2 != false && (bl2 = this.compareAndSet(l12, l10 = 1L + l12))) {
            Object object3 = (b)this.task.get();
            if (object3 != null) {
                object3.dispose();
            }
            object3 = this.downstream;
            object3.onNext(object);
            object3 = this.itemTimeoutIndicator;
            object = object3.apply(object);
            object3 = "The itemTimeoutIndicator returned a null Publisher.";
            object = e.a.w0.b.a.g(object, (String)object3);
            try {
                object = (c)object;
                object3 = new FlowableTimeout$TimeoutConsumer(l10, this);
                SequentialDisposable sequentialDisposable = this.task;
                boolean bl3 = sequentialDisposable.replace((b)object3);
                if (bl3) {
                    object.subscribe((d)object3);
                }
                return;
            }
            catch (Throwable throwable) {
                e.a.t0.a.b(throwable);
                ((e)this.upstream.get()).cancel();
                this.getAndSet(l11);
                object3 = this.downstream;
                object3.onError(throwable);
            }
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
            d d10 = this.downstream;
            TimeoutException timeoutException = new TimeoutException();
            d10.onError(timeoutException);
        }
    }

    public void onTimeoutError(long l10, Throwable throwable) {
        long l11 = Long.MAX_VALUE;
        boolean bl2 = this.compareAndSet(l10, l11);
        if (bl2) {
            SubscriptionHelper.cancel(this.upstream);
            d d10 = this.downstream;
            d10.onError(throwable);
        } else {
            a.Y(throwable);
        }
    }

    public void request(long l10) {
        AtomicReference atomicReference = this.upstream;
        AtomicLong atomicLong = this.requested;
        SubscriptionHelper.deferredRequest(atomicReference, atomicLong, l10);
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

