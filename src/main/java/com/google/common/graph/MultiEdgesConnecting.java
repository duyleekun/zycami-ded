/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.graph.MultiEdgesConnecting$1;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

public abstract class MultiEdgesConnecting
extends AbstractSet {
    private final Map outEdgeToNode;
    private final Object targetNode;

    public MultiEdgesConnecting(Map object, Object object2) {
        object = (Map)Preconditions.checkNotNull(object);
        this.outEdgeToNode = object;
        this.targetNode = object = Preconditions.checkNotNull(object2);
    }

    public static /* synthetic */ Object access$000(MultiEdgesConnecting multiEdgesConnecting) {
        return multiEdgesConnecting.targetNode;
    }

    public boolean contains(Object object) {
        Object object2 = this.targetNode;
        object = this.outEdgeToNode.get(object);
        return object2.equals(object);
    }

    public UnmodifiableIterator iterator() {
        Iterator iterator2 = this.outEdgeToNode.entrySet().iterator();
        MultiEdgesConnecting$1 multiEdgesConnecting$1 = new MultiEdgesConnecting$1(this, iterator2);
        return multiEdgesConnecting$1;
    }
}

