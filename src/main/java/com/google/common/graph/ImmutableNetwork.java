/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.graph;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap$Builder;
import com.google.common.collect.Maps;
import com.google.common.graph.ConfigurableNetwork;
import com.google.common.graph.DirectedMultiNetworkConnections;
import com.google.common.graph.DirectedNetworkConnections;
import com.google.common.graph.Graph;
import com.google.common.graph.ImmutableGraph;
import com.google.common.graph.ImmutableNetwork$1;
import com.google.common.graph.ImmutableNetwork$2;
import com.google.common.graph.ImmutableNetwork$3;
import com.google.common.graph.Network;
import com.google.common.graph.NetworkBuilder;
import com.google.common.graph.NetworkConnections;
import com.google.common.graph.UndirectedMultiNetworkConnections;
import com.google.common.graph.UndirectedNetworkConnections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class ImmutableNetwork
extends ConfigurableNetwork {
    private ImmutableNetwork(Network object) {
        NetworkBuilder networkBuilder = NetworkBuilder.from((Network)object);
        Map map = ImmutableNetwork.getNodeConnections((Network)object);
        object = ImmutableNetwork.getEdgeToReferenceNode((Network)object);
        super(networkBuilder, map, (Map)object);
    }

    private static Function adjacentNodeFn(Network network, Object object) {
        ImmutableNetwork$3 immutableNetwork$3 = new ImmutableNetwork$3(network, object);
        return immutableNetwork$3;
    }

    private static NetworkConnections connectionsOf(Network object, Object object2) {
        boolean bl2 = object.isDirected();
        if (bl2) {
            Object object3 = object.inEdges(object2);
            Object object4 = ImmutableNetwork.sourceNodeFn((Network)object);
            object3 = Maps.asMap((Set)object3, (Function)object4);
            object4 = object.outEdges(object2);
            Function function = ImmutableNetwork.targetNodeFn((Network)object);
            object4 = Maps.asMap((Set)object4, function);
            object2 = object.edgesConnecting(object2, object2);
            int n10 = object2.size();
            boolean bl3 = object.allowsParallelEdges();
            object = bl3 ? DirectedMultiNetworkConnections.ofImmutable((Map)object3, (Map)object4, n10) : DirectedNetworkConnections.ofImmutable((Map)object3, (Map)object4, n10);
            return object;
        }
        Set set = object.incidentEdges(object2);
        object2 = ImmutableNetwork.adjacentNodeFn((Network)object, object2);
        object2 = Maps.asMap(set, (Function)object2);
        boolean bl4 = object.allowsParallelEdges();
        object = bl4 ? UndirectedMultiNetworkConnections.ofImmutable((Map)object2) : UndirectedNetworkConnections.ofImmutable((Map)object2);
        return object;
    }

    public static ImmutableNetwork copyOf(ImmutableNetwork immutableNetwork) {
        return (ImmutableNetwork)Preconditions.checkNotNull(immutableNetwork);
    }

    public static ImmutableNetwork copyOf(Network network) {
        boolean bl2 = network instanceof ImmutableNetwork;
        if (bl2) {
            network = (ImmutableNetwork)network;
        } else {
            ImmutableNetwork immutableNetwork = new ImmutableNetwork(network);
            network = immutableNetwork;
        }
        return network;
    }

    private static Map getEdgeToReferenceNode(Network network) {
        boolean bl2;
        ImmutableMap$Builder immutableMap$Builder = ImmutableMap.builder();
        Iterator iterator2 = network.edges().iterator();
        while (bl2 = iterator2.hasNext()) {
            Object e10 = iterator2.next();
            Object object = network.incidentNodes(e10).nodeU();
            immutableMap$Builder.put(e10, object);
        }
        return immutableMap$Builder.build();
    }

    private static Map getNodeConnections(Network network) {
        boolean bl2;
        ImmutableMap$Builder immutableMap$Builder = ImmutableMap.builder();
        Iterator iterator2 = network.nodes().iterator();
        while (bl2 = iterator2.hasNext()) {
            Object e10 = iterator2.next();
            NetworkConnections networkConnections = ImmutableNetwork.connectionsOf(network, e10);
            immutableMap$Builder.put(e10, networkConnections);
        }
        return immutableMap$Builder.build();
    }

    private static Function sourceNodeFn(Network network) {
        ImmutableNetwork$1 immutableNetwork$1 = new ImmutableNetwork$1(network);
        return immutableNetwork$1;
    }

    private static Function targetNodeFn(Network network) {
        ImmutableNetwork$2 immutableNetwork$2 = new ImmutableNetwork$2(network);
        return immutableNetwork$2;
    }

    public ImmutableGraph asGraph() {
        Graph graph = super.asGraph();
        ImmutableGraph immutableGraph = new ImmutableGraph(graph);
        return immutableGraph;
    }
}

