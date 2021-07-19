/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.o;
import e.a.w0.i.b;
import i.g.c;
import i.g.d;
import i.g.e;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.operators.flowable.FlowableSamplePublisher$a;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public abstract class FlowableSamplePublisher$SamplePublisherSubscriber
extends AtomicReference
implements o,
e {
    private static final long serialVersionUID = -3517602651313910099L;
    public final d downstream;
    public final AtomicReference other;
    public final AtomicLong requested;
    public final c sampler;
    public e upstream;

    public FlowableSamplePublisher$SamplePublisherSubscriber(d d10, c c10) {
        Serializable serializable;
        this.requested = serializable = new AtomicLong();
        this.other = serializable;
        this.downstream = d10;
        this.sampler = c10;
    }

    public void cancel() {
        SubscriptionHelper.cancel(this.other);
        this.upstream.cancel();
    }

    public void complete() {
        this.upstream.cancel();
        this.completion();
    }

    public abstract void completion();

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

    public void error(Throwable throwable) {
        this.upstream.cancel();
        this.downstream.onError(throwable);
    }

    public void onComplete() {
        SubscriptionHelper.cancel(this.other);
        this.completion();
    }

    public void onError(Throwable throwable) {
        SubscriptionHelper.cancel(this.other);
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
            object = this.other.get();
            if (object == null) {
                object = this.sampler;
                FlowableSamplePublisher$a flowableSamplePublisher$a = new FlowableSamplePublisher$a(this);
                object.subscribe(flowableSamplePublisher$a);
                long l10 = Long.MAX_VALUE;
                e10.request(l10);
            }
        }
    }

    public void request(long l10) {
        boolean bl2 = SubscriptionHelper.validate(l10);
        if (bl2) {
            AtomicLong atomicLong = this.requested;
            b.a(atomicLong, l10);
        }
    }

    public abstract void run();

    public void setOther(e e10) {
        SubscriptionHelper.setOnce(this.other, e10, Long.MAX_VALUE);
    }
}

