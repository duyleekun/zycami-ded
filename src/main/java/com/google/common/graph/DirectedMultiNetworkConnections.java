/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Multiset;
import com.google.common.graph.AbstractDirectedNetworkConnections;
import com.google.common.graph.DirectedMultiNetworkConnections$1;
import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class DirectedMultiNetworkConnections
extends AbstractDirectedNetworkConnections {
    private transient Reference predecessorsReference;
    private transient Reference successorsReference;

    private DirectedMultiNetworkConnections(Map map, Map map2, int n10) {
        super(map, map2, n10);
    }

    public static /* synthetic */ Multiset access$000(DirectedMultiNetworkConnections directedMultiNetworkConnections) {
        return directedMultiNetworkConnections.successorsMultiset();
    }

    private static Object getReference(Reference reference) {
        reference = reference == null ? null : reference.get();
        return reference;
    }

    public static DirectedMultiNetworkConnections of() {
        int n10 = 2;
        float f10 = 1.0f;
        HashMap hashMap = new HashMap(n10, f10);
        HashMap hashMap2 = new HashMap(n10, f10);
        DirectedMultiNetworkConnections directedMultiNetworkConnections = new DirectedMultiNetworkConnections(hashMap, hashMap2, 0);
        return directedMultiNetworkConnections;
    }

    public static DirectedMultiNetworkConnections ofImmutable(Map map, Map map2, int n10) {
        map = ImmutableMap.copyOf(map);
        map2 = ImmutableMap.copyOf(map2);
        DirectedMultiNetworkConnections directedMultiNetworkConnections = new DirectedMultiNetworkConnections(map, map2, n10);
        return directedMultiNetworkConnections;
    }

    private Multiset predecessorsMultiset() {
        Multiset multiset = (Multiset)DirectedMultiNetworkConnections.getReference(this.predecessorsReference);
        if (multiset == null) {
            SoftReference<Multiset> softReference;
            multiset = HashMultiset.create(this.inEdgeMap.values());
            this.predecessorsReference = softReference = new SoftReference<Multiset>(multiset);
        }
        return multiset;
    }

    private Multiset successorsMultiset() {
        Multiset multiset = (Multiset)DirectedMultiNetworkConnections.getReference(this.successorsReference);
        if (multiset == null) {
            SoftReference<Multiset> softReference;
            multiset = HashMultiset.create(this.outEdgeMap.values());
            this.successorsReference = softReference = new SoftReference<Multiset>(multiset);
        }
        return multiset;
    }

    public void addInEdge(Object object, Object object2, boolean bl2) {
        super.addInEdge(object, object2, bl2);
        object = (Multiset)DirectedMultiNetworkConnections.getReference(this.predecessorsReference);
        if (object != null) {
            boolean bl3 = object.add(object2);
            Preconditions.checkState(bl3);
        }
    }

    public void addOutEdge(Object object, Object object2) {
        super.addOutEdge(object, object2);
        object = (Multiset)DirectedMultiNetworkConnections.getReference(this.successorsReference);
        if (object != null) {
            boolean bl2 = object.add(object2);
            Preconditions.checkState(bl2);
        }
    }

    public Set edgesConnecting(Object object) {
        Map map = this.outEdgeMap;
        DirectedMultiNetworkConnections$1 directedMultiNetworkConnections$1 = new DirectedMultiNetworkConnections$1(this, map, object, object);
        return directedMultiNetworkConnections$1;
    }

    public Set predecessors() {
        return Collections.unmodifiableSet(this.predecessorsMultiset().elementSet());
    }

    public Object removeInEdge(Object object, boolean bl2) {
        object = super.removeInEdge(object, bl2);
        Multiset multiset = (Multiset)DirectedMultiNetworkConnections.getReference(this.predecessorsReference);
        if (multiset != null) {
            bl2 = multiset.remove(object);
            Preconditions.checkState(bl2);
        }
        return object;
    }

    public Object removeOutEdge(Object object) {
        object = super.removeOutEdge(object);
        Multiset multiset = (Multiset)DirectedMultiNetworkConnections.getReference(this.successorsReference);
        if (multiset != null) {
            boolean bl2 = multiset.remove(object);
            Preconditions.checkState(bl2);
        }
        return object;
    }

    public Set successors() {
        return Collections.unmodifiableSet(this.successorsMultiset().elementSet());
    }
}

