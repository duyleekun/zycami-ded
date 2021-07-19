/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.single;

import e.a.j;
import e.a.o0;
import e.a.v0.o;
import i.g.d;
import io.reactivex.internal.operators.single.SingleFlatMapPublisher$SingleFlatMapPublisherObserver;

public final class SingleFlatMapPublisher
extends j {
    public final o0 b;
    public final o c;

    public SingleFlatMapPublisher(o0 o02, o o10) {
        this.b = o02;
        this.c = o10;
    }

    public void m6(d d10) {
        o0 o02 = this.b;
        o o10 = this.c;
        SingleFlatMapPublisher$SingleFlatMapPublisherObserver singleFlatMapPublisher$SingleFlatMapPublisherObserver = new SingleFlatMapPublisher$SingleFlatMapPublisherObserver(d10, o10);
        o02.f(singleFlatMapPublisher$SingleFlatMapPublisherObserver);
    }
}

