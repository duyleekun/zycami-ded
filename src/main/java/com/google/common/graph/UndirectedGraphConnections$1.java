/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.graph;

import com.google.common.base.Function;
import com.google.common.graph.EndpointPair;
import com.google.common.graph.UndirectedGraphConnections;

public class UndirectedGraphConnections$1
implements Function {
    public final /* synthetic */ UndirectedGraphConnections this$0;
    public final /* synthetic */ Object val$thisNode;

    public UndirectedGraphConnections$1(UndirectedGraphConnections undirectedGraphConnections, Object object) {
        this.this$0 = undirectedGraphConnections;
        this.val$thisNode = object;
    }

    public EndpointPair apply(Object object) {
        return EndpointPair.unordered(this.val$thisNode, object);
    }
}

