/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import i.g.c;
import i.g.d;
import io.reactivex.internal.operators.flowable.FlowablePublish$InnerSubscriber;
import io.reactivex.internal.operators.flowable.FlowablePublish$PublishSubscriber;
import java.util.concurrent.atomic.AtomicReference;

public final class FlowablePublish$a
implements c {
    private final AtomicReference a;
    private final int b;

    public FlowablePublish$a(AtomicReference atomicReference, int n10) {
        this.a = atomicReference;
        this.b = n10;
    }

    public void subscribe(d d10) {
        long l10;
        Object object;
        FlowablePublish$InnerSubscriber flowablePublish$InnerSubscriber = new FlowablePublish$InnerSubscriber(d10);
        d10.onSubscribe(flowablePublish$InnerSubscriber);
        while (true) {
            if ((d10 = (FlowablePublish$PublishSubscriber)this.a.get()) == null || (object = ((FlowablePublish$PublishSubscriber)d10).isDisposed())) {
                AtomicReference atomicReference = this.a;
                atomicReference = this.a;
                int n10 = this.b;
                FlowablePublish$PublishSubscriber flowablePublish$PublishSubscriber = new FlowablePublish$PublishSubscriber(atomicReference, n10);
                boolean bl2 = atomicReference.compareAndSet(d10, flowablePublish$PublishSubscriber);
                if (!bl2) continue;
                d10 = flowablePublish$PublishSubscriber;
            }
            if (object = ((FlowablePublish$PublishSubscriber)d10).add(flowablePublish$InnerSubscriber)) break;
        }
        long l11 = flowablePublish$InnerSubscriber.get();
        long l12 = l11 - (l10 = Long.MIN_VALUE);
        object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (!object) {
            ((FlowablePublish$PublishSubscriber)d10).remove(flowablePublish$InnerSubscriber);
        } else {
            flowablePublish$InnerSubscriber.parent = d10;
        }
        ((FlowablePublish$PublishSubscriber)d10).dispatch();
    }
}

