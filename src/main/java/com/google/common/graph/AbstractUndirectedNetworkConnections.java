/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.graph.NetworkConnections;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

public abstract class AbstractUndirectedNetworkConnections
implements NetworkConnections {
    public final Map incidentEdgeMap;

    public AbstractUndirectedNetworkConnections(Map map) {
        this.incidentEdgeMap = map = (Map)Preconditions.checkNotNull(map);
    }

    public void addInEdge(Object object, Object object2, boolean bl2) {
        if (!bl2) {
            this.addOutEdge(object, object2);
        }
    }

    public void addOutEdge(Object object, Object object2) {
        boolean bl2;
        Map map = this.incidentEdgeMap;
        if ((object = map.put(object, object2)) == null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        Preconditions.checkState(bl2);
    }

    public Object adjacentNode(Object object) {
        return Preconditions.checkNotNull(this.incidentEdgeMap.get(object));
    }

    public Set inEdges() {
        return this.incidentEdges();
    }

    public Set incidentEdges() {
        return Collections.unmodifiableSet(this.incidentEdgeMap.keySet());
    }

    public Set outEdges() {
        return this.incidentEdges();
    }

    public Set predecessors() {
        return this.adjacentNodes();
    }

    public Object removeInEdge(Object object, boolean bl2) {
        if (!bl2) {
            return this.removeOutEdge(object);
        }
        return null;
    }

    public Object removeOutEdge(Object object) {
        return Preconditions.checkNotNull(this.incidentEdgeMap.remove(object));
    }

    public Set successors() {
        return this.adjacentNodes();
    }
}

