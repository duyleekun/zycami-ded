/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.graph.BaseGraph;
import com.google.common.graph.EndpointPairIterator$1;
import com.google.common.graph.EndpointPairIterator$Directed;
import com.google.common.graph.EndpointPairIterator$Undirected;
import java.util.Iterator;

public abstract class EndpointPairIterator
extends AbstractIterator {
    private final BaseGraph graph;
    public Object node = null;
    private final Iterator nodeIterator;
    public Iterator successorIterator;

    private EndpointPairIterator(BaseGraph object) {
        UnmodifiableIterator unmodifiableIterator = ImmutableSet.of().iterator();
        this.successorIterator = unmodifiableIterator;
        this.graph = object;
        this.nodeIterator = object = object.nodes().iterator();
    }

    public /* synthetic */ EndpointPairIterator(BaseGraph baseGraph, EndpointPairIterator$1 endpointPairIterator$1) {
        this(baseGraph);
    }

    public static EndpointPairIterator of(BaseGraph baseGraph) {
        boolean bl2 = baseGraph.isDirected();
        EndpointPairIterator endpointPairIterator = bl2 ? new EndpointPairIterator$Directed(baseGraph, null) : new EndpointPairIterator$Undirected(baseGraph, null);
        return endpointPairIterator;
    }

    public final boolean advance() {
        boolean bl2 = this.successorIterator.hasNext();
        boolean bl3 = true;
        Preconditions.checkState(bl2 ^ bl3);
        Iterator iterator2 = this.nodeIterator;
        bl2 = iterator2.hasNext();
        if (!bl2) {
            return false;
        }
        iterator2 = this.nodeIterator.next();
        this.node = iterator2;
        this.successorIterator = iterator2 = this.graph.successors(iterator2).iterator();
        return bl3;
    }
}

