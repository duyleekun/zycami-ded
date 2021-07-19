/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.graph;

import com.google.common.graph.EndpointPair;
import com.google.common.graph.Graph;

public interface MutableGraph
extends Graph {
    public boolean addNode(Object var1);

    public boolean putEdge(EndpointPair var1);

    public boolean putEdge(Object var1, Object var2);

    public boolean removeEdge(EndpointPair var1);

    public boolean removeEdge(Object var1, Object var2);

    public boolean removeNode(Object var1);
}

