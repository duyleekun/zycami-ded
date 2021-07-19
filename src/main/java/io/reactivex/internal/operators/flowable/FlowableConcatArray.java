/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.j;
import i.g.c;
import i.g.d;
import io.reactivex.internal.operators.flowable.FlowableConcatArray$ConcatArraySubscriber;

public final class FlowableConcatArray
extends j {
    public final c[] b;
    public final boolean c;

    public FlowableConcatArray(c[] cArray, boolean bl2) {
        this.b = cArray;
        this.c = bl2;
    }

    public void m6(d d10) {
        c[] cArray = this.b;
        boolean bl2 = this.c;
        FlowableConcatArray$ConcatArraySubscriber flowableConcatArray$ConcatArraySubscriber = new FlowableConcatArray$ConcatArraySubscriber(cArray, bl2, d10);
        d10.onSubscribe(flowableConcatArray$ConcatArraySubscriber);
        flowableConcatArray$ConcatArraySubscriber.onComplete();
    }
}

