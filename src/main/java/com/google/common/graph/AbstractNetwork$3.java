/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.graph;

import com.google.common.base.Function;
import com.google.common.graph.EndpointPair;
import com.google.common.graph.Network;

public final class AbstractNetwork$3
implements Function {
    public final /* synthetic */ Network val$network;

    public AbstractNetwork$3(Network network) {
        this.val$network = network;
    }

    public EndpointPair apply(Object object) {
        return this.val$network.incidentNodes(object);
    }
}

