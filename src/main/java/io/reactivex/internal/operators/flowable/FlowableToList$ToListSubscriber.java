/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.o;
import i.g.d;
import i.g.e;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.Collection;

public final class FlowableToList$ToListSubscriber
extends DeferredScalarSubscription
implements o,
e {
    private static final long serialVersionUID = -8134157938864266736L;
    public e upstream;

    public FlowableToList$ToListSubscriber(d d10, Collection collection) {
        super(d10);
        this.value = collection;
    }

    public void cancel() {
        super.cancel();
        this.upstream.cancel();
    }

    public void onComplete() {
        Object object = this.value;
        this.complete(object);
    }

    public void onError(Throwable throwable) {
        this.value = null;
        this.downstream.onError(throwable);
    }

    public void onNext(Object object) {
        Collection collection = (Collection)this.value;
        if (collection != null) {
            collection.add(object);
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
}

