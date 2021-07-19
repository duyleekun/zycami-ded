/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.graph;

import com.google.common.base.Function;
import com.google.common.graph.EndpointPair;
import com.google.common.graph.Network;

public final class ImmutableNetwork$3
implements Function {
    public final /* synthetic */ Network val$network;
    public final /* synthetic */ Object val$node;

    public ImmutableNetwork$3(Network network, Object object) {
        this.val$network = network;
        this.val$node = object;
    }

    public Object apply(Object object) {
        object = this.val$network.incidentNodes(object);
        Object object2 = this.val$node;
        return ((EndpointPair)object).adjacentNode(object2);
    }
}

