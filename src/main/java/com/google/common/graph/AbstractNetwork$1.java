/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.graph;

import com.google.common.graph.AbstractGraph;
import com.google.common.graph.AbstractNetwork;
import com.google.common.graph.AbstractNetwork$1$1;
import com.google.common.graph.ElementOrder;
import java.util.Set;

public class AbstractNetwork$1
extends AbstractGraph {
    public final /* synthetic */ AbstractNetwork this$0;

    public AbstractNetwork$1(AbstractNetwork abstractNetwork) {
        this.this$0 = abstractNetwork;
    }

    public Set adjacentNodes(Object object) {
        return this.this$0.adjacentNodes(object);
    }

    public boolean allowsSelfLoops() {
        return this.this$0.allowsSelfLoops();
    }

    public Set edges() {
        Object object = this.this$0;
        boolean bl2 = object.allowsParallelEdges();
        if (bl2) {
            return super.edges();
        }
        object = new AbstractNetwork$1$1(this);
        return object;
    }

    public boolean isDirected() {
        return this.this$0.isDirected();
    }

    public ElementOrder nodeOrder() {
        return this.this$0.nodeOrder();
    }

    public Set nodes() {
        return this.this$0.nodes();
    }

    public Set predecessors(Object object) {
        return this.this$0.predecessors(object);
    }

    public Set successors(Object object) {
        return this.this$0.successors(object);
    }
}

