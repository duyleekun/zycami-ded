/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.e0;
import e.a.g0;
import e.a.w0.e.e.a;
import e.a.y0.l;
import io.reactivex.internal.operators.observable.ObservableSampleWithObservable$SampleMainEmitLast;
import io.reactivex.internal.operators.observable.ObservableSampleWithObservable$SampleMainNoLast;

public final class ObservableSampleWithObservable
extends a {
    public final e0 b;
    public final boolean c;

    public ObservableSampleWithObservable(e0 e02, e0 e03, boolean bl2) {
        super(e02);
        this.b = e03;
        this.c = bl2;
    }

    public void K5(g0 object) {
        l l10 = new l((g0)object);
        boolean bl2 = this.c;
        if (bl2) {
            object = this.a;
            e0 e02 = this.b;
            ObservableSampleWithObservable$SampleMainEmitLast observableSampleWithObservable$SampleMainEmitLast = new ObservableSampleWithObservable$SampleMainEmitLast(l10, e02);
            object.subscribe(observableSampleWithObservable$SampleMainEmitLast);
        } else {
            object = this.a;
            e0 e03 = this.b;
            ObservableSampleWithObservable$SampleMainNoLast observableSampleWithObservable$SampleMainNoLast = new ObservableSampleWithObservable$SampleMainNoLast(l10, e03);
            object.subscribe(observableSampleWithObservable$SampleMainNoLast);
        }
    }
}

