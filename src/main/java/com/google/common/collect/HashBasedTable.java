/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.HashBasedTable$Factory;
import com.google.common.collect.Maps;
import com.google.common.collect.StandardTable;
import com.google.common.collect.Table;
import java.util.LinkedHashMap;
import java.util.Map;

public class HashBasedTable
extends StandardTable {
    private static final long serialVersionUID;

    public HashBasedTable(Map map, HashBasedTable$Factory hashBasedTable$Factory) {
        super(map, hashBasedTable$Factory);
    }

    public static HashBasedTable create() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        HashBasedTable$Factory hashBasedTable$Factory = new HashBasedTable$Factory(0);
        HashBasedTable hashBasedTable = new HashBasedTable(linkedHashMap, hashBasedTable$Factory);
        return hashBasedTable;
    }

    public static HashBasedTable create(int n10, int n11) {
        CollectPreconditions.checkNonnegative(n11, "expectedCellsPerRow");
        LinkedHashMap linkedHashMap = Maps.newLinkedHashMapWithExpectedSize(n10);
        HashBasedTable$Factory hashBasedTable$Factory = new HashBasedTable$Factory(n11);
        HashBasedTable hashBasedTable = new HashBasedTable((Map)linkedHashMap, hashBasedTable$Factory);
        return hashBasedTable;
    }

    public static HashBasedTable create(Table table) {
        HashBasedTable hashBasedTable = HashBasedTable.create();
        hashBasedTable.putAll(table);
        return hashBasedTable;
    }

    public boolean contains(Object object, Object object2) {
        return super.contains(object, object2);
    }

    public boolean containsColumn(Object object) {
        return super.containsColumn(object);
    }

    public boolean containsRow(Object object) {
        return super.containsRow(object);
    }

    public boolean containsValue(Object object) {
        return super.containsValue(object);
    }

    public boolean equals(Object object) {
        return super.equals(object);
    }

    public Object get(Object object, Object object2) {
        return super.get(object, object2);
    }

    public Object remove(Object object, Object object2) {
        return super.remove(object, object2);
    }
}

