/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.graph;

import com.google.common.graph.Traverser$TreeTraverser;
import com.google.common.graph.Traverser$TreeTraverser$BreadthFirstIterator;
import java.util.Iterator;

public class Traverser$TreeTraverser$1
implements Iterable {
    public final /* synthetic */ Traverser.TreeTraverser this$0;
    public final /* synthetic */ Iterable val$startNodes;

    public Traverser$TreeTraverser$1(Traverser.TreeTraverser treeTraverser, Iterable iterable) {
        this.this$0 = treeTraverser;
        this.val$startNodes = iterable;
    }

    public Iterator iterator() {
        Traverser.TreeTraverser treeTraverser = this.this$0;
        Iterable iterable = this.val$startNodes;
        Traverser$TreeTraverser$BreadthFirstIterator traverser$TreeTraverser$BreadthFirstIterator = new Traverser$TreeTraverser$BreadthFirstIterator(treeTraverser, iterable);
        return traverser$TreeTraverser$BreadthFirstIterator;
    }
}

