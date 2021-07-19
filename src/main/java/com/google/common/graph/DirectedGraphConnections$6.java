/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.graph;

import com.google.common.base.Function;
import com.google.common.graph.DirectedGraphConnections;
import com.google.common.graph.DirectedGraphConnections$NodeConnection;
import com.google.common.graph.DirectedGraphConnections$NodeConnection$Succ;
import com.google.common.graph.EndpointPair;

public class DirectedGraphConnections$6
implements Function {
    public final /* synthetic */ DirectedGraphConnections this$0;
    public final /* synthetic */ Object val$thisNode;

    public DirectedGraphConnections$6(DirectedGraphConnections directedGraphConnections, Object object) {
        this.this$0 = directedGraphConnections;
        this.val$thisNode = object;
    }

    public EndpointPair apply(DirectedGraphConnections$NodeConnection object) {
        boolean bl2 = object instanceof DirectedGraphConnections$NodeConnection.Succ;
        if (bl2) {
            Object object2 = this.val$thisNode;
            object = ((DirectedGraphConnections$NodeConnection)object).node;
            return EndpointPair.ordered(object2, object);
        }
        object = ((DirectedGraphConnections$NodeConnection)object).node;
        Object object3 = this.val$thisNode;
        return EndpointPair.ordered(object, object3);
    }
}

