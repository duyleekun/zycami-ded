/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.TreeMultiset$Aggregate;
import com.google.common.collect.TreeMultiset$AvlNode;

public final class TreeMultiset$Aggregate$1
extends TreeMultiset$Aggregate {
    public int nodeAggregate(TreeMultiset$AvlNode treeMultiset$AvlNode) {
        return TreeMultiset$AvlNode.access$200(treeMultiset$AvlNode);
    }

    public long treeAggregate(TreeMultiset$AvlNode treeMultiset$AvlNode) {
        long l10 = treeMultiset$AvlNode == null ? 0L : TreeMultiset$AvlNode.access$300(treeMultiset$AvlNode);
        return l10;
    }
}

