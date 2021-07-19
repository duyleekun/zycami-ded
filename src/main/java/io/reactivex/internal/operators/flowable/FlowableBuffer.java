/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.j;
import e.a.w0.e.b.a;
import i.g.d;
import io.reactivex.internal.operators.flowable.FlowableBuffer$PublisherBufferOverlappingSubscriber;
import io.reactivex.internal.operators.flowable.FlowableBuffer$PublisherBufferSkipSubscriber;
import io.reactivex.internal.operators.flowable.FlowableBuffer$a;
import java.util.concurrent.Callable;

public final class FlowableBuffer
extends a {
    public final int c;
    public final int d;
    public final Callable e;

    public FlowableBuffer(j j10, int n10, int n11, Callable callable) {
        super(j10);
        this.c = n10;
        this.d = n11;
        this.e = callable;
    }

    public void m6(d d10) {
        int n10 = this.c;
        int n11 = this.d;
        if (n10 == n11) {
            j j10 = this.b;
            Callable callable = this.e;
            FlowableBuffer$a flowableBuffer$a = new FlowableBuffer$a(d10, n10, callable);
            j10.l6(flowableBuffer$a);
        } else if (n11 > n10) {
            j j11 = this.b;
            int n12 = this.c;
            int n13 = this.d;
            Callable callable = this.e;
            FlowableBuffer$PublisherBufferSkipSubscriber flowableBuffer$PublisherBufferSkipSubscriber = new FlowableBuffer$PublisherBufferSkipSubscriber(d10, n12, n13, callable);
            j11.l6(flowableBuffer$PublisherBufferSkipSubscriber);
        } else {
            j j12 = this.b;
            int n14 = this.c;
            int n15 = this.d;
            Callable callable = this.e;
            FlowableBuffer$PublisherBufferOverlappingSubscriber flowableBuffer$PublisherBufferOverlappingSubscriber = new FlowableBuffer$PublisherBufferOverlappingSubscriber(d10, n14, n15, callable);
            j12.l6(flowableBuffer$PublisherBufferOverlappingSubscriber);
        }
    }
}

