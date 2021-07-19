/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.e1.e;
import e.a.j;
import i.g.c;
import i.g.d;
import io.reactivex.internal.operators.flowable.FlowableSamplePublisher$SampleMainEmitLast;
import io.reactivex.internal.operators.flowable.FlowableSamplePublisher$SampleMainNoLast;

public final class FlowableSamplePublisher
extends j {
    public final c b;
    public final c c;
    public final boolean d;

    public FlowableSamplePublisher(c c10, c c11, boolean bl2) {
        this.b = c10;
        this.c = c11;
        this.d = bl2;
    }

    public void m6(d object) {
        e e10 = new e((d)object);
        boolean bl2 = this.d;
        if (bl2) {
            object = this.b;
            c c10 = this.c;
            FlowableSamplePublisher$SampleMainEmitLast flowableSamplePublisher$SampleMainEmitLast = new FlowableSamplePublisher$SampleMainEmitLast(e10, c10);
            object.subscribe(flowableSamplePublisher$SampleMainEmitLast);
        } else {
            object = this.b;
            c c11 = this.c;
            FlowableSamplePublisher$SampleMainNoLast flowableSamplePublisher$SampleMainNoLast = new FlowableSamplePublisher$SampleMainNoLast(e10, c11);
            object.subscribe(flowableSamplePublisher$SampleMainNoLast);
        }
    }
}

