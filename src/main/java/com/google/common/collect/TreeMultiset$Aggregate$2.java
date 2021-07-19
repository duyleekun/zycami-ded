/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.TreeMultiset$Aggregate;
import com.google.common.collect.TreeMultiset$AvlNode;

public final class TreeMultiset$Aggregate$2
extends TreeMultiset$Aggregate {
    public int nodeAggregate(TreeMultiset$AvlNode treeMultiset$AvlNode) {
        return 1;
    }

    public long treeAggregate(TreeMultiset$AvlNode treeMultiset$AvlNode) {
        long l10;
        if (treeMultiset$AvlNode == null) {
            l10 = 0L;
        } else {
            int n10 = TreeMultiset$AvlNode.access$400(treeMultiset$AvlNode);
            l10 = n10;
        }
        return l10;
    }
}

