/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Ordering;
import com.google.common.collect.StandardRowSortedTable;
import com.google.common.collect.TreeBasedTable$1;
import com.google.common.collect.TreeBasedTable$2;
import com.google.common.collect.TreeBasedTable$Factory;
import com.google.common.collect.TreeBasedTable$TreeRow;
import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;

public class TreeBasedTable
extends StandardRowSortedTable {
    private static final long serialVersionUID;
    private final Comparator columnComparator;

    public TreeBasedTable(Comparator object, Comparator comparator) {
        TreeMap treeMap = new TreeMap(object);
        object = new TreeBasedTable$Factory(comparator);
        super(treeMap, (Supplier)object);
        this.columnComparator = comparator;
    }

    public static TreeBasedTable create() {
        Ordering ordering = Ordering.natural();
        Ordering ordering2 = Ordering.natural();
        TreeBasedTable treeBasedTable = new TreeBasedTable(ordering, ordering2);
        return treeBasedTable;
    }

    public static TreeBasedTable create(TreeBasedTable treeBasedTable) {
        Comparator comparator = treeBasedTable.rowComparator();
        Comparator comparator2 = treeBasedTable.columnComparator();
        TreeBasedTable treeBasedTable2 = new TreeBasedTable(comparator, comparator2);
        treeBasedTable2.putAll(treeBasedTable);
        return treeBasedTable2;
    }

    public static TreeBasedTable create(Comparator comparator, Comparator comparator2) {
        Preconditions.checkNotNull(comparator);
        Preconditions.checkNotNull(comparator2);
        TreeBasedTable treeBasedTable = new TreeBasedTable(comparator, comparator2);
        return treeBasedTable;
    }

    public Comparator columnComparator() {
        return this.columnComparator;
    }

    public Iterator createColumnKeyIterator() {
        Comparator comparator = this.columnComparator();
        Object object = this.backingMap.values();
        Object object2 = new TreeBasedTable$1(this);
        object = Iterators.mergeSorted(Iterables.transform(object, (Function)object2), comparator);
        object2 = new TreeBasedTable$2(this, (Iterator)object, comparator);
        return object2;
    }

    public SortedMap row(Object object) {
        TreeBasedTable$TreeRow treeBasedTable$TreeRow = new TreeBasedTable$TreeRow(this, object);
        return treeBasedTable$TreeRow;
    }

    public Comparator rowComparator() {
        return this.rowKeySet().comparator();
    }

    public SortedSet rowKeySet() {
        return super.rowKeySet();
    }

    public SortedMap rowMap() {
        return super.rowMap();
    }
}

