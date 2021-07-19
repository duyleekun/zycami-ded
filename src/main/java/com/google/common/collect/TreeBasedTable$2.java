/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractIterator;
import com.google.common.collect.TreeBasedTable;
import java.util.Comparator;
import java.util.Iterator;

public class TreeBasedTable$2
extends AbstractIterator {
    public Object lastValue;
    public final /* synthetic */ TreeBasedTable this$0;
    public final /* synthetic */ Comparator val$comparator;
    public final /* synthetic */ Iterator val$merged;

    public TreeBasedTable$2(TreeBasedTable treeBasedTable, Iterator iterator2, Comparator comparator) {
        this.this$0 = treeBasedTable;
        this.val$merged = iterator2;
        this.val$comparator = comparator;
    }

    public Object computeNext() {
        Iterator iterator2;
        boolean bl2;
        while (bl2 = (iterator2 = this.val$merged).hasNext()) {
            Comparator comparator;
            int n10;
            iterator2 = this.val$merged.next();
            Object object = this.lastValue;
            if (object != null && (n10 = (comparator = this.val$comparator).compare(iterator2, object)) == 0) {
                n10 = 1;
            } else {
                n10 = 0;
                object = null;
            }
            if (n10 != 0) continue;
            this.lastValue = iterator2;
            return iterator2;
        }
        this.lastValue = null;
        return this.endOfData();
    }
}

