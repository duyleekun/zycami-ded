/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.graph;

import com.google.common.collect.UnmodifiableIterator;
import com.google.common.graph.Traverser$GraphTraverser;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.Set;

public final class Traverser$GraphTraverser$BreadthFirstIterator
extends UnmodifiableIterator {
    private final Queue queue;
    public final /* synthetic */ Traverser$GraphTraverser this$0;
    private final Set visited;

    public Traverser$GraphTraverser$BreadthFirstIterator(Traverser$GraphTraverser object, Iterable iterable) {
        boolean bl2;
        this.this$0 = object;
        object = new ArrayDeque();
        this.queue = object;
        this.visited = object;
        object = iterable.iterator();
        while (bl2 = object.hasNext()) {
            Collection<Iterable> collection = this.visited;
            iterable = object.next();
            boolean bl3 = collection.add(iterable);
            if (!bl3) continue;
            collection = this.queue;
            collection.add(iterable);
        }
    }

    public boolean hasNext() {
        return this.queue.isEmpty() ^ true;
    }

    public Object next() {
        boolean bl2;
        Object e10 = this.queue.remove();
        Iterator iterator2 = Traverser$GraphTraverser.access$100(this.this$0).successors(e10).iterator();
        while (bl2 = iterator2.hasNext()) {
            Collection collection = this.visited;
            Object t10 = iterator2.next();
            boolean bl3 = collection.add(t10);
            if (!bl3) continue;
            collection = this.queue;
            collection.add(t10);
        }
        return e10;
    }
}

