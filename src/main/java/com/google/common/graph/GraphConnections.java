/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.graph;

import java.util.Iterator;
import java.util.Set;

public interface GraphConnections {
    public void addPredecessor(Object var1, Object var2);

    public Object addSuccessor(Object var1, Object var2);

    public Set adjacentNodes();

    public Iterator incidentEdgeIterator(Object var1);

    public Set predecessors();

    public void removePredecessor(Object var1);

    public Object removeSuccessor(Object var1);

    public Set successors();

    public Object value(Object var1);
}

