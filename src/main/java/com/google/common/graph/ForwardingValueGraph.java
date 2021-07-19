/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.graph;

import com.google.common.graph.AbstractValueGraph;
import com.google.common.graph.ElementOrder;
import com.google.common.graph.EndpointPair;
import com.google.common.graph.ValueGraph;
import java.util.Set;

public abstract class ForwardingValueGraph
extends AbstractValueGraph {
    public Set adjacentNodes(Object object) {
        return this.delegate().adjacentNodes(object);
    }

    public boolean allowsSelfLoops() {
        return this.delegate().allowsSelfLoops();
    }

    public int degree(Object object) {
        return this.delegate().degree(object);
    }

    public abstract ValueGraph delegate();

    public long edgeCount() {
        return this.delegate().edges().size();
    }

    public Object edgeValueOrDefault(EndpointPair endpointPair, Object object) {
        return this.delegate().edgeValueOrDefault(endpointPair, object);
    }

    public Object edgeValueOrDefault(Object object, Object object2, Object object3) {
        return this.delegate().edgeValueOrDefault(object, object2, object3);
    }

    public boolean hasEdgeConnecting(EndpointPair endpointPair) {
        return this.delegate().hasEdgeConnecting(endpointPair);
    }

    public boolean hasEdgeConnecting(Object object, Object object2) {
        return this.delegate().hasEdgeConnecting(object, object2);
    }

    public int inDegree(Object object) {
        return this.delegate().inDegree(object);
    }

    public boolean isDirected() {
        return this.delegate().isDirected();
    }

    public ElementOrder nodeOrder() {
        return this.delegate().nodeOrder();
    }

    public Set nodes() {
        return this.delegate().nodes();
    }

    public int outDegree(Object object) {
        return this.delegate().outDegree(object);
    }

    public Set predecessors(Object object) {
        return this.delegate().predecessors(object);
    }

    public Set successors(Object object) {
        return this.delegate().successors(object);
    }
}

