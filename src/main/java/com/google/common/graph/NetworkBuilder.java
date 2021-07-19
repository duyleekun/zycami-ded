/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.graph;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.graph.AbstractGraphBuilder;
import com.google.common.graph.ConfigurableMutableNetwork;
import com.google.common.graph.ElementOrder;
import com.google.common.graph.Graphs;
import com.google.common.graph.ImmutableNetwork$Builder;
import com.google.common.graph.MutableNetwork;
import com.google.common.graph.Network;

public final class NetworkBuilder
extends AbstractGraphBuilder {
    public boolean allowsParallelEdges = false;
    public ElementOrder edgeOrder;
    public Optional expectedEdgeCount;

    private NetworkBuilder(boolean bl2) {
        super(bl2);
        Object object = ElementOrder.insertion();
        this.edgeOrder = object;
        this.expectedEdgeCount = object = Optional.absent();
    }

    private NetworkBuilder cast() {
        return this;
    }

    public static NetworkBuilder directed() {
        NetworkBuilder networkBuilder = new NetworkBuilder(true);
        return networkBuilder;
    }

    public static NetworkBuilder from(Network object) {
        boolean bl2 = object.isDirected();
        NetworkBuilder networkBuilder = new NetworkBuilder(bl2);
        bl2 = object.allowsParallelEdges();
        networkBuilder = networkBuilder.allowsParallelEdges(bl2);
        bl2 = object.allowsSelfLoops();
        networkBuilder = networkBuilder.allowsSelfLoops(bl2);
        ElementOrder elementOrder = object.nodeOrder();
        networkBuilder = networkBuilder.nodeOrder(elementOrder);
        object = object.edgeOrder();
        return networkBuilder.edgeOrder((ElementOrder)object);
    }

    public static NetworkBuilder undirected() {
        NetworkBuilder networkBuilder = new NetworkBuilder(false);
        return networkBuilder;
    }

    public NetworkBuilder allowsParallelEdges(boolean bl2) {
        this.allowsParallelEdges = bl2;
        return this;
    }

    public NetworkBuilder allowsSelfLoops(boolean bl2) {
        this.allowsSelfLoops = bl2;
        return this;
    }

    public MutableNetwork build() {
        ConfigurableMutableNetwork configurableMutableNetwork = new ConfigurableMutableNetwork(this);
        return configurableMutableNetwork;
    }

    public NetworkBuilder edgeOrder(ElementOrder elementOrder) {
        NetworkBuilder networkBuilder = this.cast();
        networkBuilder.edgeOrder = elementOrder = (ElementOrder)Preconditions.checkNotNull(elementOrder);
        return networkBuilder;
    }

    public NetworkBuilder expectedEdgeCount(int n10) {
        Optional optional;
        this.expectedEdgeCount = optional = Optional.of(Graphs.checkNonNegative(n10));
        return this;
    }

    public NetworkBuilder expectedNodeCount(int n10) {
        Optional optional;
        this.expectedNodeCount = optional = Optional.of(Graphs.checkNonNegative(n10));
        return this;
    }

    public ImmutableNetwork$Builder immutable() {
        NetworkBuilder networkBuilder = this.cast();
        ImmutableNetwork$Builder immutableNetwork$Builder = new ImmutableNetwork$Builder(networkBuilder);
        return immutableNetwork$Builder;
    }

    public NetworkBuilder nodeOrder(ElementOrder elementOrder) {
        NetworkBuilder networkBuilder = this.cast();
        networkBuilder.nodeOrder = elementOrder = (ElementOrder)Preconditions.checkNotNull(elementOrder);
        return networkBuilder;
    }
}

