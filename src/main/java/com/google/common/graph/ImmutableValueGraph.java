/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.graph;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap$Builder;
import com.google.common.collect.Maps;
import com.google.common.graph.ConfigurableValueGraph;
import com.google.common.graph.DirectedGraphConnections;
import com.google.common.graph.GraphConnections;
import com.google.common.graph.ImmutableGraph;
import com.google.common.graph.ImmutableValueGraph$1;
import com.google.common.graph.UndirectedGraphConnections;
import com.google.common.graph.ValueGraph;
import com.google.common.graph.ValueGraphBuilder;
import java.util.Iterator;

public final class ImmutableValueGraph
extends ConfigurableValueGraph {
    private ImmutableValueGraph(ValueGraph valueGraph) {
        ValueGraphBuilder valueGraphBuilder = ValueGraphBuilder.from(valueGraph);
        ImmutableMap immutableMap = ImmutableValueGraph.getNodeConnections(valueGraph);
        long l10 = valueGraph.edges().size();
        super(valueGraphBuilder, immutableMap, l10);
    }

    private static GraphConnections connectionsOf(ValueGraph object, Object object2) {
        ImmutableValueGraph$1 immutableValueGraph$1 = new ImmutableValueGraph$1((ValueGraph)object, object2);
        boolean bl2 = object.isDirected();
        if (bl2) {
            object = object.incidentEdges(object2);
            object = DirectedGraphConnections.ofImmutable(object2, (Iterable)object, immutableValueGraph$1);
        } else {
            object = UndirectedGraphConnections.ofImmutable(Maps.asMap(object.adjacentNodes(object2), (Function)immutableValueGraph$1));
        }
        return object;
    }

    public static ImmutableValueGraph copyOf(ImmutableValueGraph immutableValueGraph) {
        return (ImmutableValueGraph)Preconditions.checkNotNull(immutableValueGraph);
    }

    public static ImmutableValueGraph copyOf(ValueGraph valueGraph) {
        boolean bl2 = valueGraph instanceof ImmutableValueGraph;
        if (bl2) {
            valueGraph = (ImmutableValueGraph)valueGraph;
        } else {
            ImmutableValueGraph immutableValueGraph = new ImmutableValueGraph(valueGraph);
            valueGraph = immutableValueGraph;
        }
        return valueGraph;
    }

    private static ImmutableMap getNodeConnections(ValueGraph valueGraph) {
        boolean bl2;
        ImmutableMap$Builder immutableMap$Builder = ImmutableMap.builder();
        Iterator iterator2 = valueGraph.nodes().iterator();
        while (bl2 = iterator2.hasNext()) {
            Object e10 = iterator2.next();
            GraphConnections graphConnections = ImmutableValueGraph.connectionsOf(valueGraph, e10);
            immutableMap$Builder.put(e10, graphConnections);
        }
        return immutableMap$Builder.build();
    }

    public ImmutableGraph asGraph() {
        ImmutableGraph immutableGraph = new ImmutableGraph(this);
        return immutableGraph;
    }
}

