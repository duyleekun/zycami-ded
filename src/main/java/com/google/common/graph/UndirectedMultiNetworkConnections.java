/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Multiset;
import com.google.common.graph.AbstractUndirectedNetworkConnections;
import com.google.common.graph.UndirectedMultiNetworkConnections$1;
import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class UndirectedMultiNetworkConnections
extends AbstractUndirectedNetworkConnections {
    private transient Reference adjacentNodesReference;

    private UndirectedMultiNetworkConnections(Map map) {
        super(map);
    }

    public static /* synthetic */ Multiset access$000(UndirectedMultiNetworkConnections undirectedMultiNetworkConnections) {
        return undirectedMultiNetworkConnections.adjacentNodesMultiset();
    }

    private Multiset adjacentNodesMultiset() {
        Multiset multiset = (Multiset)UndirectedMultiNetworkConnections.getReference(this.adjacentNodesReference);
        if (multiset == null) {
            SoftReference<Multiset> softReference;
            multiset = HashMultiset.create(this.incidentEdgeMap.values());
            this.adjacentNodesReference = softReference = new SoftReference<Multiset>(multiset);
        }
        return multiset;
    }

    private static Object getReference(Reference reference) {
        reference = reference == null ? null : reference.get();
        return reference;
    }

    public static UndirectedMultiNetworkConnections of() {
        HashMap hashMap = new HashMap(2, 1.0f);
        UndirectedMultiNetworkConnections undirectedMultiNetworkConnections = new UndirectedMultiNetworkConnections(hashMap);
        return undirectedMultiNetworkConnections;
    }

    public static UndirectedMultiNetworkConnections ofImmutable(Map map) {
        map = ImmutableMap.copyOf(map);
        UndirectedMultiNetworkConnections undirectedMultiNetworkConnections = new UndirectedMultiNetworkConnections(map);
        return undirectedMultiNetworkConnections;
    }

    public void addInEdge(Object object, Object object2, boolean bl2) {
        if (!bl2) {
            this.addOutEdge(object, object2);
        }
    }

    public void addOutEdge(Object object, Object object2) {
        super.addOutEdge(object, object2);
        object = (Multiset)UndirectedMultiNetworkConnections.getReference(this.adjacentNodesReference);
        if (object != null) {
            boolean bl2 = object.add(object2);
            Preconditions.checkState(bl2);
        }
    }

    public Set adjacentNodes() {
        return Collections.unmodifiableSet(this.adjacentNodesMultiset().elementSet());
    }

    public Set edgesConnecting(Object object) {
        Map map = this.incidentEdgeMap;
        UndirectedMultiNetworkConnections$1 undirectedMultiNetworkConnections$1 = new UndirectedMultiNetworkConnections$1(this, map, object, object);
        return undirectedMultiNetworkConnections$1;
    }

    public Object removeInEdge(Object object, boolean bl2) {
        if (!bl2) {
            return this.removeOutEdge(object);
        }
        return null;
    }

    public Object removeOutEdge(Object object) {
        object = super.removeOutEdge(object);
        Multiset multiset = (Multiset)UndirectedMultiNetworkConnections.getReference(this.adjacentNodesReference);
        if (multiset != null) {
            boolean bl2 = multiset.remove(object);
            Preconditions.checkState(bl2);
        }
        return object;
    }
}

