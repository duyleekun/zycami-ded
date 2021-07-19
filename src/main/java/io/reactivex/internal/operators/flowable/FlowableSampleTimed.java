/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.e1.e;
import e.a.h0;
import e.a.j;
import e.a.w0.e.b.a;
import i.g.d;
import io.reactivex.internal.operators.flowable.FlowableSampleTimed$SampleTimedEmitLast;
import io.reactivex.internal.operators.flowable.FlowableSampleTimed$SampleTimedNoLast;
import java.util.concurrent.TimeUnit;

public final class FlowableSampleTimed
extends a {
    public final long c;
    public final TimeUnit d;
    public final h0 e;
    public final boolean f;

    public FlowableSampleTimed(j j10, long l10, TimeUnit timeUnit, h0 h02, boolean bl2) {
        super(j10);
        this.c = l10;
        this.d = timeUnit;
        this.e = h02;
        this.f = bl2;
    }

    public void m6(d object) {
        e e10 = new e((d)object);
        boolean bl2 = this.f;
        if (bl2) {
            object = this.b;
            long l10 = this.c;
            TimeUnit timeUnit = this.d;
            h0 h02 = this.e;
            FlowableSampleTimed$SampleTimedEmitLast flowableSampleTimed$SampleTimedEmitLast = new FlowableSampleTimed$SampleTimedEmitLast(e10, l10, timeUnit, h02);
            ((j)object).l6(flowableSampleTimed$SampleTimedEmitLast);
        } else {
            object = this.b;
            long l11 = this.c;
            TimeUnit timeUnit = this.d;
            h0 h03 = this.e;
            FlowableSampleTimed$SampleTimedNoLast flowableSampleTimed$SampleTimedNoLast = new FlowableSampleTimed$SampleTimedNoLast(e10, l11, timeUnit, h03);
            ((j)object).l6(flowableSampleTimed$SampleTimedNoLast);
        }
    }
}

