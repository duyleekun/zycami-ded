/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.single;

import e.a.i0;
import e.a.l0;
import e.a.o0;
import i.g.c;
import io.reactivex.internal.operators.single.SingleDelayWithPublisher$OtherSubscriber;

public final class SingleDelayWithPublisher
extends i0 {
    public final o0 a;
    public final c b;

    public SingleDelayWithPublisher(o0 o02, c c10) {
        this.a = o02;
        this.b = c10;
    }

    public void e1(l0 l02) {
        c c10 = this.b;
        o0 o02 = this.a;
        SingleDelayWithPublisher$OtherSubscriber singleDelayWithPublisher$OtherSubscriber = new SingleDelayWithPublisher$OtherSubscriber(l02, o02);
        c10.subscribe(singleDelayWithPublisher$OtherSubscriber);
    }
}

