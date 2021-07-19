/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.graph;

import com.google.common.collect.AbstractIterator;
import com.google.common.graph.DirectedGraphConnections;
import com.google.common.graph.DirectedGraphConnections$2;
import java.util.Iterator;
import java.util.Map;

public class DirectedGraphConnections$2$1
extends AbstractIterator {
    public final /* synthetic */ DirectedGraphConnections$2 this$1;
    public final /* synthetic */ Iterator val$entries;

    public DirectedGraphConnections$2$1(DirectedGraphConnections$2 directedGraphConnections$2, Iterator iterator2) {
        this.this$1 = directedGraphConnections$2;
        this.val$entries = iterator2;
    }

    public Object computeNext() {
        Object object;
        boolean bl2;
        while (bl2 = (object = this.val$entries).hasNext()) {
            object = (Map.Entry)this.val$entries.next();
            Object v10 = object.getValue();
            boolean bl3 = DirectedGraphConnections.access$200(v10);
            if (!bl3) continue;
            return object.getKey();
        }
        return this.endOfData();
    }
}

