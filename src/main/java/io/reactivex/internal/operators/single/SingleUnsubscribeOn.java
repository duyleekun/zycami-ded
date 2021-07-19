/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.single;

import e.a.h0;
import e.a.i0;
import e.a.l0;
import e.a.o0;
import io.reactivex.internal.operators.single.SingleUnsubscribeOn$UnsubscribeOnSingleObserver;

public final class SingleUnsubscribeOn
extends i0 {
    public final o0 a;
    public final h0 b;

    public SingleUnsubscribeOn(o0 o02, h0 h02) {
        this.a = o02;
        this.b = h02;
    }

    public void e1(l0 l02) {
        o0 o02 = this.a;
        h0 h02 = this.b;
        SingleUnsubscribeOn$UnsubscribeOnSingleObserver singleUnsubscribeOn$UnsubscribeOnSingleObserver = new SingleUnsubscribeOn$UnsubscribeOnSingleObserver(l02, h02);
        o02.f(singleUnsubscribeOn$UnsubscribeOnSingleObserver);
    }
}

