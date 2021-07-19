/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.graph;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.graph.AbstractDirectedNetworkConnections;
import com.google.common.graph.EdgesConnecting;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

public final class DirectedNetworkConnections
extends AbstractDirectedNetworkConnections {
    public DirectedNetworkConnections(Map map, Map map2, int n10) {
        super(map, map2, n10);
    }

    public static DirectedNetworkConnections of() {
        int n10 = 2;
        HashBiMap hashBiMap = HashBiMap.create(n10);
        HashBiMap hashBiMap2 = HashBiMap.create(n10);
        DirectedNetworkConnections directedNetworkConnections = new DirectedNetworkConnections(hashBiMap, hashBiMap2, 0);
        return directedNetworkConnections;
    }

    public static DirectedNetworkConnections ofImmutable(Map map, Map map2, int n10) {
        map = ImmutableBiMap.copyOf(map);
        map2 = ImmutableBiMap.copyOf(map2);
        DirectedNetworkConnections directedNetworkConnections = new DirectedNetworkConnections(map, map2, n10);
        return directedNetworkConnections;
    }

    public Set edgesConnecting(Object object) {
        BiMap biMap = ((BiMap)this.outEdgeMap).inverse();
        EdgesConnecting edgesConnecting = new EdgesConnecting(biMap, object);
        return edgesConnecting;
    }

    public Set predecessors() {
        return Collections.unmodifiableSet(((BiMap)this.inEdgeMap).values());
    }

    public Set successors() {
        return Collections.unmodifiableSet(((BiMap)this.outEdgeMap).values());
    }
}

