/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.graph;

import com.google.common.graph.ElementOrder;
import com.google.common.graph.EndpointPair;
import com.google.common.graph.Graph;
import com.google.common.graph.PredecessorsFunction;
import com.google.common.graph.SuccessorsFunction;
import java.util.Set;

public interface Network
extends SuccessorsFunction,
PredecessorsFunction {
    public Set adjacentEdges(Object var1);

    public Set adjacentNodes(Object var1);

    public boolean allowsParallelEdges();

    public boolean allowsSelfLoops();

    public Graph asGraph();

    public int degree(Object var1);

    public Object edgeConnectingOrNull(EndpointPair var1);

    public Object edgeConnectingOrNull(Object var1, Object var2);

    public ElementOrder edgeOrder();

    public Set edges();

    public Set edgesConnecting(EndpointPair var1);

    public Set edgesConnecting(Object var1, Object var2);

    public boolean equals(Object var1);

    public boolean hasEdgeConnecting(EndpointPair var1);

    public boolean hasEdgeConnecting(Object var1, Object var2);

    public int hashCode();

    public int inDegree(Object var1);

    public Set inEdges(Object var1);

    public Set incidentEdges(Object var1);

    public EndpointPair incidentNodes(Object var1);

    public boolean isDirected();

    public ElementOrder nodeOrder();

    public Set nodes();

    public int outDegree(Object var1);

    public Set outEdges(Object var1);

    public Set predecessors(Object var1);

    public Set successors(Object var1);
}

