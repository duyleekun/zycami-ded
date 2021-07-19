/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.graph;

import com.google.common.graph.BaseGraph;
import com.google.common.graph.EndpointPair;
import java.util.AbstractSet;

public abstract class IncidentEdgeSet
extends AbstractSet {
    public final BaseGraph graph;
    public final Object node;

    public IncidentEdgeSet(BaseGraph baseGraph, Object object) {
        this.graph = baseGraph;
        this.node = object;
    }

    public boolean contains(Object object) {
        boolean bl2;
        boolean bl3;
        boolean bl4;
        Object object2;
        boolean bl5;
        boolean bl6;
        block7: {
            block10: {
                block9: {
                    boolean bl7;
                    Object object3;
                    block8: {
                        bl6 = object instanceof EndpointPair;
                        bl5 = false;
                        if (!bl6) {
                            return false;
                        }
                        object = (EndpointPair)object;
                        object2 = this.graph;
                        bl6 = object2.isDirected();
                        bl4 = true;
                        if (!bl6) break block7;
                        bl6 = ((EndpointPair)object).isOrdered();
                        if (!bl6) {
                            return false;
                        }
                        object2 = ((EndpointPair)object).source();
                        object = ((EndpointPair)object).target();
                        object3 = this.node;
                        boolean bl8 = object3.equals(object2);
                        if (!bl8) break block8;
                        object3 = this.graph;
                        Object object4 = this.node;
                        bl8 = (object3 = object3.successors(object4)).contains(object);
                        if (bl8) break block9;
                    }
                    if (!(bl7 = (object3 = this.node).equals(object))) break block10;
                    object = this.graph;
                    object3 = this.node;
                    bl7 = (object = object.predecessors(object3)).contains(object2);
                    if (!bl7) break block10;
                }
                bl5 = bl4;
            }
            return bl5;
        }
        bl6 = ((EndpointPair)object).isOrdered();
        if (bl6) {
            return false;
        }
        object2 = this.graph;
        Object object5 = this.node;
        object2 = object2.adjacentNodes(object5);
        object5 = ((EndpointPair)object).nodeU();
        Object object6 = this.node;
        boolean bl9 = object6.equals(object = ((EndpointPair)object).nodeV());
        if (bl9 && (bl9 = object2.contains(object5)) || (bl3 = (object6 = this.node).equals(object5)) && (bl2 = object2.contains(object))) {
            bl5 = bl4;
        }
        return bl5;
    }

    public boolean remove(Object object) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public int size() {
        BaseGraph baseGraph = this.graph;
        int n10 = baseGraph.isDirected();
        if (n10 != 0) {
            baseGraph = this.graph;
            Object object = this.node;
            n10 = baseGraph.inDegree(object);
            object = this.graph;
            Object object2 = this.node;
            int n11 = object.outDegree(object2);
            n10 += n11;
            object = this.graph;
            object2 = this.node;
            object = object.successors(object2);
            object2 = this.node;
            n11 = (int)(object.contains(object2) ? 1 : 0);
            return n10 - n11;
        }
        baseGraph = this.graph;
        Object object = this.node;
        return baseGraph.adjacentNodes(object).size();
    }
}

