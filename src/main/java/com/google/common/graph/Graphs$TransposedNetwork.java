/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.graph;

import com.google.common.graph.EndpointPair;
import com.google.common.graph.ForwardingNetwork;
import com.google.common.graph.Graphs;
import com.google.common.graph.Network;
import java.util.Set;

public class Graphs$TransposedNetwork
extends ForwardingNetwork {
    private final Network network;

    public Graphs$TransposedNetwork(Network network) {
        this.network = network;
    }

    public static /* synthetic */ Network access$200(Graphs$TransposedNetwork graphs$TransposedNetwork) {
        return graphs$TransposedNetwork.network;
    }

    public Network delegate() {
        return this.network;
    }

    public Object edgeConnectingOrNull(EndpointPair endpointPair) {
        Network network = this.delegate();
        endpointPair = Graphs.transpose(endpointPair);
        return network.edgeConnectingOrNull(endpointPair);
    }

    public Object edgeConnectingOrNull(Object object, Object object2) {
        return this.delegate().edgeConnectingOrNull(object2, object);
    }

    public Set edgesConnecting(EndpointPair endpointPair) {
        Network network = this.delegate();
        endpointPair = Graphs.transpose(endpointPair);
        return network.edgesConnecting(endpointPair);
    }

    public Set edgesConnecting(Object object, Object object2) {
        return this.delegate().edgesConnecting(object2, object);
    }

    public boolean hasEdgeConnecting(EndpointPair endpointPair) {
        Network network = this.delegate();
        endpointPair = Graphs.transpose(endpointPair);
        return network.hasEdgeConnecting(endpointPair);
    }

    public boolean hasEdgeConnecting(Object object, Object object2) {
        return this.delegate().hasEdgeConnecting(object2, object);
    }

    public int inDegree(Object object) {
        return this.delegate().outDegree(object);
    }

    public Set inEdges(Object object) {
        return this.delegate().outEdges(object);
    }

    public EndpointPair incidentNodes(Object object) {
        object = this.delegate().incidentNodes(object);
        Network network = this.network;
        Object object2 = ((EndpointPair)object).nodeV();
        object = ((EndpointPair)object).nodeU();
        return EndpointPair.of(network, object2, object);
    }

    public int outDegree(Object object) {
        return this.delegate().inDegree(object);
    }

    public Set outEdges(Object object) {
        return this.delegate().inEdges(object);
    }

    public Set predecessors(Object object) {
        return this.delegate().successors(object);
    }

    public Set successors(Object object) {
        return this.delegate().predecessors(object);
    }
}

