/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.graph;

import com.google.common.collect.UnmodifiableIterator;
import com.google.common.graph.DirectedGraphConnections;
import com.google.common.graph.DirectedGraphConnections$2$1;
import com.google.common.graph.DirectedGraphConnections$2$2;
import java.util.AbstractSet;
import java.util.Iterator;

public class DirectedGraphConnections$2
extends AbstractSet {
    public final /* synthetic */ DirectedGraphConnections this$0;

    public DirectedGraphConnections$2(DirectedGraphConnections directedGraphConnections) {
        this.this$0 = directedGraphConnections;
    }

    public boolean contains(Object object) {
        return DirectedGraphConnections.access$200(DirectedGraphConnections.access$100(this.this$0).get(object));
    }

    public UnmodifiableIterator iterator() {
        Object object = DirectedGraphConnections.access$000(this.this$0);
        if (object == null) {
            object = DirectedGraphConnections.access$100(this.this$0).entrySet().iterator();
            DirectedGraphConnections$2$1 directedGraphConnections$2$1 = new DirectedGraphConnections$2$1(this, (Iterator)object);
            return directedGraphConnections$2$1;
        }
        object = DirectedGraphConnections.access$000(this.this$0).iterator();
        DirectedGraphConnections$2$2 directedGraphConnections$2$2 = new DirectedGraphConnections$2$2(this, (Iterator)object);
        return directedGraphConnections$2$2;
    }

    public int size() {
        return DirectedGraphConnections.access$300(this.this$0);
    }
}

