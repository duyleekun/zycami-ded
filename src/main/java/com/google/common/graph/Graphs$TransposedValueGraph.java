/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.graph;

import com.google.common.graph.EndpointPair;
import com.google.common.graph.ForwardingValueGraph;
import com.google.common.graph.Graphs;
import com.google.common.graph.ValueGraph;
import java.util.Set;

public class Graphs$TransposedValueGraph
extends ForwardingValueGraph {
    private final ValueGraph graph;

    public Graphs$TransposedValueGraph(ValueGraph valueGraph) {
        this.graph = valueGraph;
    }

    public static /* synthetic */ ValueGraph access$100(Graphs$TransposedValueGraph graphs$TransposedValueGraph) {
        return graphs$TransposedValueGraph.graph;
    }

    public ValueGraph delegate() {
        return this.graph;
    }

    public Object edgeValueOrDefault(EndpointPair endpointPair, Object object) {
        ValueGraph valueGraph = this.delegate();
        endpointPair = Graphs.transpose(endpointPair);
        return valueGraph.edgeValueOrDefault(endpointPair, object);
    }

    public Object edgeValueOrDefault(Object object, Object object2, Object object3) {
        return this.delegate().edgeValueOrDefault(object2, object, object3);
    }

    public boolean hasEdgeConnecting(EndpointPair endpointPair) {
        ValueGraph valueGraph = this.delegate();
        endpointPair = Graphs.transpose(endpointPair);
        return valueGraph.hasEdgeConnecting(endpointPair);
    }

    public boolean hasEdgeConnecting(Object object, Object object2) {
        return this.delegate().hasEdgeConnecting(object2, object);
    }

    public int inDegree(Object object) {
        return this.delegate().outDegree(object);
    }

    public int outDegree(Object object) {
        return this.delegate().inDegree(object);
    }

    public Set predecessors(Object object) {
        return this.delegate().successors(object);
    }

    public Set successors(Object object) {
        return this.delegate().predecessors(object);
    }
}

