/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap$Builder;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableTable;
import com.google.common.collect.ImmutableTable$SerializedForm;
import com.google.common.collect.Maps;
import com.google.common.collect.RegularImmutableTable;
import com.google.common.collect.Table$Cell;
import com.google.common.collect.UnmodifiableIterator;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public final class SparseImmutableTable
extends RegularImmutableTable {
    public static final ImmutableTable EMPTY;
    private final int[] cellColumnInRowIndices;
    private final int[] cellRowIndices;
    private final ImmutableMap columnMap;
    private final ImmutableMap rowMap;

    static {
        ImmutableList immutableList = ImmutableList.of();
        ImmutableSet immutableSet = ImmutableSet.of();
        ImmutableSet immutableSet2 = ImmutableSet.of();
        SparseImmutableTable sparseImmutableTable = new SparseImmutableTable(immutableList, immutableSet, immutableSet2);
        EMPTY = sparseImmutableTable;
    }

    public SparseImmutableTable(ImmutableList object, ImmutableSet iterator2, ImmutableSet object2) {
        boolean bl2;
        int n10;
        LinkedHashMap linkedHashMap;
        Object object3;
        int n11;
        Object object4 = Maps.indexMap((Collection)((Object)iterator2));
        LinkedHashMap linkedHashMap2 = Maps.newLinkedHashMap();
        iterator2 = ((ImmutableSet)((Object)iterator2)).iterator();
        while ((n11 = iterator2.hasNext()) != 0) {
            object3 = iterator2.next();
            linkedHashMap = new LinkedHashMap();
            linkedHashMap2.put(object3, linkedHashMap);
        }
        iterator2 = Maps.newLinkedHashMap();
        object2 = ((ImmutableSet)object2).iterator();
        while ((n11 = object2.hasNext()) != 0) {
            object3 = object2.next();
            linkedHashMap = new LinkedHashMap();
            iterator2.put(object3, linkedHashMap);
        }
        int n12 = ((AbstractCollection)object).size();
        object2 = new int[n12];
        n11 = ((AbstractCollection)object).size();
        object3 = new int[n11];
        linkedHashMap = null;
        for (int i10 = 0; i10 < (n10 = ((AbstractCollection)object).size()); ++i10) {
            Object object5 = (Table$Cell)object.get(i10);
            Object object6 = object5.getRowKey();
            Object object7 = object5.getColumnKey();
            object5 = object5.getValue();
            int n13 = (Integer)object4.get(object6);
            object2[i10] = (Iterator)n13;
            Object object8 = (Map)linkedHashMap2.get(object6);
            int n14 = object8.size();
            object3[i10] = n14;
            object8 = object8.put(object7, object5);
            this.checkNoDuplicate(object6, object7, object8, object5);
            object7 = (Map)iterator2.get(object7);
            object7.put(object6, object5);
        }
        this.cellRowIndices = (int[])object2;
        this.cellColumnInRowIndices = (int[])object3;
        n12 = linkedHashMap2.size();
        object = new ImmutableMap$Builder(n12);
        object2 = linkedHashMap2.entrySet().iterator();
        while (bl2 = object2.hasNext()) {
            object4 = object2.next();
            linkedHashMap2 = object4.getKey();
            object4 = ImmutableMap.copyOf((Map)object4.getValue());
            ((ImmutableMap$Builder)object).put(linkedHashMap2, object4);
        }
        this.rowMap = object = ((ImmutableMap$Builder)object).build();
        n12 = iterator2.size();
        object = new ImmutableMap$Builder(n12);
        iterator2 = iterator2.entrySet().iterator();
        while ((n12 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
            object2 = iterator2.next();
            object4 = object2.getKey();
            object2 = ImmutableMap.copyOf((Map)object2.getValue());
            ((ImmutableMap$Builder)object).put(object4, object2);
        }
        this.columnMap = object = ((ImmutableMap$Builder)object).build();
    }

    public ImmutableMap columnMap() {
        return ImmutableMap.copyOf((Map)this.columnMap);
    }

    public ImmutableTable$SerializedForm createSerializedForm() {
        int n10;
        Object object = Maps.indexMap(this.columnKeySet());
        int n11 = this.cellSet().size();
        int[] nArray = new int[n11];
        UnmodifiableIterator unmodifiableIterator = this.cellSet().iterator();
        int n12 = 0;
        while ((n10 = unmodifiableIterator.hasNext()) != 0) {
            Object object2 = (Table$Cell)unmodifiableIterator.next();
            int n13 = n12 + 1;
            object2 = object2.getColumnKey();
            object2 = (Integer)object.get(object2);
            nArray[n12] = n10 = ((Integer)object2).intValue();
            n12 = n13;
        }
        object = this.cellRowIndices;
        return ImmutableTable$SerializedForm.create(this, (int[])object, nArray);
    }

    public Table$Cell getCell(int n10) {
        int n11 = this.cellRowIndices[n10];
        Map.Entry entry = (Map.Entry)this.rowMap.entrySet().asList().get(n11);
        ImmutableMap immutableMap = (ImmutableMap)entry.getValue();
        n10 = this.cellColumnInRowIndices[n10];
        Map.Entry entry2 = (Map.Entry)immutableMap.entrySet().asList().get(n10);
        entry = entry.getKey();
        immutableMap = entry2.getKey();
        entry2 = entry2.getValue();
        return ImmutableTable.cellOf(entry, immutableMap, entry2);
    }

    public Object getValue(int n10) {
        int n11 = this.cellRowIndices[n10];
        ImmutableMap immutableMap = (ImmutableMap)this.rowMap.values().asList().get(n11);
        n10 = this.cellColumnInRowIndices[n10];
        return immutableMap.values().asList().get(n10);
    }

    public ImmutableMap rowMap() {
        return ImmutableMap.copyOf((Map)this.rowMap);
    }

    public int size() {
        return this.cellRowIndices.length;
    }
}

