/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.graph.BaseGraph;
import com.google.common.graph.Network;
import com.google.common.graph.SuccessorsFunction;
import com.google.common.graph.Traverser$1;
import com.google.common.graph.Traverser$GraphTraverser;
import com.google.common.graph.Traverser$TreeTraverser;

public abstract class Traverser {
    private Traverser() {
    }

    public /* synthetic */ Traverser(Traverser$1 traverser$1) {
        this();
    }

    public static Traverser forGraph(SuccessorsFunction successorsFunction) {
        Preconditions.checkNotNull(successorsFunction);
        Traverser$GraphTraverser traverser$GraphTraverser = new Traverser$GraphTraverser(successorsFunction);
        return traverser$GraphTraverser;
    }

    public static Traverser forTree(SuccessorsFunction successorsFunction) {
        String string2;
        Object object;
        Preconditions.checkNotNull(successorsFunction);
        boolean bl2 = successorsFunction instanceof BaseGraph;
        if (bl2) {
            object = successorsFunction;
            object = (BaseGraph)successorsFunction;
            bl2 = object.isDirected();
            string2 = "Undirected graphs can never be trees.";
            Preconditions.checkArgument(bl2, string2);
        }
        if (bl2 = successorsFunction instanceof Network) {
            object = successorsFunction;
            object = (Network)successorsFunction;
            bl2 = object.isDirected();
            string2 = "Undirected networks can never be trees.";
            Preconditions.checkArgument(bl2, string2);
        }
        object = new Traverser$TreeTraverser(successorsFunction);
        return object;
    }

    public abstract Iterable breadthFirst(Iterable var1);

    public abstract Iterable breadthFirst(Object var1);

    public abstract Iterable depthFirstPostOrder(Iterable var1);

    public abstract Iterable depthFirstPostOrder(Object var1);

    public abstract Iterable depthFirstPreOrder(Iterable var1);

    public abstract Iterable depthFirstPreOrder(Object var1);
}

