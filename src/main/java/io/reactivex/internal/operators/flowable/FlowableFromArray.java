/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.j;
import e.a.w0.c.a;
import i.g.d;
import io.reactivex.internal.operators.flowable.FlowableFromArray$ArrayConditionalSubscription;
import io.reactivex.internal.operators.flowable.FlowableFromArray$ArraySubscription;

public final class FlowableFromArray
extends j {
    public final Object[] b;

    public FlowableFromArray(Object[] objectArray) {
        this.b = objectArray;
    }

    public void m6(d d10) {
        boolean bl2 = d10 instanceof a;
        if (bl2) {
            d d11 = d10;
            d11 = (a)d10;
            Object[] objectArray = this.b;
            FlowableFromArray$ArrayConditionalSubscription flowableFromArray$ArrayConditionalSubscription = new FlowableFromArray$ArrayConditionalSubscription((a)d11, objectArray);
            d10.onSubscribe(flowableFromArray$ArrayConditionalSubscription);
        } else {
            Object[] objectArray = this.b;
            FlowableFromArray$ArraySubscription flowableFromArray$ArraySubscription = new FlowableFromArray$ArraySubscription(d10, objectArray);
            d10.onSubscribe(flowableFromArray$ArraySubscription);
        }
    }
}

