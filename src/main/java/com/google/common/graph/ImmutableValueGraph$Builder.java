/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.graph;

import com.google.common.graph.EndpointPair;
import com.google.common.graph.ImmutableValueGraph;
import com.google.common.graph.MutableValueGraph;
import com.google.common.graph.ValueGraphBuilder;

public class ImmutableValueGraph$Builder {
    private final MutableValueGraph mutableValueGraph;

    public ImmutableValueGraph$Builder(ValueGraphBuilder object) {
        this.mutableValueGraph = object = ((ValueGraphBuilder)object).build();
    }

    public ImmutableValueGraph$Builder addNode(Object object) {
        this.mutableValueGraph.addNode(object);
        return this;
    }

    public ImmutableValueGraph build() {
        return ImmutableValueGraph.copyOf(this.mutableValueGraph);
    }

    public ImmutableValueGraph$Builder putEdgeValue(EndpointPair endpointPair, Object object) {
        this.mutableValueGraph.putEdgeValue(endpointPair, object);
        return this;
    }

    public ImmutableValueGraph$Builder putEdgeValue(Object object, Object object2, Object object3) {
        this.mutableValueGraph.putEdgeValue(object, object2, object3);
        return this;
    }
}

