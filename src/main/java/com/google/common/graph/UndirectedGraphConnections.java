/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterators;
import com.google.common.graph.GraphConnections;
import com.google.common.graph.UndirectedGraphConnections$1;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class UndirectedGraphConnections
implements GraphConnections {
    private final Map adjacentNodeValues;

    private UndirectedGraphConnections(Map map) {
        this.adjacentNodeValues = map = (Map)Preconditions.checkNotNull(map);
    }

    public static UndirectedGraphConnections of() {
        HashMap hashMap = new HashMap(2, 1.0f);
        UndirectedGraphConnections undirectedGraphConnections = new UndirectedGraphConnections(hashMap);
        return undirectedGraphConnections;
    }

    public static UndirectedGraphConnections ofImmutable(Map map) {
        map = ImmutableMap.copyOf(map);
        UndirectedGraphConnections undirectedGraphConnections = new UndirectedGraphConnections(map);
        return undirectedGraphConnections;
    }

    public void addPredecessor(Object object, Object object2) {
        this.addSuccessor(object, object2);
    }

    public Object addSuccessor(Object object, Object object2) {
        return this.adjacentNodeValues.put(object, object2);
    }

    public Set adjacentNodes() {
        return Collections.unmodifiableSet(this.adjacentNodeValues.keySet());
    }

    public Iterator incidentEdgeIterator(Object object) {
        Iterator iterator2 = this.adjacentNodeValues.keySet().iterator();
        UndirectedGraphConnections$1 undirectedGraphConnections$1 = new UndirectedGraphConnections$1(this, object);
        return Iterators.transform(iterator2, undirectedGraphConnections$1);
    }

    public Set predecessors() {
        return this.adjacentNodes();
    }

    public void removePredecessor(Object object) {
        this.removeSuccessor(object);
    }

    public Object removeSuccessor(Object object) {
        return this.adjacentNodeValues.remove(object);
    }

    public Set successors() {
        return this.adjacentNodes();
    }

    public Object value(Object object) {
        return this.adjacentNodeValues.get(object);
    }
}

