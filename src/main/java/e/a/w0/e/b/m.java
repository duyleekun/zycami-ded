/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.b;

import e.a.j;
import e.a.v0.o;
import i.g.c;
import i.g.d;
import io.reactivex.internal.operators.flowable.FlowableConcatMapEager$ConcatMapEagerDelayErrorSubscriber;
import io.reactivex.internal.util.ErrorMode;

public final class m
extends j {
    public final c b;
    public final o c;
    public final int d;
    public final int e;
    public final ErrorMode f;

    public m(c c10, o o10, int n10, int n11, ErrorMode errorMode) {
        this.b = c10;
        this.c = o10;
        this.d = n10;
        this.e = n11;
        this.f = errorMode;
    }

    public void m6(d d10) {
        c c10 = this.b;
        o o10 = this.c;
        int n10 = this.d;
        int n11 = this.e;
        ErrorMode errorMode = this.f;
        FlowableConcatMapEager$ConcatMapEagerDelayErrorSubscriber flowableConcatMapEager$ConcatMapEagerDelayErrorSubscriber = new FlowableConcatMapEager$ConcatMapEagerDelayErrorSubscriber(d10, o10, n10, n11, errorMode);
        c10.subscribe(flowableConcatMapEager$ConcatMapEagerDelayErrorSubscriber);
    }
}

