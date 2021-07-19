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
import io.reactivex.internal.operators.flowable.FlowableDebounceTimed$DebounceEmitter;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public final class FlowableDebounceTimed$DebounceTimedSubscriber
extends AtomicLong
implements o,
e {
    private static final long serialVersionUID = -9102637559663639004L;
    public boolean done;
    public final d downstream;
    public volatile long index;
    public final long timeout;
    public e.a.s0.b timer;
    public final TimeUnit unit;
    public e upstream;
    public final h0$c worker;

    public FlowableDebounceTimed$DebounceTimedSubscriber(d d10, long l10, TimeUnit timeUnit, h0$c h0$c) {
        this.downstream = d10;
        this.timeout = l10;
        this.unit = timeUnit;
        this.worker = h0$c;
    }

    public void cancel() {
        this.upstream.cancel();
        this.worker.dispose();
    }

    public void emit(long l10, Object object, FlowableDebounceTimed$DebounceEmitter flowableDebounceTimed$DebounceEmitter) {
        long l11 = this.index;
        long l12 = l10 - l11;
        Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object2 == false) {
            l10 = this.get();
            long l13 = l10 - (l11 = 0L);
            object2 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            if (object2 != false) {
                d d10 = this.downstream;
                d10.onNext(object);
                l10 = 1L;
                b.e(this, l10);
                flowableDebounceTimed$DebounceEmitter.dispose();
            } else {
                this.cancel();
                d d11 = this.downstream;
                object = "Could not deliver value due to lack of requests";
                MissingBackpressureException missingBackpressureException = new MissingBackpressureException((String)object);
                d11.onError(missingBackpressureException);
            }
        }
    }

    public void onComplete() {
        boolean bl2 = this.done;
        if (bl2) {
            return;
        }
        this.done = bl2 = true;
        e.a.s0.b b10 = this.timer;
        if (b10 != null) {
            b10.dispose();
        }
        if ((b10 = (FlowableDebounceTimed$DebounceEmitter)b10) != null) {
            ((FlowableDebounceTimed$DebounceEmitter)b10).emit();
        }
        this.downstream.onComplete();
        this.worker.dispose();
    }

    public void onError(Throwable throwable) {
        boolean bl2 = this.done;
        if (bl2) {
            a.Y(throwable);
            return;
        }
        this.done = bl2 = true;
        e.a.s0.b b10 = this.timer;
        if (b10 != null) {
            b10.dispose();
        }
        this.downstream.onError(throwable);
        this.worker.dispose();
    }

    public void onNext(Object object) {
        boolean bl2 = this.done;
        if (bl2) {
            return;
        }
        long l10 = this.index;
        long l11 = 1L;
        this.index = l10 += l11;
        e.a.s0.b b10 = this.timer;
        if (b10 != null) {
            b10.dispose();
        }
        this.timer = b10 = new FlowableDebounceTimed$DebounceEmitter(object, l10, this);
        object = this.worker;
        l10 = this.timeout;
        TimeUnit timeUnit = this.unit;
        object = ((h0$c)object).c((Runnable)((Object)b10), l10, timeUnit);
        ((FlowableDebounceTimed$DebounceEmitter)b10).setResource((e.a.s0.b)object);
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
}

