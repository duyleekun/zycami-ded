/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.Table$Cell;
import java.util.Comparator;

public final class RegularImmutableTable$1
implements Comparator {
    public final /* synthetic */ Comparator val$columnComparator;
    public final /* synthetic */ Comparator val$rowComparator;

    public RegularImmutableTable$1(Comparator comparator, Comparator comparator2) {
        this.val$rowComparator = comparator;
        this.val$columnComparator = comparator2;
    }

    public int compare(Table$Cell object, Table$Cell object2) {
        int n10;
        Comparator comparator = this.val$rowComparator;
        int n11 = 0;
        if (comparator == null) {
            n10 = 0;
            comparator = null;
        } else {
            Object object3 = object.getRowKey();
            Object object4 = object2.getRowKey();
            n10 = comparator.compare(object3, object4);
        }
        if (n10 != 0) {
            return n10;
        }
        comparator = this.val$columnComparator;
        if (comparator != null) {
            object = object.getColumnKey();
            object2 = object2.getColumnKey();
            n11 = comparator.compare(object, object2);
        }
        return n11;
    }
}

