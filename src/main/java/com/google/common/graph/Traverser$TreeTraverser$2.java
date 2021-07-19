/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.graph;

import com.google.common.graph.Traverser$TreeTraverser;
import com.google.common.graph.Traverser$TreeTraverser$DepthFirstPreOrderIterator;
import java.util.Iterator;

public class Traverser$TreeTraverser$2
implements Iterable {
    public final /* synthetic */ Traverser$TreeTraverser this$0;
    public final /* synthetic */ Iterable val$startNodes;

    public Traverser$TreeTraverser$2(Traverser$TreeTraverser traverser$TreeTraverser, Iterable iterable) {
        this.this$0 = traverser$TreeTraverser;
        this.val$startNodes = iterable;
    }

    public Iterator iterator() {
        Traverser$TreeTraverser traverser$TreeTraverser = this.this$0;
        Iterable iterable = this.val$startNodes;
        Traverser$TreeTraverser$DepthFirstPreOrderIterator traverser$TreeTraverser$DepthFirstPreOrderIterator = new Traverser$TreeTraverser$DepthFirstPreOrderIterator(traverser$TreeTraverser, iterable);
        return traverser$TreeTraverser$DepthFirstPreOrderIterator;
    }
}

