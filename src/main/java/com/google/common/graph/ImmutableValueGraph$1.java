/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.graph;

import com.google.common.base.Function;
import com.google.common.graph.ValueGraph;

public final class ImmutableValueGraph$1
implements Function {
    public final /* synthetic */ ValueGraph val$graph;
    public final /* synthetic */ Object val$node;

    public ImmutableValueGraph$1(ValueGraph valueGraph, Object object) {
        this.val$graph = valueGraph;
        this.val$node = object;
    }

    public Object apply(Object object) {
        ValueGraph valueGraph = this.val$graph;
        Object object2 = this.val$node;
        return valueGraph.edgeValueOrDefault(object2, object, null);
    }
}

