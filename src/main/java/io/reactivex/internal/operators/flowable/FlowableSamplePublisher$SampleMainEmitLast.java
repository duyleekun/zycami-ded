/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import i.g.c;
import i.g.d;
import io.reactivex.internal.operators.flowable.FlowableSamplePublisher$SamplePublisherSubscriber;
import java.util.concurrent.atomic.AtomicInteger;

public final class FlowableSamplePublisher$SampleMainEmitLast
extends FlowableSamplePublisher$SamplePublisherSubscriber {
    private static final long serialVersionUID = -3029755663834015785L;
    public volatile boolean done;
    public final AtomicInteger wip;

    public FlowableSamplePublisher$SampleMainEmitLast(d object, c c10) {
        super((d)object, c10);
        this.wip = object = new AtomicInteger();
    }

    public void completion() {
        this.done = true;
        Object object = this.wip;
        int n10 = ((AtomicInteger)object).getAndIncrement();
        if (n10 == 0) {
            this.emit();
            object = this.downstream;
            object.onComplete();
        }
    }

    public void run() {
        AtomicInteger atomicInteger = this.wip;
        int n10 = atomicInteger.getAndIncrement();
        if (n10 == 0) {
            do {
                n10 = (int)(this.done ? 1 : 0);
                this.emit();
                if (n10 == 0) continue;
                this.downstream.onComplete();
                return;
            } while ((n10 = (atomicInteger = this.wip).decrementAndGet()) != 0);
        }
    }
}

