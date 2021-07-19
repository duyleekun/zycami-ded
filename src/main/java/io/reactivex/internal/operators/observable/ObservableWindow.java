/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.e0;
import e.a.g0;
import e.a.w0.e.e.a;
import io.reactivex.internal.operators.observable.ObservableWindow$WindowExactObserver;
import io.reactivex.internal.operators.observable.ObservableWindow$WindowSkipObserver;

public final class ObservableWindow
extends a {
    public final long b;
    public final long c;
    public final int d;

    public ObservableWindow(e0 e02, long l10, long l11, int n10) {
        super(e02);
        this.b = l10;
        this.c = l11;
        this.d = n10;
    }

    public void K5(g0 g02) {
        long l10 = this.b;
        long l11 = this.c;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object == false) {
            e0 e02 = this.a;
            l11 = this.b;
            int n10 = this.d;
            ObservableWindow$WindowExactObserver observableWindow$WindowExactObserver = new ObservableWindow$WindowExactObserver(g02, l11, n10);
            e02.subscribe(observableWindow$WindowExactObserver);
        } else {
            ObservableWindow$WindowSkipObserver observableWindow$WindowSkipObserver;
            e0 e03 = this.a;
            long l13 = this.b;
            long l14 = this.c;
            int n11 = this.d;
            ObservableWindow$WindowSkipObserver observableWindow$WindowSkipObserver2 = observableWindow$WindowSkipObserver;
            observableWindow$WindowSkipObserver = new ObservableWindow$WindowSkipObserver(g02, l13, l14, n11);
            e03.subscribe(observableWindow$WindowSkipObserver);
        }
    }
}

