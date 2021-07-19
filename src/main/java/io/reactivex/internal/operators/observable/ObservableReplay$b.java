/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.s0.b;
import e.a.v0.g;
import io.reactivex.internal.operators.observable.ObserverResourceWrapper;

public final class ObservableReplay$b
implements g {
    private final ObserverResourceWrapper a;

    public ObservableReplay$b(ObserverResourceWrapper observerResourceWrapper) {
        this.a = observerResourceWrapper;
    }

    public void a(b b10) {
        this.a.setResource(b10);
    }
}

