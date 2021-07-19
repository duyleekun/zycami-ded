/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.o;
import i.g.d;
import i.g.e;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;

public final class FlowableTakeLastOne$TakeLastOneSubscriber
extends DeferredScalarSubscription
implements o {
    private static final long serialVersionUID = -5467847744262967226L;
    public e upstream;

    public FlowableTakeLastOne$TakeLastOneSubscriber(d d10) {
        super(d10);
    }

    public void cancel() {
        super.cancel();
        this.upstream.cancel();
    }

    public void onComplete() {
        Object object = this.value;
        if (object != null) {
            this.complete(object);
        } else {
            object = this.downstream;
            object.onComplete();
        }
    }

    public void onError(Throwable throwable) {
        this.value = null;
        this.downstream.onError(throwable);
    }

    public void onNext(Object object) {
        this.value = object;
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
}

