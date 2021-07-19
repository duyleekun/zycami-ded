/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.subscribers;

import e.a.o;
import i.g.d;
import i.g.e;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;

public abstract class DeferredScalarSubscriber
extends DeferredScalarSubscription
implements o {
    private static final long serialVersionUID = 2984505488220891551L;
    public boolean hasValue;
    public e upstream;

    public DeferredScalarSubscriber(d d10) {
        super(d10);
    }

    public void cancel() {
        super.cancel();
        this.upstream.cancel();
    }

    public void onComplete() {
        boolean bl2 = this.hasValue;
        if (bl2) {
            Object object = this.value;
            this.complete(object);
        } else {
            d d10 = this.downstream;
            d10.onComplete();
        }
    }

    public void onError(Throwable throwable) {
        this.value = null;
        this.downstream.onError(throwable);
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

