/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import java.io.Serializable;
import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public final class MultimapBuilder$TreeSetSupplier
implements Supplier,
Serializable {
    private final Comparator comparator;

    public MultimapBuilder$TreeSetSupplier(Comparator comparator) {
        this.comparator = comparator = (Comparator)Preconditions.checkNotNull(comparator);
    }

    public SortedSet get() {
        Comparator comparator = this.comparator;
        TreeSet treeSet = new TreeSet(comparator);
        return treeSet;
    }
}

