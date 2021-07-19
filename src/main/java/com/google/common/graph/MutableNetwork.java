/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.graph;

import com.google.common.graph.EndpointPair;
import com.google.common.graph.Network;

public interface MutableNetwork
extends Network {
    public boolean addEdge(EndpointPair var1, Object var2);

    public boolean addEdge(Object var1, Object var2, Object var3);

    public boolean addNode(Object var1);

    public boolean removeEdge(Object var1);

    public boolean removeNode(Object var1);
}

