/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.graph.AbstractBaseGraph$1;
import com.google.common.graph.AbstractBaseGraph$2;
import com.google.common.graph.BaseGraph;
import com.google.common.graph.EndpointPair;
import com.google.common.math.IntMath;
import java.util.Iterator;
import java.util.Set;

public abstract class AbstractBaseGraph
implements BaseGraph {
    public int degree(Object object) {
        int n10;
        int n11 = this.isDirected();
        if (n11 != 0) {
            n11 = this.predecessors(object).size();
            int n12 = this.successors(object).size();
            return IntMath.saturatedAdd(n11, n12);
        }
        Set set = this.adjacentNodes(object);
        boolean bl2 = this.allowsSelfLoops();
        if (bl2 && (n10 = set.contains(object)) != 0) {
            n10 = 1;
        } else {
            n10 = 0;
            object = null;
        }
        return IntMath.saturatedAdd(set.size(), n10);
    }

    public long edgeCount() {
        long l10;
        int n10;
        long l11;
        Iterator iterator2 = this.nodes().iterator();
        long l12 = l11 = 0L;
        while ((n10 = iterator2.hasNext()) != 0) {
            Object e10 = iterator2.next();
            n10 = this.degree(e10);
            l10 = n10;
            l12 += l10;
        }
        l10 = 1L & l12;
        long l13 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        int n11 = 1;
        if (l13 == false) {
            l13 = n11;
        } else {
            l13 = 0;
            iterator2 = null;
        }
        Preconditions.checkState((boolean)l13);
        return l12 >>> n11;
    }

    public Set edges() {
        AbstractBaseGraph$1 abstractBaseGraph$1 = new AbstractBaseGraph$1(this);
        return abstractBaseGraph$1;
    }

    public boolean hasEdgeConnecting(EndpointPair object) {
        boolean bl2;
        Preconditions.checkNotNull(object);
        boolean bl3 = this.isOrderingCompatible((EndpointPair)object);
        boolean bl4 = false;
        if (!bl3) {
            return false;
        }
        Object object2 = ((EndpointPair)object).nodeU();
        object = ((EndpointPair)object).nodeV();
        Set set = this.nodes();
        boolean bl5 = set.contains(object2);
        if (bl5 && (bl2 = (object2 = this.successors(object2)).contains(object))) {
            bl4 = true;
        }
        return bl4;
    }

    public boolean hasEdgeConnecting(Object object, Object object2) {
        boolean bl2;
        Preconditions.checkNotNull(object);
        Preconditions.checkNotNull(object2);
        Set set = this.nodes();
        boolean bl3 = set.contains(object);
        if (bl3 && (bl2 = (object = this.successors(object)).contains(object2))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public int inDegree(Object object) {
        int n10;
        boolean bl2 = this.isDirected();
        if (bl2) {
            object = this.predecessors(object);
            n10 = object.size();
        } else {
            n10 = this.degree(object);
        }
        return n10;
    }

    public Set incidentEdges(Object object) {
        Preconditions.checkNotNull(object);
        Preconditions.checkArgument(this.nodes().contains(object), "Node %s is not an element of this graph.", object);
        AbstractBaseGraph$2 abstractBaseGraph$2 = new AbstractBaseGraph$2(this, this, object);
        return abstractBaseGraph$2;
    }

    public final boolean isOrderingCompatible(EndpointPair endpointPair) {
        boolean bl2 = endpointPair.isOrdered();
        if (!bl2 && (bl2 = this.isDirected())) {
            bl2 = false;
            endpointPair = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public int outDegree(Object object) {
        int n10;
        boolean bl2 = this.isDirected();
        if (bl2) {
            object = this.successors(object);
            n10 = object.size();
        } else {
            n10 = this.degree(object);
        }
        return n10;
    }

    public final void validateEndpoints(EndpointPair endpointPair) {
        Preconditions.checkNotNull(endpointPair);
        Preconditions.checkArgument(this.isOrderingCompatible(endpointPair), "Mismatch: unordered endpoints cannot be used with directed graphs");
    }
}

