/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.w0.i.b;
import i.g.d;
import i.g.e;
import io.reactivex.internal.operators.flowable.FlowablePublishMulticast$a;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;

public final class FlowablePublishMulticast$MulticastSubscription
extends AtomicLong
implements e {
    private static final long serialVersionUID = 8664815189257569791L;
    public final d downstream;
    public long emitted;
    public final FlowablePublishMulticast$a parent;

    public FlowablePublishMulticast$MulticastSubscription(d d10, FlowablePublishMulticast$a a10) {
        this.downstream = d10;
        this.parent = a10;
    }

    public void cancel() {
        long l10 = Long.MIN_VALUE;
        long l11 = this.getAndSet(l10);
        long l12 = l11 - l10;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object != false) {
            this.parent.O8(this);
            FlowablePublishMulticast$a flowablePublishMulticast$a = this.parent;
            flowablePublishMulticast$a.M8();
        }
    }

    public boolean isCancelled() {
        long l10;
        long l11 = this.get();
        long l12 = l11 - (l10 = Long.MIN_VALUE);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        object = object == false ? (Object)1 : (Object)0;
        return (boolean)object;
    }

    public void request(long l10) {
        boolean bl2 = SubscriptionHelper.validate(l10);
        if (bl2) {
            b.b(this, l10);
            FlowablePublishMulticast$a flowablePublishMulticast$a = this.parent;
            flowablePublishMulticast$a.M8();
        }
    }
}

