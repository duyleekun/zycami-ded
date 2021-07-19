/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.graph;

import com.google.common.graph.ElementOrder;
import com.google.common.graph.EndpointPair;
import com.google.common.graph.GraphBuilder;
import com.google.common.graph.ImmutableGraph;
import com.google.common.graph.MutableGraph;

public class ImmutableGraph$Builder {
    private final MutableGraph mutableGraph;

    public ImmutableGraph$Builder(GraphBuilder object) {
        object = ((GraphBuilder)object).copy();
        ElementOrder elementOrder = ElementOrder.stable();
        this.mutableGraph = object = ((GraphBuilder)object).incidentEdgeOrder(elementOrder).build();
    }

    public ImmutableGraph$Builder addNode(Object object) {
        this.mutableGraph.addNode(object);
        return this;
    }

    public ImmutableGraph build() {
        return ImmutableGraph.copyOf(this.mutableGraph);
    }

    public ImmutableGraph$Builder putEdge(EndpointPair endpointPair) {
        this.mutableGraph.putEdge(endpointPair);
        return this;
    }

    public ImmutableGraph$Builder putEdge(Object object, Object object2) {
        this.mutableGraph.putEdge(object, object2);
        return this;
    }
}

