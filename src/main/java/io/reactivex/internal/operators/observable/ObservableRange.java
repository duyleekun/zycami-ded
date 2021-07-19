/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.g0;
import e.a.z;
import io.reactivex.internal.operators.observable.ObservableRange$RangeDisposable;

public final class ObservableRange
extends z {
    private final int a;
    private final long b;

    public ObservableRange(int n10, int n11) {
        this.a = n10;
        long l10 = n10;
        long l11 = n11;
        this.b = l10 += l11;
    }

    public void K5(g0 g02) {
        long l10 = this.a;
        long l11 = this.b;
        ObservableRange$RangeDisposable observableRange$RangeDisposable = new ObservableRange$RangeDisposable(g02, l10, l11);
        g02.onSubscribe(observableRange$RangeDisposable);
        observableRange$RangeDisposable.run();
    }
}

