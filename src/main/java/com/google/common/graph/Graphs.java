/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.graph;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import com.google.common.graph.EndpointPair;
import com.google.common.graph.Graph;
import com.google.common.graph.GraphBuilder;
import com.google.common.graph.Graphs$NodeVisitState;
import com.google.common.graph.Graphs$TransposedGraph;
import com.google.common.graph.Graphs$TransposedNetwork;
import com.google.common.graph.Graphs$TransposedValueGraph;
import com.google.common.graph.MutableGraph;
import com.google.common.graph.MutableNetwork;
import com.google.common.graph.MutableValueGraph;
import com.google.common.graph.Network;
import com.google.common.graph.NetworkBuilder;
import com.google.common.graph.Traverser;
import com.google.common.graph.ValueGraph;
import com.google.common.graph.ValueGraphBuilder;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class Graphs {
    private Graphs() {
    }

    private static boolean canTraverseWithoutReusingEdge(Graph graph, Object object, Object object2) {
        boolean bl2 = graph.isDirected();
        return bl2 || !(bl2 = Objects.equal(object2, object));
        {
        }
    }

    public static int checkNonNegative(int n10) {
        boolean bl2 = n10 >= 0;
        Preconditions.checkArgument(bl2, "Not true that %s is non-negative.", n10);
        return n10;
    }

    public static long checkNonNegative(long l10) {
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        object = object >= 0 ? (Object)1 : (Object)0;
        Preconditions.checkArgument((boolean)object, "Not true that %s is non-negative.", l10);
        return l10;
    }

    public static int checkPositive(int n10) {
        boolean bl2 = n10 > 0;
        Preconditions.checkArgument(bl2, "Not true that %s is positive.", n10);
        return n10;
    }

    public static long checkPositive(long l10) {
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        object = object > 0 ? (Object)1 : (Object)0;
        Preconditions.checkArgument((boolean)object, "Not true that %s is positive.", l10);
        return l10;
    }

    public static MutableGraph copyOf(Graph object) {
        Object object2;
        boolean bl2;
        Object object3 = GraphBuilder.from((Graph)object);
        int n10 = object.nodes().size();
        object3 = ((GraphBuilder)object3).expectedNodeCount(n10).build();
        Object object4 = object.nodes().iterator();
        while (bl2 = object4.hasNext()) {
            object2 = object4.next();
            object3.addNode(object2);
        }
        object = object.edges().iterator();
        while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            object4 = (EndpointPair)object.next();
            object2 = ((EndpointPair)object4).nodeU();
            object4 = ((EndpointPair)object4).nodeV();
            object3.putEdge(object2, object4);
        }
        return object3;
    }

    public static MutableNetwork copyOf(Network network) {
        Object e10;
        boolean bl2;
        Object object = NetworkBuilder.from(network);
        int n10 = network.nodes().size();
        object = ((NetworkBuilder)object).expectedNodeCount(n10);
        n10 = network.edges().size();
        object = ((NetworkBuilder)object).expectedEdgeCount(n10).build();
        Iterator iterator2 = network.nodes().iterator();
        while (bl2 = iterator2.hasNext()) {
            e10 = iterator2.next();
            object.addNode(e10);
        }
        iterator2 = network.edges().iterator();
        while (bl2 = iterator2.hasNext()) {
            e10 = iterator2.next();
            Object object2 = network.incidentNodes(e10);
            Object object3 = ((EndpointPair)object2).nodeU();
            object2 = ((EndpointPair)object2).nodeV();
            object.addEdge(object3, object2, e10);
        }
        return object;
    }

    public static MutableValueGraph copyOf(ValueGraph valueGraph) {
        Object object;
        boolean bl2;
        Object object2 = ValueGraphBuilder.from(valueGraph);
        int n10 = valueGraph.nodes().size();
        object2 = ((ValueGraphBuilder)object2).expectedNodeCount(n10).build();
        Iterator iterator2 = valueGraph.nodes().iterator();
        while (bl2 = iterator2.hasNext()) {
            object = iterator2.next();
            object2.addNode(object);
        }
        iterator2 = valueGraph.edges().iterator();
        while (bl2 = iterator2.hasNext()) {
            object = (EndpointPair)iterator2.next();
            Object object3 = ((EndpointPair)object).nodeU();
            Object object4 = ((EndpointPair)object).nodeV();
            Object object5 = ((EndpointPair)object).nodeU();
            object = ((EndpointPair)object).nodeV();
            object = valueGraph.edgeValueOrDefault(object5, object, null);
            object2.putEdgeValue(object3, object4, object);
        }
        return object2;
    }

    public static boolean hasCycle(Graph graph) {
        boolean bl2;
        Object object;
        Object object2 = graph.edges();
        int n10 = object2.size();
        if (n10 == 0) {
            return false;
        }
        int n11 = graph.isDirected();
        boolean bl3 = true;
        if (n11 == 0 && n10 >= (n11 = (object = graph.nodes()).size())) {
            return bl3;
        }
        n10 = graph.nodes().size();
        object2 = Maps.newHashMapWithExpectedSize(n10);
        object = graph.nodes().iterator();
        while (bl2 = object.hasNext()) {
            Object e10 = object.next();
            bl2 = Graphs.subgraphHasCycle(graph, (Map)object2, e10, null);
            if (!bl2) continue;
            return bl3;
        }
        return false;
    }

    public static boolean hasCycle(Network network) {
        Set set;
        int n10;
        Set set2;
        int n11 = network.isDirected();
        if (n11 == 0 && (n11 = network.allowsParallelEdges()) != 0 && (n11 = (set2 = network.edges()).size()) > (n10 = (set = network.asGraph().edges()).size())) {
            return true;
        }
        return Graphs.hasCycle(network.asGraph());
    }

    public static MutableGraph inducedSubgraph(Graph graph, Iterable iterator2) {
        int n10;
        Iterable<Object> iterable;
        Object object;
        boolean bl2 = iterator2 instanceof Collection;
        if (bl2) {
            object = GraphBuilder.from(graph);
            iterable = iterator2;
            iterable = (Collection)((Object)iterator2);
            n10 = iterable.size();
            object = ((GraphBuilder)object).expectedNodeCount(n10).build();
        } else {
            object = GraphBuilder.from(graph).build();
        }
        iterator2 = iterator2.iterator();
        while ((n10 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
            iterable = iterator2.next();
            object.addNode(iterable);
        }
        iterator2 = object.nodes().iterator();
        while ((n10 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
            boolean bl3;
            iterable = iterator2.next();
            Iterator iterator3 = graph.successors(iterable).iterator();
            while (bl3 = iterator3.hasNext()) {
                Object e10 = iterator3.next();
                Set set = object.nodes();
                boolean bl4 = set.contains(e10);
                if (!bl4) continue;
                object.putEdge(iterable, e10);
            }
        }
        return object;
    }

    public static MutableNetwork inducedSubgraph(Network network, Iterable iterator2) {
        int n10;
        Iterable<Object> iterable;
        Object object;
        boolean bl2 = iterator2 instanceof Collection;
        if (bl2) {
            object = NetworkBuilder.from(network);
            iterable = iterator2;
            iterable = (Collection)((Object)iterator2);
            n10 = iterable.size();
            object = ((NetworkBuilder)object).expectedNodeCount(n10).build();
        } else {
            object = NetworkBuilder.from(network).build();
        }
        iterator2 = iterator2.iterator();
        while ((n10 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
            iterable = iterator2.next();
            object.addNode(iterable);
        }
        iterator2 = object.nodes().iterator();
        while ((n10 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
            boolean bl3;
            iterable = iterator2.next();
            Iterator iterator3 = network.outEdges(iterable).iterator();
            while (bl3 = iterator3.hasNext()) {
                Object e10 = iterator3.next();
                Object object2 = network.incidentNodes(e10).adjacentNode(iterable);
                Set set = object.nodes();
                boolean bl4 = set.contains(object2);
                if (!bl4) continue;
                object.addEdge(iterable, object2, e10);
            }
        }
        return object;
    }

    public static MutableValueGraph inducedSubgraph(ValueGraph valueGraph, Iterable iterator2) {
        int n10;
        Iterable<Object> iterable;
        Object object;
        boolean bl2 = iterator2 instanceof Collection;
        if (bl2) {
            object = ValueGraphBuilder.from(valueGraph);
            iterable = iterator2;
            iterable = (Collection)((Object)iterator2);
            n10 = iterable.size();
            object = ((ValueGraphBuilder)object).expectedNodeCount(n10).build();
        } else {
            object = ValueGraphBuilder.from(valueGraph).build();
        }
        iterator2 = iterator2.iterator();
        while ((n10 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
            iterable = iterator2.next();
            object.addNode(iterable);
        }
        iterator2 = object.nodes().iterator();
        while ((n10 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
            boolean bl3;
            iterable = iterator2.next();
            Iterator iterator3 = valueGraph.successors(iterable).iterator();
            while (bl3 = iterator3.hasNext()) {
                Object e10 = iterator3.next();
                Object object2 = object.nodes();
                boolean bl4 = object2.contains(e10);
                if (!bl4) continue;
                bl4 = false;
                object2 = valueGraph.edgeValueOrDefault(iterable, e10, null);
                object.putEdgeValue(iterable, e10, object2);
            }
        }
        return object;
    }

    public static Set reachableNodes(Graph graph, Object object) {
        Preconditions.checkArgument(graph.nodes().contains(object), "Node %s is not an element of this graph.", object);
        return ImmutableSet.copyOf(Traverser.forGraph(graph).breadthFirst(object));
    }

    private static boolean subgraphHasCycle(Graph object, Map map, Object object2, Object object3) {
        boolean bl2;
        Graphs$NodeVisitState graphs$NodeVisitState;
        Object object4 = (Graphs$NodeVisitState)((Object)map.get(object2));
        if (object4 == (graphs$NodeVisitState = Graphs$NodeVisitState.COMPLETE)) {
            return false;
        }
        graphs$NodeVisitState = Graphs$NodeVisitState.PENDING;
        boolean bl3 = true;
        if (object4 == graphs$NodeVisitState) {
            return bl3;
        }
        map.put(object2, graphs$NodeVisitState);
        object4 = object.successors(object2).iterator();
        while (bl2 = object4.hasNext()) {
            graphs$NodeVisitState = object4.next();
            boolean bl4 = Graphs.canTraverseWithoutReusingEdge(object, (Object)graphs$NodeVisitState, object3);
            if (!bl4 || !(bl2 = Graphs.subgraphHasCycle(object, map, (Object)graphs$NodeVisitState, object2))) continue;
            return bl3;
        }
        object = Graphs$NodeVisitState.COMPLETE;
        map.put(object2, object);
        return false;
    }

    public static Graph transitiveClosure(Graph graph) {
        Object object = GraphBuilder.from(graph);
        int n10 = 1;
        object = ((GraphBuilder)object).allowsSelfLoops(n10 != 0).build();
        boolean bl2 = graph.isDirected();
        if (bl2) {
            Iterator iterator2 = graph.nodes().iterator();
            while (bl2 = iterator2.hasNext()) {
                boolean bl3;
                Object e10 = iterator2.next();
                Iterator iterator3 = Graphs.reachableNodes(graph, e10).iterator();
                while (bl3 = iterator3.hasNext()) {
                    Object e11 = iterator3.next();
                    object.putEdge(e10, e11);
                }
            }
        } else {
            boolean bl4;
            HashSet hashSet = new HashSet();
            Iterator iterator4 = graph.nodes().iterator();
            while (bl4 = iterator4.hasNext()) {
                boolean bl5;
                Object object2 = iterator4.next();
                boolean bl6 = hashSet.contains(object2);
                if (bl6) continue;
                object2 = Graphs.reachableNodes(graph, object2);
                hashSet.addAll(object2);
                Iterator iterator5 = object2.iterator();
                int n11 = n10;
                while (bl5 = iterator5.hasNext()) {
                    boolean bl7;
                    Object e12 = iterator5.next();
                    int n12 = n11 + 1;
                    Iterator iterator6 = Iterables.limit((Iterable)object2, n11).iterator();
                    while (bl7 = iterator6.hasNext()) {
                        Object t10 = iterator6.next();
                        object.putEdge(e12, t10);
                    }
                    n11 = n12;
                }
            }
        }
        return object;
    }

    public static EndpointPair transpose(EndpointPair object) {
        boolean bl2 = ((EndpointPair)object).isOrdered();
        if (bl2) {
            Object object2 = ((EndpointPair)object).target();
            object = ((EndpointPair)object).source();
            object = EndpointPair.ordered(object2, object);
        }
        return object;
    }

    public static Graph transpose(Graph graph) {
        boolean bl2 = graph.isDirected();
        if (!bl2) {
            return graph;
        }
        bl2 = graph instanceof Graphs$TransposedGraph;
        if (bl2) {
            return Graphs$TransposedGraph.access$000((Graphs$TransposedGraph)graph);
        }
        Graphs$TransposedGraph graphs$TransposedGraph = new Graphs$TransposedGraph(graph);
        return graphs$TransposedGraph;
    }

    public static Network transpose(Network network) {
        boolean bl2 = network.isDirected();
        if (!bl2) {
            return network;
        }
        bl2 = network instanceof Graphs$TransposedNetwork;
        if (bl2) {
            return Graphs$TransposedNetwork.access$200((Graphs$TransposedNetwork)network);
        }
        Graphs$TransposedNetwork graphs$TransposedNetwork = new Graphs$TransposedNetwork(network);
        return graphs$TransposedNetwork;
    }

    public static ValueGraph transpose(ValueGraph valueGraph) {
        boolean bl2 = valueGraph.isDirected();
        if (!bl2) {
            return valueGraph;
        }
        bl2 = valueGraph instanceof Graphs$TransposedValueGraph;
        if (bl2) {
            return Graphs$TransposedValueGraph.access$100((Graphs$TransposedValueGraph)valueGraph);
        }
        Graphs$TransposedValueGraph graphs$TransposedValueGraph = new Graphs$TransposedValueGraph(valueGraph);
        return graphs$TransposedValueGraph;
    }
}

