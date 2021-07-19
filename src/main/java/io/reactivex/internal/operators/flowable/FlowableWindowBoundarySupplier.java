/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.j;
import e.a.w0.e.b.a;
import i.g.d;
import io.reactivex.internal.operators.flowable.FlowableWindowBoundarySupplier$WindowBoundaryMainSubscriber;
import java.util.concurrent.Callable;

public final class FlowableWindowBoundarySupplier
extends a {
    public final Callable c;
    public final int d;

    public FlowableWindowBoundarySupplier(j j10, Callable callable, int n10) {
        super(j10);
        this.c = callable;
        this.d = n10;
    }

    public void m6(d d10) {
        int n10 = this.d;
        Callable callable = this.c;
        FlowableWindowBoundarySupplier$WindowBoundaryMainSubscriber flowableWindowBoundarySupplier$WindowBoundaryMainSubscriber = new FlowableWindowBoundarySupplier$WindowBoundaryMainSubscriber(d10, n10, callable);
        this.b.l6(flowableWindowBoundarySupplier$WindowBoundaryMainSubscriber);
    }
}

