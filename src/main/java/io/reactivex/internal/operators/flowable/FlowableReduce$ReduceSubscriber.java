/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.a1.a;
import e.a.o;
import e.a.v0.c;
import i.g.d;
import i.g.e;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;

public final class FlowableReduce$ReduceSubscriber
extends DeferredScalarSubscription
implements o {
    private static final long serialVersionUID = -4663883003264602070L;
    public final c reducer;
    public e upstream;

    public FlowableReduce$ReduceSubscriber(d d10, c c10) {
        super(d10);
        this.reducer = c10;
    }

    public void cancel() {
        super.cancel();
        this.upstream.cancel();
        SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
        this.upstream = subscriptionHelper;
    }

    public void onComplete() {
        Object object = this.upstream;
        SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
        if (object == subscriptionHelper) {
            return;
        }
        this.upstream = subscriptionHelper;
        object = this.value;
        if (object != null) {
            this.complete(object);
        } else {
            object = this.downstream;
            object.onComplete();
        }
    }

    public void onError(Throwable throwable) {
        e e10 = this.upstream;
        SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
        if (e10 == subscriptionHelper) {
            a.Y(throwable);
            return;
        }
        this.upstream = subscriptionHelper;
        this.downstream.onError(throwable);
    }

    public void onNext(Object object) {
        Object object2 = this.upstream;
        Object object3 = SubscriptionHelper.CANCELLED;
        if (object2 == object3) {
            return;
        }
        object2 = this.value;
        if (object2 == null) {
            this.value = object;
        } else {
            object3 = this.reducer;
            object = object3.apply(object2, object);
            object2 = "The reducer returned a null value";
            object = e.a.w0.b.a.g(object, (String)object2);
            try {
                this.value = object;
            }
            catch (Throwable throwable) {
                e.a.t0.a.b(throwable);
                object2 = this.upstream;
                object2.cancel();
                this.onError(throwable);
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
}

