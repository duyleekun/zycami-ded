/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.graph;

import com.google.common.collect.AbstractIterator;
import com.google.common.graph.DirectedGraphConnections;
import com.google.common.graph.DirectedGraphConnections$3;
import java.util.Iterator;
import java.util.Map;

public class DirectedGraphConnections$3$1
extends AbstractIterator {
    public final /* synthetic */ DirectedGraphConnections$3 this$1;
    public final /* synthetic */ Iterator val$entries;

    public DirectedGraphConnections$3$1(DirectedGraphConnections$3 directedGraphConnections$3, Iterator iterator2) {
        this.this$1 = directedGraphConnections$3;
        this.val$entries = iterator2;
    }

    public Object computeNext() {
        Object object;
        boolean bl2;
        while (bl2 = (object = this.val$entries).hasNext()) {
            object = (Map.Entry)this.val$entries.next();
            Object v10 = object.getValue();
            boolean bl3 = DirectedGraphConnections.access$400(v10);
            if (!bl3) continue;
            return object.getKey();
        }
        return this.endOfData();
    }
}

