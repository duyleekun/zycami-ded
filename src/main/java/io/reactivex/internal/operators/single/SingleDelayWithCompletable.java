/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.single;

import e.a.g;
import e.a.i0;
import e.a.l0;
import e.a.o0;
import io.reactivex.internal.operators.single.SingleDelayWithCompletable$OtherObserver;

public final class SingleDelayWithCompletable
extends i0 {
    public final o0 a;
    public final g b;

    public SingleDelayWithCompletable(o0 o02, g g10) {
        this.a = o02;
        this.b = g10;
    }

    public void e1(l0 l02) {
        g g10 = this.b;
        o0 o02 = this.a;
        SingleDelayWithCompletable$OtherObserver singleDelayWithCompletable$OtherObserver = new SingleDelayWithCompletable$OtherObserver(l02, o02);
        g10.f(singleDelayWithCompletable$OtherObserver);
    }
}

