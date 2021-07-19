/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.single;

import e.a.e0;
import e.a.i0;
import e.a.l0;
import e.a.o0;
import io.reactivex.internal.operators.single.SingleDelayWithObservable$OtherSubscriber;

public final class SingleDelayWithObservable
extends i0 {
    public final o0 a;
    public final e0 b;

    public SingleDelayWithObservable(o0 o02, e0 e02) {
        this.a = o02;
        this.b = e02;
    }

    public void e1(l0 l02) {
        e0 e02 = this.b;
        o0 o02 = this.a;
        SingleDelayWithObservable$OtherSubscriber singleDelayWithObservable$OtherSubscriber = new SingleDelayWithObservable$OtherSubscriber(l02, o02);
        e02.subscribe(singleDelayWithObservable$OtherSubscriber);
    }
}

