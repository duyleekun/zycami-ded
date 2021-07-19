/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.graph;

import com.google.common.graph.Traverser$TreeTraverser$DepthFirstPostOrderIterator;
import java.util.Iterator;

public final class Traverser$TreeTraverser$DepthFirstPostOrderIterator$NodeAndChildren {
    public final Iterator childIterator;
    public final Object node;
    public final /* synthetic */ Traverser$TreeTraverser$DepthFirstPostOrderIterator this$1;

    public Traverser$TreeTraverser$DepthFirstPostOrderIterator$NodeAndChildren(Traverser$TreeTraverser$DepthFirstPostOrderIterator iterator2, Object object, Iterable iterable) {
        this.this$1 = iterator2;
        this.node = object;
        iterator2 = iterable.iterator();
        this.childIterator = iterator2;
    }
}

