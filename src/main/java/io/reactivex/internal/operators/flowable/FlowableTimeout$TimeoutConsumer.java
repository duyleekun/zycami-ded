/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.a1.a;
import e.a.o;
import e.a.s0.b;
import i.g.e;
import io.reactivex.internal.operators.flowable.FlowableTimeout$a;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class FlowableTimeout$TimeoutConsumer
extends AtomicReference
implements o,
b {
    private static final long serialVersionUID = 8708641127342403073L;
    public final long idx;
    public final FlowableTimeout$a parent;

    public FlowableTimeout$TimeoutConsumer(long l10, FlowableTimeout$a flowableTimeout$a) {
        this.idx = l10;
        this.parent = flowableTimeout$a;
    }

    public void dispose() {
        SubscriptionHelper.cancel(this);
    }

    public boolean isDisposed() {
        boolean bl2;
        SubscriptionHelper subscriptionHelper;
        Object v10 = this.get();
        if (v10 == (subscriptionHelper = SubscriptionHelper.CANCELLED)) {
            bl2 = true;
        } else {
            bl2 = false;
            v10 = null;
        }
        return bl2;
    }

    public void onComplete() {
        SubscriptionHelper subscriptionHelper;
        Object object = this.get();
        if (object != (subscriptionHelper = SubscriptionHelper.CANCELLED)) {
            this.lazySet(subscriptionHelper);
            object = this.parent;
            long l10 = this.idx;
            object.onTimeout(l10);
        }
    }

    public void onError(Throwable throwable) {
        SubscriptionHelper subscriptionHelper;
        Object object = this.get();
        if (object != (subscriptionHelper = SubscriptionHelper.CANCELLED)) {
            this.lazySet(subscriptionHelper);
            object = this.parent;
            long l10 = this.idx;
            object.onTimeoutError(l10, throwable);
        } else {
            a.Y(throwable);
        }
    }

    public void onNext(Object object) {
        SubscriptionHelper subscriptionHelper;
        object = (e)this.get();
        if (object != (subscriptionHelper = SubscriptionHelper.CANCELLED)) {
            object.cancel();
            this.lazySet(subscriptionHelper);
            object = this.parent;
            long l10 = this.idx;
            object.onTimeout(l10);
        }
    }

    public void onSubscribe(e e10) {
        SubscriptionHelper.setOnce(this, e10, Long.MAX_VALUE);
    }
}

