/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.o;
import e.a.w0.i.g;
import i.g.d;
import i.g.e;
import io.reactivex.internal.operators.flowable.FlowableSkipUntil$SkipUntilMainSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicReference;

public final class FlowableSkipUntil$SkipUntilMainSubscriber$OtherSubscriber
extends AtomicReference
implements o {
    private static final long serialVersionUID = -5592042965931999169L;
    public final /* synthetic */ FlowableSkipUntil$SkipUntilMainSubscriber this$0;

    public FlowableSkipUntil$SkipUntilMainSubscriber$OtherSubscriber(FlowableSkipUntil$SkipUntilMainSubscriber skipUntilMainSubscriber) {
        this.this$0 = skipUntilMainSubscriber;
    }

    public void onComplete() {
        this.this$0.gate = true;
    }

    public void onError(Throwable throwable) {
        SubscriptionHelper.cancel(this.this$0.upstream);
        FlowableSkipUntil$SkipUntilMainSubscriber flowableSkipUntil$SkipUntilMainSubscriber = this.this$0;
        d d10 = flowableSkipUntil$SkipUntilMainSubscriber.downstream;
        AtomicThrowable atomicThrowable = flowableSkipUntil$SkipUntilMainSubscriber.error;
        g.d(d10, throwable, flowableSkipUntil$SkipUntilMainSubscriber, atomicThrowable);
    }

    public void onNext(Object object) {
        this.this$0.gate = true;
        ((e)this.get()).cancel();
    }

    public void onSubscribe(e e10) {
        SubscriptionHelper.setOnce(this, e10, Long.MAX_VALUE);
    }
}

