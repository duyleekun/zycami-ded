/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.Sets;
import com.google.common.graph.AbstractDirectedNetworkConnections$1;
import com.google.common.graph.Graphs;
import com.google.common.graph.NetworkConnections;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

public abstract class AbstractDirectedNetworkConnections
implements NetworkConnections {
    public final Map inEdgeMap;
    public final Map outEdgeMap;
    private int selfLoopCount;

    public AbstractDirectedNetworkConnections(Map map, Map map2, int n10) {
        int n11;
        Map map3;
        this.inEdgeMap = map3 = (Map)Preconditions.checkNotNull(map);
        this.outEdgeMap = map3 = (Map)Preconditions.checkNotNull(map2);
        this.selfLoopCount = n11 = Graphs.checkNonNegative(n10);
        int n12 = map.size();
        if (n10 <= n12 && n10 <= (n12 = map2.size())) {
            n12 = 1;
        } else {
            n12 = 0;
            map = null;
        }
        Preconditions.checkState(n12 != 0);
    }

    public static /* synthetic */ int access$000(AbstractDirectedNetworkConnections abstractDirectedNetworkConnections) {
        return abstractDirectedNetworkConnections.selfLoopCount;
    }

    public void addInEdge(Object object, Object object2, boolean bl2) {
        Map map;
        int n10 = 1;
        if (bl2) {
            int n11;
            this.selfLoopCount = n11 = this.selfLoopCount + n10;
            Graphs.checkPositive(n11);
        }
        if ((object = (map = this.inEdgeMap).put(object, object2)) != null) {
            n10 = 0;
        }
        Preconditions.checkState(n10 != 0);
    }

    public void addOutEdge(Object object, Object object2) {
        boolean bl2;
        Map map = this.outEdgeMap;
        if ((object = map.put(object, object2)) == null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        Preconditions.checkState(bl2);
    }

    public Object adjacentNode(Object object) {
        return Preconditions.checkNotNull(this.outEdgeMap.get(object));
    }

    public Set adjacentNodes() {
        Set set = this.predecessors();
        Set set2 = this.successors();
        return Sets.union(set, set2);
    }

    public Set inEdges() {
        return Collections.unmodifiableSet(this.inEdgeMap.keySet());
    }

    public Set incidentEdges() {
        AbstractDirectedNetworkConnections$1 abstractDirectedNetworkConnections$1 = new AbstractDirectedNetworkConnections$1(this);
        return abstractDirectedNetworkConnections$1;
    }

    public Set outEdges() {
        return Collections.unmodifiableSet(this.outEdgeMap.keySet());
    }

    public Object removeInEdge(Object object, boolean bl2) {
        if (bl2) {
            int n10;
            this.selfLoopCount = n10 = this.selfLoopCount + -1;
            Graphs.checkNonNegative(n10);
        }
        return Preconditions.checkNotNull(this.inEdgeMap.remove(object));
    }

    public Object removeOutEdge(Object object) {
        return Preconditions.checkNotNull(this.outEdgeMap.remove(object));
    }
}

