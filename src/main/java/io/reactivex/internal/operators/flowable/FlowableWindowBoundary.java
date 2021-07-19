/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.j;
import e.a.w0.e.b.a;
import i.g.c;
import i.g.d;
import io.reactivex.internal.operators.flowable.FlowableWindowBoundary$WindowBoundaryMainSubscriber;
import io.reactivex.internal.operators.flowable.FlowableWindowBoundary$a;

public final class FlowableWindowBoundary
extends a {
    public final c c;
    public final int d;

    public FlowableWindowBoundary(j j10, c c10, int n10) {
        super(j10);
        this.c = c10;
        this.d = n10;
    }

    public void m6(d object) {
        int n10 = this.d;
        FlowableWindowBoundary$WindowBoundaryMainSubscriber flowableWindowBoundary$WindowBoundaryMainSubscriber = new FlowableWindowBoundary$WindowBoundaryMainSubscriber((d)object, n10);
        object.onSubscribe(flowableWindowBoundary$WindowBoundaryMainSubscriber);
        flowableWindowBoundary$WindowBoundaryMainSubscriber.innerNext();
        object = this.c;
        FlowableWindowBoundary$a flowableWindowBoundary$a = flowableWindowBoundary$WindowBoundaryMainSubscriber.boundarySubscriber;
        object.subscribe(flowableWindowBoundary$a);
        this.b.l6(flowableWindowBoundary$WindowBoundaryMainSubscriber);
    }
}

