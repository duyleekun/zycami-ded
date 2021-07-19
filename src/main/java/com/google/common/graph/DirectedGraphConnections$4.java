/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.graph;

import com.google.common.base.Function;
import com.google.common.graph.DirectedGraphConnections;
import com.google.common.graph.EndpointPair;

public class DirectedGraphConnections$4
implements Function {
    public final /* synthetic */ DirectedGraphConnections this$0;
    public final /* synthetic */ Object val$thisNode;

    public DirectedGraphConnections$4(DirectedGraphConnections directedGraphConnections, Object object) {
        this.this$0 = directedGraphConnections;
        this.val$thisNode = object;
    }

    public EndpointPair apply(Object object) {
        Object object2 = this.val$thisNode;
        return EndpointPair.ordered(object, object2);
    }
}

