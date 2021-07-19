/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.graph.ConfigurableNetwork;
import com.google.common.graph.DirectedMultiNetworkConnections;
import com.google.common.graph.DirectedNetworkConnections;
import com.google.common.graph.EndpointPair;
import com.google.common.graph.MapIteratorCache;
import com.google.common.graph.MutableNetwork;
import com.google.common.graph.NetworkBuilder;
import com.google.common.graph.NetworkConnections;
import com.google.common.graph.UndirectedMultiNetworkConnections;
import com.google.common.graph.UndirectedNetworkConnections;
import java.util.Collection;

public final class ConfigurableMutableNetwork
extends ConfigurableNetwork
implements MutableNetwork {
    public ConfigurableMutableNetwork(NetworkBuilder networkBuilder) {
        super(networkBuilder);
    }

    private NetworkConnections addNodeInternal(Object object) {
        boolean bl2;
        MapIteratorCache mapIteratorCache = this.nodeConnections;
        NetworkConnections networkConnections = this.newConnections();
        if ((object = mapIteratorCache.put(object, networkConnections)) == null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        Preconditions.checkState(bl2);
        return networkConnections;
    }

    private NetworkConnections newConnections() {
        boolean bl2 = this.isDirected();
        NetworkConnections networkConnections = bl2 ? ((bl2 = this.allowsParallelEdges()) ? DirectedMultiNetworkConnections.of() : DirectedNetworkConnections.of()) : ((bl2 = this.allowsParallelEdges()) ? UndirectedMultiNetworkConnections.of() : UndirectedNetworkConnections.of());
        return networkConnections;
    }

    public boolean addEdge(EndpointPair object, Object object2) {
        this.validateEndpoints((EndpointPair)object);
        Object object3 = ((EndpointPair)object).nodeU();
        object = ((EndpointPair)object).nodeV();
        return this.addEdge(object3, object, object2);
    }

    public boolean addEdge(Object object, Object object2, Object object3) {
        Preconditions.checkNotNull(object, "nodeU");
        Preconditions.checkNotNull(object2, "nodeV");
        Object object4 = "edge";
        Preconditions.checkNotNull(object3, object4);
        boolean bl2 = this.containsEdge(object3);
        boolean bl3 = false;
        if (bl2) {
            object4 = this.incidentNodes(object3);
            object = EndpointPair.of(this, object, object2);
            Preconditions.checkArgument(((EndpointPair)object4).equals(object), "Edge %s already exists between the following nodes: %s, so it cannot be reused to connect the following nodes: %s.", object3, object4, object);
            return false;
        }
        object4 = (NetworkConnections)this.nodeConnections.get(object);
        boolean bl4 = this.allowsParallelEdges();
        boolean bl5 = true;
        if (!bl4) {
            Object object5;
            if (object4 == null || !(bl4 = (object5 = object4.successors()).contains(object2))) {
                bl3 = bl5;
            }
            object5 = "Nodes %s and %s are already connected by a different edge. To construct a graph that allows parallel edges, call allowsParallelEdges(true) on the Builder.";
            Preconditions.checkArgument(bl3, (String)object5, object, object2);
        }
        bl3 = object.equals(object2);
        bl4 = this.allowsSelfLoops();
        if (!bl4) {
            bl4 = bl3 ^ true;
            String string2 = "Cannot add self-loop edge on node %s, as self-loops are not allowed. To construct a graph that allows self-loops, call allowsSelfLoops(true) on the Builder.";
            Preconditions.checkArgument(bl4, string2, object);
        }
        if (object4 == null) {
            object4 = this.addNodeInternal(object);
        }
        object4.addOutEdge(object3, object2);
        object4 = (NetworkConnections)this.nodeConnections.get(object2);
        if (object4 == null) {
            object4 = this.addNodeInternal(object2);
        }
        object4.addInEdge(object3, object, bl3);
        this.edgeToReferenceNode.put(object3, object);
        return bl5;
    }

    public boolean addNode(Object object) {
        String string2 = "node";
        Preconditions.checkNotNull(object, string2);
        boolean bl2 = this.containsNode(object);
        if (bl2) {
            return false;
        }
        this.addNodeInternal(object);
        return true;
    }

    public boolean removeEdge(Object object) {
        boolean bl2;
        Preconditions.checkNotNull(object, "edge");
        Object object2 = this.edgeToReferenceNode.get(object);
        boolean bl3 = false;
        if (object2 == null) {
            return false;
        }
        NetworkConnections networkConnections = (NetworkConnections)this.nodeConnections.get(object2);
        Object object3 = networkConnections.adjacentNode(object);
        NetworkConnections networkConnections2 = (NetworkConnections)this.nodeConnections.get(object3);
        networkConnections.removeOutEdge(object);
        boolean bl4 = this.allowsSelfLoops();
        boolean bl5 = true;
        if (bl4 && (bl2 = object2.equals(object3))) {
            bl3 = bl5;
        }
        networkConnections2.removeInEdge(object, bl3);
        this.edgeToReferenceNode.remove(object);
        return bl5;
    }

    public boolean removeNode(Object object) {
        boolean bl2;
        Preconditions.checkNotNull(object, "node");
        Object object2 = (NetworkConnections)this.nodeConnections.get(object);
        if (object2 == null) {
            return false;
        }
        object2 = ImmutableList.copyOf((Collection)object2.incidentEdges()).iterator();
        while (bl2 = object2.hasNext()) {
            Object e10 = object2.next();
            this.removeEdge(e10);
        }
        this.nodeConnections.remove(object);
        return true;
    }
}

