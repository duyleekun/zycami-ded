/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.internal.operators.observable.ObservableTimeoutTimed$b;

public final class ObservableTimeoutTimed$c
implements Runnable {
    public final ObservableTimeoutTimed$b a;
    public final long b;

    public ObservableTimeoutTimed$c(long l10, ObservableTimeoutTimed$b observableTimeoutTimed$b) {
        this.b = l10;
        this.a = observableTimeoutTimed$b;
    }

    public void run() {
        ObservableTimeoutTimed$b observableTimeoutTimed$b = this.a;
        long l10 = this.b;
        observableTimeoutTimed$b.onTimeout(l10);
    }
}

