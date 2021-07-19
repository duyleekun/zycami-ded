/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.a1.a;
import e.a.h0$c;
import e.a.o;
import e.a.w0.i.b;
import i.g.d;
import i.g.e;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public final class FlowableThrottleFirstTimed$DebounceTimedSubscriber
extends AtomicLong
implements o,
e,
Runnable {
    private static final long serialVersionUID = -9102637559663639004L;
    public boolean done;
    public final d downstream;
    public volatile boolean gate;
    public final long timeout;
    public final SequentialDisposable timer;
    public final TimeUnit unit;
    public e upstream;
    public final h0$c worker;

    public FlowableThrottleFirstTimed$DebounceTimedSubscriber(d d10, long l10, TimeUnit timeUnit, h0$c h0$c) {
        SequentialDisposable sequentialDisposable;
        this.timer = sequentialDisposable = new SequentialDisposable();
        this.downstream = d10;
        this.timeout = l10;
        this.unit = timeUnit;
        this.worker = h0$c;
    }

    public void cancel() {
        this.upstream.cancel();
        this.worker.dispose();
    }

    public void onComplete() {
        boolean bl2 = this.done;
        if (bl2) {
            return;
        }
        this.done = true;
        this.downstream.onComplete();
        this.worker.dispose();
    }

    public void onError(Throwable throwable) {
        boolean bl2 = this.done;
        if (bl2) {
            a.Y(throwable);
            return;
        }
        this.done = true;
        this.downstream.onError(throwable);
        this.worker.dispose();
    }

    public void onNext(Object object) {
        boolean bl2 = this.done;
        if (bl2) {
            return;
        }
        bl2 = this.gate;
        if (!bl2) {
            long l10;
            this.gate = bl2 = true;
            long l11 = this.get();
            long l12 = l11 - (l10 = 0L);
            Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object2 != false) {
                Object object3 = this.downstream;
                object3.onNext(object);
                long l13 = 1L;
                b.e(this, l13);
                object = (e.a.s0.b)this.timer.get();
                if (object != null) {
                    object.dispose();
                }
                object = this.timer;
                object3 = this.worker;
                l11 = this.timeout;
                TimeUnit timeUnit = this.unit;
                object3 = ((h0$c)object3).c(this, l11, timeUnit);
                ((SequentialDisposable)object).replace((e.a.s0.b)object3);
            } else {
                this.done = bl2;
                this.cancel();
                object = this.downstream;
                String string2 = "Could not deliver value due to lack of requests";
                MissingBackpressureException missingBackpressureException = new MissingBackpressureException(string2);
                object.onError(missingBackpressureException);
            }
        }
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
            b.a(this, l10);
        }
    }

    public void run() {
        this.gate = false;
    }
}

