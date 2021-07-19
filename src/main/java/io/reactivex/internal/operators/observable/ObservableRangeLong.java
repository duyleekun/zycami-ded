/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.g0;
import e.a.z;
import io.reactivex.internal.operators.observable.ObservableRangeLong$RangeDisposable;

public final class ObservableRangeLong
extends z {
    private final long a;
    private final long b;

    public ObservableRangeLong(long l10, long l11) {
        this.a = l10;
        this.b = l11;
    }

    public void K5(g0 g02) {
        long l10 = this.a;
        long l11 = this.b;
        long l12 = l10 + l11;
        ObservableRangeLong$RangeDisposable observableRangeLong$RangeDisposable = new ObservableRangeLong$RangeDisposable(g02, l10, l12);
        g02.onSubscribe(observableRangeLong$RangeDisposable);
        observableRangeLong$RangeDisposable.run();
    }
}

