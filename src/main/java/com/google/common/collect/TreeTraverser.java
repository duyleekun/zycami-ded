/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.TreeTraverser$1;
import com.google.common.collect.TreeTraverser$2;
import com.google.common.collect.TreeTraverser$3;
import com.google.common.collect.TreeTraverser$4;
import com.google.common.collect.TreeTraverser$PostOrderIterator;
import com.google.common.collect.TreeTraverser$PreOrderIterator;
import com.google.common.collect.UnmodifiableIterator;

public abstract class TreeTraverser {
    public static TreeTraverser using(Function function) {
        Preconditions.checkNotNull(function);
        TreeTraverser$1 treeTraverser$1 = new TreeTraverser$1(function);
        return treeTraverser$1;
    }

    public final FluentIterable breadthFirstTraversal(Object object) {
        Preconditions.checkNotNull(object);
        TreeTraverser$4 treeTraverser$4 = new TreeTraverser$4(this, object);
        return treeTraverser$4;
    }

    public abstract Iterable children(Object var1);

    public UnmodifiableIterator postOrderIterator(Object object) {
        TreeTraverser$PostOrderIterator treeTraverser$PostOrderIterator = new TreeTraverser$PostOrderIterator(this, object);
        return treeTraverser$PostOrderIterator;
    }

    public final FluentIterable postOrderTraversal(Object object) {
        Preconditions.checkNotNull(object);
        TreeTraverser$3 treeTraverser$3 = new TreeTraverser$3(this, object);
        return treeTraverser$3;
    }

    public UnmodifiableIterator preOrderIterator(Object object) {
        TreeTraverser$PreOrderIterator treeTraverser$PreOrderIterator = new TreeTraverser$PreOrderIterator(this, object);
        return treeTraverser$PreOrderIterator;
    }

    public final FluentIterable preOrderTraversal(Object object) {
        Preconditions.checkNotNull(object);
        TreeTraverser$2 treeTraverser$2 = new TreeTraverser$2(this, object);
        return treeTraverser$2;
    }
}

