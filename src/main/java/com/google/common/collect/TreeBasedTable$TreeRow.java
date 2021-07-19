/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps$SortedKeySet;
import com.google.common.collect.StandardTable$Row;
import com.google.common.collect.TreeBasedTable;
import java.util.Comparator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.SortedMap;
import java.util.SortedSet;

public class TreeBasedTable$TreeRow
extends StandardTable$Row
implements SortedMap {
    public final Object lowerBound;
    public final /* synthetic */ TreeBasedTable this$0;
    public final Object upperBound;
    public transient SortedMap wholeRow;

    public TreeBasedTable$TreeRow(TreeBasedTable treeBasedTable, Object object) {
        this(treeBasedTable, object, null, null);
    }

    public TreeBasedTable$TreeRow(TreeBasedTable treeBasedTable, Object object, Object object2, Object object3) {
        int n10;
        this.this$0 = treeBasedTable;
        super(treeBasedTable, object);
        this.lowerBound = object2;
        this.upperBound = object3;
        if (object2 != null && object3 != null && (n10 = this.compare(object2, object3)) > 0) {
            n10 = 0;
            treeBasedTable = null;
        } else {
            n10 = 1;
        }
        Preconditions.checkArgument(n10 != 0);
    }

    public SortedMap backingRowMap() {
        return (SortedMap)super.backingRowMap();
    }

    public Comparator comparator() {
        return this.this$0.columnComparator();
    }

    public int compare(Object object, Object object2) {
        return this.comparator().compare(object, object2);
    }

    public SortedMap computeBackingRowMap() {
        SortedMap sortedMap = this.wholeRow();
        if (sortedMap != null) {
            Object object = this.lowerBound;
            if (object != null) {
                sortedMap = sortedMap.tailMap(object);
            }
            if ((object = this.upperBound) != null) {
                sortedMap = sortedMap.headMap(object);
            }
            return sortedMap;
        }
        return null;
    }

    public boolean containsKey(Object object) {
        boolean bl2;
        boolean bl3 = this.rangeContains(object);
        if (bl3 && (bl2 = super.containsKey(object))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public Object firstKey() {
        Object object = this.backingRowMap();
        if (object != null) {
            return this.backingRowMap().firstKey();
        }
        object = new NoSuchElementException();
        throw object;
    }

    public SortedMap headMap(Object object) {
        Object object2 = Preconditions.checkNotNull(object);
        Preconditions.checkArgument(this.rangeContains(object2));
        TreeBasedTable treeBasedTable = this.this$0;
        Object object3 = this.rowKey;
        Object object4 = this.lowerBound;
        object2 = new TreeBasedTable$TreeRow(treeBasedTable, object3, object4, object);
        return object2;
    }

    public SortedSet keySet() {
        Maps$SortedKeySet maps$SortedKeySet = new Maps$SortedKeySet(this);
        return maps$SortedKeySet;
    }

    public Object lastKey() {
        Object object = this.backingRowMap();
        if (object != null) {
            return this.backingRowMap().lastKey();
        }
        object = new NoSuchElementException();
        throw object;
    }

    public void maintainEmptyInvariant() {
        boolean bl2;
        Map map = this.wholeRow();
        if (map != null && (bl2 = (map = this.wholeRow).isEmpty())) {
            map = this.this$0.backingMap;
            Object object = this.rowKey;
            map.remove(object);
            bl2 = false;
            map = null;
            this.wholeRow = null;
            this.backingRowMap = null;
        }
    }

    public Object put(Object object, Object object2) {
        Object object3 = Preconditions.checkNotNull(object);
        Preconditions.checkArgument(this.rangeContains(object3));
        return super.put(object, object2);
    }

    public boolean rangeContains(Object object) {
        int n10;
        int n11;
        Object object2;
        if (!(object == null || (object2 = this.lowerBound) != null && (n11 = this.compare(object2, object)) > 0 || (object2 = this.upperBound) != null && (n10 = this.compare(object2, object)) <= 0)) {
            n10 = 1;
        } else {
            n10 = 0;
            object = null;
        }
        return n10 != 0;
    }

    public SortedMap subMap(Object object, Object object2) {
        Object object3 = Preconditions.checkNotNull(object);
        boolean bl2 = this.rangeContains(object3);
        if (bl2 && (bl2 = this.rangeContains(object3 = Preconditions.checkNotNull(object2)))) {
            bl2 = true;
        } else {
            bl2 = false;
            object3 = null;
        }
        Preconditions.checkArgument(bl2);
        TreeBasedTable treeBasedTable = this.this$0;
        Object object4 = this.rowKey;
        object3 = new TreeBasedTable$TreeRow(treeBasedTable, object4, object, object2);
        return object3;
    }

    public SortedMap tailMap(Object object) {
        Object object2 = Preconditions.checkNotNull(object);
        Preconditions.checkArgument(this.rangeContains(object2));
        TreeBasedTable treeBasedTable = this.this$0;
        Object object3 = this.rowKey;
        Object object4 = this.upperBound;
        object2 = new TreeBasedTable$TreeRow(treeBasedTable, object3, object, object4);
        return object2;
    }

    public SortedMap wholeRow() {
        Object object;
        boolean bl2;
        Map map = this.wholeRow;
        if (map == null || (bl2 = map.isEmpty()) && (bl2 = (map = this.this$0.backingMap).containsKey(object = this.rowKey))) {
            map = this.this$0.backingMap;
            object = this.rowKey;
            map = (SortedMap)map.get(object);
            this.wholeRow = map;
        }
        return this.wholeRow;
    }
}

