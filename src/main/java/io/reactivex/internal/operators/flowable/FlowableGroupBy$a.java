/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.v0.g;
import io.reactivex.internal.operators.flowable.FlowableGroupBy$b;
import java.util.Queue;

public final class FlowableGroupBy$a
implements g {
    public final Queue a;

    public FlowableGroupBy$a(Queue queue) {
        this.a = queue;
    }

    public void a(FlowableGroupBy$b flowableGroupBy$b) {
        this.a.offer(flowableGroupBy$b);
    }
}

