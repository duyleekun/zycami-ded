/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.mixed;

import e.a.a;
import e.a.d;
import e.a.j;
import e.a.v0.o;
import io.reactivex.internal.operators.mixed.FlowableConcatMapCompletable$ConcatMapCompletableObserver;
import io.reactivex.internal.util.ErrorMode;

public final class FlowableConcatMapCompletable
extends a {
    public final j a;
    public final o b;
    public final ErrorMode c;
    public final int d;

    public FlowableConcatMapCompletable(j j10, o o10, ErrorMode errorMode, int n10) {
        this.a = j10;
        this.b = o10;
        this.c = errorMode;
        this.d = n10;
    }

    public void L0(d d10) {
        j j10 = this.a;
        o o10 = this.b;
        ErrorMode errorMode = this.c;
        int n10 = this.d;
        FlowableConcatMapCompletable$ConcatMapCompletableObserver flowableConcatMapCompletable$ConcatMapCompletableObserver = new FlowableConcatMapCompletable$ConcatMapCompletableObserver(d10, o10, errorMode, n10);
        j10.l6(flowableConcatMapCompletable$ConcatMapCompletableObserver);
    }
}

