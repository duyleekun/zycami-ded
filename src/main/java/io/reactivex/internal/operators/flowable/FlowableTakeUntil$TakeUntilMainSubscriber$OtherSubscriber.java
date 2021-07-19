/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.o;
import e.a.w0.i.g;
import i.g.d;
import i.g.e;
import io.reactivex.internal.operators.flowable.FlowableTakeUntil$TakeUntilMainSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicReference;

public final class FlowableTakeUntil$TakeUntilMainSubscriber$OtherSubscriber
extends AtomicReference
implements o {
    private static final long serialVersionUID = -3592821756711087922L;
    public final /* synthetic */ FlowableTakeUntil$TakeUntilMainSubscriber this$0;

    public FlowableTakeUntil$TakeUntilMainSubscriber$OtherSubscriber(FlowableTakeUntil$TakeUntilMainSubscriber takeUntilMainSubscriber) {
        this.this$0 = takeUntilMainSubscriber;
    }

    public void onComplete() {
        SubscriptionHelper.cancel(this.this$0.upstream);
        FlowableTakeUntil$TakeUntilMainSubscriber flowableTakeUntil$TakeUntilMainSubscriber = this.this$0;
        d d10 = flowableTakeUntil$TakeUntilMainSubscriber.downstream;
        AtomicThrowable atomicThrowable = flowableTakeUntil$TakeUntilMainSubscriber.error;
        g.b(d10, flowableTakeUntil$TakeUntilMainSubscriber, atomicThrowable);
    }

    public void onError(Throwable throwable) {
        SubscriptionHelper.cancel(this.this$0.upstream);
        FlowableTakeUntil$TakeUntilMainSubscriber flowableTakeUntil$TakeUntilMainSubscriber = this.this$0;
        d d10 = flowableTakeUntil$TakeUntilMainSubscriber.downstream;
        AtomicThrowable atomicThrowable = flowableTakeUntil$TakeUntilMainSubscriber.error;
        g.d(d10, throwable, flowableTakeUntil$TakeUntilMainSubscriber, atomicThrowable);
    }

    public void onNext(Object object) {
        SubscriptionHelper.cancel(this);
        this.onComplete();
    }

    public void onSubscribe(e e10) {
        SubscriptionHelper.setOnce(this, e10, Long.MAX_VALUE);
    }
}

