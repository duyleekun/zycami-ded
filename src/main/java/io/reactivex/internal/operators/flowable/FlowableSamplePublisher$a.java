/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.o;
import i.g.e;
import io.reactivex.internal.operators.flowable.FlowableSamplePublisher$SamplePublisherSubscriber;

public final class FlowableSamplePublisher$a
implements o {
    public final FlowableSamplePublisher$SamplePublisherSubscriber a;

    public FlowableSamplePublisher$a(FlowableSamplePublisher$SamplePublisherSubscriber flowableSamplePublisher$SamplePublisherSubscriber) {
        this.a = flowableSamplePublisher$SamplePublisherSubscriber;
    }

    public void onComplete() {
        this.a.complete();
    }

    public void onError(Throwable throwable) {
        this.a.error(throwable);
    }

    public void onNext(Object object) {
        this.a.run();
    }

    public void onSubscribe(e e10) {
        this.a.setOther(e10);
    }
}

