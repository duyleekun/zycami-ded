/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.o;
import e.a.s0.b;
import i.g.e;
import io.reactivex.internal.operators.flowable.FlowableGroupJoin$a;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class FlowableGroupJoin$LeftRightEndSubscriber
extends AtomicReference
implements o,
b {
    private static final long serialVersionUID = 1883890389173668373L;
    public final int index;
    public final boolean isLeft;
    public final FlowableGroupJoin$a parent;

    public FlowableGroupJoin$LeftRightEndSubscriber(FlowableGroupJoin$a flowableGroupJoin$a, boolean bl2, int n10) {
        this.parent = flowableGroupJoin$a;
        this.isLeft = bl2;
        this.index = n10;
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
        FlowableGroupJoin$a flowableGroupJoin$a = this.parent;
        boolean bl2 = this.isLeft;
        flowableGroupJoin$a.innerClose(bl2, this);
    }

    public void onError(Throwable throwable) {
        this.parent.innerCloseError(throwable);
    }

    public void onNext(Object object) {
        boolean bl2 = SubscriptionHelper.cancel(this);
        if (bl2) {
            object = this.parent;
            boolean bl3 = this.isLeft;
            object.innerClose(bl3, this);
        }
    }

    public void onSubscribe(e e10) {
        SubscriptionHelper.setOnce(this, e10, Long.MAX_VALUE);
    }
}

