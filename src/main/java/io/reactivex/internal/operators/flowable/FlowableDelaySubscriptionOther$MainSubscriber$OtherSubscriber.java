/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.a1.a;
import e.a.o;
import i.g.e;
import io.reactivex.internal.operators.flowable.FlowableDelaySubscriptionOther$MainSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class FlowableDelaySubscriptionOther$MainSubscriber$OtherSubscriber
extends AtomicReference
implements o {
    private static final long serialVersionUID = -3892798459447644106L;
    public final /* synthetic */ FlowableDelaySubscriptionOther$MainSubscriber this$0;

    public FlowableDelaySubscriptionOther$MainSubscriber$OtherSubscriber(FlowableDelaySubscriptionOther$MainSubscriber mainSubscriber) {
        this.this$0 = mainSubscriber;
    }

    public void onComplete() {
        SubscriptionHelper subscriptionHelper;
        e e10 = (e)this.get();
        if (e10 != (subscriptionHelper = SubscriptionHelper.CANCELLED)) {
            e10 = this.this$0;
            ((FlowableDelaySubscriptionOther$MainSubscriber)e10).next();
        }
    }

    public void onError(Throwable throwable) {
        SubscriptionHelper subscriptionHelper;
        Object object = (e)this.get();
        if (object != (subscriptionHelper = SubscriptionHelper.CANCELLED)) {
            object = this.this$0.downstream;
            object.onError(throwable);
        } else {
            a.Y(throwable);
        }
    }

    public void onNext(Object object) {
        SubscriptionHelper subscriptionHelper;
        object = (e)this.get();
        if (object != (subscriptionHelper = SubscriptionHelper.CANCELLED)) {
            this.lazySet(subscriptionHelper);
            object.cancel();
            object = this.this$0;
            ((FlowableDelaySubscriptionOther$MainSubscriber)object).next();
        }
    }

    public void onSubscribe(e e10) {
        boolean bl2 = SubscriptionHelper.setOnce(this, e10);
        if (bl2) {
            long l10 = Long.MAX_VALUE;
            e10.request(l10);
        }
    }
}

