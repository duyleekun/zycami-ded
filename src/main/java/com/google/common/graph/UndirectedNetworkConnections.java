/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.graph;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.graph.AbstractUndirectedNetworkConnections;
import com.google.common.graph.EdgesConnecting;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

public final class UndirectedNetworkConnections
extends AbstractUndirectedNetworkConnections {
    public UndirectedNetworkConnections(Map map) {
        super(map);
    }

    public static UndirectedNetworkConnections of() {
        HashBiMap hashBiMap = HashBiMap.create(2);
        UndirectedNetworkConnections undirectedNetworkConnections = new UndirectedNetworkConnections(hashBiMap);
        return undirectedNetworkConnections;
    }

    public static UndirectedNetworkConnections ofImmutable(Map map) {
        map = ImmutableBiMap.copyOf(map);
        UndirectedNetworkConnections undirectedNetworkConnections = new UndirectedNetworkConnections(map);
        return undirectedNetworkConnections;
    }

    public Set adjacentNodes() {
        return Collections.unmodifiableSet(((BiMap)this.incidentEdgeMap).values());
    }

    public Set edgesConnecting(Object object) {
        BiMap biMap = ((BiMap)this.incidentEdgeMap).inverse();
        EdgesConnecting edgesConnecting = new EdgesConnecting(biMap, object);
        return edgesConnecting;
    }
}

