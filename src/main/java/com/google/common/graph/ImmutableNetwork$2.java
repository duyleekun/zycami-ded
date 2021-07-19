/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.graph;

import com.google.common.base.Function;
import com.google.common.graph.Network;

public final class ImmutableNetwork$2
implements Function {
    public final /* synthetic */ Network val$network;

    public ImmutableNetwork$2(Network network) {
        this.val$network = network;
    }

    public Object apply(Object object) {
        return this.val$network.incidentNodes(object).target();
    }
}

