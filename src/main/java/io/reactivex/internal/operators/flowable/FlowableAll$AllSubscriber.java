/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.a1.a;
import e.a.o;
import e.a.v0.r;
import i.g.d;
import i.g.e;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;

public final class FlowableAll$AllSubscriber
extends DeferredScalarSubscription
implements o {
    private static final long serialVersionUID = -3521127104134758517L;
    public boolean done;
    public final r predicate;
    public e upstream;

    public FlowableAll$AllSubscriber(d d10, r r10) {
        super(d10);
        this.predicate = r10;
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
        Boolean bl3 = Boolean.TRUE;
        this.complete(bl3);
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
        r r10;
        boolean bl2 = this.done;
        if (bl2) {
            return;
        }
        try {
            r10 = this.predicate;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            this.upstream.cancel();
            this.onError(throwable);
            return;
        }
        boolean bl3 = r10.test(object);
        if (!bl3) {
            this.done = bl3 = true;
            this.upstream.cancel();
            object = Boolean.FALSE;
            this.complete(object);
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

