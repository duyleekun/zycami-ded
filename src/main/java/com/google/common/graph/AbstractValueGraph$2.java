/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.graph;

import com.google.common.base.Function;
import com.google.common.graph.EndpointPair;
import com.google.common.graph.ValueGraph;

public final class AbstractValueGraph$2
implements Function {
    public final /* synthetic */ ValueGraph val$graph;

    public AbstractValueGraph$2(ValueGraph valueGraph) {
        this.val$graph = valueGraph;
    }

    public Object apply(EndpointPair object) {
        ValueGraph valueGraph = this.val$graph;
        Object object2 = ((EndpointPair)object).nodeU();
        object = ((EndpointPair)object).nodeV();
        return valueGraph.edgeValueOrDefault(object2, object, null);
    }
}

