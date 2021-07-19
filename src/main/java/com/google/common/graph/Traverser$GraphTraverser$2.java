/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.graph;

import com.google.common.graph.Traverser$GraphTraverser;
import com.google.common.graph.Traverser$GraphTraverser$DepthFirstIterator;
import com.google.common.graph.Traverser$Order;
import java.util.Iterator;

public class Traverser$GraphTraverser$2
implements Iterable {
    public final /* synthetic */ Traverser$GraphTraverser this$0;
    public final /* synthetic */ Iterable val$startNodes;

    public Traverser$GraphTraverser$2(Traverser$GraphTraverser traverser$GraphTraverser, Iterable iterable) {
        this.this$0 = traverser$GraphTraverser;
        this.val$startNodes = iterable;
    }

    public Iterator iterator() {
        Traverser$GraphTraverser traverser$GraphTraverser = this.this$0;
        Iterable iterable = this.val$startNodes;
        Traverser$Order traverser$Order = Traverser$Order.PREORDER;
        Traverser$GraphTraverser$DepthFirstIterator traverser$GraphTraverser$DepthFirstIterator = new Traverser$GraphTraverser$DepthFirstIterator(traverser$GraphTraverser, iterable, traverser$Order);
        return traverser$GraphTraverser$DepthFirstIterator;
    }
}

