/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.graph;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap$Builder;
import com.google.common.collect.Maps;
import com.google.common.graph.BaseGraph;
import com.google.common.graph.ConfigurableValueGraph;
import com.google.common.graph.DirectedGraphConnections;
import com.google.common.graph.ForwardingGraph;
import com.google.common.graph.Graph;
import com.google.common.graph.GraphBuilder;
import com.google.common.graph.GraphConnections;
import com.google.common.graph.GraphConstants$Presence;
import com.google.common.graph.UndirectedGraphConnections;
import java.util.Iterator;

public class ImmutableGraph
extends ForwardingGraph {
    private final BaseGraph backingGraph;

    public ImmutableGraph(BaseGraph baseGraph) {
        this.backingGraph = baseGraph;
    }

    private static GraphConnections connectionsOf(Graph object, Object object2) {
        Function function = Functions.constant((Object)GraphConstants$Presence.EDGE_EXISTS);
        boolean bl2 = object.isDirected();
        if (bl2) {
            object = object.incidentEdges(object2);
            object = DirectedGraphConnections.ofImmutable(object2, (Iterable)object, function);
        } else {
            object = UndirectedGraphConnections.ofImmutable(Maps.asMap(object.adjacentNodes(object2), function));
        }
        return object;
    }

    public static ImmutableGraph copyOf(Graph graph) {
        boolean bl2 = graph instanceof ImmutableGraph;
        if (bl2) {
            graph = (ImmutableGraph)graph;
        } else {
            GraphBuilder graphBuilder = GraphBuilder.from(graph);
            ImmutableMap immutableMap = ImmutableGraph.getNodeConnections(graph);
            int n10 = graph.edges().size();
            long l10 = n10;
            ConfigurableValueGraph configurableValueGraph = new ConfigurableValueGraph(graphBuilder, immutableMap, l10);
            ImmutableGraph immutableGraph = new ImmutableGraph(configurableValueGraph);
            graph = immutableGraph;
        }
        return graph;
    }

    public static ImmutableGraph copyOf(ImmutableGraph immutableGraph) {
        return (ImmutableGraph)Preconditions.checkNotNull(immutableGraph);
    }

    private static ImmutableMap getNodeConnections(Graph graph) {
        boolean bl2;
        ImmutableMap$Builder immutableMap$Builder = ImmutableMap.builder();
        Iterator iterator2 = graph.nodes().iterator();
        while (bl2 = iterator2.hasNext()) {
            Object e10 = iterator2.next();
            GraphConnections graphConnections = ImmutableGraph.connectionsOf(graph, e10);
            immutableMap$Builder.put(e10, graphConnections);
        }
        return immutableMap$Builder.build();
    }

    public BaseGraph delegate() {
        return this.backingGraph;
    }
}

