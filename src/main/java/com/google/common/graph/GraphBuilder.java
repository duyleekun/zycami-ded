/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.graph;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.graph.AbstractGraphBuilder;
import com.google.common.graph.ConfigurableMutableGraph;
import com.google.common.graph.ElementOrder;
import com.google.common.graph.ElementOrder$Type;
import com.google.common.graph.Graph;
import com.google.common.graph.Graphs;
import com.google.common.graph.ImmutableGraph$Builder;
import com.google.common.graph.MutableGraph;

public final class GraphBuilder
extends AbstractGraphBuilder {
    private GraphBuilder(boolean bl2) {
        super(bl2);
    }

    private GraphBuilder cast() {
        return this;
    }

    public static GraphBuilder directed() {
        GraphBuilder graphBuilder = new GraphBuilder(true);
        return graphBuilder;
    }

    public static GraphBuilder from(Graph object) {
        boolean bl2 = object.isDirected();
        GraphBuilder graphBuilder = new GraphBuilder(bl2);
        bl2 = object.allowsSelfLoops();
        graphBuilder = graphBuilder.allowsSelfLoops(bl2);
        object = object.nodeOrder();
        return graphBuilder.nodeOrder((ElementOrder)object);
    }

    public static GraphBuilder undirected() {
        GraphBuilder graphBuilder = new GraphBuilder(false);
        return graphBuilder;
    }

    public GraphBuilder allowsSelfLoops(boolean bl2) {
        this.allowsSelfLoops = bl2;
        return this;
    }

    public MutableGraph build() {
        ConfigurableMutableGraph configurableMutableGraph = new ConfigurableMutableGraph(this);
        return configurableMutableGraph;
    }

    public GraphBuilder copy() {
        boolean bl2 = this.directed;
        GraphBuilder graphBuilder = new GraphBuilder(bl2);
        graphBuilder.allowsSelfLoops = bl2 = this.allowsSelfLoops;
        Object object = this.nodeOrder;
        graphBuilder.nodeOrder = object;
        graphBuilder.expectedNodeCount = object = this.expectedNodeCount;
        graphBuilder.incidentEdgeOrder = object = this.incidentEdgeOrder;
        return graphBuilder;
    }

    public GraphBuilder expectedNodeCount(int n10) {
        Optional optional;
        this.expectedNodeCount = optional = Optional.of(Graphs.checkNonNegative(n10));
        return this;
    }

    public ImmutableGraph$Builder immutable() {
        GraphBuilder graphBuilder = this.cast();
        ImmutableGraph$Builder immutableGraph$Builder = new ImmutableGraph$Builder(graphBuilder);
        return immutableGraph$Builder;
    }

    public GraphBuilder incidentEdgeOrder(ElementOrder elementOrder) {
        boolean bl2;
        ElementOrder$Type elementOrder$Type;
        Object object = elementOrder.type();
        if (object != (elementOrder$Type = ElementOrder$Type.UNORDERED) && (object = elementOrder.type()) != (elementOrder$Type = ElementOrder$Type.STABLE)) {
            bl2 = false;
            object = null;
        } else {
            bl2 = true;
        }
        Preconditions.checkArgument(bl2, "The given elementOrder (%s) is unsupported. incidentEdgeOrder() only supports ElementOrder.unordered() and ElementOrder.stable().", (Object)elementOrder);
        object = this.cast();
        ((AbstractGraphBuilder)object).incidentEdgeOrder = elementOrder = (ElementOrder)Preconditions.checkNotNull(elementOrder);
        return object;
    }

    public GraphBuilder nodeOrder(ElementOrder elementOrder) {
        GraphBuilder graphBuilder = this.cast();
        graphBuilder.nodeOrder = elementOrder = (ElementOrder)Preconditions.checkNotNull(elementOrder);
        return graphBuilder;
    }
}

