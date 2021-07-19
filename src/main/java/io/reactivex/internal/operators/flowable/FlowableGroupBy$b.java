/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.u0.b;
import i.g.d;
import io.reactivex.internal.operators.flowable.FlowableGroupBy$GroupBySubscriber;
import io.reactivex.internal.operators.flowable.FlowableGroupBy$State;

public final class FlowableGroupBy$b
extends b {
    public final FlowableGroupBy$State c;

    public FlowableGroupBy$b(Object object, FlowableGroupBy$State state) {
        super(object);
        this.c = state;
    }

    public static FlowableGroupBy$b L8(Object object, int n10, FlowableGroupBy.GroupBySubscriber groupBySubscriber, boolean bl2) {
        FlowableGroupBy$State flowableGroupBy$State = new FlowableGroupBy$State(n10, groupBySubscriber, object, bl2);
        FlowableGroupBy$b flowableGroupBy$b = new FlowableGroupBy$b(object, flowableGroupBy$State);
        return flowableGroupBy$b;
    }

    public void m6(d d10) {
        this.c.subscribe(d10);
    }

    public void onComplete() {
        this.c.onComplete();
    }

    public void onError(Throwable throwable) {
        this.c.onError(throwable);
    }

    public void onNext(Object object) {
        this.c.onNext(object);
    }
}

