/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.mixed;

import e.a.j;
import e.a.v0.o;
import i.g.d;
import io.reactivex.internal.operators.mixed.FlowableConcatMapSingle$ConcatMapSingleSubscriber;
import io.reactivex.internal.util.ErrorMode;

public final class FlowableConcatMapSingle
extends j {
    public final j b;
    public final o c;
    public final ErrorMode d;
    public final int e;

    public FlowableConcatMapSingle(j j10, o o10, ErrorMode errorMode, int n10) {
        this.b = j10;
        this.c = o10;
        this.d = errorMode;
        this.e = n10;
    }

    public void m6(d d10) {
        j j10 = this.b;
        o o10 = this.c;
        int n10 = this.e;
        ErrorMode errorMode = this.d;
        FlowableConcatMapSingle$ConcatMapSingleSubscriber flowableConcatMapSingle$ConcatMapSingleSubscriber = new FlowableConcatMapSingle$ConcatMapSingleSubscriber(d10, o10, n10, errorMode);
        j10.l6(flowableConcatMapSingle$ConcatMapSingleSubscriber);
    }
}

