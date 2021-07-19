/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import i.g.c;
import i.g.d;
import io.reactivex.internal.operators.flowable.FlowableSamplePublisher$SamplePublisherSubscriber;

public final class FlowableSamplePublisher$SampleMainNoLast
extends FlowableSamplePublisher$SamplePublisherSubscriber {
    private static final long serialVersionUID = -3029755663834015785L;

    public FlowableSamplePublisher$SampleMainNoLast(d d10, c c10) {
        super(d10, c10);
    }

    public void completion() {
        this.downstream.onComplete();
    }

    public void run() {
        this.emit();
    }
}

