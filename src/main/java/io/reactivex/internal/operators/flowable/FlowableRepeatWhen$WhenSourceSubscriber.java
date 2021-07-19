/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.b1.a;
import e.a.o;
import i.g.d;
import i.g.e;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;

public abstract class FlowableRepeatWhen$WhenSourceSubscriber
extends SubscriptionArbiter
implements o {
    private static final long serialVersionUID = -5604623027276966720L;
    public final d downstream;
    public final a processor;
    private long produced;
    public final e receiver;

    public FlowableRepeatWhen$WhenSourceSubscriber(d d10, a a10, e e10) {
        super(false);
        this.downstream = d10;
        this.processor = a10;
        this.receiver = e10;
    }

    public final void again(Object object) {
        EmptySubscription emptySubscription = EmptySubscription.INSTANCE;
        this.setSubscription(emptySubscription);
        long l10 = this.produced;
        long l11 = 0L;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (l12 != false) {
            this.produced = l11;
            this.produced(l10);
        }
        this.receiver.request(1L);
        this.processor.onNext(object);
    }

    public final void cancel() {
        super.cancel();
        this.receiver.cancel();
    }

    public final void onNext(Object object) {
        long l10;
        this.produced = l10 = this.produced + 1L;
        this.downstream.onNext(object);
    }

    public final void onSubscribe(e e10) {
        this.setSubscription(e10);
    }
}

