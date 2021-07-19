/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Supplier;
import java.io.Serializable;
import java.util.Comparator;
import java.util.TreeMap;

public class TreeBasedTable$Factory
implements Supplier,
Serializable {
    private static final long serialVersionUID;
    public final Comparator comparator;

    public TreeBasedTable$Factory(Comparator comparator) {
        this.comparator = comparator;
    }

    public TreeMap get() {
        Comparator comparator = this.comparator;
        TreeMap treeMap = new TreeMap(comparator);
        return treeMap;
    }
}

