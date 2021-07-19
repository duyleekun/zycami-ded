/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.graph;

import com.google.common.collect.Multiset;
import com.google.common.graph.MultiEdgesConnecting;
import com.google.common.graph.UndirectedMultiNetworkConnections;
import java.util.Map;

public class UndirectedMultiNetworkConnections$1
extends MultiEdgesConnecting {
    public final /* synthetic */ UndirectedMultiNetworkConnections this$0;
    public final /* synthetic */ Object val$node;

    public UndirectedMultiNetworkConnections$1(UndirectedMultiNetworkConnections undirectedMultiNetworkConnections, Map map, Object object, Object object2) {
        this.this$0 = undirectedMultiNetworkConnections;
        this.val$node = object2;
        super(map, object);
    }

    public int size() {
        Multiset multiset = UndirectedMultiNetworkConnections.access$000(this.this$0);
        Object object = this.val$node;
        return multiset.count(object);
    }
}

