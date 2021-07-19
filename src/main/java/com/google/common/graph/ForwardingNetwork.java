/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.graph;

import com.google.common.graph.AbstractNetwork;
import com.google.common.graph.ElementOrder;
import com.google.common.graph.EndpointPair;
import com.google.common.graph.Network;
import java.util.Set;

public abstract class ForwardingNetwork
extends AbstractNetwork {
    public Set adjacentEdges(Object object) {
        return this.delegate().adjacentEdges(object);
    }

    public Set adjacentNodes(Object object) {
        return this.delegate().adjacentNodes(object);
    }

    public boolean allowsParallelEdges() {
        return this.delegate().allowsParallelEdges();
    }

    public boolean allowsSelfLoops() {
        return this.delegate().allowsSelfLoops();
    }

    public int degree(Object object) {
        return this.delegate().degree(object);
    }

    public abstract Network delegate();

    public Object edgeConnectingOrNull(EndpointPair endpointPair) {
        return this.delegate().edgeConnectingOrNull(endpointPair);
    }

    public Object edgeConnectingOrNull(Object object, Object object2) {
        return this.delegate().edgeConnectingOrNull(object, object2);
    }

    public ElementOrder edgeOrder() {
        return this.delegate().edgeOrder();
    }

    public Set edges() {
        return this.delegate().edges();
    }

    public Set edgesConnecting(EndpointPair endpointPair) {
        return this.delegate().edgesConnecting(endpointPair);
    }

    public Set edgesConnecting(Object object, Object object2) {
        return this.delegate().edgesConnecting(object, object2);
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

    public Set inEdges(Object object) {
        return this.delegate().inEdges(object);
    }

    public Set incidentEdges(Object object) {
        return this.delegate().incidentEdges(object);
    }

    public EndpointPair incidentNodes(Object object) {
        return this.delegate().incidentNodes(object);
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

    public Set outEdges(Object object) {
        return this.delegate().outEdges(object);
    }

    public Set predecessors(Object object) {
        return this.delegate().predecessors(object);
    }

    public Set successors(Object object) {
        return this.delegate().successors(object);
    }
}

