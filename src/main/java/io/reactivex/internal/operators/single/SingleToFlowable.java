/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.single;

import e.a.j;
import e.a.o0;
import i.g.d;
import io.reactivex.internal.operators.single.SingleToFlowable$SingleToFlowableObserver;

public final class SingleToFlowable
extends j {
    public final o0 b;

    public SingleToFlowable(o0 o02) {
        this.b = o02;
    }

    public void m6(d d10) {
        o0 o02 = this.b;
        SingleToFlowable$SingleToFlowableObserver singleToFlowable$SingleToFlowableObserver = new SingleToFlowable$SingleToFlowableObserver(d10);
        o02.f(singleToFlowable$SingleToFlowableObserver);
    }
}

