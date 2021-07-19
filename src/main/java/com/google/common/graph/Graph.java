/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.graph;

import com.google.common.graph.BaseGraph;
import com.google.common.graph.ElementOrder;
import com.google.common.graph.EndpointPair;
import java.util.Set;

public interface Graph
extends BaseGraph {
    public Set adjacentNodes(Object var1);

    public boolean allowsSelfLoops();

    public int degree(Object var1);

    public Set edges();

    public boolean equals(Object var1);

    public boolean hasEdgeConnecting(EndpointPair var1);

    public boolean hasEdgeConnecting(Object var1, Object var2);

    public int hashCode();

    public int inDegree(Object var1);

    public Set incidentEdges(Object var1);

    public boolean isDirected();

    public ElementOrder nodeOrder();

    public Set nodes();

    public int outDegree(Object var1);

    public Set predecessors(Object var1);

    public Set successors(Object var1);
}

