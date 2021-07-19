/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.graph;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.graph.AbstractGraphBuilder;
import com.google.common.graph.AbstractNetwork;
import com.google.common.graph.ElementOrder;
import com.google.common.graph.EndpointPair;
import com.google.common.graph.MapIteratorCache;
import com.google.common.graph.MapRetrievalCache;
import com.google.common.graph.NetworkBuilder;
import com.google.common.graph.NetworkConnections;
import java.io.Serializable;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class ConfigurableNetwork
extends AbstractNetwork {
    private final boolean allowsParallelEdges;
    private final boolean allowsSelfLoops;
    private final ElementOrder edgeOrder;
    public final MapIteratorCache edgeToReferenceNode;
    private final boolean isDirected;
    public final MapIteratorCache nodeConnections;
    private final ElementOrder nodeOrder;

    public ConfigurableNetwork(NetworkBuilder networkBuilder) {
        Object object = networkBuilder.nodeOrder;
        Object object2 = networkBuilder.expectedNodeCount;
        Serializable serializable = Integer.valueOf(10);
        int n10 = (Integer)((Optional)object2).or(serializable);
        object = ((ElementOrder)object).createMap(n10);
        object2 = networkBuilder.edgeOrder;
        serializable = networkBuilder.expectedEdgeCount;
        Integer n11 = 20;
        int n12 = (Integer)((Optional)serializable).or(n11);
        object2 = ((ElementOrder)object2).createMap(n12);
        this(networkBuilder, (Map)object, (Map)object2);
    }

    public ConfigurableNetwork(NetworkBuilder object, Map map, Map map2) {
        ElementOrder elementOrder;
        boolean bl2;
        this.isDirected = bl2 = ((AbstractGraphBuilder)object).directed;
        this.allowsParallelEdges = bl2 = ((NetworkBuilder)object).allowsParallelEdges;
        this.allowsSelfLoops = bl2 = ((AbstractGraphBuilder)object).allowsSelfLoops;
        this.nodeOrder = elementOrder = ((AbstractGraphBuilder)object).nodeOrder.cast();
        this.edgeOrder = object = ((NetworkBuilder)object).edgeOrder.cast();
        boolean bl3 = map instanceof TreeMap;
        object = bl3 ? new MapRetrievalCache(map) : new MapIteratorCache(map);
        this.nodeConnections = object;
        this.edgeToReferenceNode = object = new MapIteratorCache(map2);
    }

    public Set adjacentNodes(Object object) {
        return this.checkedConnections(object).adjacentNodes();
    }

    public boolean allowsParallelEdges() {
        return this.allowsParallelEdges;
    }

    public boolean allowsSelfLoops() {
        return this.allowsSelfLoops;
    }

    public final NetworkConnections checkedConnections(Object object) {
        Object object2 = (NetworkConnections)this.nodeConnections.get(object);
        if (object2 != null) {
            return object2;
        }
        Preconditions.checkNotNull(object);
        Object[] objectArray = new Object[]{object};
        object = String.format("Node %s is not an element of this graph.", objectArray);
        object2 = new IllegalArgumentException((String)object);
        throw object2;
    }

    public final Object checkedReferenceNode(Object object) {
        Object object2 = this.edgeToReferenceNode.get(object);
        if (object2 != null) {
            return object2;
        }
        Preconditions.checkNotNull(object);
        Object[] objectArray = new Object[]{object};
        object = String.format("Edge %s is not an element of this graph.", objectArray);
        object2 = new IllegalArgumentException((String)object);
        throw object2;
    }

    public final boolean containsEdge(Object object) {
        return this.edgeToReferenceNode.containsKey(object);
    }

    public final boolean containsNode(Object object) {
        return this.nodeConnections.containsKey(object);
    }

    public ElementOrder edgeOrder() {
        return this.edgeOrder;
    }

    public Set edges() {
        return this.edgeToReferenceNode.unmodifiableKeySet();
    }

    public Set edgesConnecting(Object object, Object object2) {
        NetworkConnections networkConnections = this.checkedConnections(object);
        boolean bl2 = this.allowsSelfLoops;
        if (!bl2 && object == object2) {
            return ImmutableSet.of();
        }
        Preconditions.checkArgument(this.containsNode(object2), "Node %s is not an element of this graph.", object2);
        return networkConnections.edgesConnecting(object2);
    }

    public Set inEdges(Object object) {
        return this.checkedConnections(object).inEdges();
    }

    public Set incidentEdges(Object object) {
        return this.checkedConnections(object).incidentEdges();
    }

    public EndpointPair incidentNodes(Object object) {
        Object object2 = this.checkedReferenceNode(object);
        object = ((NetworkConnections)this.nodeConnections.get(object2)).adjacentNode(object);
        return EndpointPair.of(this, object2, object);
    }

    public boolean isDirected() {
        return this.isDirected;
    }

    public ElementOrder nodeOrder() {
        return this.nodeOrder;
    }

    public Set nodes() {
        return this.nodeConnections.unmodifiableKeySet();
    }

    public Set outEdges(Object object) {
        return this.checkedConnections(object).outEdges();
    }

    public Set predecessors(Object object) {
        return this.checkedConnections(object).predecessors();
    }

    public Set successors(Object object) {
        return this.checkedConnections(object).successors();
    }
}

