/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.graph.Traverser$TreeTraverser;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public final class Traverser$TreeTraverser$DepthFirstPreOrderIterator
extends UnmodifiableIterator {
    private final Deque stack;
    public final /* synthetic */ Traverser$TreeTraverser this$0;

    public Traverser$TreeTraverser$DepthFirstPreOrderIterator(Traverser$TreeTraverser arrayDeque, Iterable object) {
        this.this$0 = arrayDeque;
        this.stack = arrayDeque = new ArrayDeque<Object>();
        object = object.iterator();
        arrayDeque.addLast(object);
    }

    public boolean hasNext() {
        return this.stack.isEmpty() ^ true;
    }

    public Object next() {
        boolean bl2;
        Iterator iterator2 = (Iterator)this.stack.getLast();
        Object object = Preconditions.checkNotNull(iterator2.next());
        boolean bl3 = iterator2.hasNext();
        if (!bl3) {
            iterator2 = this.stack;
            iterator2.removeLast();
        }
        if (bl2 = (iterator2 = Traverser$TreeTraverser.access$200(this.this$0).successors(object).iterator()).hasNext()) {
            Deque deque = this.stack;
            deque.addLast(iterator2);
        }
        return object;
    }
}

