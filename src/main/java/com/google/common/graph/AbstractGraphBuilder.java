/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.graph;

import com.google.common.base.Optional;
import com.google.common.graph.ElementOrder;

public abstract class AbstractGraphBuilder {
    public boolean allowsSelfLoops = false;
    public final boolean directed;
    public Optional expectedNodeCount;
    public ElementOrder incidentEdgeOrder;
    public ElementOrder nodeOrder;

    public AbstractGraphBuilder(boolean bl2) {
        Object object = ElementOrder.insertion();
        this.nodeOrder = object;
        object = ElementOrder.unordered();
        this.incidentEdgeOrder = object;
        this.expectedNodeCount = object = Optional.absent();
        this.directed = bl2;
    }
}

