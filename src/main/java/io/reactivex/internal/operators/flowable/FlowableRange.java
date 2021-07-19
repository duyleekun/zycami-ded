/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.j;
import e.a.w0.c.a;
import i.g.d;
import io.reactivex.internal.operators.flowable.FlowableRange$RangeConditionalSubscription;
import io.reactivex.internal.operators.flowable.FlowableRange$RangeSubscription;

public final class FlowableRange
extends j {
    public final int b;
    public final int c;

    public FlowableRange(int n10, int n11) {
        this.b = n10;
        this.c = n10 += n11;
    }

    public void m6(d d10) {
        boolean bl2 = d10 instanceof a;
        if (bl2) {
            d d11 = d10;
            d11 = (a)d10;
            int n10 = this.b;
            int n11 = this.c;
            FlowableRange$RangeConditionalSubscription flowableRange$RangeConditionalSubscription = new FlowableRange$RangeConditionalSubscription((a)d11, n10, n11);
            d10.onSubscribe(flowableRange$RangeConditionalSubscription);
        } else {
            int n12 = this.b;
            int n13 = this.c;
            FlowableRange$RangeSubscription flowableRange$RangeSubscription = new FlowableRange$RangeSubscription(d10, n12, n13);
            d10.onSubscribe(flowableRange$RangeSubscription);
        }
    }
}

