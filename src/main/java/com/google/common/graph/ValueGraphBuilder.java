/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.graph;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.graph.AbstractGraphBuilder;
import com.google.common.graph.ConfigurableMutableValueGraph;
import com.google.common.graph.ElementOrder;
import com.google.common.graph.Graphs;
import com.google.common.graph.ImmutableValueGraph$Builder;
import com.google.common.graph.MutableValueGraph;
import com.google.common.graph.ValueGraph;

public final class ValueGraphBuilder
extends AbstractGraphBuilder {
    private ValueGraphBuilder(boolean bl2) {
        super(bl2);
    }

    private ValueGraphBuilder cast() {
        return this;
    }

    public static ValueGraphBuilder directed() {
        ValueGraphBuilder valueGraphBuilder = new ValueGraphBuilder(true);
        return valueGraphBuilder;
    }

    public static ValueGraphBuilder from(ValueGraph object) {
        boolean bl2 = object.isDirected();
        ValueGraphBuilder valueGraphBuilder = new ValueGraphBuilder(bl2);
        bl2 = object.allowsSelfLoops();
        valueGraphBuilder = valueGraphBuilder.allowsSelfLoops(bl2);
        object = object.nodeOrder();
        return valueGraphBuilder.nodeOrder((ElementOrder)object);
    }

    public static ValueGraphBuilder undirected() {
        ValueGraphBuilder valueGraphBuilder = new ValueGraphBuilder(false);
        return valueGraphBuilder;
    }

    public ValueGraphBuilder allowsSelfLoops(boolean bl2) {
        this.allowsSelfLoops = bl2;
        return this;
    }

    public MutableValueGraph build() {
        ConfigurableMutableValueGraph configurableMutableValueGraph = new ConfigurableMutableValueGraph(this);
        return configurableMutableValueGraph;
    }

    public ValueGraphBuilder expectedNodeCount(int n10) {
        Optional optional;
        this.expectedNodeCount = optional = Optional.of(Graphs.checkNonNegative(n10));
        return this;
    }

    public ImmutableValueGraph$Builder immutable() {
        ValueGraphBuilder valueGraphBuilder = this.cast();
        ImmutableValueGraph$Builder immutableValueGraph$Builder = new ImmutableValueGraph$Builder(valueGraphBuilder);
        return immutableValueGraph$Builder;
    }

    public ValueGraphBuilder nodeOrder(ElementOrder elementOrder) {
        ValueGraphBuilder valueGraphBuilder = this.cast();
        valueGraphBuilder.nodeOrder = elementOrder = (ElementOrder)Preconditions.checkNotNull(elementOrder);
        return valueGraphBuilder;
    }
}

