/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.graph;

import com.google.common.collect.AbstractIterator;
import com.google.common.graph.DirectedGraphConnections$2;
import com.google.common.graph.DirectedGraphConnections$NodeConnection;
import com.google.common.graph.DirectedGraphConnections$NodeConnection$Pred;
import java.util.Iterator;

public class DirectedGraphConnections$2$2
extends AbstractIterator {
    public final /* synthetic */ DirectedGraphConnections$2 this$1;
    public final /* synthetic */ Iterator val$nodeConnections;

    public DirectedGraphConnections$2$2(DirectedGraphConnections$2 directedGraphConnections$2, Iterator iterator2) {
        this.this$1 = directedGraphConnections$2;
        this.val$nodeConnections = iterator2;
    }

    public Object computeNext() {
        Object object;
        boolean bl2;
        while (bl2 = (object = this.val$nodeConnections).hasNext()) {
            object = (DirectedGraphConnections$NodeConnection)this.val$nodeConnections.next();
            boolean bl3 = object instanceof DirectedGraphConnections$NodeConnection$Pred;
            if (!bl3) continue;
            return ((DirectedGraphConnections$NodeConnection)object).node;
        }
        return this.endOfData();
    }
}

