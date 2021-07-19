/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.graph;

import com.google.common.graph.Traverser$GraphTraverser;
import com.google.common.graph.Traverser$GraphTraverser$BreadthFirstIterator;
import java.util.Iterator;

public class Traverser$GraphTraverser$1
implements Iterable {
    public final /* synthetic */ Traverser.GraphTraverser this$0;
    public final /* synthetic */ Iterable val$startNodes;

    public Traverser$GraphTraverser$1(Traverser.GraphTraverser graphTraverser, Iterable iterable) {
        this.this$0 = graphTraverser;
        this.val$startNodes = iterable;
    }

    public Iterator iterator() {
        Traverser.GraphTraverser graphTraverser = this.this$0;
        Iterable iterable = this.val$startNodes;
        Traverser$GraphTraverser$BreadthFirstIterator traverser$GraphTraverser$BreadthFirstIterator = new Traverser$GraphTraverser$BreadthFirstIterator(graphTraverser, iterable);
        return traverser$GraphTraverser$BreadthFirstIterator;
    }
}

