/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.v0.o;
import io.reactivex.internal.operators.flowable.FlowableCombineLatest;

public final class FlowableCombineLatest$a
implements o {
    public final /* synthetic */ FlowableCombineLatest a;

    public FlowableCombineLatest$a(FlowableCombineLatest flowableCombineLatest) {
        this.a = flowableCombineLatest;
    }

    public Object apply(Object object) {
        o o10 = this.a.d;
        Object[] objectArray = new Object[]{object};
        return o10.apply(objectArray);
    }
}

