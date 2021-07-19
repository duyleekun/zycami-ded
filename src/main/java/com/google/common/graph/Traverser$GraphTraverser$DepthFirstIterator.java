/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.graph;

import com.google.common.collect.AbstractIterator;
import com.google.common.graph.Traverser$GraphTraverser;
import com.google.common.graph.Traverser$GraphTraverser$DepthFirstIterator$NodeAndSuccessors;
import com.google.common.graph.Traverser$Order;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public final class Traverser$GraphTraverser$DepthFirstIterator
extends AbstractIterator {
    private final Traverser$Order order;
    private final Deque stack;
    public final /* synthetic */ Traverser$GraphTraverser this$0;
    private final Set visited;

    public Traverser$GraphTraverser$DepthFirstIterator(Traverser$GraphTraverser arrayDeque, Iterable iterable, Traverser$Order traverser$Order) {
        this.this$0 = arrayDeque;
        this.stack = arrayDeque = new ArrayDeque<Object>();
        Object object = new HashSet();
        this.visited = object;
        object = new Traverser$GraphTraverser$DepthFirstIterator$NodeAndSuccessors(this, null, iterable);
        arrayDeque.push(object);
        this.order = traverser$Order;
    }

    public Object computeNext() {
        Object object;
        boolean bl2;
        do {
            Traverser$Order traverser$Order;
            boolean bl3;
            if (bl3 = (object = this.stack).isEmpty()) {
                return this.endOfData();
            }
            object = (Traverser$GraphTraverser$DepthFirstIterator$NodeAndSuccessors)this.stack.getFirst();
            Object object2 = this.visited;
            Object object3 = ((Traverser$GraphTraverser$DepthFirstIterator$NodeAndSuccessors)object).node;
            boolean bl4 = object2.add(object3);
            object3 = ((Traverser$GraphTraverser$DepthFirstIterator$NodeAndSuccessors)object).successorIterator;
            boolean bl5 = object3.hasNext();
            bl2 = true;
            if (!(bl4 && (object2 = this.order) == (traverser$Order = Traverser$Order.PREORDER) || (bl5 ^= bl2) && (object2 = this.order) == (traverser$Order = Traverser$Order.POSTORDER))) {
                bl2 = false;
            }
            if (bl5) {
                object2 = this.stack;
                object2.pop();
                continue;
            }
            object3 = this.visited;
            object2 = ((Traverser$GraphTraverser$DepthFirstIterator$NodeAndSuccessors)object).successorIterator.next();
            bl5 = object3.contains(object2);
            if (bl5) continue;
            object3 = this.stack;
            object2 = this.withSuccessors(object2);
            object3.push(object2);
        } while (!bl2 || (object = ((Traverser$GraphTraverser$DepthFirstIterator$NodeAndSuccessors)object).node) == null);
        return object;
    }

    public Traverser$GraphTraverser$DepthFirstIterator$NodeAndSuccessors withSuccessors(Object object) {
        Iterable iterable = Traverser$GraphTraverser.access$100(this.this$0).successors(object);
        Traverser$GraphTraverser$DepthFirstIterator$NodeAndSuccessors traverser$GraphTraverser$DepthFirstIterator$NodeAndSuccessors = new Traverser$GraphTraverser$DepthFirstIterator$NodeAndSuccessors(this, object, iterable);
        return traverser$GraphTraverser$DepthFirstIterator$NodeAndSuccessors;
    }
}

