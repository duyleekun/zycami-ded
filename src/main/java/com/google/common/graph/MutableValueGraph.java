/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.graph;

import com.google.common.graph.EndpointPair;
import com.google.common.graph.ValueGraph;

public interface MutableValueGraph
extends ValueGraph {
    public boolean addNode(Object var1);

    public Object putEdgeValue(EndpointPair var1, Object var2);

    public Object putEdgeValue(Object var1, Object var2, Object var3);

    public Object removeEdge(EndpointPair var1);

    public Object removeEdge(Object var1, Object var2);

    public boolean removeNode(Object var1);
}

