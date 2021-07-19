/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.v0.o;
import e.a.w0.b.a;
import io.reactivex.internal.operators.flowable.FlowableWithLatestFromMany;

public final class FlowableWithLatestFromMany$a
implements o {
    public final /* synthetic */ FlowableWithLatestFromMany a;

    public FlowableWithLatestFromMany$a(FlowableWithLatestFromMany flowableWithLatestFromMany) {
        this.a = flowableWithLatestFromMany;
    }

    public Object apply(Object object) {
        o o10 = this.a.e;
        Object[] objectArray = new Object[]{object};
        return e.a.w0.b.a.g(o10.apply(objectArray), "The combiner returned a null value");
    }
}

