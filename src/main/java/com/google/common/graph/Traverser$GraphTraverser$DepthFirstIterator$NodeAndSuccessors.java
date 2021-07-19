/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.graph;

import com.google.common.graph.Traverser$GraphTraverser$DepthFirstIterator;
import java.util.Iterator;

public final class Traverser$GraphTraverser$DepthFirstIterator$NodeAndSuccessors {
    public final Object node;
    public final Iterator successorIterator;
    public final /* synthetic */ Traverser$GraphTraverser$DepthFirstIterator this$1;

    public Traverser$GraphTraverser$DepthFirstIterator$NodeAndSuccessors(Traverser$GraphTraverser$DepthFirstIterator iterator2, Object object, Iterable iterable) {
        this.this$1 = iterator2;
        this.node = object;
        iterator2 = iterable.iterator();
        this.successorIterator = iterator2;
    }
}

