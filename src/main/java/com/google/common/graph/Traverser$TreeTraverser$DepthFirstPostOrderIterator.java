/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.graph;

import com.google.common.collect.AbstractIterator;
import com.google.common.graph.Traverser$TreeTraverser;
import com.google.common.graph.Traverser$TreeTraverser$DepthFirstPostOrderIterator$NodeAndChildren;
import java.util.ArrayDeque;

public final class Traverser$TreeTraverser$DepthFirstPostOrderIterator
extends AbstractIterator {
    private final ArrayDeque stack;
    public final /* synthetic */ Traverser$TreeTraverser this$0;

    public Traverser$TreeTraverser$DepthFirstPostOrderIterator(Traverser$TreeTraverser arrayDeque, Iterable iterable) {
        this.this$0 = arrayDeque;
        this.stack = arrayDeque = new ArrayDeque<Traverser$TreeTraverser$DepthFirstPostOrderIterator$NodeAndChildren>();
        Traverser$TreeTraverser$DepthFirstPostOrderIterator$NodeAndChildren traverser$TreeTraverser$DepthFirstPostOrderIterator$NodeAndChildren = new Traverser$TreeTraverser$DepthFirstPostOrderIterator$NodeAndChildren(this, null, iterable);
        arrayDeque.addLast(traverser$TreeTraverser$DepthFirstPostOrderIterator$NodeAndChildren);
    }

    public Object computeNext() {
        Object object;
        boolean bl2;
        while (!(bl2 = ((ArrayDeque)(object = this.stack)).isEmpty())) {
            object = (Traverser$TreeTraverser$DepthFirstPostOrderIterator$NodeAndChildren)this.stack.getLast();
            Object object2 = ((Traverser$TreeTraverser$DepthFirstPostOrderIterator$NodeAndChildren)object).childIterator;
            boolean bl3 = object2.hasNext();
            if (bl3) {
                object = ((Traverser$TreeTraverser$DepthFirstPostOrderIterator$NodeAndChildren)object).childIterator.next();
                object2 = this.stack;
                object = this.withChildren(object);
                ((ArrayDeque)object2).addLast(object);
                continue;
            }
            object2 = this.stack;
            ((ArrayDeque)object2).removeLast();
            object = ((Traverser$TreeTraverser$DepthFirstPostOrderIterator$NodeAndChildren)object).node;
            if (object == null) continue;
            return object;
        }
        return this.endOfData();
    }

    public Traverser$TreeTraverser$DepthFirstPostOrderIterator$NodeAndChildren withChildren(Object object) {
        Iterable iterable = Traverser$TreeTraverser.access$200(this.this$0).successors(object);
        Traverser$TreeTraverser$DepthFirstPostOrderIterator$NodeAndChildren traverser$TreeTraverser$DepthFirstPostOrderIterator$NodeAndChildren = new Traverser$TreeTraverser$DepthFirstPostOrderIterator$NodeAndChildren(this, object, iterable);
        return traverser$TreeTraverser$DepthFirstPostOrderIterator$NodeAndChildren;
    }
}

