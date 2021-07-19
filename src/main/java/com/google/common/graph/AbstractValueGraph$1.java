/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.graph;

import com.google.common.graph.AbstractGraph;
import com.google.common.graph.AbstractValueGraph;
import com.google.common.graph.ElementOrder;
import java.util.Set;

public class AbstractValueGraph$1
extends AbstractGraph {
    public final /* synthetic */ AbstractValueGraph this$0;

    public AbstractValueGraph$1(AbstractValueGraph abstractValueGraph) {
        this.this$0 = abstractValueGraph;
    }

    public Set adjacentNodes(Object object) {
        return this.this$0.adjacentNodes(object);
    }

    public boolean allowsSelfLoops() {
        return this.this$0.allowsSelfLoops();
    }

    public int degree(Object object) {
        return this.this$0.degree(object);
    }

    public Set edges() {
        return this.this$0.edges();
    }

    public int inDegree(Object object) {
        return this.this$0.inDegree(object);
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

    public int outDegree(Object object) {
        return this.this$0.outDegree(object);
    }

    public Set predecessors(Object object) {
        return this.this$0.predecessors(object);
    }

    public Set successors(Object object) {
        return this.this$0.successors(object);
    }
}

