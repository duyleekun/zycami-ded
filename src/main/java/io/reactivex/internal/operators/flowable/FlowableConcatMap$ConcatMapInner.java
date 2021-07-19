/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.o;
import i.g.e;
import io.reactivex.internal.operators.flowable.FlowableConcatMap$b;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;

public final class FlowableConcatMap$ConcatMapInner
extends SubscriptionArbiter
implements o {
    private static final long serialVersionUID = 897683679971470653L;
    public final FlowableConcatMap$b parent;
    public long produced;

    public FlowableConcatMap$ConcatMapInner(FlowableConcatMap$b flowableConcatMap$b) {
        super(false);
        this.parent = flowableConcatMap$b;
    }

    public void onComplete() {
        long l10 = this.produced;
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object != false) {
            this.produced = l11;
            this.produced(l10);
        }
        this.parent.innerComplete();
    }

    public void onError(Throwable throwable) {
        long l10 = this.produced;
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object != false) {
            this.produced = l11;
            this.produced(l10);
        }
        this.parent.innerError(throwable);
    }

    public void onNext(Object object) {
        long l10;
        this.produced = l10 = this.produced + 1L;
        this.parent.innerNext(object);
    }

    public void onSubscribe(e e10) {
        this.setSubscription(e10);
    }
}

