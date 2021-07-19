/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.graph;

import com.google.common.collect.UnmodifiableIterator;
import com.google.common.graph.DirectedGraphConnections;
import com.google.common.graph.DirectedGraphConnections$1$1;
import java.util.AbstractSet;
import java.util.HashSet;
import java.util.Iterator;

public class DirectedGraphConnections$1
extends AbstractSet {
    public final /* synthetic */ DirectedGraphConnections this$0;

    public DirectedGraphConnections$1(DirectedGraphConnections directedGraphConnections) {
        this.this$0 = directedGraphConnections;
    }

    public boolean contains(Object object) {
        return DirectedGraphConnections.access$100(this.this$0).containsKey(object);
    }

    public UnmodifiableIterator iterator() {
        Iterator iterator2 = DirectedGraphConnections.access$000(this.this$0).iterator();
        HashSet hashSet = new HashSet();
        DirectedGraphConnections$1$1 directedGraphConnections$1$1 = new DirectedGraphConnections$1$1(this, iterator2, hashSet);
        return directedGraphConnections$1$1;
    }

    public int size() {
        return DirectedGraphConnections.access$100(this.this$0).size();
    }
}

