/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.graph;

import com.google.common.graph.BaseGraph;
import com.google.common.graph.EndpointPair;
import com.google.common.graph.ForwardingGraph;
import com.google.common.graph.Graph;
import com.google.common.graph.Graphs;
import com.google.common.graph.Graphs$TransposedGraph$1;
import java.util.Set;

public class Graphs$TransposedGraph
extends ForwardingGraph {
    private final Graph graph;

    public Graphs$TransposedGraph(Graph graph) {
        this.graph = graph;
    }

    public static /* synthetic */ Graph access$000(Graphs$TransposedGraph graphs$TransposedGraph) {
        return graphs$TransposedGraph.graph;
    }

    public Graph delegate() {
        return this.graph;
    }

    public boolean hasEdgeConnecting(EndpointPair endpointPair) {
        BaseGraph baseGraph = this.delegate();
        endpointPair = Graphs.transpose(endpointPair);
        return baseGraph.hasEdgeConnecting(endpointPair);
    }

    public boolean hasEdgeConnecting(Object object, Object object2) {
        return this.delegate().hasEdgeConnecting(object2, object);
    }

    public int inDegree(Object object) {
        return this.delegate().outDegree(object);
    }

    public Set incidentEdges(Object object) {
        Graphs$TransposedGraph$1 graphs$TransposedGraph$1 = new Graphs$TransposedGraph$1(this, this, object);
        return graphs$TransposedGraph$1;
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

