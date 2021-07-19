/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.graph.SuccessorsFunction;
import com.google.common.graph.Traverser;
import com.google.common.graph.Traverser$GraphTraverser$1;
import com.google.common.graph.Traverser$GraphTraverser$2;
import com.google.common.graph.Traverser$GraphTraverser$3;

public final class Traverser$GraphTraverser
extends Traverser {
    private final SuccessorsFunction graph;

    public Traverser$GraphTraverser(SuccessorsFunction successorsFunction) {
        super(null);
        this.graph = successorsFunction = (SuccessorsFunction)Preconditions.checkNotNull(successorsFunction);
    }

    public static /* synthetic */ SuccessorsFunction access$100(Traverser$GraphTraverser traverser$GraphTraverser) {
        return traverser$GraphTraverser.graph;
    }

    private void checkThatNodeIsInGraph(Object object) {
        this.graph.successors(object);
    }

    public Iterable breadthFirst(Iterable iterable) {
        boolean bl2;
        Preconditions.checkNotNull(iterable);
        boolean bl3 = Iterables.isEmpty(iterable);
        if (bl3) {
            return ImmutableSet.of();
        }
        Object object = iterable.iterator();
        while (bl2 = object.hasNext()) {
            Object t10 = object.next();
            this.checkThatNodeIsInGraph(t10);
        }
        object = new Traverser$GraphTraverser$1(this, iterable);
        return object;
    }

    public Iterable breadthFirst(Object object) {
        Preconditions.checkNotNull(object);
        object = ImmutableSet.of(object);
        return this.breadthFirst((Iterable)object);
    }

    public Iterable depthFirstPostOrder(Iterable iterable) {
        boolean bl2;
        Preconditions.checkNotNull(iterable);
        boolean bl3 = Iterables.isEmpty(iterable);
        if (bl3) {
            return ImmutableSet.of();
        }
        Object object = iterable.iterator();
        while (bl2 = object.hasNext()) {
            Object t10 = object.next();
            this.checkThatNodeIsInGraph(t10);
        }
        object = new Traverser$GraphTraverser$3(this, iterable);
        return object;
    }

    public Iterable depthFirstPostOrder(Object object) {
        Preconditions.checkNotNull(object);
        object = ImmutableSet.of(object);
        return this.depthFirstPostOrder((Iterable)object);
    }

    public Iterable depthFirstPreOrder(Iterable iterable) {
        boolean bl2;
        Preconditions.checkNotNull(iterable);
        boolean bl3 = Iterables.isEmpty(iterable);
        if (bl3) {
            return ImmutableSet.of();
        }
        Object object = iterable.iterator();
        while (bl2 = object.hasNext()) {
            Object t10 = object.next();
            this.checkThatNodeIsInGraph(t10);
        }
        object = new Traverser$GraphTraverser$2(this, iterable);
        return object;
    }

    public Iterable depthFirstPreOrder(Object object) {
        Preconditions.checkNotNull(object);
        object = ImmutableSet.of(object);
        return this.depthFirstPreOrder((Iterable)object);
    }
}

