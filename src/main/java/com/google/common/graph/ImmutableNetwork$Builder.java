/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.graph;

import com.google.common.graph.EndpointPair;
import com.google.common.graph.ImmutableNetwork;
import com.google.common.graph.MutableNetwork;
import com.google.common.graph.NetworkBuilder;

public class ImmutableNetwork$Builder {
    private final MutableNetwork mutableNetwork;

    public ImmutableNetwork$Builder(NetworkBuilder object) {
        this.mutableNetwork = object = ((NetworkBuilder)object).build();
    }

    public ImmutableNetwork$Builder addEdge(EndpointPair endpointPair, Object object) {
        this.mutableNetwork.addEdge(endpointPair, object);
        return this;
    }

    public ImmutableNetwork$Builder addEdge(Object object, Object object2, Object object3) {
        this.mutableNetwork.addEdge(object, object2, object3);
        return this;
    }

    public ImmutableNetwork$Builder addNode(Object object) {
        this.mutableNetwork.addNode(object);
        return this;
    }

    public ImmutableNetwork build() {
        return ImmutableNetwork.copyOf(this.mutableNetwork);
    }
}

