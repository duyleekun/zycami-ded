/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.j;
import e.a.w0.c.a;
import i.g.d;
import io.reactivex.internal.operators.flowable.FlowableRangeLong$RangeConditionalSubscription;
import io.reactivex.internal.operators.flowable.FlowableRangeLong$RangeSubscription;

public final class FlowableRangeLong
extends j {
    public final long b;
    public final long c;

    public FlowableRangeLong(long l10, long l11) {
        this.b = l10;
        this.c = l10 += l11;
    }

    public void m6(d d10) {
        boolean bl2 = d10 instanceof a;
        if (bl2) {
            d d11 = d10;
            d11 = (a)d10;
            long l10 = this.b;
            long l11 = this.c;
            FlowableRangeLong$RangeConditionalSubscription flowableRangeLong$RangeConditionalSubscription = new FlowableRangeLong$RangeConditionalSubscription((a)d11, l10, l11);
            d10.onSubscribe(flowableRangeLong$RangeConditionalSubscription);
        } else {
            long l12 = this.b;
            long l13 = this.c;
            FlowableRangeLong$RangeSubscription flowableRangeLong$RangeSubscription = new FlowableRangeLong$RangeSubscription(d10, l12, l13);
            d10.onSubscribe(flowableRangeLong$RangeSubscription);
        }
    }
}

