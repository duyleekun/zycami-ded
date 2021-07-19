/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.w0.i.b;
import i.g.d;
import i.g.e;
import io.reactivex.internal.operators.flowable.FlowablePublishAlt$PublishConnection;
import java.util.concurrent.atomic.AtomicLong;

public final class FlowablePublishAlt$InnerSubscription
extends AtomicLong
implements e {
    private static final long serialVersionUID = 2845000326761540265L;
    public final d downstream;
    public long emitted;
    public final FlowablePublishAlt$PublishConnection parent;

    public FlowablePublishAlt$InnerSubscription(d d10, FlowablePublishAlt$PublishConnection publishConnection) {
        this.downstream = d10;
        this.parent = publishConnection;
    }

    public void cancel() {
        long l10 = Long.MIN_VALUE;
        long l11 = this.getAndSet(l10);
        long l12 = l11 - l10;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object != false) {
            this.parent.remove(this);
            FlowablePublishAlt$PublishConnection flowablePublishAlt$PublishConnection = this.parent;
            flowablePublishAlt$PublishConnection.drain();
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
        b.b(this, l10);
        this.parent.drain();
    }
}

