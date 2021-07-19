/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.graph.AbstractGraphBuilder;
import com.google.common.graph.ConfigurableValueGraph;
import com.google.common.graph.DirectedGraphConnections;
import com.google.common.graph.ElementOrder;
import com.google.common.graph.EndpointPair;
import com.google.common.graph.GraphConnections;
import com.google.common.graph.Graphs;
import com.google.common.graph.MapIteratorCache;
import com.google.common.graph.MutableValueGraph;
import com.google.common.graph.UndirectedGraphConnections;

public final class ConfigurableMutableValueGraph
extends ConfigurableValueGraph
implements MutableValueGraph {
    private final ElementOrder incidentEdgeOrder;

    public ConfigurableMutableValueGraph(AbstractGraphBuilder object) {
        super((AbstractGraphBuilder)object);
        this.incidentEdgeOrder = object = ((AbstractGraphBuilder)object).incidentEdgeOrder.cast();
    }

    private GraphConnections addNodeInternal(Object object) {
        boolean bl2;
        MapIteratorCache mapIteratorCache = this.nodeConnections;
        GraphConnections graphConnections = this.newConnections();
        if ((object = mapIteratorCache.put(object, graphConnections)) == null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        Preconditions.checkState(bl2);
        return graphConnections;
    }

    private GraphConnections newConnections() {
        boolean bl2 = this.isDirected();
        GraphConnections graphConnections = bl2 ? DirectedGraphConnections.of(this.incidentEdgeOrder) : UndirectedGraphConnections.of();
        return graphConnections;
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

    public Object putEdgeValue(EndpointPair object, Object object2) {
        this.validateEndpoints((EndpointPair)object);
        Object object3 = ((EndpointPair)object).nodeU();
        object = ((EndpointPair)object).nodeV();
        return this.putEdgeValue(object3, object, object2);
    }

    public Object putEdgeValue(Object object, Object object2, Object object3) {
        Object object4;
        Preconditions.checkNotNull(object, "nodeU");
        Preconditions.checkNotNull(object2, "nodeV");
        Object object5 = "value";
        Preconditions.checkNotNull(object3, object5);
        boolean bl2 = this.allowsSelfLoops();
        if (!bl2) {
            bl2 = object.equals(object2) ^ true;
            object4 = "Cannot add self-loop edge on node %s, as self-loops are not allowed. To construct a graph that allows self-loops, call allowsSelfLoops(true) on the Builder.";
            Preconditions.checkArgument(bl2, (String)object4, object);
        }
        if ((object5 = (GraphConnections)this.nodeConnections.get(object)) == null) {
            object5 = this.addNodeInternal(object);
        }
        object5 = object5.addSuccessor(object2, object3);
        object4 = (GraphConnections)this.nodeConnections.get(object2);
        if (object4 == null) {
            object4 = this.addNodeInternal(object2);
        }
        object4.addPredecessor(object, object3);
        if (object5 == null) {
            long l10 = this.edgeCount;
            long l11 = 1L;
            this.edgeCount = l10 += l11;
            Graphs.checkPositive(l10);
        }
        return object5;
    }

    public Object removeEdge(EndpointPair object) {
        this.validateEndpoints((EndpointPair)object);
        Object object2 = ((EndpointPair)object).nodeU();
        object = ((EndpointPair)object).nodeV();
        return this.removeEdge(object2, object);
    }

    public Object removeEdge(Object object, Object object2) {
        Preconditions.checkNotNull(object, "nodeU");
        Preconditions.checkNotNull(object2, "nodeV");
        GraphConnections graphConnections = (GraphConnections)this.nodeConnections.get(object);
        GraphConnections graphConnections2 = (GraphConnections)this.nodeConnections.get(object2);
        if (graphConnections != null && graphConnections2 != null) {
            if ((object2 = graphConnections.removeSuccessor(object2)) != null) {
                graphConnections2.removePredecessor(object);
                long l10 = this.edgeCount;
                long l11 = 1L;
                this.edgeCount = l10 -= l11;
                Graphs.checkNonNegative(l10);
            }
            return object2;
        }
        return null;
    }

    public boolean removeNode(Object object) {
        MapIteratorCache mapIteratorCache;
        boolean bl2;
        long l10;
        Object object2;
        Preconditions.checkNotNull(object, "node");
        Object object3 = (GraphConnections)this.nodeConnections.get(object);
        if (object3 == null) {
            return false;
        }
        boolean bl3 = this.allowsSelfLoops();
        long l11 = 1L;
        if (bl3 && (object2 = object3.removeSuccessor(object)) != null) {
            object3.removePredecessor(object);
            this.edgeCount = l10 = this.edgeCount - l11;
        }
        object2 = object3.successors().iterator();
        while (bl2 = object2.hasNext()) {
            Object object4 = object2.next();
            mapIteratorCache = this.nodeConnections;
            object4 = (GraphConnections)mapIteratorCache.getWithoutCaching(object4);
            object4.removePredecessor(object);
            this.edgeCount = l10 = this.edgeCount - l11;
        }
        bl3 = this.isDirected();
        bl2 = true;
        if (bl3) {
            object3 = object3.predecessors().iterator();
            while (bl3 = object3.hasNext()) {
                long l12;
                object2 = object3.next();
                mapIteratorCache = this.nodeConnections;
                if ((object2 = ((GraphConnections)mapIteratorCache.getWithoutCaching(object2)).removeSuccessor(object)) != null) {
                    bl3 = bl2;
                } else {
                    bl3 = false;
                    object2 = null;
                }
                Preconditions.checkState(bl3);
                this.edgeCount = l12 = this.edgeCount - l11;
            }
        }
        this.nodeConnections.remove(object);
        Graphs.checkNonNegative(this.edgeCount);
        return bl2;
    }
}

