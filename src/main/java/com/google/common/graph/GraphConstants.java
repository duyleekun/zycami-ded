/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.graph;

public final class GraphConstants {
    public static final int DEFAULT_EDGE_COUNT = 20;
    public static final int DEFAULT_NODE_COUNT = 10;
    public static final String EDGE_ALREADY_EXISTS = "Edge %s already exists in the graph.";
    public static final String EDGE_NOT_IN_GRAPH = "Edge %s is not an element of this graph.";
    public static final String ENDPOINTS_MISMATCH = "Mismatch: unordered endpoints cannot be used with directed graphs";
    public static final int EXPECTED_DEGREE = 2;
    public static final int INNER_CAPACITY = 2;
    public static final float INNER_LOAD_FACTOR = 1.0f;
    public static final String MULTIPLE_EDGES_CONNECTING = "Cannot call edgeConnecting() when parallel edges exist between %s and %s. Consider calling edgesConnecting() instead.";
    public static final String NODE_NOT_IN_GRAPH = "Node %s is not an element of this graph.";
    public static final String NOT_AVAILABLE_ON_UNDIRECTED = "Cannot call source()/target() on a EndpointPair from an undirected graph. Consider calling adjacentNode(node) if you already have a node, or nodeU()/nodeV() if you don't.";
    public static final String PARALLEL_EDGES_NOT_ALLOWED = "Nodes %s and %s are already connected by a different edge. To construct a graph that allows parallel edges, call allowsParallelEdges(true) on the Builder.";
    public static final String REUSING_EDGE = "Edge %s already exists between the following nodes: %s, so it cannot be reused to connect the following nodes: %s.";
    public static final String SELF_LOOPS_NOT_ALLOWED = "Cannot add self-loop edge on node %s, as self-loops are not allowed. To construct a graph that allows self-loops, call allowsSelfLoops(true) on the Builder.";

    private GraphConstants() {
    }
}

