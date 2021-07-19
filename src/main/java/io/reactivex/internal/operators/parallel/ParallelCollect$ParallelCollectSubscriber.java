/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.parallel;

import e.a.a1.a;
import e.a.v0.b;
import i.g.d;
import i.g.e;
import io.reactivex.internal.subscribers.DeferredScalarSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;

public final class ParallelCollect$ParallelCollectSubscriber
extends DeferredScalarSubscriber {
    private static final long serialVersionUID = -4767392946044436228L;
    public Object collection;
    public final b collector;
    public boolean done;

    public ParallelCollect$ParallelCollectSubscriber(d d10, Object object, b b10) {
        super(d10);
        this.collection = object;
        this.collector = b10;
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
        Object object = this.collection;
        this.collection = null;
        this.complete(object);
    }

    public void onError(Throwable throwable) {
        boolean bl2 = this.done;
        if (bl2) {
            a.Y(throwable);
            return;
        }
        this.done = true;
        this.collection = null;
        this.downstream.onError(throwable);
    }

    public void onNext(Object object) {
        boolean bl2 = this.done;
        if (bl2) {
            return;
        }
        b b10 = this.collector;
        Object object2 = this.collection;
        try {
            b10.accept(object2, object);
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            this.cancel();
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

