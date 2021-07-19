/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.single;

import e.a.h0;
import e.a.i0;
import e.a.l0;
import e.a.o0;
import e.a.s0.b;
import io.reactivex.internal.operators.single.SingleSubscribeOn$SubscribeOnObserver;

public final class SingleSubscribeOn
extends i0 {
    public final o0 a;
    public final h0 b;

    public SingleSubscribeOn(o0 o02, h0 h02) {
        this.a = o02;
        this.b = h02;
    }

    public void e1(l0 object) {
        o0 o02 = this.a;
        SingleSubscribeOn$SubscribeOnObserver singleSubscribeOn$SubscribeOnObserver = new SingleSubscribeOn$SubscribeOnObserver((l0)object, o02);
        object.onSubscribe(singleSubscribeOn$SubscribeOnObserver);
        object = this.b.e(singleSubscribeOn$SubscribeOnObserver);
        singleSubscribeOn$SubscribeOnObserver.task.replace((b)object);
    }
}

