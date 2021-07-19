/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.graph;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.graph.AbstractGraphBuilder;
import com.google.common.graph.AbstractValueGraph;
import com.google.common.graph.ConfigurableValueGraph$1;
import com.google.common.graph.ElementOrder;
import com.google.common.graph.EndpointPair;
import com.google.common.graph.GraphConnections;
import com.google.common.graph.Graphs;
import com.google.common.graph.MapIteratorCache;
import com.google.common.graph.MapRetrievalCache;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class ConfigurableValueGraph
extends AbstractValueGraph {
    private final boolean allowsSelfLoops;
    public long edgeCount;
    private final boolean isDirected;
    public final MapIteratorCache nodeConnections;
    private final ElementOrder nodeOrder;

    public ConfigurableValueGraph(AbstractGraphBuilder abstractGraphBuilder) {
        Object object = abstractGraphBuilder.nodeOrder;
        Optional optional = abstractGraphBuilder.expectedNodeCount;
        Integer n10 = 10;
        int n11 = (Integer)optional.or(n10);
        object = ((ElementOrder)object).createMap(n11);
        this(abstractGraphBuilder, (Map)object, 0L);
    }

    public ConfigurableValueGraph(AbstractGraphBuilder object, Map map, long l10) {
        long l11;
        boolean bl2;
        this.isDirected = bl2 = ((AbstractGraphBuilder)object).directed;
        this.allowsSelfLoops = bl2 = ((AbstractGraphBuilder)object).allowsSelfLoops;
        this.nodeOrder = object = ((AbstractGraphBuilder)object).nodeOrder.cast();
        boolean bl3 = map instanceof TreeMap;
        object = bl3 ? new MapRetrievalCache(map) : new MapIteratorCache(map);
        this.nodeConnections = object;
        this.edgeCount = l11 = Graphs.checkNonNegative(l10);
    }

    public Set adjacentNodes(Object object) {
        return this.checkedConnections(object).adjacentNodes();
    }

    public boolean allowsSelfLoops() {
        return this.allowsSelfLoops;
    }

    public final GraphConnections checkedConnections(Object object) {
        Object object2 = (GraphConnections)this.nodeConnections.get(object);
        if (object2 != null) {
            return object2;
        }
        Preconditions.checkNotNull(object);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Node ");
        stringBuilder.append(object);
        stringBuilder.append(" is not an element of this graph.");
        object = stringBuilder.toString();
        object2 = new IllegalArgumentException((String)object);
        throw object2;
    }

    public final boolean containsNode(Object object) {
        return this.nodeConnections.containsKey(object);
    }

    public long edgeCount() {
        return this.edgeCount;
    }

    public Object edgeValueOrDefault(EndpointPair object, Object object2) {
        this.validateEndpoints((EndpointPair)object);
        Object object3 = ((EndpointPair)object).nodeU();
        object = ((EndpointPair)object).nodeV();
        return this.edgeValueOrDefault_internal(object3, object, object2);
    }

    public Object edgeValueOrDefault(Object object, Object object2, Object object3) {
        object = Preconditions.checkNotNull(object);
        object2 = Preconditions.checkNotNull(object2);
        return this.edgeValueOrDefault_internal(object, object2, object3);
    }

    public final Object edgeValueOrDefault_internal(Object object, Object object2, Object object3) {
        MapIteratorCache mapIteratorCache = this.nodeConnections;
        if ((object = (object = (GraphConnections)mapIteratorCache.get(object)) == null ? null : object.value(object2)) != null) {
            object3 = object;
        }
        return object3;
    }

    public boolean hasEdgeConnecting(EndpointPair object) {
        Object object2;
        boolean bl2;
        Preconditions.checkNotNull(object);
        boolean bl3 = this.isOrderingCompatible((EndpointPair)object);
        if (bl3 && (bl2 = this.hasEdgeConnecting_internal(object2 = ((EndpointPair)object).nodeU(), object = ((EndpointPair)object).nodeV()))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public boolean hasEdgeConnecting(Object object, Object object2) {
        object = Preconditions.checkNotNull(object);
        object2 = Preconditions.checkNotNull(object2);
        return this.hasEdgeConnecting_internal(object, object2);
    }

    public final boolean hasEdgeConnecting_internal(Object object, Object object2) {
        boolean bl2;
        MapIteratorCache mapIteratorCache = this.nodeConnections;
        if ((object = (GraphConnections)mapIteratorCache.get(object)) != null && (bl2 = (object = object.successors()).contains(object2))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public Set incidentEdges(Object object) {
        GraphConnections graphConnections = this.checkedConnections(object);
        ConfigurableValueGraph$1 configurableValueGraph$1 = new ConfigurableValueGraph$1(this, this, object, graphConnections);
        return configurableValueGraph$1;
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

    public Set predecessors(Object object) {
        return this.checkedConnections(object).predecessors();
    }

    public Set successors(Object object) {
        return this.checkedConnections(object).successors();
    }
}

