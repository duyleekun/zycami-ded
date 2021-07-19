/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.a1.a;
import e.a.h0;
import e.a.o;
import i.g.d;
import i.g.e;
import io.reactivex.internal.operators.flowable.FlowableUnsubscribeOn$UnsubscribeSubscriber$a;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;

public final class FlowableUnsubscribeOn$UnsubscribeSubscriber
extends AtomicBoolean
implements o,
e {
    private static final long serialVersionUID = 1015244841293359600L;
    public final d downstream;
    public final h0 scheduler;
    public e upstream;

    public FlowableUnsubscribeOn$UnsubscribeSubscriber(d d10, h0 h02) {
        this.downstream = d10;
        this.scheduler = h02;
    }

    public void cancel() {
        h0 h02 = null;
        boolean bl2 = true;
        boolean bl3 = this.compareAndSet(false, bl2);
        if (bl3) {
            h02 = this.scheduler;
            FlowableUnsubscribeOn$UnsubscribeSubscriber$a flowableUnsubscribeOn$UnsubscribeSubscriber$a = new FlowableUnsubscribeOn$UnsubscribeSubscriber$a(this);
            h02.e(flowableUnsubscribeOn$UnsubscribeSubscriber$a);
        }
    }

    public void onComplete() {
        boolean bl2 = this.get();
        if (!bl2) {
            d d10 = this.downstream;
            d10.onComplete();
        }
    }

    public void onError(Throwable throwable) {
        boolean bl2 = this.get();
        if (bl2) {
            a.Y(throwable);
            return;
        }
        this.downstream.onError(throwable);
    }

    public void onNext(Object object) {
        boolean bl2 = this.get();
        if (!bl2) {
            d d10 = this.downstream;
            d10.onNext(object);
        }
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
        this.upstream.request(l10);
    }
}

