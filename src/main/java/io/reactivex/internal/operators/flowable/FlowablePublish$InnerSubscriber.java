/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.w0.i.b;
import i.g.d;
import i.g.e;
import io.reactivex.internal.operators.flowable.FlowablePublish$PublishSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;

public final class FlowablePublish$InnerSubscriber
extends AtomicLong
implements e {
    private static final long serialVersionUID = -4453897557930727610L;
    public final d child;
    public long emitted;
    public volatile FlowablePublish$PublishSubscriber parent;

    public FlowablePublish$InnerSubscriber(d d10) {
        this.child = d10;
    }

    public void cancel() {
        FlowablePublish$PublishSubscriber flowablePublish$PublishSubscriber;
        long l10;
        long l11;
        long l12 = this.get();
        long l13 = l12 - (l11 = Long.MIN_VALUE);
        Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object != false && (object = (l10 = (l12 = this.getAndSet(l11)) - l11) == 0L ? 0 : (l10 < 0L ? -1 : 1)) != false && (flowablePublish$PublishSubscriber = this.parent) != null) {
            flowablePublish$PublishSubscriber.remove(this);
            flowablePublish$PublishSubscriber.dispatch();
        }
    }

    public void request(long l10) {
        boolean bl2 = SubscriptionHelper.validate(l10);
        if (bl2) {
            b.b(this, l10);
            FlowablePublish$PublishSubscriber flowablePublish$PublishSubscriber = this.parent;
            if (flowablePublish$PublishSubscriber != null) {
                flowablePublish$PublishSubscriber.dispatch();
            }
        }
    }
}

