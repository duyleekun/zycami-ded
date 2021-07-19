/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.graph;

import java.util.Set;

public interface NetworkConnections {
    public void addInEdge(Object var1, Object var2, boolean var3);

    public void addOutEdge(Object var1, Object var2);

    public Object adjacentNode(Object var1);

    public Set adjacentNodes();

    public Set edgesConnecting(Object var1);

    public Set inEdges();

    public Set incidentEdges();

    public Set outEdges();

    public Set predecessors();

    public Object removeInEdge(Object var1, boolean var2);

    public Object removeOutEdge(Object var1);

    public Set successors();
}

