/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.single;

import e.a.i0;
import e.a.l0;
import e.a.o0;
import i.g.c;
import io.reactivex.internal.operators.single.SingleTakeUntil$TakeUntilMainObserver;
import io.reactivex.internal.operators.single.SingleTakeUntil$TakeUntilOtherSubscriber;

public final class SingleTakeUntil
extends i0 {
    public final o0 a;
    public final c b;

    public SingleTakeUntil(o0 o02, c c10) {
        this.a = o02;
        this.b = c10;
    }

    public void e1(l0 object) {
        SingleTakeUntil$TakeUntilMainObserver singleTakeUntil$TakeUntilMainObserver = new SingleTakeUntil$TakeUntilMainObserver((l0)object);
        object.onSubscribe(singleTakeUntil$TakeUntilMainObserver);
        object = this.b;
        SingleTakeUntil$TakeUntilOtherSubscriber singleTakeUntil$TakeUntilOtherSubscriber = singleTakeUntil$TakeUntilMainObserver.other;
        object.subscribe(singleTakeUntil$TakeUntilOtherSubscriber);
        this.a.f(singleTakeUntil$TakeUntilMainObserver);
    }
}

