/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.a1.a;
import e.a.o;
import e.a.v0.b;
import i.g.d;
import i.g.e;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;

public final class FlowableCollect$CollectSubscriber
extends DeferredScalarSubscription
implements o {
    private static final long serialVersionUID = -3589550218733891694L;
    public final b collector;
    public boolean done;
    public final Object u;
    public e upstream;

    public FlowableCollect$CollectSubscriber(d d10, Object object, b b10) {
        super(d10);
        this.collector = b10;
        this.u = object;
    }

    public void cancel() {
        super.cancel();
        this.upstream.cancel();
    }

    public void onComplete() {
        boolean bl2 = this.done;
        if (bl2) {
            return;
        }
        this.done = true;
        Object object = this.u;
        this.complete(object);
    }

    public void onError(Throwable throwable) {
        boolean bl2 = this.done;
        if (bl2) {
            a.Y(throwable);
            return;
        }
        this.done = true;
        this.downstream.onError(throwable);
    }

    public void onNext(Object object) {
        boolean bl2 = this.done;
        if (bl2) {
            return;
        }
        Object object2 = this.collector;
        Object object3 = this.u;
        try {
            object2.accept(object3, object);
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            object2 = this.upstream;
            object2.cancel();
            this.onError(throwable);
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

