/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.Multisets$AbstractEntry;
import com.google.common.collect.TreeMultiset;
import com.google.common.collect.TreeMultiset$AvlNode;

public class TreeMultiset$1
extends Multisets$AbstractEntry {
    public final /* synthetic */ TreeMultiset this$0;
    public final /* synthetic */ TreeMultiset$AvlNode val$baseEntry;

    public TreeMultiset$1(TreeMultiset treeMultiset, TreeMultiset$AvlNode treeMultiset$AvlNode) {
        this.this$0 = treeMultiset;
        this.val$baseEntry = treeMultiset$AvlNode;
    }

    public int getCount() {
        Object object = this.val$baseEntry;
        int n10 = ((TreeMultiset$AvlNode)object).getCount();
        if (n10 == 0) {
            object = this.this$0;
            Object object2 = this.getElement();
            n10 = ((TreeMultiset)object).count(object2);
        }
        return n10;
    }

    public Object getElement() {
        return this.val$baseEntry.getElement();
    }
}

