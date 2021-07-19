/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.graph;

import com.google.common.collect.Iterables;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.graph.Traverser$TreeTraverser;
import java.util.ArrayDeque;
import java.util.Queue;

public final class Traverser$TreeTraverser$BreadthFirstIterator
extends UnmodifiableIterator {
    private final Queue queue;
    public final /* synthetic */ Traverser$TreeTraverser this$0;

    public Traverser$TreeTraverser$BreadthFirstIterator(Traverser$TreeTraverser object, Iterable iterable) {
        boolean bl2;
        this.this$0 = object;
        object = new ArrayDeque();
        this.queue = object;
        object = iterable.iterator();
        while (bl2 = object.hasNext()) {
            iterable = object.next();
            Queue queue = this.queue;
            queue.add(iterable);
        }
    }

    public boolean hasNext() {
        return this.queue.isEmpty() ^ true;
    }

    public Object next() {
        Object e10 = this.queue.remove();
        Queue queue = this.queue;
        Iterable iterable = Traverser$TreeTraverser.access$200(this.this$0).successors(e10);
        Iterables.addAll(queue, iterable);
        return e10;
    }
}

