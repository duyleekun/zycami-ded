/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.graph;

import com.google.common.collect.UnmodifiableIterator;
import com.google.common.graph.DirectedGraphConnections;
import com.google.common.graph.DirectedGraphConnections$3$1;
import com.google.common.graph.DirectedGraphConnections$3$2;
import java.util.AbstractSet;
import java.util.Iterator;

public class DirectedGraphConnections$3
extends AbstractSet {
    public final /* synthetic */ DirectedGraphConnections this$0;

    public DirectedGraphConnections$3(DirectedGraphConnections directedGraphConnections) {
        this.this$0 = directedGraphConnections;
    }

    public boolean contains(Object object) {
        return DirectedGraphConnections.access$400(DirectedGraphConnections.access$100(this.this$0).get(object));
    }

    public UnmodifiableIterator iterator() {
        Object object = DirectedGraphConnections.access$000(this.this$0);
        if (object == null) {
            object = DirectedGraphConnections.access$100(this.this$0).entrySet().iterator();
            DirectedGraphConnections$3$1 directedGraphConnections$3$1 = new DirectedGraphConnections$3$1(this, (Iterator)object);
            return directedGraphConnections$3$1;
        }
        object = DirectedGraphConnections.access$000(this.this$0).iterator();
        DirectedGraphConnections$3$2 directedGraphConnections$3$2 = new DirectedGraphConnections$3$2(this, (Iterator)object);
        return directedGraphConnections$3$2;
    }

    public int size() {
        return DirectedGraphConnections.access$500(this.this$0);
    }
}

