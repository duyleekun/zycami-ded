/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.single;

import e.a.i0;
import e.a.l0;
import e.a.o0;
import io.reactivex.internal.operators.single.SingleDelayWithSingle$OtherObserver;

public final class SingleDelayWithSingle
extends i0 {
    public final o0 a;
    public final o0 b;

    public SingleDelayWithSingle(o0 o02, o0 o03) {
        this.a = o02;
        this.b = o03;
    }

    public void e1(l0 l02) {
        o0 o02 = this.b;
        o0 o03 = this.a;
        SingleDelayWithSingle$OtherObserver singleDelayWithSingle$OtherObserver = new SingleDelayWithSingle$OtherObserver(l02, o03);
        o02.f(singleDelayWithSingle$OtherObserver);
    }
}

