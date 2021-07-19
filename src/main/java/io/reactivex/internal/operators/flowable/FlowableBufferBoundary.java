/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.j;
import e.a.v0.o;
import e.a.w0.e.b.a;
import i.g.c;
import i.g.d;
import io.reactivex.internal.operators.flowable.FlowableBufferBoundary$BufferBoundarySubscriber;
import java.util.concurrent.Callable;

public final class FlowableBufferBoundary
extends a {
    public final Callable c;
    public final c d;
    public final o e;

    public FlowableBufferBoundary(j j10, c c10, o o10, Callable callable) {
        super(j10);
        this.d = c10;
        this.e = o10;
        this.c = callable;
    }

    public void m6(d d10) {
        c c10 = this.d;
        o o10 = this.e;
        Callable callable = this.c;
        FlowableBufferBoundary$BufferBoundarySubscriber flowableBufferBoundary$BufferBoundarySubscriber = new FlowableBufferBoundary$BufferBoundarySubscriber(d10, c10, o10, callable);
        d10.onSubscribe(flowableBufferBoundary$BufferBoundarySubscriber);
        this.b.l6(flowableBufferBoundary$BufferBoundarySubscriber);
    }
}

