/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.TreeMultiset$1;
import com.google.common.collect.TreeMultiset$Aggregate$1;
import com.google.common.collect.TreeMultiset$Aggregate$2;
import com.google.common.collect.TreeMultiset$AvlNode;

public abstract class TreeMultiset$Aggregate
extends Enum {
    private static final /* synthetic */ TreeMultiset$Aggregate[] $VALUES;
    public static final /* enum */ TreeMultiset$Aggregate DISTINCT;
    public static final /* enum */ TreeMultiset$Aggregate SIZE;

    static {
        TreeMultiset$Aggregate$1 treeMultiset$Aggregate$1 = new TreeMultiset$Aggregate$1();
        SIZE = treeMultiset$Aggregate$1;
        int n10 = 1;
        TreeMultiset$Aggregate$2 treeMultiset$Aggregate$2 = new TreeMultiset$Aggregate$2();
        DISTINCT = treeMultiset$Aggregate$2;
        TreeMultiset$Aggregate[] treeMultiset$AggregateArray = new TreeMultiset$Aggregate[2];
        treeMultiset$AggregateArray[0] = treeMultiset$Aggregate$1;
        treeMultiset$AggregateArray[n10] = treeMultiset$Aggregate$2;
        $VALUES = treeMultiset$AggregateArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private TreeMultiset$Aggregate() {
        void var2_-1;
        void var1_-1;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public /* synthetic */ TreeMultiset$Aggregate(TreeMultiset.1 varnull) {
        this((String)var1_-1, (int)var2_1);
        void var2_1;
        void var1_-1;
    }

    public static TreeMultiset$Aggregate valueOf(String string2) {
        return Enum.valueOf(TreeMultiset$Aggregate.class, string2);
    }

    public static TreeMultiset$Aggregate[] values() {
        return (TreeMultiset$Aggregate[])$VALUES.clone();
    }

    public abstract int nodeAggregate(TreeMultiset$AvlNode var1);

    public abstract long treeAggregate(TreeMultiset$AvlNode var1);
}

