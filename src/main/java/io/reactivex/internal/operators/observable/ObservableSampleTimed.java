/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.e0;
import e.a.g0;
import e.a.h0;
import e.a.w0.e.e.a;
import e.a.y0.l;
import io.reactivex.internal.operators.observable.ObservableSampleTimed$SampleTimedEmitLast;
import io.reactivex.internal.operators.observable.ObservableSampleTimed$SampleTimedNoLast;
import java.util.concurrent.TimeUnit;

public final class ObservableSampleTimed
extends a {
    public final long b;
    public final TimeUnit c;
    public final h0 d;
    public final boolean e;

    public ObservableSampleTimed(e0 e02, long l10, TimeUnit timeUnit, h0 h02, boolean bl2) {
        super(e02);
        this.b = l10;
        this.c = timeUnit;
        this.d = h02;
        this.e = bl2;
    }

    public void K5(g0 object) {
        l l10 = new l((g0)object);
        boolean bl2 = this.e;
        if (bl2) {
            object = this.a;
            long l11 = this.b;
            TimeUnit timeUnit = this.c;
            h0 h02 = this.d;
            ObservableSampleTimed$SampleTimedEmitLast observableSampleTimed$SampleTimedEmitLast = new ObservableSampleTimed$SampleTimedEmitLast(l10, l11, timeUnit, h02);
            object.subscribe(observableSampleTimed$SampleTimedEmitLast);
        } else {
            object = this.a;
            long l12 = this.b;
            TimeUnit timeUnit = this.c;
            h0 h03 = this.d;
            ObservableSampleTimed$SampleTimedNoLast observableSampleTimed$SampleTimedNoLast = new ObservableSampleTimed$SampleTimedNoLast(l10, l12, timeUnit, h03);
            object.subscribe(observableSampleTimed$SampleTimedNoLast);
        }
    }
}

